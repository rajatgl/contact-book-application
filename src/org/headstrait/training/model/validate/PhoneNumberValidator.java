package org.headstrait.training.model.validate;

import java.util.concurrent.CompletableFuture;

public class PhoneNumberValidator implements Validator<String>{
    @Override
    public CompletableFuture<Boolean> validate(String object) {
        return null;
    }
}
