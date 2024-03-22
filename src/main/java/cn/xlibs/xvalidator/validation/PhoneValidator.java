package cn.xlibs.xvalidator.validation;

import cn.xlibs.xvalidator.ValidatorUtils;
import cn.xlibs.xvalidator.annotation.Phone;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * 手机号码
 * Phone Number Validator
 *
 * @author Fury
 * @since 2024-03-21
 * <p>
 * All rights Reserved.
 */
public class PhoneValidator extends AbstractValidator<Phone, String> {
    private Phone ann;

    @Override
    public void initialize(Phone ann) {
        this.ann = ann;
        initialize(ann.required());
    }

    @Override
    public boolean isValid(final String value, ConstraintValidatorContext ctx) {
        if (StringUtils.isBlank(value)) {
            return notRequired();
        }
        return Arrays.stream(this.ann.type()).allMatch(
                t -> ValidatorUtils.Phone.matches(value, t));
    }
}
