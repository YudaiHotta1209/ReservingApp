CREATE SCHEMA IF NOT EXISTS `buildings`;
USE `buildings`;

集会室予約用
CREATE TABLE IF NOT EXISTS meeting_info(
　id bigint(50) NOT NULL AUTO_INCREMENT,
  roomid int(11) NOT NULL, 
  username VARCHAR(64),
  day varchar(20),
  start VARCHAR,
  close VARCHAR,
  purpose VARCHAR(64),
  owner VARCHAR(64),
  people int(20),
  remarks VARCHAR(100),
);


ログイン用
CREATE TABLE IF NOT EXISTS users(
  username VARCHAR(64) NOT NULL primary key,
  password VARCHAR(128) NOT NULL
  authority enum('ADMIN','USER')not null
);

ユーザー情報詳細用
CREATE TABLE IF NOT EXISTS user_info(
  username VARCHAR(64),
  address int,
  workplace VARCHAR(64),
  mailaddress VARCHAR(100),
  information VARCHAR(100),
);