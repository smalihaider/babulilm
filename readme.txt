Commands to create database user and grant permissions
======================================================
CREATE USER 'alih'@'localhost' IDENTIFIED BY 'secret';
GRANT ALL PRIVILEGES ON * . * TO 'alih'@'localhost';
FLUSH PRIVILEGES;

Commands to create database
===========================
CREATE DATABASE babulilm;

Link: http://www.codingpedia.org/ama/how-to-create-a-mysql-database-from-command-line/