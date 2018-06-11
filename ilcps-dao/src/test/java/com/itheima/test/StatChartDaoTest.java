package com.itheima.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.StatChartDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
public class StatChartDaoTest {
	@Autowired
	private StatChartDao scd;

	@Test
	public void test() {
		//List<Object[]> list = scd.findFactorySale();
		//List<Object[]> list2 = scd.findProductSale();
		List<Object[]> list3 = scd.findOnlineInfo();
		System.out.println(list3);
	}
}
