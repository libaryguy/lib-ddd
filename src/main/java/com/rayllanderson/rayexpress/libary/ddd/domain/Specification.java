package com.rayllanderson.rayexpress.libary.ddd.domain;

public interface Specification<T> {
    boolean isSatisfiedBy(T t);
}