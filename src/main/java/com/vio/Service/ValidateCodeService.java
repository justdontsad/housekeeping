package com.vio.Service;

import com.vio.Entity.ValidateCode;

public interface ValidateCodeService {
    /**
     * 将验证码存入数据库
     * @param code
     */
    public void saveValidateCode(ValidateCode code);

    /**
     * 判断图片验证码是否正确
     */
    public boolean judgeValidateCode(String userEmail,String validateCode);

    /**
     *判断邮箱验证码是否正确
     */
    public boolean judgeEmailCode(String userEmail,String emailCode);
}
