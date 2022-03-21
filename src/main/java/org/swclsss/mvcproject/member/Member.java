package org.swclsss.mvcproject.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Member implements Serializable {
    private String id;
    @JsonIgnore
    private String pw;
    private int age;
    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss")
    private LocalDateTime registerDateTime;

    public Member() {
    }

    public Member(String id, String pw, int age, LocalDateTime registerDateTime) {
        this.id = id;
        this.pw = pw;
        this.age = age;
        this.registerDateTime = registerDateTime;
    }

    public Member(String id, String pw, int age) {
        this.id = id;
        this.pw = pw;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", age=" + age +
                ", registerDateTime=" + registerDateTime +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getRegisterDateTime() {
        return registerDateTime;
    }

    public void setRegisterDateTime(LocalDateTime registerDateTime) {
        this.registerDateTime = registerDateTime;
    }
}
