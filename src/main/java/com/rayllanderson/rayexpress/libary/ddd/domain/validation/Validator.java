package com.rayllanderson.rayexpress.libary.ddd.domain.validation;

public abstract class Validator {

    private final ValidatorHandler validationHandler;

    protected Validator(final ValidatorHandler validationHandler) {
        this.validationHandler = validationHandler;
    }

    protected ValidatorHandler validationHandler() {
        return this.validationHandler;
    }

    public abstract void validate();
}
