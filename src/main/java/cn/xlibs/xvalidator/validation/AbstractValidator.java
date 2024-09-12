package cn.xlibs.xvalidator.validation;

import javax.validation.ConstraintValidator;
import java.lang.annotation.Annotation;

/**
 * Base Validator
 *
 * @author Fury
 * @since 2024-03-21
 * <p>
 * All rights Reserved.
 */
public abstract class AbstractValidator<A extends Annotation, T> implements ConstraintValidator<A, T> {
    private boolean required;

    protected void initialize(boolean required) {
        this.required = required;
    }

    protected boolean notRequired() {
        return !this.required;
    }

}
