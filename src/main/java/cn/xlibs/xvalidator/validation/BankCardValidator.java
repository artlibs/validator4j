package cn.xlibs.xvalidator.validation;

import cn.xlibs.xvalidator.ValidatorUtils;
import cn.xlibs.xvalidator.annotation.BankCard;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidatorContext;

/**
 * 银行卡号码
 * Bank Card Validator
 *
 * @author Fury
 * @since 2024-03-21
 * <p>
 * All rights Reserved.
 */
public class BankCardValidator extends AbstractValidator<BankCard, String> {
    @Override
    public void initialize(BankCard ann) {
        initialize(ann.required());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext ctx) {
        if (StringUtils.isBlank(value)) {
            return notRequired();
        }

        return ValidatorUtils.BankCard.matches(value);
    }
}
