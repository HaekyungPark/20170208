package com.bit.jdbc.dao.test;

import java.util.List;

import com.bit2017.jdbc.vo.BookVo;
import com.bit2019.jdbc.dao.BookDao;

public class BookDaoTest {
	public static void main(String[] args) {
		
		insertTest();
		deleteTest();
		getListTest();
		
	}
	private static void deleteTest(){
		BookDao bookDao = new BookDao();
		bookDao.delete(new Long(2L));
	}
	private static void insertTest(){
		BookVo bookVo = new BookVo();
		bookVo.setTitle("별님달님");
		bookVo.setPub_date("2005-05-01");
		bookVo.setState("대여가능");
		bookVo.setAuthor_no((long)4);
		
		BookDao bookDao = new BookDao();
		bookDao.insert(bookVo);
	}
	private static void getListTest(){
		BookDao bookDao = new BookDao();
		List<BookVo> list = bookDao.getList();
		
		for(BookVo vo:list )
			System.out.println(vo);
	}
}
