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
public class ProductDaoImpl extends baseDao implements ProductDao {
	public Map<Object, Object> selectProductByName(String name) {
		SqlSession  sqlSession= getSqlSession();
		return sqlSession.selectOne("selectProductByName", name);
	}

	public void add(String name) {
		SqlSession  sqlSession= getSqlSession();
		sqlSession.insert("add", name);
	}
	public int addOne(User3 user) {
		SqlSession  sqlSession= getSqlSession();
		return sqlSession.insert("addOne", user);
		
	}

	public int addList(List<HashMap<String, Object>> list) {
		SqlSession  sqlSession= getSqlSession();
		return sqlSession.insert("addList", list);
	}

	public List<Map<Object, Object>> loadAll() {
		SqlSession  sqlSession= getSqlSession();
		return sqlSession.selectList("loadAll");
	}
}
