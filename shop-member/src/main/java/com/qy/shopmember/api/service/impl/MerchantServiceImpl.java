package com.qy.shopmember.api.service.impl;


import com.qy.shopcommon.globalresult.GlobalResponseResult;
import com.qy.shopmember.api.model.MerchantReqDto;
import com.qy.shopmember.api.service.MerchantService;
import com.qy.shopmember.manage.MerchantManage;
import com.qy.shopmember.model.merchant.pojo.Merchant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author qiyun
 * @date 2019/10/17
 * @描述
 */
@RestController
public class MerchantServiceImpl implements MerchantService {

    private Logger logger = LogManager.getLogger(MerchantServiceImpl.class);

    @Autowired
    MerchantManage merchantManage;


    @Override
    public GlobalResponseResult regist(MerchantReqDto merchantReqDto) {
        try {
            String username = merchantReqDto.getUsername();
            String password = merchantReqDto.getPassword();
            String email = merchantReqDto.getEmail();
            String phone = merchantReqDto.getPhone();
            //todo 对参数的各种验证
            Merchant merchant = new Merchant();
            merchant.setUsername(username);
            merchant.setPassword(password);
            merchant.setEmail(email);
            merchant.setPhone(phone);
            merchantManage.regist(merchant);
            return GlobalResponseResult.setResultSuccess();
        } catch (Exception e) {
            logger.info("注册失败");
            return GlobalResponseResult.setResultError();

        }

    }

    @Override
    public GlobalResponseResult login(MerchantReqDto merchantReqDto) {
        return null;
    }

    @Override
    public GlobalResponseResult getUser(String token) {
        return null;
    }

    @Override
    public GlobalResponseResult findLogin(String openid) {
        return null;
    }

    @Override
    public GlobalResponseResult test() {
        return GlobalResponseResult.setResultSuccess();
    }

}