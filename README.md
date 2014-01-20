FXForm 2
========

**Stop coding forms: FXForm 2 can do it for you!**

About
-----

FXForm2 is a library providing automatic JavaFX 2.0 form generation.

How does it work?
-----------------

1. Write your model bean
2. Generate your form using FXForm2
3. Style it using CSS, skins and resource bundles!

Quick start
-----------
Add FXForm to your project dependencies:
  
    <dependency>
        <groupId>com.dooapp.fxform2</groupId>
        <artifactId>core</artifactId>
        <version>2.2.6</version> <!-- Note: For JavaFX 8, use 8.0.5 -->
    </dependency>

Get your FXForm...

    FXForm<MyBean> fxForm = new FXForm<MyBean>(myBean);

...and add it to your scene!

See [Get started](https://github.com/dooApp/FXForm2/wiki/Get-started).

Features
--------

Main features include:

* Automatic form generation and binding to bean properties
* CSS support
* Bean Validation handling (JSR 303)
* Fields reordering and filtering
* Tooltips
* Localization
* Custom factories

Key benefits
------------
* Don't waste time coding forms, focus on styling
* Less code and improved quality
* Easy to use and to customize

Reports
-------
* [Javadoc](http://dooapp.github.io/FXForm2/2.2.6/site/apidocs/index.html)
* [Javadoc for 8.0 branch](http://dooapp.github.io/FXForm2/8.0.6-SNApSHOT/site/apidocs/index.html)
* [Maven site](http://dooapp.github.io/FXForm2/2.2.6)
* [Maven site for 8.0 branch](http://dooapp.github.io/FXForm2/8.0.6-SNAPSHOT)

Links
-----
Articles about FXForm2 on [dooApp technical blog](http://blog.dooapp.com/search/label/fxform).

A video by Betrand Goetzmann with [Grezi](https://bitbucket.org/bgoetzmann/grezi/wiki/Home) and FXForm2: [http://screenr.com/GvDs]

JavaFX [Third Party Tools and Utilities](http://www.oracle.com/technetwork/java/javafx/community/3rd-party-1844355.html)

Considerations about [GUI Generation with JavaFX](http://ustesis.wordpress.com/2013/07/12/gui-generation-with-javafx/) and [Using FXForm2 with EMF Models](http://ustesis.wordpress.com/2013/11/08/using-fxform2-with-emf-models/) by Uwe.

Oliver Probst. [Investigating a Constraint-Based Approach to Data Quality in Information Systems](http://e-collection.library.ethz.ch/eserv/eth:7430/eth-7430-01.pdf), 12.2.5.1 FXForm2, pages 85-88.

[Screenshots](http://infiltrea.com/index.php/visuels) of Infiltrea, a real-world application using FXForm2 - all forms you can see there are based on FXForm2

Licensing
---------

FXForm2 is licensed under the Lesser GPL license.

Build status
------------
[![Build Status](https://buildhive.cloudbees.com/job/dooApp/job/FXForm2/badge/icon)](https://buildhive.cloudbees.com/job/dooApp/job/FXForm2/)