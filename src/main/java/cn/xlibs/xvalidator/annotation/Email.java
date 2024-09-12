package cn.xlibs.xvalidator.annotation;

import cn.xlibs.xvalidator.validation.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 电子邮件
 * Email Validator
 *
 * @author Fury
 * @since 2024-03-21
 * <p>
 * All rights Reserved.
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
public @interface Email {
    boolean required() default true;

    String message() default "电子邮件格式错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
