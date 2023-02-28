package com.rayllanderson.rayexpress.libary.ddd.domain.exceptions;

import com.rayllanderson.rayexpress.libary.ddd.domain.validation.Error;

import java.util.List;
import java.util.Optional;

public class DomainException extends NoStacktraceException {

    protected final List<Error> errors;

    protected DomainException(String message, List<Error> errors) {
        super(message);
        this.errors = errors;
    }

    public static DomainException with(final Error error) {
        return new DomainException(error.message(), List.of(error));
    }

    public static DomainException with(final List<Error> errors) {
        return new DomainException("", errors);
    }

    public List<Error> getErrors() {
        return errors;
    }

    public Optional<Error> getFirstError() {
        return errors == null || errors.isEmpty() ? Optional.empty() : Optional.of(errors.get(0));
    }
}
