package org.swclsss.mvcproject.logInOut;

import java.io.Serializable;

public class LoginCommand implements Serializable {
    private String id;
    private String password;

    public LoginCommand() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
