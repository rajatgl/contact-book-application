package org.headstrait.training.model.validate;

import java.util.concurrent.CompletableFuture;

/**
 *
 * @param <T> dataType of the object to be validated
 */
public interface Validator<T>{
    /**
     *
     * @param object to be validated
     * @return whether valid or not
     */
    CompletableFuture<Boolean> validate(T object);
}
