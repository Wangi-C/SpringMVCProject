package org.swclsss.mvcproject.Topic;

import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.swclsss.mvcproject.ListCommand;

@Controller
public class TopicController {
    @GetMapping("/topics")
    public ModelAndView topicForm(ListCommand listCommand) {
        System.out.println(listCommand);
        return new ModelAndView("topicForm/topic");
    }

    @PostMapping("/topics")
    public ModelAndView topicRegist(Topic topic, Errors errors) {
        ModelAndView mav = new ModelAndView();
        new TopicValidator().validate(topic, errors);

        if (errors.hasErrors()) {
            mav.setViewName("topicForm/topic");
            return mav;
        }
        mav.addObject("topic",topic);
        mav.setViewName("topicForm/topicCheck");
        return mav;
    }

    @ExceptionHandler(TypeMismatchException.class)
    public String handleTypeMismatchException() {
        return "exceptionForm/invalid";
    }
}
