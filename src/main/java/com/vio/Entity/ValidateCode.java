package com.vio.Entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@DynamicUpdate
public class ValidateCode {
    @Id
    private String validateCodeId;
    private String validateCode;
    private java.sql.Timestamp validateCodeCreateTime;
    private String userMail;

    public ValidateCode() {
    }

    public String getValidateCodeId() {
        return validateCodeId;
    }

    public void setValidateCodeId(String validateCodeId) {
        this.validateCodeId = validateCodeId;
    }


    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }


    public java.sql.Timestamp getValidateCodeCreateTime() {
        return validateCodeCreateTime;
    }

    public void setValidateCodeCreateTime(java.sql.Timestamp validateCodeCreateTime) {
        this.validateCodeCreateTime = validateCodeCreateTime;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }
}
