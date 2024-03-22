package cn.xlibs.xvalidator.validation;

import cn.xlibs.xvalidator.ValidatorUtils;
import cn.xlibs.xvalidator.annotation.Email;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidatorContext;

/**
 * 电子邮件
 * Email Validator
 *
 * @author Fury
 * @since 2024-03-21
 * <p>
 * All rights Reserved.
 */
public class EmailValidator extends AbstractValidator<Email, String> {
    @Override
    public void initialize(Email ann) {
        initialize(ann.required());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext ctx) {
        if (StringUtils.isBlank(value)) {
            return notRequired();
        }

        return ValidatorUtils.Email.matches(value);
    }
}
