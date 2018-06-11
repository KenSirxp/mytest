package com.itheima.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.itheima.common.dao.BaseDao;
import com.itheima.domain.Contract;

public interface StatChartDao extends BaseDao<Contract, String> {

	@Query(nativeQuery = true, value = "select p.factory_name,sum(amount) amount"
			+ " from (select cp.factory_name,sum(cp.amount) amount from contract_product_c cp group by cp.factory_name"
			+ " union all"
			+ " select ep.factory_name,sum(ep.amount) amount from ext_cproduct_c ep group by ep.factory_name) p"
			+ " group by p.factory_name")
	List<Object[]> findFactorySale();

	@Query(nativeQuery = true, value = "select * from(" + " select  cp.product_no,sum(amount) amount"
			+ " from contract_product_c cp" + " group by cp.product_no" + " order by amount desc) p"
			+ " where rownum<=15")
	List<Object[]> findProductSale();

	@Query(nativeQuery = true, value = "select o.a1,nvl(p.times,0) from online_info_t o"
			+ " left join( select to_char(l.login_time,'hh24') lt,count(to_char(l.login_time,'hh24')) times"
			+ " from login_log_p l group by to_char(l.login_time,'hh24')) p" + " on p.lt=o.a1 order by o.a1")
	List<Object[]> findOnlineInfo();

}
