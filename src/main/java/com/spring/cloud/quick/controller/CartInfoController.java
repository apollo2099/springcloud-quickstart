package com.spring.cloud.quick.controller;

import com.alibaba.fastjson.JSON;
import com.spring.cloud.quick.entity.CartInfoEntity;
import com.spring.cloud.quick.service.CartInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 购物袋核心业务处理入口类
 * Created by huixiong on 2018/1/4.
 */
@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartInfoController {

    private static final Logger LOG = LoggerFactory.getLogger(CartInfoController.class);

    @Autowired
    private CartInfoService cartInfoService;

    @RequestMapping(value = "/getCartInfo", method = RequestMethod.GET)
    public CartInfoEntity getCartInfo(@RequestParam("userId") Long userId){
        System.out.println("input param "+userId);
        CartInfoEntity cartInfoEntity = cartInfoService.getCartInfoByUserId(userId);
        System.out.println(JSON.toJSONString(cartInfoEntity));
        return cartInfoEntity;
    }
}
