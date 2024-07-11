-- 创建库
create database if not exists my_db;

-- 切换库
use my_db;

-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userAccount  varchar(256)                           not null comment '账号',
    userPassword varchar(512)                           not null comment '密码',
    userName     varchar(256)                           null default '你没起名字' comment '用户昵称',
    userAvatar   varchar(1024)                          null comment '用户头像',
    money        double                                 null default 0 comment '余额',
    courseList   varchar(2048)                          null comment '已购课程id列表',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user/admin/ban',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '逻辑删除'
) comment '用户' collate = utf8mb4_unicode_ci;


-- 课程表
create table if not exists course
(
    id           bigint auto_increment comment 'id' primary key,
    courseName   varchar(256)                            not null comment '课程名称',
    url          varchar(1024)                           null comment     '课程链接地址',
    value        double                                  not null comment '课程标价',
    imgUrl       varchar(2048)                           null comment '课程封面地址',
    type         tinyint                                 not null default 0 comment '课程类型 0-其他 1-计算机 2-数学 3-语文 4-英语 5-物理 6-艺术',
    profile      varchar(2048)                           null comment '课程介绍',
    founder      varchar(256)                            not null comment '课程主讲人',
    num          long                                    not null comment '已购人数',
    createTime   datetime     default CURRENT_TIMESTAMP  not null comment  '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP  not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                  not null comment '逻辑删除'
) comment '课程' collate = utf8mb4_unicode_ci;