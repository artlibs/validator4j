package cn.xlibs.xvalidator.annotation;

import cn.xlibs.xvalidator.validation.BankCardValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 银行卡号码
 * Bank Card Validator
 *
 * @author Fury
 * @since 2024-03-21
 * <p>
 * All rights Reserved.
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BankCardValidator.class)
public @interface BankCard {
    boolean required() default true;

    String message() default "银行卡号格式错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
