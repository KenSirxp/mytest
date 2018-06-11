package com.itheima.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.dao.DeptDao;
import com.itheima.domain.Dept;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DeptTest2 {
	@Autowired
	private DeptDao dd;

	/**
	 * 动态条件查询
	 */
	@Test
	public void findAll() {
		String deptId = null;
		Integer state = 1;

		Specification<Dept> spec = new Specification<Dept>() {
			@Override
			public Predicate toPredicate(Root<Dept> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<>();
				if (StringUtils.isNoneBlank(deptId)) {
					Predicate p1 = cb.equal(root.get("deptId").as(String.class), deptId);
					list.add(p1);
				}
				if (state != null) {
					Predicate p2 = cb.equal(root.get("state").as(Integer.class), state);
					list.add(p2);
				}
				Predicate[] preds = new Predicate[list.size()];
				Predicate[] array = list.toArray(preds);
				return cb.and(array);
			}
		};

		List<Dept> list = dd.findAll(spec);
		for (Dept dept : list) {
			System.out.println(dept);
		}
	}
}
