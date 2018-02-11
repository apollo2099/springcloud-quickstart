package com.spring.cloud.quick.dao;

import com.alibaba.fastjson.JSON;
import com.spring.cloud.quick.Application;
import com.spring.cloud.quick.controller.CartInfoController;
import com.spring.cloud.quick.controller.CartInfoControllerTest;
import com.spring.cloud.quick.entity.CartInfoEntity;
import com.spring.cloud.quick.utils.TableModelHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huixiong on 2018/2/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= Application.class)
@WebAppConfiguration
public class CartInfoDaoTest {

    private static final Logger logger = LoggerFactory.getLogger(CartInfoControllerTest.class);


    @Autowired
    private CartInfoDao cartInfoDao;


    @Test
    public void testGetCartInfo(){
        Long userId = 16130151L;
        // 获取分表名称
        String tableName ="js_cart_info";
        tableName = TableModelHelper.getCartInfoTableName(String.valueOf(userId), tableName);
        // 组装参数
        Map<String,Object> param = new HashMap();
        param.put("userId",userId);
        param.put("tableName",tableName);
        CartInfoEntity cartInfoEntity = cartInfoDao.getCartInfoByUserId(param);
        logger.info(JSON.toJSONString(cartInfoEntity));
    }
}
