package com.itheima.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.itheima.common.dao.BaseDao;
import com.itheima.domain.ContractProduct;

public interface ContractProductDao extends BaseDao<ContractProduct,String> {
	/**
	 * 通过船期查询所有货物
	 * @param inputDate
	 * @return
	 */
	@Query("from ContractProduct cp where to_char(cp.contract.shipTime,'yyyy-MM')=?1")
	List<ContractProduct> findProductByShipTime(String inputDate);
}
