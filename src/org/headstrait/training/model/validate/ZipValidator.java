package org.headstrait.training.model.validate;

import java.util.concurrent.CompletableFuture;

public class ZipValidator implements Validator<Integer>{
    @Override
    public CompletableFuture<Boolean> validate(Integer object) {
        return null;
    }
}
