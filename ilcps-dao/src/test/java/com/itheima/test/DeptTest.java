package com.itheima.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.DeptDao;
import com.itheima.domain.Dept;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
public class DeptTest {
	@Autowired
	private DeptDao dd;

	@Test
	public void findAll() {
		List<Dept> list = dd.findAll();
		for (Dept dept : list) {
			System.out.println(dept);
		}
	}

	@Test
	public void save() {
		Dept d = new Dept();
		d.setDeptName("测试数据22222");
		dd.save(d);
	}

	@Test
	public void update() {
		Dept d = new Dept();
		d.setId("4028368163210387016321038ab40000");
		d.setDeptName("测试数据111111");
		d.setState(1);
		dd.save(d);
	}

	@Test
	public void delete() {
		Dept d = new Dept();
		d.setId("402836816321070501632107083d0000");
		dd.delete(d);
	}

	@Test
	public void findOne() {
		Dept one = dd.findOne("100");
		System.out.println(one);
	}

	@Test
	public void findByPage() {
		Pageable p = new PageRequest(0, 2);
		Page<Dept> page = dd.findAll(p);
		List<Dept> list = page.getContent();
		System.out.println(list);
	}

	/*@Test
	public void findBy() {
		List<Dept> list = null;
		// List<Dept> list =
		// dd.findByDeptId("73f3fa2f-66a2-4d16-8306-78d89003031b");
		list = dd.findByState(1);

		for (Dept dept : list) {
			System.out.println(dept);
		}
	}*/

	@Test
	public void queryAll() {
		/*List<Dept> list = dd.queryAll(1, "100");
		for (Dept dept : list) {
			System.out.println(dept);
		}*/
	}

	/*@Test
	@Rollback(false)
	public void updateById() {
		dd.update("4028368163210387016321038ab40000", 0);
	}*/

}
