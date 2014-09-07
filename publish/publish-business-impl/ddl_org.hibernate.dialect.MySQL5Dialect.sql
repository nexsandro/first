alter table TB_COMP drop foreign key FKD185AA405247FFA3;
alter table TB_COMP_MRKT_SEGM drop foreign key FK2148874A75DC5FC;
alter table TB_COMP_MRKT_SEGM drop foreign key FK2148874ACF58B34A;
alter table TB_COMP_PRDT drop foreign key FKE40B10B1CF58B34A;
alter table TB_COMP_PRDT drop foreign key FKE40B10B1844536BF;
alter table TB_CTCT drop foreign key FKD185BBD3CF58B34A;
alter table TB_PRDT drop foreign key FKD18B9D4342A55301;
alter table TB_PRDT drop foreign key FKD18B9D434427D48B;
alter table TB_USER drop foreign key FKD18DE6FCCF58B34A;
alter table tb_user_role drop foreign key FK37884BD9EA927CD0;
alter table tb_user_role drop foreign key FK37884BD9EA95537A;
drop table if exists TB_ADDR;
drop table if exists TB_BRND;
drop table if exists TB_COMP;
drop table if exists TB_COMP_MRKT_SEGM;
drop table if exists TB_COMP_PRDT;
drop table if exists TB_CTCT;
drop table if exists TB_KEYW;
drop table if exists TB_MANF;
drop table if exists TB_MRKT_SEGM;
drop table if exists TB_PRDT;
drop table if exists TB_ROLE;
drop table if exists TB_USER;
drop table if exists tb_user_role;
create table TB_ADDR (sq_addr bigint not null auto_increment, no_cep varchar(8), no_city varchar(255), no_cntr varchar(255), no_extr varchar(600), no_numb varchar(10), no_stat varchar(2), no_stre varchar(255), nu_vers integer, primary key (sq_addr));
create table TB_BRND (sq_brnd bigint not null auto_increment, no_name varchar(255) not null, no_vers integer not null, primary key (sq_brnd));
create table TB_COMP (sq_comp bigint not null auto_increment, no_cnpj varchar(14), tx_comm varchar(600), no_name varchar(255), no_site varchar(255), nu_vers integer, sq_addr bigint, primary key (sq_comp));
create table TB_COMP_MRKT_SEGM (sq_comp bigint not null, sq_mrkt_segm bigint not null, primary key (sq_comp, sq_mrkt_segm));
create table TB_COMP_PRDT (sq_comp bigint not null, sq_prdt bigint not null, primary key (sq_comp, sq_prdt));
create table TB_CTCT (sq_ctct bigint not null auto_increment, no_mai1 varchar(255), no_mai2 varchar(255), no_fon1 varchar(12), no_fon2 varchar(12), no_name varchar(255), nu_vers integer, sq_comp bigint not null, primary key (sq_ctct));
create table TB_KEYW (sq_prdt bigint not null auto_increment, no_name varchar(255) not null, no_vers integer not null, primary key (sq_prdt));
create table TB_MANF (sq_manf bigint not null auto_increment, no_name varchar(255) not null, no_vers integer, primary key (sq_manf));
create table TB_MRKT_SEGM (sq_mrkt_segm bigint not null auto_increment, no_name varchar(255) not null, no_vers integer not null, primary key (sq_mrkt_segm));
create table TB_PRDT (sq_prdt bigint not null auto_increment, no_name varchar(255) not null, no_vers integer not null, sq_brnd bigint, sq_manf bigint, primary key (sq_prdt));
create table TB_ROLE (sq_role integer not null auto_increment, no_name varchar(255) not null, primary key (sq_role));
create table TB_USER (sq_user bigint not null auto_increment, no_mail varchar(255), no_logn varchar(255), no_name varchar(255), no_pass varchar(255), no_phon varchar(255), nu_vers varchar(10), sq_comp bigint, primary key (sq_user));
create table tb_user_role (sq_user bigint not null, sq_role integer not null, primary key (sq_user, sq_role));
alter table TB_COMP add index FKD185AA405247FFA3 (sq_addr), add constraint FKD185AA405247FFA3 foreign key (sq_addr) references TB_ADDR (sq_addr);
alter table TB_COMP_MRKT_SEGM add index FK2148874A75DC5FC (sq_mrkt_segm), add constraint FK2148874A75DC5FC foreign key (sq_mrkt_segm) references TB_MRKT_SEGM (sq_mrkt_segm);
alter table TB_COMP_MRKT_SEGM add index FK2148874ACF58B34A (sq_comp), add constraint FK2148874ACF58B34A foreign key (sq_comp) references TB_COMP (sq_comp);
alter table TB_COMP_PRDT add index FKE40B10B1CF58B34A (sq_comp), add constraint FKE40B10B1CF58B34A foreign key (sq_comp) references TB_COMP (sq_comp);
alter table TB_COMP_PRDT add index FKE40B10B1844536BF (sq_prdt), add constraint FKE40B10B1844536BF foreign key (sq_prdt) references TB_PRDT (sq_prdt);
alter table TB_CTCT add index FKD185BBD3CF58B34A (sq_comp), add constraint FKD185BBD3CF58B34A foreign key (sq_comp) references TB_COMP (sq_comp);
alter table TB_PRDT add index FKD18B9D4342A55301 (sq_manf), add constraint FKD18B9D4342A55301 foreign key (sq_manf) references TB_MANF (sq_manf);
alter table TB_PRDT add index FKD18B9D434427D48B (sq_brnd), add constraint FKD18B9D434427D48B foreign key (sq_brnd) references TB_BRND (sq_brnd);
alter table TB_USER add index FKD18DE6FCCF58B34A (sq_comp), add constraint FKD18DE6FCCF58B34A foreign key (sq_comp) references TB_COMP (sq_comp);
alter table tb_user_role add index FK37884BD9EA927CD0 (sq_role), add constraint FK37884BD9EA927CD0 foreign key (sq_role) references TB_ROLE (sq_role);
alter table tb_user_role add index FK37884BD9EA95537A (sq_user), add constraint FK37884BD9EA95537A foreign key (sq_user) references TB_USER (sq_user);
