--book sequence
drop SEQUENCE BOOK_SEQ;
create SEQUENCE book_seq START WITH 1 INCREMENT BY 1 MAXVALUE  9999999999;


--author sequence
drop SEQUENCE author_seq;

create SEQUENCE author_seq START WITH 1 INCREMENT BY 1 MAXVALUE  9999999999;

--test
--select BOOK_seq.nextval from dual;





