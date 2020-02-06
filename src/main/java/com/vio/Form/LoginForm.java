package com.vio.Form;

/**
 * @author vio
 * 登录表单信息类
 * @date 2020-02-02   20:02
 */
public class LoginForm {
    private String email;
    private String imgCode;
    private String validateCode;

    public LoginForm() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgCode() {
        return imgCode;
    }

    public void setImgCode(String imgCode) {
        this.imgCode = imgCode;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "email='" + email + '\'' +
                ", imgCode='" + imgCode + '\'' +
                ", validateCode='" + validateCode + '\'' +
                '}';
    }
}
