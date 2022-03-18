package org.swclsss.mvcproject.logInOut;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LogInOutController {
    //로그인 폼
    @GetMapping("/signIn")
    public String loginForm(LoginCommand loginCommand
            , @CookieValue(value = "REMEMBER", required = false) Cookie rCookie) {
        if (rCookie != null) {
            loginCommand.setId(rCookie.getValue());
            loginCommand.setRememberId(true);
        }
        return "login/loginForm";
    }
    //로그인_로직
    //Post("/logInOut"),LogIn,view: login/loginSuccess
    @PostMapping("/logInOut")
    public ModelAndView logIn(LoginCommand loginCommand
            , Errors errors
            , HttpSession session
            , HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        new LoginValidator().validate(loginCommand, errors);
        if (errors.hasErrors()) {
            mav.setViewName("redirect:/signIn");
            return mav;
        }

        Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getId());
        rememberCookie.setPath("/");
        if (loginCommand.isRememberId()) {
            rememberCookie.setMaxAge(60 * 60 * 1);
        } else {
            rememberCookie.setMaxAge(0);
        }
        response.addCookie(rememberCookie);

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
