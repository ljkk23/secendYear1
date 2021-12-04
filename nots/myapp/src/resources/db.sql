CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) NOT NULL DEFAULT '' COMMENT '书名',
  `author` char(20) NOT NULL DEFAULT '' COMMENT '作者',
  `price` int(11) NOT NULL DEFAULT '0' COMMENT '价格',
  `type` char(15) NOT NULL DEFAULT '' COMMENT '类别',
  `describe` varchar(250) NOT NULL DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;