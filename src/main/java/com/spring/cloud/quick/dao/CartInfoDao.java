package com.spring.cloud.quick.dao;

import com.spring.cloud.quick.entity.CartInfoEntity;

import java.util.Map;

/**
 * Created by huixiong on 2018/1/4.
 */
public interface CartInfoDao {

    public CartInfoEntity getCartInfoByUserId(Map param);
}
