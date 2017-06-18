package com.lumpofcode.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * NOTE: It would be nice to have this build into Java.
 *
 * TODO: figure out how to get this processed by FindBugs http://findbugs.sourceforge.net/
 *
 * Created by emurphy on 5/29/15.
 */
@Documented
@Target(value=ElementType.TYPE)
@Retention(value=RetentionPolicy.CLASS)
public @interface Immutable
{
}
