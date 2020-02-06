package com.vio.Service.impl;

import com.vio.Entity.ValidateCode;
import com.vio.Repository.ValidateCodeDao;
import com.vio.Service.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vio
 * @date 2020-02-03   21:27
 */
@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {
    @Autowired
    ValidateCodeDao dao;


    @Override
    public void saveValidateCode(ValidateCode code) {
        dao.save(code);
    }

    @Override
    public boolean judgeValidateCode(String userEmail, String validateCode) {
        ValidateCode code = dao.findByValidateCodeIdAndValidateCode(userEmail, validateCode);
        if(code == null)
            return false;
        return true ;
    }

    @Override
    public boolean judgeEmailCode(String userEmail, String emailCode) {
        return false;
    }


}
