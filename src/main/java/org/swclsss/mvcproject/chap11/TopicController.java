package org.swclsss.mvcproject.chap11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TopicController {
    @GetMapping("/topics")
    public ModelAndView topicForm() {
        return new ModelAndView("topicForm/topic");
    }

    @PostMapping("/topics")
    public ModelAndView topicRegist(Topic topic) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("topic",topic);
        mav.setViewName("topicForm/topicCheck");
        return mav;
    }
}
