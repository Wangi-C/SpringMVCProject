package org.swclsss.mvcproject.logInOut;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LogInOutController {
    //로그인_로직
    //Post("/logInOut"),LogIn,view: login/loginSuccess
    @PostMapping("/logInOut")
    public ModelAndView logIn(LoginCommand loginCommand, Errors errors, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        new LoginValidator().validate(loginCommand, errors);
        if (errors.hasErrors()) {
            mav.setViewName("redirect:/signIn");
            return mav;
        }
        session.setAttribute("id", loginCommand.getId());
        mav.setViewName("login/loginSuccess");
        return mav;
    }
    //로그아웃_로직
    //Get("/loInOut"),LogOut,view: login/logout
    @GetMapping("/logInOut")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "redirect:/signIn";
    }
}
