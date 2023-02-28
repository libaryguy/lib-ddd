package com.rayllanderson.rayexpress.libary.ddd.domain.validation.handler;



import com.rayllanderson.rayexpress.libary.ddd.domain.exceptions.DomainException;
import com.rayllanderson.rayexpress.libary.ddd.domain.validation.Error;
import com.rayllanderson.rayexpress.libary.ddd.domain.validation.ValidatorHandler;

import java.util.ArrayList;
import java.util.List;

public class Notification implements ValidatorHandler {

    private final List<Error> errors;

    private Notification(final List<Error> errors) {
        this.errors = errors;
    }

    public static Notification create() {
        return new Notification(new ArrayList<>());
    }

    public static Notification create(final Error error) {
        return new Notification(new ArrayList<>()).append(error);
    }

    public static Notification create(final Throwable error) {
        return create(new Error(error.getMessage()));
    }

    @Override
    public Notification append(final Error error) {
        this.errors.add(error);
        return this;
    }

    @Override
    public Notification append(final ValidatorHandler handler) {
        this.errors.addAll(handler.getErrors());
        return this;
    }

    @Override
    public <T> T validate(final Validation<T> handler) {
        try {
            return handler.validate();
        } catch (final DomainException e) {
            this.errors.addAll(e.getErrors());
        } catch (final Exception e) {
            this.errors.add(new Error(e.getMessage()));
        }
        return null;
    }

    @Override
    public List<Error> getErrors() {
        return errors;
    }
}
