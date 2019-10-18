package com.qy.shopmember.manage;


import com.qy.shopmember.model.merchant.pojo.Merchant;

/**
 * @author qiyun
 * @date 2019/10/17
 * @描述
 */
public interface MerchantManage {
    /**
     * 商户注册
     * @param merchant
     */
    void regist(Merchant merchant);
}
