package org.swclsss.mvcproject.chap11;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

public class RegisterService {
    private static Map<String, RegisterRequest> memberDAO;

    static {
        memberDAO = new HashMap<String, RegisterRequest>();
    }

    //회원 등록
    public void regist(RegisterRequest request) {
        memberDAO.put(request.getEmail(), request);

        System.out.println(memberDAO.size());
    }
}
