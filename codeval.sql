--This is the script for the coding eval.

/*CREATE THE TABLE
CREATE TABLE fam_members (
    mem_id serial primary key not null,
    f_name text,
    l_name text,
    
    father_id int ,
    father_f_name text,
    father_l_name text,
    
    mother_id int ,
    mother_f_name text,
    mother_l_name text
);
*/

/*CREATE FIRST ANCESTORS
insert into fam_members (
f_name, 
l_name,  
father_id,
father_f_name,
father_l_name,
mother_id,
mother_f_name,
mother_l_name)
values( 
'Ancient',
'McOlderson',
0,
'unkown',
'unkown',
0,
'unkown',
'unkown'
);


insert into fam_members (
f_name, 
l_name,  
father_id,
father_f_name,
father_l_name,
mother_id,
mother_f_name,
mother_l_name)
values( 
'Sally',
'Henwich',
0,
'unkown',
'unkown',
0,
'unkown',
'unkown'
);

insert into fam_members (
f_name, 
l_name,  
father_id,
father_f_name,
father_l_name,
mother_id,
mother_f_name,
mother_l_name)
values( 
'Richard',
'McOlderson',
1,
'Ancient',
'McOlderson',
2,
'Sally',
'Henwich'
);
*/



