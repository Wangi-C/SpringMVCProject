package org.swclsss.mvcproject.chap09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.swclsss.mvcproject.chap11.RegisterRequest;

@Controller
public class HelloController {
    @GetMapping("/hello/{id}")
    public String helloOne(@PathVariable("id") String id, Model model) {
        model.addAttribute("id", id);
        return "hello";
    }

    @PostMapping("/hello")
    public String helloTwo(RegisterRequest registerRequest) {
        return "hello2";
    }
}
