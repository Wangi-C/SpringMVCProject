package org.swclsss.mvcproject.logInOut;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static org.springframework.validation.ValidationUtils.*;

public class LoginValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return LoginCommand.class.isAssignableFrom(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        LoginCommand loginCommand = (LoginCommand) target;
        rejectIfEmptyOrWhitespace(errors, "id", "required");
        rejectIfEmptyOrWhitespace(errors, "password", "required");
    }
}
