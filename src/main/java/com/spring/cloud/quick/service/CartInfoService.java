package com.spring.cloud.quick.service;

import com.spring.cloud.quick.dao.CartInfoDao;
import com.spring.cloud.quick.entity.CartInfoEntity;
import com.spring.cloud.quick.utils.TableModelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huixiong on 2018/1/4.
 */
@Component
public class CartInfoService {
    @Autowired
    private CartInfoDao cartInfoDao;

    public CartInfoEntity getCartInfoByUserId(Long userId){
        // 获取分表名称
        String tableName ="js_cart_info";
        tableName = TableModelHelper.getCartInfoTableName(String.valueOf(userId), tableName);
        // 组装参数
        Map<String,Object> param = new HashMap();
        param.put("userId",userId);
        param.put("tableName",tableName);
        return cartInfoDao.getCartInfoByUserId(param);
    }
}
