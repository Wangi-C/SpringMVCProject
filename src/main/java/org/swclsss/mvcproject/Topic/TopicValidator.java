package org.swclsss.mvcproject.Topic;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class TopicValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Topic.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Topic topic = (Topic) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "requierd");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contents", "required");
    }
}
