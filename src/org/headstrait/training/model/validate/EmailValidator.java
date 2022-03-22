package org.headstrait.training.model.validate;

import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements Validator<String> {

    /**
     * @param email to be validated
     * @return whether valid or not
     */
    @Override
    public CompletableFuture<Boolean> validate(String email) {
        return CompletableFuture.supplyAsync(() -> {
            Pattern pattern = Pattern.compile("^[A-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[A-Z0-9_!#$%&'*+/=?`{|}~^-]+↵\n" +
                    ")*@[A-Z0-9-]+(?:\\.[A-Z0-9-]+)*$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            return matcher.find();
        });
    }
}
