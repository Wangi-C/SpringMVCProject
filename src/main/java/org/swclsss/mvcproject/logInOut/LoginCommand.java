package org.swclsss.mvcproject.logInOut;

import java.io.Serializable;

public class LoginCommand implements Serializable {
    private String id;
    private String password;
    private boolean rememberId;

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

    public boolean isRememberId() {
        return rememberId;
    }

    public void setRememberId(boolean rememberId) {
        this.rememberId = rememberId;
    }

    @Override
    public String toString() {
        return "LoginCommand{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", rememberId=" + rememberId +
                '}';
    }
}
