package com.itheima.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.itheima.common.dao.BaseDao;
import com.itheima.domain.Dept;

public interface DeptDao extends BaseDao<Dept,String> {
	
	@Query("from Dept where parent.id=?")
	List<Dept> findByParentId(String parentId);

}
