select first_name|| ' ' ||last_name, 
	   email, 
	   phone_number,
	   to_char(hire_date, 'yyyy-mm-dd')
  from employees
 where first_name like '%en%'
    or last_name like '%en%'
  ;