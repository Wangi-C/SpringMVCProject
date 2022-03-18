package org.swclsss.mvcproject.Topic;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TopicController {
    @GetMapping("/topics")
    public ModelAndView topicForm() {
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
}
