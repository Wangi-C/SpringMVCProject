package org.swclsss.mvcproject.chap09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.swclsss.mvcproject.chap11.RegisterRequest;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String helloOne() {
        return "hello";
    }

    @PostMapping("/hello")
    public String helloTwo(RegisterRequest registerRequest) {
        return "hello2";
    }
}
