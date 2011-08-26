/*
 * Copyright (c) 2011, dooApp <contact@dooapp.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * Neither the name of dooApp nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.dooapp.fxform.model.impl;

import com.dooapp.fxform.model.FormException;
import com.dooapp.fxform.model.Element;
import javafx.beans.value.ObservableValue;

import java.lang.reflect.Field;

/**
 * User: Antoine Mischler
 * Date: 26/04/11
 * Time: 11:45
 * <p/>
 * A form field that represent an observable value.
 */
public class ObservableElement<T> extends Element {

    public ObservableElement(Field field, Object source) throws FormException {
        super(field, source);
        if (!ObservableValue.class.isAssignableFrom(field.getType())) {
            throw new FormException("Trying to create an observable form field with a non-observable source " + field.getType());
        }
    }

    public ObservableValue<T> getObservable() {
        try {
            Object ref = field.get(source);
            return (ObservableValue) ref;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}