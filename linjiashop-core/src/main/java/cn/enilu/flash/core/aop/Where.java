package cn.enilu.flash.core.aop;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, METHOD, FIELD})
@Retention(RUNTIME)
public @interface Where {
    /**
     * The where-clause predicate.
     */
    String clause();
}
