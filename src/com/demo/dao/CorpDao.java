package com.demo.dao;

import com.demo.pojo.Corp;

import java.util.List;

public interface CorpDao {
	
	/**
	 * 此处的方法名“deleteByPrimaryKey”，对应mapping.xml文件中的<delete id="deleteByPrimaryKey" parameterType="java.lang.Integer">中的id;必须保持一致
	 * @param corpId
	 * @return
	 */
    int deleteByPrimaryKey(Integer corpId);

    int insert(Corp record);

    Corp selectByPrimaryKey(Integer corpId);

    void insertList(List<Corp> list);
}