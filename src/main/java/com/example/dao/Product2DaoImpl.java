package com.example.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.base.baseDao;
import com.example.pojo.User3;

@Mapper
@Repository
public class Product2DaoImpl extends baseDao implements Product2Dao {

	public int addList2(List<HashMap<String, Object>> list) {
		SqlSession  sqlSession= getSqlSession();
		return sqlSession.insert("addList2", list);
	}
}
