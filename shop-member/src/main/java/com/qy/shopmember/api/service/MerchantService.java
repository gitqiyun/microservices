
package com.qy.shopmember.api.service;

import com.qy.shopcommon.globalresult.GlobalResponseResult;
import com.qy.shopmember.api.model.MerchantReqDto;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/merchant")
public interface MerchantService {
    /**
     * @methodDesc: 功能描述:(注册服务)
     * @param: @param
     * UserEntity
     * @param: @return
     */
    @PostMapping("/regist")
    GlobalResponseResult regist(@RequestBody MerchantReqDto merchantReqDto);

    /**
     * 功能描述:登录成功后,生成对应的token，作为key,将用户userID作为value存放在redis中.返回token给客户端.
     *
     * @methodDesc: 功能描述:(登录)
     * @param: @return
     */
    @PostMapping("/login")
    GlobalResponseResult login(@RequestBody MerchantReqDto merchantReqDto);

    /**
     * @methodDesc: 功能描述:(使用token查找用户信息)
     * @param: @param
     * token
     * @param: @return
     */
    @PostMapping("/getUser")
    GlobalResponseResult getUser(@RequestParam("token") String token);


    /**
     * @methodDesc: 功能描述:(使用openid查找用户信息)
     * @param: @param
     * token
     * @param: @return
     */
    @PostMapping("/findOpenId")
    GlobalResponseResult findLogin(@RequestParam("openid") String openid);

    @GetMapping("/test")
    GlobalResponseResult test();
}
