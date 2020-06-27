/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50730
Source Host           : localhost:3306
Source Database       : cloudmusic

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2020-06-04 22:17:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminid` int(11) NOT NULL AUTO_INCREMENT,
  `accounts` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`adminid`,`accounts`) USING BTREE,
  KEY `admin` (`accounts`,`password`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('2', 'sa', '123456');
INSERT INTO `admin` VALUES ('1', 'system', '123456');

-- ----------------------------
-- Table structure for album
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `albumid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `singerid` int(11) DEFAULT NULL,
  `introduction` varchar(40) DEFAULT NULL,
  `cover` varchar(80) DEFAULT NULL,
  `releasetime` date DEFAULT NULL,
  `style` varchar(8) DEFAULT NULL,
  `recommend` enum('y','n') DEFAULT 'n',
  PRIMARY KEY (`albumid`) USING BTREE,
  KEY `singor` (`singerid`) USING BTREE,
  KEY `style` (`style`) USING BTREE,
  CONSTRAINT `album_ibfk_1` FOREIGN KEY (`singerid`) REFERENCES `singer` (`singerid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of album
-- ----------------------------
INSERT INTO `album` VALUES ('1', '25周年精选', '1', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('2', '光辉岁月十五年', '1', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('3', '海阔天空', '1', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('4', '犹豫', '1', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('5', '秘密警察', '1', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('6', 'A.I.N.Y. 爱你', '2', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('7', 'Xposed', '2', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('8', '光年之外', '2', null, 'albumCover/album.jpg', '2010-01-01', null, 'y');
INSERT INTO `album` VALUES ('9', '另一个童话', '2', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('10', '后会无期', '2', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('11', '喜欢你', '2', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('12', '我是歌手第二季 半决赛', '2', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('13', '摩天动物园', '2', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('14', '新的心跳', '2', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('15', '烟火里的尘埃', '3', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('16', 'Kiss Me Soft avep1', '4', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('17', 'Simply Me', '5', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('18', '100天', '6', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('19', 'JJ陆', '6', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('20', '她说 概念自选辑', '6', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('21', '新地球', '6', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('22', '曹操', '6', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('23', '第二天堂', '6', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('24', '编号89757', '6', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('25', '有点野', '7', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('26', '温式效应', '7', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('27', '再见，昨天', '8', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('28', '加油吧 实习生 电视原声带', '8', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('29', '欢乐颂2 电视原声带', '8', null, 'albumCover/album.jpg', '2010-01-01', null, 'y');
INSERT INTO `album` VALUES ('30', 'My Love', '9', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('31', '小幸运', '9', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('32', '渺小', '9', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('33', '天使与魔鬼的对话', '10', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('34', '若你碰到他', '10', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('35', '初学者', '10', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('36', '意外', '10', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('37', '我是歌手第三季 总决赛', '10', null, 'albumCover/album.jpg', '2010-01-01', null, 'y');
INSERT INTO `album` VALUES ('38', '未完成的歌', '10', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('39', '渡', '10', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('40', '绅士', '10', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('41', '纸船', '11', null, 'albumCover/album.jpg', '2010-01-01', null, 'y');
INSERT INTO `album` VALUES ('42', 'Hello 1', '12', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('43', 'Eason Moving On Stag', '13', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('44', 'Life Continues…', '13', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('45', 'rice & shine', '13', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('46', 'U-87', '13', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('47', 'What\'s Going On…？', '13', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');
INSERT INTO `album` VALUES ('48', '认了吧', '13', null, 'albumCover/album.jpg', '2010-01-01', null, 'n');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `keyid` int(11) DEFAULT NULL,
  `type` enum('music','issue') DEFAULT 'music',
  `text` varchar(100) DEFAULT NULL,
  `likes` int(11) DEFAULT '0',
  `createtime` date DEFAULT NULL,
  PRIMARY KEY (`commentid`) USING BTREE,
  KEY `comment` (`keyid`,`type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '2', 'music', '真好听', '21', '2020-05-03');
