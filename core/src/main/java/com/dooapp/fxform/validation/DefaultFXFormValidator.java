/*
 * Copyright (c) 2013, dooApp <contact@dooapp.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of dooApp nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.dooapp.fxform.validation;

import com.dooapp.fxform.model.Element;

import javax.validation.*;
import javax.validation.metadata.BeanDescriptor;
import javax.validation.metadata.ConstraintDescriptor;
import java.lang.annotation.ElementType;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User: Antoine Mischler <antoine@dooapp.com>
 * Date: 20/11/2013
 * Time: 17:31
 */
public class DefaultFXFormValidator implements FXFormValidator {

    private final Logger logger = Logger.getLogger(DefaultFXFormValidator.class.getName());

    static ValidatorFactory factory;

    Validator validator;

    /**
     * Initialize the constraint validator. Might be null after that if no implementation has been provided.
     */
    protected void createValidator() {
        try {
            if (factory == null) {
                factory = Validation.buildDefaultValidatorFactory();
            }
            validator = factory.getValidator();
        } catch (ValidationException e) {
            // validation is not activated, since no implementation has been provided
            logger.log(Level.INFO, "Validation disabled", e);
        }
    }

    public DefaultFXFormValidator() {
        createValidator();
    }

    @Override
    public List<ConstraintViolation> validate(Element element, Object newValue, Class... groups) {
        final List<ConstraintViolation> list = new LinkedList<ConstraintViolation>();
        if (validator != null) {
            list.addAll(validator.validateValue((Class<Object>) (element.getBean().getClass()), element.getName(), newValue, groups));
        }
        return list;
    }

    @Override
    public List<ConstraintViolation> validateClassConstraint(Object bean) {
        final List<ConstraintViolation> list = new LinkedList<ConstraintViolation>();
        if (validator != null && bean != null) {
            BeanDescriptor beanDescriptor = validator.getConstraintsForClass(bean.getClass());
            Set<ConstraintDescriptor<?>> classLevelConstraints = beanDescriptor.findConstraints().declaredOn(ElementType.TYPE).getConstraintDescriptors();
            Set<ConstraintViolation<Object>> constraintViolations = validator.validate(bean);
            for (ConstraintViolation constraintViolation : constraintViolations) {
                if (classLevelConstraints.contains(constraintViolation.getConstraintDescriptor())) {
                    list.add(constraintViolation);
                }
            }
        }
        return list;
    }

}
