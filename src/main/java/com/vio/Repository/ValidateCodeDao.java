package com.vio.Repository;

import com.vio.Entity.ValidateCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidateCodeDao extends JpaRepository<ValidateCode,String> {
    public ValidateCode findByValidateCodeIdAndValidateCode(String userEmail, String validateCode );
}