INSERT INTO `comment` VALUES ('2', '2', '2', 'music', '好听', '23', '2020-05-01');
INSERT INTO `comment` VALUES ('3', '3', '2', 'music', '听这首歌我很开心', '11', '2020-05-05');
INSERT INTO `comment` VALUES ('4', '1', '2', 'music', '你好', '0', '2020-05-06');
INSERT INTO `comment` VALUES ('5', '1', '2', 'music', '你好吗', '0', '2020-05-06');
INSERT INTO `comment` VALUES ('6', '1', '2', 'music', '是你吗', '0', '2020-05-06');
INSERT INTO `comment` VALUES ('7', '1', '2', 'music', '1234abcd', '0', '2020-05-06');
INSERT INTO `comment` VALUES ('8', '1', '2', 'music', '2938479khfa;gha;gka;g', '0', '2020-05-06');
INSERT INTO `comment` VALUES ('9', '1', '2', 'music', 'asdgagadhsstrsj', '0', '2020-05-06');

-- ----------------------------
-- Table structure for music
-- ----------------------------
DROP TABLE IF EXISTS `music`;
CREATE TABLE `music` (
  `musicid` int(11) NOT NULL AUTO_INCREMENT,
  `cover` varchar(40) DEFAULT NULL,
  `name` varchar(35) NOT NULL,
  `singerid` int(11) DEFAULT NULL,
  `albumid` int(11) DEFAULT NULL,
  `collecttime` date DEFAULT NULL,
  `path` varchar(80) DEFAULT NULL,
  `playtimes` int(11) DEFAULT '0',
  `style` varchar(8) DEFAULT NULL,
  `location` varchar(8) DEFAULT NULL,
  `category` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`musicid`) USING BTREE,
  KEY `style` (`style`) USING BTREE,
  KEY `singor` (`singerid`) USING BTREE,
  KEY `album` (`albumid`) USING BTREE,
  CONSTRAINT `music_ibfk_1` FOREIGN KEY (`singerid`) REFERENCES `singer` (`singerid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `music_ibfk_2` FOREIGN KEY (`albumid`) REFERENCES `album` (`albumid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of music
-- ----------------------------
INSERT INTO `music` VALUES ('1', 'musicCover/music.jpg', 'Beyond - 冷雨夜', '1', '1', '2020-04-28', 'music/Beyond/25周年精选/Beyond - 冷雨夜.mp3', '0', null, '港台', null);
INSERT INTO `music` VALUES ('2', 'musicCover/music.jpg', 'Beyond - 真的爱你', '1', '1', '2020-04-28', 'music/Beyond/25周年精选/Beyond - 真的爱你.mp3', '0', null, '港台', null);
INSERT INTO `music` VALUES ('3', 'musicCover/music.jpg', 'Beyond - 谁伴我闯荡', '1', '1', '2020-04-28', 'music/Beyond/25周年精选/Beyond - 谁伴我闯荡.mp3', '0', null, '港台', null);
INSERT INTO `music` VALUES ('4', 'musicCover/music.jpg', 'Beyond - 光辉岁月', '1', '2', '2020-04-28', 'music/Beyond/光辉岁月十五年/Beyond - 光辉岁月.mp3', '0', null, '港台', null);
INSERT INTO `music` VALUES ('5', 'musicCover/music.jpg', 'Beyond - 海阔天空', '1', '3', '2020-04-28', 'music/Beyond/海阔天空/Beyond - 海阔天空.mp3', '0', null, '港台', null);
INSERT INTO `music` VALUES ('6', 'musicCover/music.jpg', 'Beyond - 不再犹豫', '1', '4', '2020-04-28', 'music/Beyond/犹豫/Beyond - 不再犹豫.mp3', '0', null, '港台', null);
INSERT INTO `music` VALUES ('7', 'musicCover/music.jpg', 'Beyond - 大地', '1', '5', '2020-04-28', 'music/Beyond/秘密警察/Beyond - 大地.mp3', '0', null, '港台', null);
INSERT INTO `music` VALUES ('8', 'musicCover/music.jpg', 'G.E.M.邓紫棋 - 我的秘密', '2', '6', '2020-04-28', 'music/G.E.M.邓紫棋/A.I.N.Y. 爱你/G.E.M.邓紫棋 - 我的秘密.mp3', '0', null, '华语内地', '流行音乐');
INSERT INTO `music` VALUES ('9', 'musicCover/music.jpg', 'G.E.M.邓紫棋 - 泡沫', '2', '7', '2020-04-28', 'music/G.E.M.邓紫棋/Xposed/G.E.M.邓紫棋 - 泡沫.mp3', '0', null, '华语内地', '流行音乐');
INSERT INTO `music` VALUES ('10', 'musicCover/music.jpg', 'G.E.M.邓紫棋 - 光年之外', '2', '8', '2020-04-28', 'music/G.E.M.邓紫棋/光年之外/G.E.M.邓紫棋 - 光年之外.mp3', '0', null, '华语内地', '流行音乐');
INSERT INTO `music` VALUES ('11', 'musicCover/music.jpg', 'G.E.M.邓紫棋 - 倒数', '2', '9', '2020-04-28', 'music/G.E.M.邓紫棋/另一个童话/G.E.M.邓紫棋 - 倒数.mp3', '0', null, '华语内地', '流行音乐');
INSERT INTO `music` VALUES ('12', 'musicCover/music.jpg', 'G.E.M.邓紫棋 - 后会无期', '2', '10', '2020-04-28', 'music/G.E.M.邓紫棋/后会无期/G.E.M.邓紫棋 - 后会无期.mp3', '0', null, '华语内地', '流行音乐');
INSERT INTO `music` VALUES ('13', 'musicCover/music.jpg', 'G.E.M.邓紫棋 - 喜欢你', '2', '11', '2020-04-28', 'music/G.E.M.邓紫棋/喜欢你/G.E.M.邓紫棋 - 喜欢你.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('14', 'musicCover/music.jpg', 'G.E.M.邓紫棋 - 你不是真正的快乐 (Live)', '2', '12', '2020-04-28', 'music/G.E.M.邓紫棋/我是歌手第二季 半决赛/G.E.M.邓紫棋 - 你不是真正的快乐 (Live).mp3', '0', null, '华语内地', '流行音乐');
INSERT INTO `music` VALUES ('15', 'musicCover/music.jpg', 'G.E.M.邓紫棋 - 句号', '2', '13', '2020-04-28', 'music/G.E.M.邓紫棋/摩天动物园/G.E.M.邓紫棋 - 句号.mp3', '0', null, '华语内地', '流行音乐');
INSERT INTO `music` VALUES ('16', 'musicCover/music.jpg', 'G.E.M.邓紫棋 - 再见', '2', '14', '2020-04-28', 'music/G.E.M.邓紫棋/新的心跳/G.E.M.邓紫棋 - 再见.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('17', 'musicCover/music.jpg', '华晨宇 - 烟火里的尘埃', '3', '15', '2020-04-28', 'music/华晨宇/烟火里的尘埃/华晨宇 - 烟火里的尘埃.mp3', '0', null, '华语内地', '流行音乐');
INSERT INTO `music` VALUES ('18', 'musicCover/music.jpg', '杨千嬅 - 少女的祈祷', '4', '16', '2020-04-28', 'music/杨千嬅/Kiss Me Soft avep1/杨千嬅 - 少女的祈祷.mp3', '0', null, '港台', null);
INSERT INTO `music` VALUES ('19', 'musicCover/music.jpg', '杨千嬅 - 处处吻', '4', '17', '2020-04-28', 'music/杨千嬅/Simply Me/杨千嬅 - 处处吻.mp3', '0', null, '港台', null);
INSERT INTO `music` VALUES ('20', 'musicCover/music.jpg', '林俊杰 - 背对背拥抱', '5', '18', '2020-04-28', 'music/林俊杰/100天/林俊杰 - 背对背拥抱.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('21', 'musicCover/music.jpg', '林俊杰 - 醉赤壁', '5', '19', '2020-04-28', 'music/林俊杰/JJ陆/林俊杰 - 醉赤壁.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('22', 'musicCover/music.jpg', '林俊杰 - 心墙', '5', '20', '2020-04-28', 'music/林俊杰/她说 概念自选辑/林俊杰 - 心墙.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('23', 'musicCover/music.jpg', '林俊杰,G.E.M.邓紫棋 - 手心的蔷薇', '5', '21', '2020-04-28', 'music/林俊杰/新地球/林俊杰,G.E.M.邓紫棋 - 手心的蔷薇.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('24', 'musicCover/music.jpg', '林俊杰 - 曹操', '5', '22', '2020-04-28', 'music/林俊杰/曹操/林俊杰 - 曹操.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('25', 'musicCover/music.jpg', '林俊杰 - 江南', '5', '23', '2020-04-28', 'music/林俊杰/第二天堂/林俊杰 - 江南.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('26', 'musicCover/music.jpg', '林俊杰 - 美人鱼', '5', '23', '2020-04-28', 'music/林俊杰/第二天堂/林俊杰 - 美人鱼.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('27', 'musicCover/music.jpg', '林俊杰 - 一千年以后', '5', '24', '2020-04-28', 'music/林俊杰/编号89757/林俊杰 - 一千年以后.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('28', 'musicCover/music.jpg', '温岚,周杰伦 - 屋顶', '6', '25', '2020-04-28', 'music/温岚/有点野/温岚,周杰伦 - 屋顶.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('29', 'musicCover/music.jpg', '温岚 - 夏天的风', '6', '26', '2020-04-28', 'music/温岚/温式效应/温岚 - 夏天的风.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('30', 'musicCover/music.jpg', '牛奶咖啡 - 再见，昨天', '7', '27', '2020-04-28', 'music/牛奶咖啡/再见，昨天/牛奶咖啡 - 再见，昨天.mp3', '0', null, '华语内地', '寂静音乐');
INSERT INTO `music` VALUES ('31', 'musicCover/music.jpg', '牛奶咖啡 - 明天你好', '7', '28', '2020-04-28', 'music/牛奶咖啡/加油吧 实习生 电视原声带/牛奶咖啡 - 明天你好.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('32', 'musicCover/music.jpg', '牛奶咖啡 - 咖喱咖喱', '7', '29', '2020-04-28', 'music/牛奶咖啡/欢乐颂2 电视原声带/牛奶咖啡 - 咖喱咖喱.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('33', 'musicCover/music.jpg', '田馥甄 - 魔鬼中的天使', '8', '30', '2020-04-28', 'music/田馥甄/My Love/田馥甄 - 魔鬼中的天使.mp3', '0', null, '港台', null);
INSERT INTO `music` VALUES ('34', 'musicCover/music.jpg', '田馥甄 - 小幸运', '8', '31', '2020-04-28', 'music/田馥甄/小幸运/田馥甄 - 小幸运.mp3', '0', null, '港台', null);
INSERT INTO `music` VALUES ('35', 'musicCover/music.jpg', '田馥甄 - 你就不要想起我', '8', '32', '2020-04-28', 'music/田馥甄/渺小/田馥甄 - 你就不要想起我.mp3', '0', null, '港台', null);
INSERT INTO `music` VALUES ('36', 'musicCover/music.jpg', '蔡健雅 - 被驯服的象', '9', '33', '2020-04-28', 'music/蔡健雅/天使与魔鬼的对话/蔡健雅 - 被驯服的象.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('37', 'musicCover/music.jpg', '蔡健雅 - 红色高跟鞋', '9', '34', '2020-04-28', 'music/蔡健雅/若你碰到他/蔡健雅 - 红色高跟鞋.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('38', 'musicCover/music.jpg', '薛之谦 - 花儿和少年', '10', '35', '2020-04-28', 'music/薛之谦/初学者/薛之谦 - 花儿和少年.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('39', 'musicCover/music.jpg', '薛之谦 - 丑八怪', '10', '36', '2020-04-28', 'music/薛之谦/意外/薛之谦 - 丑八怪.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('40', 'musicCover/music.jpg', '薛之谦 - 你还要我怎样', '10', '36', '2020-04-28', 'music/薛之谦/意外/薛之谦 - 你还要我怎样.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('41', 'musicCover/music.jpg', '韩红,陈奕迅 - 十年(Live)', '10', '37', '2020-04-28', 'music/薛之谦/我是歌手第三季 总决赛/韩红,陈奕迅 - 十年(Live).mp3', '0', null, '华语内地', '情歌对唱');
INSERT INTO `music` VALUES ('42', 'musicCover/music.jpg', '薛之谦 - 认真的雪', '10', '38', '2020-04-28', 'music/薛之谦/未完成的歌/薛之谦 - 认真的雪.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('43', 'musicCover/music.jpg', '薛之谦 - 暧昧', '10', '39', '2020-04-28', 'music/薛之谦/渡/薛之谦 - 暧昧.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('44', 'musicCover/music.jpg', '薛之谦 - 演员', '10', '40', '2020-04-28', 'music/薛之谦/绅士/薛之谦 - 演员.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('45', 'musicCover/music.jpg', '薛之谦 - 绅士', '10', '40', '2020-04-28', 'music/薛之谦/绅士/薛之谦 - 绅士.mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('46', 'musicCover/music.jpg', '薛之谦,郁可唯 - 纸船', '11', '41', '2020-04-28', 'music/薛之谦,郁可唯/纸船/薛之谦,郁可唯 - 纸船.mp3', '0', null, '华语内地', '情歌对唱');
INSERT INTO `music` VALUES ('47', 'musicCover/music.jpg', '金志文,徐佳莹 - 远走高飞 (合唱版)', '12', '42', '2020-04-28', 'music/金志文/Hello 1/金志文,徐佳莹 - 远走高飞 (合唱版).mp3', '0', null, '华语内地', null);
INSERT INTO `music` VALUES ('48', 'musicCover/music.jpg', '陈奕迅 - 明年今日 (2007 Live)', '13', '43', '2020-04-28', 'music/陈奕迅/Eason Moving On Stage 1/陈奕迅 - 明年今日 (2007 Live).mp3', '0', null, '港台', '忧伤音乐');
INSERT INTO `music` VALUES ('49', 'musicCover/music.jpg', '陈奕迅 - 最佳损友', '13', '44', '2020-04-28', 'music/陈奕迅/Life Continues…/陈奕迅 - 最佳损友.mp3', '0', null, '港台', '流行音乐');
INSERT INTO `music` VALUES ('50', 'musicCover/music.jpg', '陈奕迅 - 可以了', '13', '45', '2020-04-28', 'music/陈奕迅/rice & shine/陈奕迅 - 可以了.mp3', '0', null, '港台', null);
INSERT INTO `music` VALUES ('51', 'musicCover/music.jpg', '陈奕迅 - 浮夸', '13', '46', '2020-04-28', 'music/陈奕迅/U-87/陈奕迅 - 浮夸.mp3', '0', null, '港台', null);
INSERT INTO `music` VALUES ('52', 'musicCover/music.jpg', '陈奕迅 - 富士山下', '13', '47', '2020-04-28', 'music/陈奕迅/What\'s Going On…？/陈奕迅 - 富士山下.mp3', '0', null, '港台', null);
INSERT INTO `music` VALUES ('53', 'musicCover/music.jpg', '陈奕迅 - 好久不见', '13', '48', '2020-04-28', 'music/陈奕迅/认了吧/陈奕迅 - 好久不见.mp3', '0', null, '港台', null);

-- ----------------------------
-- Table structure for musiccategory
-- ----------------------------
DROP TABLE IF EXISTS `musiccategory`;
CREATE TABLE `musiccategory` (
  `categoryid` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`categoryid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of musiccategory
-- ----------------------------
INSERT INTO `musiccategory` VALUES ('1', '古典音乐');
INSERT INTO `musiccategory` VALUES ('2', '流行音乐');
INSERT INTO `musiccategory` VALUES ('3', '轻唱民歌');
INSERT INTO `musiccategory` VALUES ('4', '寂静音乐');
INSERT INTO `musiccategory` VALUES ('5', '忧伤音乐');
INSERT INTO `musiccategory` VALUES ('6', '经典民歌');
INSERT INTO `musiccategory` VALUES ('7', '情歌对唱');

-- ----------------------------
-- Table structure for musicinsonglist
-- ----------------------------
DROP TABLE IF EXISTS `musicinsonglist`;
CREATE TABLE `musicinsonglist` (
  `songlistid` int(11) DEFAULT NULL,
  `musicid` int(11) DEFAULT NULL,
  KEY `musiclist` (`songlistid`,`musicid`) USING BTREE,
  KEY `musicid` (`musicid`) USING BTREE,
  CONSTRAINT `musicinsonglist_ibfk_2` FOREIGN KEY (`musicid`) REFERENCES `music` (`musicid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of musicinsonglist
-- ----------------------------
INSERT INTO `musicinsonglist` VALUES ('1', '2');
INSERT INTO `musicinsonglist` VALUES ('1', '4');
INSERT INTO `musicinsonglist` VALUES ('1', '6');
INSERT INTO `musicinsonglist` VALUES ('1', '10');
INSERT INTO `musicinsonglist` VALUES ('1', '15');
INSERT INTO `musicinsonglist` VALUES ('1', '25');
INSERT INTO `musicinsonglist` VALUES ('1', '31');
INSERT INTO `musicinsonglist` VALUES ('1', '34');
INSERT INTO `musicinsonglist` VALUES ('1', '42');
INSERT INTO `musicinsonglist` VALUES ('1', '51');

-- ----------------------------
-- Table structure for musiclocation
-- ----------------------------
DROP TABLE IF EXISTS `musiclocation`;
CREATE TABLE `musiclocation` (
  `locationid` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`locationid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of musiclocation
-- ----------------------------
INSERT INTO `musiclocation` VALUES ('1', '华语内地');
INSERT INTO `musiclocation` VALUES ('2', '港台');
INSERT INTO `musiclocation` VALUES ('3', '欧美');
INSERT INTO `musiclocation` VALUES ('4', '韩国');
INSERT INTO `musiclocation` VALUES ('5', '日本');

-- ----------------------------
-- Table structure for share
-- ----------------------------
DROP TABLE IF EXISTS `share`;
CREATE TABLE `share` (
  `shareid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `musicid` int(11) DEFAULT NULL,
  `songlistid` int(11) DEFAULT NULL,
  `text` varchar(100) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  PRIMARY KEY (`shareid`) USING BTREE,
  KEY `share` (`userid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of share
-- ----------------------------

-- ----------------------------
-- Table structure for singer
-- ----------------------------
DROP TABLE IF EXISTS `singer`;
CREATE TABLE `singer` (
  `singerid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `cover` varchar(80) DEFAULT NULL,
  `introduction` varchar(100) DEFAULT NULL,
  `masterpiece` varchar(25) DEFAULT NULL,
  `alphabet` char(1) DEFAULT NULL,
  PRIMARY KEY (`singerid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of singer
-- ----------------------------
INSERT INTO `singer` VALUES ('1', 'Beyond', 'singerCover/singer.jpg', '乐队', '海阔天空', 'B');
INSERT INTO `singer` VALUES ('2', 'G.E.M.邓紫棋', 'singerCover/singer.jpg', '华语歌手', '泡沫', 'D');
INSERT INTO `singer` VALUES ('3', '华晨宇', 'singerCover/singer.jpg', '华语歌手', '烟火里的尘埃', 'H');
INSERT INTO `singer` VALUES ('4', '杨千嬅', 'singerCover/singer.jpg', null, null, 'Y');
INSERT INTO `singer` VALUES ('5', '林俊杰', 'singerCover/singer.jpg', null, null, 'L');
INSERT INTO `singer` VALUES ('6', '温岚', 'singerCover/singer.jpg', null, null, 'W');
INSERT INTO `singer` VALUES ('7', '牛奶咖啡', 'singerCover/singer.jpg', null, null, 'N');
INSERT INTO `singer` VALUES ('8', '田馥甄', 'singerCover/singer.jpg', null, null, 'T');
INSERT INTO `singer` VALUES ('9', '蔡健雅', 'singerCover/singer.jpg', null, null, 'C');
INSERT INTO `singer` VALUES ('10', '薛之谦', 'singerCover/singer.jpg', null, null, 'X');
INSERT INTO `singer` VALUES ('11', '薛之谦,郁可唯', 'singerCover/singer.jpg', null, null, 'X');
INSERT INTO `singer` VALUES ('12', '金志文', 'singerCover/singer.jpg', null, null, 'J');
INSERT INTO `singer` VALUES ('13', '陈奕迅', 'singerCover/singer.jpg', null, null, 'C');

-- ----------------------------
-- Table structure for songlist
-- ----------------------------
DROP TABLE IF EXISTS `songlist`;
CREATE TABLE `songlist` (
  `songlistid` int(10) NOT NULL AUTO_INCREMENT,
  `creatorid` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `cover` varchar(40) DEFAULT NULL,
  `introduction` varchar(50) DEFAULT NULL,
  `style` varchar(8) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `collectiontimes` int(11) DEFAULT '0',
  PRIMARY KEY (`songlistid`) USING BTREE,
  KEY `getUserSongList` (`creatorid`) USING BTREE,
  KEY `getHotList` (`createtime`,`collectiontimes`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of songlist
-- ----------------------------
INSERT INTO `songlist` VALUES ('1', '0', 'recommendedmusic', null, null, 'system', null, '0');
INSERT INTO `songlist` VALUES ('2', '0', 'hotmusic', null, null, 'system', null, '0');
INSERT INTO `songlist` VALUES ('3', '0', 'newmusic', null, null, 'system', null, '0');
INSERT INTO `songlist` VALUES ('4', '0', 'newmusic', null, null, 'system', null, '0');
INSERT INTO `songlist` VALUES ('5', '0', 'newmusic', null, null, 'system', null, '0');
INSERT INTO `songlist` VALUES ('6', '0', 'newmusic', null, null, 'system', null, '0');
INSERT INTO `songlist` VALUES ('7', '0', 'newmusic', null, null, 'system', null, '0');
INSERT INTO `songlist` VALUES ('8', '0', 'newmusic', null, null, 'system', null, '0');
INSERT INTO `songlist` VALUES ('9', '0', 'newmusic', null, null, 'system', null, '0');
INSERT INTO `songlist` VALUES ('10', '0', 'newmusic', null, null, 'system', null, '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(10) NOT NULL AUTO_INCREMENT,
  `accounts` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `cover` varchar(80) DEFAULT NULL,
  `introduction` varchar(100) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `registtime` date DEFAULT NULL,
  PRIMARY KEY (`userid`,`accounts`,`password`) USING BTREE,
  KEY `userlogin` (`accounts`,`password`) USING BTREE COMMENT '登录用',
  KEY `userid` (`userid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'sa', '123', '张三', 'userCover/user.jpg', '可爱的人', '22', '男', '广东省-广州市', '2020-02-20');
INSERT INTO `user` VALUES ('2', 'sb', '123', '小风', 'userCover/user.jpg', '你好', '12', '男', '', '2020-03-20');
INSERT INTO `user` VALUES ('3', 'sc', '123', '小风', 'userCover/user.jpg', null, null, null, null, '2020-03-23');
INSERT INTO `user` VALUES ('4', 'a', '123', '小风', 'userCover/user.jpg', '你好', '22', '男', '广州', '2020-03-23');
INSERT INTO `user` VALUES ('5', 'sab', '111', '小风', 'userCover/user.jpg', null, null, null, null, '2020-04-27');
INSERT INTO `user` VALUES ('6', 'scd', '123', '小风', 'userCover/user.jpg', null, null, null, null, '2020-04-28');

-- ----------------------------
-- Table structure for usersonglist
-- ----------------------------
DROP TABLE IF EXISTS `usersonglist`;
CREATE TABLE `usersonglist` (
  `userid` int(10) NOT NULL,
  `songlistid` int(10) NOT NULL,
  `type` char(7) NOT NULL,
  KEY `usersonglist` (`userid`,`songlistid`) USING BTREE,
  KEY `songlistid` (`songlistid`) USING BTREE,
  CONSTRAINT `usersonglist_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of usersonglist
-- ----------------------------
INSERT INTO `usersonglist` VALUES ('1', '3', 'default');
