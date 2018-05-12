package com.spring.cloud.quick.service;

import com.alibaba.fastjson.JSON;
import com.spring.cloud.quick.entity.CartInfoEntity;
import com.spring.cloud.quick.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by huixiong on 2018/2/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= Application.class)
@WebAppConfiguration
public class CartInfoServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(CartInfoServiceTest.class);


    @Autowired
    private CartInfoService cartInfoService;


    @Test
    public void testGetCartInfo(){
        Long userId = 16130151L;
        CartInfoEntity cartInfoEntity = cartInfoService.getCartInfoByUserId(userId);
        logger.info(JSON.toJSONString(cartInfoEntity));
    }
}
