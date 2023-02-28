package com.rayllanderson.rayexpress.libary.ddd.domain.validation;

import java.util.List;

public interface ValidatorHandler {
    ValidatorHandler append(Error error);

    ValidatorHandler append(ValidatorHandler handler);

    <T> T validate(Validation<T> aValidation);

    default boolean hasErrors() {
        return getErrors() != null && !getErrors().isEmpty();
    }

    List<Error> getErrors();

    interface Validation<T> {
        T validate();
    }

    default Error firstError() {
        return getErrors() == null || getErrors().isEmpty() ? null : getErrors().get(0);
    }
}
