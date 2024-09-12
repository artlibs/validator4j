package cn.xlibs.xvalidator.annotation;

import cn.xlibs.xvalidator.validation.IdentifierValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 字母数字标识
 * Alpha Number Validator
 *
 * @author Fury
 * @since 2024-03-21
 * <p>
 * All rights Reserved.
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdentifierValidator.class)
public @interface Identifier {
    boolean required() default true;

    String message() default "参数格式错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
