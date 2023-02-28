package com.rayllanderson.rayexpress.libary.ddd.infrastructure.utils;


import org.springframework.data.jpa.domain.Specification;

public final class SpecificationUtils {

    private SpecificationUtils() {
    }

    public static <T> Specification<T> like(final String property, final String term) {
        notNull(property, "property should not be null");
        notNull(term, "term should not be null");
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get(property)), like(term.toUpperCase()));
    }

    private static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    private static String like(String term) {
        return "%" + term + "%";
    }
}
