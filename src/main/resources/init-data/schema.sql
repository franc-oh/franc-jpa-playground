drop table if exists ACCOUNT;

CREATE TABLE ACCOUNT (
    ACCOUNT_ID BIGINT NOT NULL AUTO_INCREMENT COMMENT '회원번호',
    NAME VARCHAR(50) NOT NULL COMMENT '회원이름',
    STATUS INTEGER DEFAULT 1 COMMENT '상태 (1:사용, 9:정지, 0:탈퇴)',
    EMAIL VARCHAR(50) NOT NULL COMMENT '이메일',
    VIP_YN BOOLEAN DEFAULT FALSE COMMENT 'VIP여부',
    INSERT_AT TIMESTAMP DEFAULT NOW() COMMENT '등록일자',
    CONSTRAINT ACCOUNT_PK PRIMARY KEY(ACCOUNT_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '회원정보';