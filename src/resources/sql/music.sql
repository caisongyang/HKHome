CREATE TABLE `hkhome`.`hkh_music` (
  `music_id` INT NOT NULL,
  `music_name` VARCHAR(200) NULL COMMENT '歌曲名称',
  `singer_id` VARCHAR(200) NULL COMMENT '歌手id',
  `singer_name` VARCHAR(200) NULL COMMENT '歌手名称',
  `music_t1` VARCHAR(45) NULL,
  `music_mp3` BLOB NULL COMMENT 'MP3',
  PRIMARY KEY (`music_id`))
ENGINE = InnoDB;