package com.bit.jdbc.dao.test;

import java.util.List;

import com.bit2017.jdbc.vo.AuthorVo;
import com.bit2019.jdbc.dao.AuthorDao;

public class AuthorDaoTest {
	public static void main(String[] args) {
		//insertTest();
		//deleteTest();
		getListTest();
		
		
	}
	private static void deleteTest(){
		
		AuthorDao authorDao = new AuthorDao();
		authorDao.delete(new Long(2L));
		
	}
	private static void insertTest(){
		//Mock Data
		AuthorVo authorVo = new AuthorVo();
		authorVo.setName("김경리");
		authorVo.setDescription("어쩌구저쩌구");
		
		AuthorDao authorDao = new AuthorDao();
		authorDao.insert(authorVo);
	}
	private static void getListTest(){ //select임 
		AuthorDao authorDao = new AuthorDao();
		List<AuthorVo> list = authorDao.getList();
		
		for(AuthorVo vo: list){
			System.out.println(vo);
		}
	}
}
