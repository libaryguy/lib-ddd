package com.rayllanderson.rayexpress.libary.ddd.application;

public abstract class UnitUseCase<IN> {

    public abstract void execute(IN input);
}
