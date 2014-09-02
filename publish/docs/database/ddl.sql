-- create schema DUMP;


drop table tb_dir;
drop table tb_file;
drop table tb_user_grup;
drop table tb_grup;
drop table tb_user;
drop table tb_proj;
drop table tb_proj_user;
drop table tb_proj_grup;


create table tb_grup (
	sq_grup int not null auto_increment primary key,
    no_grup varchar(255) not null
);

create table tb_user_grup (
    sq_user int not null,
    sq_grup int not null
);

create table tb_user (
	sq_user int not null auto_increment primary key,
    no_logn varchar(255) not null,
    no_pass varchar(255) not null
);

create table tb_proj (
	sq_proj int not null auto_increment primary key,
	no_name varchar(255) not null
);

create table tb_proj_user (
	sq_proj int not null,
	sq_user int not null
);

create table tb_proj_grup (
	sq_proj int not null,
	sq_grup int not null
);

create table tb_dir (
	sq_dir int not null auto_increment primary key,
	no_dir varchar(255) not null,
	no_path varchar(2000) not null,
	sq_prnt int,
	no_vers int not null
);

create table tb_file (
	sq_file int not null auto_increment primary key,
	sq_dir int,
	sq_faml int,
	no_name varchar(255) not null,
	cd_situ int(4) not null,
	nu_size int not null,
	no_vers int not null
);

create table tb_cnfg_parm (
	cd_cnfg_parm varchar(255) not null,
	no_valu varchar(255) not null
);


insert into tb_cnfg_parm(cd_cnfg_parm, no_valu) values ('FILESYSTEM_ROOT', 'c:/environment/fileserver');

create index ip_dir on tb_dir(sq_dir);

create index ip_file on tb_file(sq_file);

create index ip_user on tb_user(sq_user);

create index ip_grup on tb_grup(sq_grup);

create index ip_proj on tb_proj(sq_proj);

create index ip_proj_user on tb_proj_user(sq_proj, sq_user);

create index ip_proj_grup on tb_proj_grup(sq_proj, sq_grup);

create index ip_cnfg_parm on tb_cnfg_parm(cd_cnfg_parm);

alter table tb_cnfg_parm add constraint PK_cnfg_parm primary key (cd_cnfg_parm);

alter table tb_grup add constraint PK_GRUP primary key (sq_grup);

alter table tb_user add constraint PK_USER primary key (sq_user);

alter table tb_user_grup add constraint PK_user_GRUP primary key  (sq_user, sq_grup);

alter table tb_proj add constraint PK_PROJ primary key  (sq_proj);

alter table tb_proj_grup add constraint PK_PROJ_GRUP primary key  (sq_proj, sq_grup);

alter table tb_proj_user add constraint PK_PROJ_USER primary key  (sq_proj, sq_user);

create sequence se_grup start with 1 increment by 1;

create sequence se_user start with 1 increment by 1;

create sequence se_proj start with 1 increment by 1;
