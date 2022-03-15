package org.swclsss.mvcproject.chap11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegistController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/step1")
    public String handleStep1() {
        return "register/step1";
    }

    @PostMapping("/step2")
    public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") String agree) {
        if (agree == null || !"true".equals(agree)) {
            return "register/step1";
        }

        return "register/step2";
    }

    @PostMapping("/step3")
    public String handleStep3(RegisterRequest request) {
        try{
            registerService.regist(request);

            return "register/step3";
        } catch (Exception e) {
            return "register/step2";
        }
    }
}
