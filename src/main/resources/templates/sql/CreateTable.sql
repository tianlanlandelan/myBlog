create table article_info
(
	title varchar(200) null,
	content longtext null,
	sendtime datetime(6) null,
	id int not null auto_increment
		primary key,
	outline text null,
	txtContent longtext null,
	imgurl varchar(200) null
)
;

create table article_tags
(
	article_id int null,
	tag_name varchar(20) null
)
;

comment on table article_tags is '文章标签表'
;

create table article_types
(
	article_id int null,
	type_id int null
)
;

comment on table article_types is '文章类型表'
;


create table tag_info
(
	id int not null auto_increment
		primary key,
	name varchar(50) null
)
;

comment on table tag_info is '标签信息表'
;

create table type_info
(
	id int not null auto_increment
		primary key,
	name varchar(50) null
)
;

comment on table type_info is '类型信息表'
;


