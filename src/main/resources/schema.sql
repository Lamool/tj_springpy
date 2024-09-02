-- [1] DB 생성, DB생성은 mysql workbench
--drop database if exists springpy;
--create database springpy;
--use springpy;

-- [2] 테이블 생성
-- 1. user 테이블
drop table if exists user;
create table user (
    id int auto_increment,
    name varchar(20),
    age int,
    primary key (id)
);

-- 2. account 테이블
drop table if exists account;
create table account (
    num int auto_increment,
    explanation varchar(50),
    price int,
    date DATETIME,
    primary key (num)
);


