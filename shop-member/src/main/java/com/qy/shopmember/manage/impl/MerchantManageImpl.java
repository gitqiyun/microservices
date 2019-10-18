package com.qy.shopmember.manage.impl;


import com.qy.shopcommon.util.MD5Util;
import com.qy.shopmember.manage.MerchantManage;
import com.qy.shopmember.mapper.MerchantMapper;
import com.qy.shopmember.model.merchant.pojo.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author qiyun
 * @date 2019/10/17
 * @描述
 */
@Service
@Transactional
public class MerchantManageImpl implements MerchantManage {

    @Autowired
    MerchantMapper merchantMapper;

    @Override
    public void regist(Merchant merchant) {
        String username=merchant.getUsername();
        String password=merchant.getPassword();
        merchant.setPassword(MD5Util.MD5(username+password));
        merchant.setCreated(new Date());
        merchant.setUpdated(new Date());
        merchantMapper.insert(merchant);
        //todo 邮件通知商户注册成功
    }
}
