package org.swclsss.mvcproject.logInOut;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor {
    //컨트롤러 실행 전 : preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    //컨트롤러 실행 후, 뷰 실행 전 : postHandle(HttpSerletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    //뷰를 실행한 이후 : afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception
    @Override
    public boolean preHandle(HttpServletRequest request
            , HttpServletResponse response
            , Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String id = (String) session.getAttribute("id");
            if (id != null) {
                return true;
            }
        }
        response.sendRedirect(request.getContextPath() + "/signIn");
        return false;
    }
}
