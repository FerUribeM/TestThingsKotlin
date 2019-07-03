package com.ferbajoo.annotation_test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by
 * cagonzalez on 19/11/2017.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited()
public @interface Foo {
    String name() default "";
    String value() default  "";
    int drawable();
}
