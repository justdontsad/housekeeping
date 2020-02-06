package com.vio.Controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.vio.Entity.ValidateCode;
import com.vio.Form.LoginForm;
import com.vio.Service.ValidateCodeService;
import com.vio.Service.impl.MailService;
import com.vio.dto.ResultVO;
import com.vio.dto.ValidateCodeDTO;
import com.vio.util.JWTUtil;
import com.vio.util.ResultVOUtil;
import com.vio.util.ValidateCodeCreator;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vio
 * @date 2020-01-05   15:32
 */

@RestController
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    DefaultKaptcha kaptcha;

    @Autowired
    ValidateCodeService validateCodeService;

    @Autowired
    MailService mailService;

    @Autowired
    JWTUtil jwtUtil;

    /**
     * 1.以用户邮箱为用户名，存入用户表生成唯一的userId
     * 2.向用户邮箱发送验证码
     * 3.
     */
    @PostMapping(value = "/")
    public ResultVO login(@RequestBody LoginForm form,HttpServletRequest request) {
        String email = form.getEmail();
        String validateCode = form.getValidateCode();
        String imgCode = form.getImgCode();
        //判断图片验证码是否正确
        if (!imgCode.equals(request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY))) {
            return ResultVOUtil.error(505, "图片验证码输入错误！");
        }
        //校验邮箱验证码是否正确
        boolean passed = validateCodeService.judgeValidateCode(email, validateCode);
        if (!passed) {
            return ResultVOUtil.error(01, "邮件验证码错误！");
        }
        //验证通过，生成TOKEN,TOKEN有效期为6个小时
        try {
            List<Object> rsList = new ArrayList<Object>();
            String jwt = jwtUtil.createJWT(email, "", 600000);
            rsList.add(jwt);
            rsList.add(email);
            //将Token反回给前端，完成登录
            return ResultVOUtil.success(rsList);
            //TODO
            /**  添加jwt到redis，实现用户下线   */
        } catch (Exception e) {
            ResultVOUtil.error(506,"获取Token失败，请重新登录！");
        }


        return null;
    }

    /**
     * 获得邮箱验证码
     *
     * @param validateCodeDTO
     * @param request
     * @return
     */
    @PostMapping(value = "/getValidateCode")
    public ResultVO<ValidateCodeDTO> getValidateCode(@RequestBody ValidateCodeDTO validateCodeDTO,
                                                     HttpServletRequest request) {
        String imgCode = validateCodeDTO.getImgCode();
        String userEmail = validateCodeDTO.getUserEmail();
        //检查图片验证码是否正确
        if (!imgCode.equals(request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY))) {
            return ResultVOUtil.error(505, "验证码输入错误！");
        }
        ValidateCode code = new ValidateCode();
        //为验证码封装类赋初始值
        code.setValidateCode(ValidateCodeCreator.getCode());
        code.setUserMail(userEmail);
        code.setValidateCodeId(userEmail); //采用用户Email为主键，防止数据库冗余数据
        //将验证码存入数据库
        validateCodeService.saveValidateCode(code);
        //通过邮件发送验证码
        mailService.sendValidateCode(userEmail, code.getValidateCode());
        return ResultVOUtil.success(new ValidateCodeDTO(code.getValidateCodeId(), code.getValidateCode()));
    }


    /**
     * 图片验证码生成
     *
     * @param response response对象
     * @return
     */
    @GetMapping(value = "/getImageCode", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImageCode(HttpServletResponse response, HttpServletRequest request) {
        //定义二进制数组用于反回
        byte[] captchaChallengeAsJpeg;
        //图片字节输出流
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        /**
         * 生成验证码字符串并保存到session中
         */
        //生成验证码
        String createText = kaptcha.createText();
        //存入Session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, createText);

        /**
         * 使用生成的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
         */
        //图片实例
        BufferedImage challenge = kaptcha.createImage(createText);
        try {
            //将图片实例转为二进制输出流，对象为 jpegOutputStream
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IOException e) {
            LoggerFactory.getLogger("验证码").error("生成图形验证码失败", e);
            //throw new BusinessException(ErrorEnum.CRATE_IMAGE_ERROR);	// 抛出异常，可以不用关心
        }
        //将图片输出流转二进制数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        // 返回成功提示信息
        return captchaChallengeAsJpeg;
    }


}
