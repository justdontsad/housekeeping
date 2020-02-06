package com.vio.dto;

/**
 * @author vio
 * @date 2020-02-03   21:56
 */

public class ValidateCodeDTO {
    private String userEmail;
    private String imgCode;

    public ValidateCodeDTO() {
    }

    public ValidateCodeDTO(String validateCodeId, String validateCodeCode) {
        this.userEmail = validateCodeId;
        this.imgCode = imgCode;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getImgCode() {
        return imgCode;
    }

    public void setImgCode(String imgCode) {
        this.imgCode = imgCode;
    }
}
