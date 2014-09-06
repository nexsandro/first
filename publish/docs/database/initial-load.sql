use pub;

INSERT INTO pub.tb_role (sq_role, no_name) VALUES ('1', 'Admin');
INSERT INTO pub.tb_role (sq_role, no_name) VALUES ('2', 'User');


INSERT INTO pub.tb_user (sq_user, no_mail, no_logn, no_name, no_pass, nu_vers) VALUES ('1', 'santos.sandro@gmail.com', 'sandro', 'Sebastiao A. L. Santos', 'x', '1');

INSERT INTO pub.tb_user_role (sq_user, sq_role) VALUES ('1', '1');
INSERT INTO pub.tb_user_role (sq_user, sq_role) VALUES ('1', '2');
