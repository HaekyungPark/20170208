delete from book;
commit; --commit반드시 해라 안그러면 변경 안됨

select * from author;

select * from book;

insert 
	into book
values(BOOK_seq.nextval,'토지', sysdate, '대여중', 1);

commit;

select book_seq.currval FROM dual;

update book
   set title = '..',
 	   state = '대여가능'
 where no =1;
 
 commit;