package com.itheima.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.itheima.common.dao.BaseDao;
import com.itheima.domain.Contract;

public interface ContractDao extends BaseDao<Contract,String> {
	
	@Query("from Contract where id in ?1")
	List<Contract> findByIds(String[] split);
}
