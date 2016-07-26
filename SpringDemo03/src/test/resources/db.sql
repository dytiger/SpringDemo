DROP TABLE IF EXISTS `test_users`;
CREATE TABLE `test_users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(50) unique NOT NULL DEFAULT '',
  `password` varchar(40) NOT NULL DEFAULT '',
  `email` varchar(150) unique NOT NULL DEFAULT '',
  `user_level` int(2) NOT NULL DEFAULT '0',
  `status` char(2) DEFAULT 'NA',
  `regist_time` datetime NOT NULL DEFAULT current_timestamp,
  `last_login_time` datetime NOT NULL DEFAULT current_timestamp,
  `val_code` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;