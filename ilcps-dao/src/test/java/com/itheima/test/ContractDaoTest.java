package com.itheima.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.dao.ContractDao;
import com.itheima.domain.Contract;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ContractDaoTest {
	@Autowired
	private ContractDao cd;
	@Test
	public void test(){
		List<Contract> contract = cd.findByIds(new String[]{"8a7e84c363587fe701635884ee690001"});
		System.out.println(contract);
	}

}
