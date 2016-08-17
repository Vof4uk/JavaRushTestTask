--
-- Database: `test`
--


CREATE DATABASE IF NOT EXISTS `test`;
USE `test`;

-- --------------------------------------------------------

--
-- Table structure for table user_table--
DROP TABLE IF EXISTS `user_table`;

CREATE TABLE IF NOT EXISTS `user_table` (
  `id` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `age` int(8),
  `admin` tinyint(1) unsigned ZEROFILL NOT NULL,
  `creation_date` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB;

--
-- Dumping data for table user_table--

INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('phil', '16', '0', '2016-08-13 21:19:28.2490');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('Kozel', '10', '1', '2016-08-13 22:43:29.3670');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('kocherga', '11', '0', '2016-08-14 02:43:39.3000');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('Captain Jack', '2', '0', '2016-08-14 15:00:00.7400');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('Rosie O\'Donnel', '23', '0', '2016-08-14 15:00:17.2880');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('Sahsha', '3', '0', '2016-08-14 15:00:32.2440');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('Zap', '99', '1', '2016-08-14 15:00:45.8020');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('Cat ', '2', '1', '2016-08-14 15:01:00.5770');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('Comp_Aliosha', '22', '0', '2016-08-14 15:46:00.9580');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('gena', '55', '0', '2016-08-14 15:46:14.6370');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('feofan', '5', '1', '2016-08-14 15:46:26.8490');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('adolf', '55', '0', '2016-08-14 15:46:43.3080');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('bubka', '66', '0', '2016-08-14 15:47:13.3090');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('peoplenet', '7', '0', '2016-08-14 15:47:39.8630');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('gera', '88', '0', '2016-08-14 15:50:42.8360');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('zevs', '1000', '1', '2016-08-14 15:50:54.5210');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('apollo', '800', '0', '2016-08-14 15:51:04.5010');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('google', '6', '1', '2016-08-14 15:57:28.1840');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('kafir', '10', '1', '2016-08-14 15:58:37.1250');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('Zebra', '12', '1', '2016-08-14 20:12:57.6950');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('potato', '1', '0', '2016-08-15 16:47:34.8870');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('kisel', '100', '1', '2016-08-15 20:49:24.0500');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('ова', '14', '0', '2016-08-16 00:00:00.0000');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('Зова', '14', '0', '2016-08-16 00:00:00.0000');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('вован', '28', '1', '2016-08-16 12:13:11.8660');
INSERT INTO `user_table` (username, age, admin, creation_date) VALUES('оод', NULL, '0', '2016-08-16 12:12:45.2760');



