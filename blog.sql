use mygym;

# admin table
drop table if exists `admin`;
create table `admin`(
                        `id` bigint unsigned primary key auto_increment,
                        `username` varchar(255) not null,
                        `password` varchar(255) not null,
                        `create_time` datetime not null default now(),
                        `update_time` datetime not null default now()
)engine=innodb, charset=utf8;

insert into `admin`(`username`, `password`) values('white', '202cb962ac59075b964b07152d234b70');

# course table
drop table if exists `course`;
create table `course`(
                         `id` bigint unsigned primary key auto_increment,
                         `course_name` varchar(255) not null,
                         `create_time` datetime not null default now(),
                         `update_time` datetime not null default now()
)engine=innodb, charset=utf8;

insert into `course`(course_name) values('减脂训练');
insert into `course`(course_name) values('肌肉训练');
insert into `course`(course_name) values('体能训练');

# coach table
drop table if exists `coach`;
create table `coach`(
                        `id` bigint unsigned primary key auto_increment,
                        `name` varchar(255) not null,
                        `gender` varchar(10) not null,
                        `experience` tinyint unsigned not null default 0,
                        `create_time` datetime not null default now(),
                        `update_time` datetime not null default now()
)engine=innodb, charset=utf8;

insert into `coach`(`name`, `gender`, `experience`) values('张三', '男', 4);
insert into `coach`(`name`, `gender`, `experience`) values('李四', '女', 1);
insert into `coach`(`name`, `gender`, `experience`) values('王五', '女', 5);
insert into `coach`(`name`, `gender`, `experience`) values('赵跃进', '男', 7);

drop table if exists `notice`;
create table `notice`(
                         `id` bigint unsigned primary key auto_increment,
                         `title` varchar(255) not null,
                         `content` varchar(255) not null,
                         `create_time` datetime not null default now(),
                         `update_time` datetime not null default now()
)engine=innodb, charset=utf8;

insert into `notice`(`title`, `content`) values('关于本店放假的通知', '本店拟于2023.4.5休息一天，忘周知');
insert into `notice`(`title`, `content`) values('关于本店福利的通知', '本店从今天开始提供免费下午茶，祝大家健身愉快');
insert into `notice`(`title`, `content`) values('促销活动', '新年大促，月卡立减50');
insert into `notice`(`title`, `content`) values('开业大吉', '开业大促，月卡办一送一');

drop table if exists `comment`;
create table `comment`(
                          `id` bigint unsigned primary key auto_increment,
                          `content` varchar(255) not null,
                          `create_time` datetime not null default now(),
                          `update_time` datetime not null default now()
)engine=innodb, charset=utf8;

insert into `comment`(`content`) values('很好，很推荐');
insert into `comment`(`content`) values('五星好评★★★★★');
insert into `comment`(`content`) values('很好，孩子很喜欢');
insert into `comment`(`content`) values('还会再回购');
