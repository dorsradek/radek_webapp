insert into security_role(name) values ("ROLE_admin");
insert into security_role(name) values ("ROLE_Kennel_Owner");
insert into security_role(name) values ("ROLE_User");
insert into user (first_name,family_name,password,username,confirm_password,active)
values ("ioannis","ntantis","123456","giannisapi","123456",1);
insert into user_security_role (user_id,security_role_id) values (1,1);