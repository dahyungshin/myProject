CREATE TABLE TB_BOARD (
     POST_ID INTEGER NOT NULL
    , TITLE VARCHAR(150) NOT NULL
    , CONTENTS VARCHAR(2000) NULL
    , REG_ID VARCHAR(20) NULL
    , REG_DATE DATE NULL
    , COMMUNITY_ID VARCHAR(16) NULL
    , HIT_COUNT INTEGER NULL
    , PRIMARY KEY (POST_ID)
);
CREATE TABLE TB_CODEGROUP (
     GROUP_CD VARCHAR(10) NOT NULL
    , GROUP_NM VARCHAR(20) NOT NULL
    , USE_FG VARCHAR(1) NULL
    , CREATE_USER VARCHAR(12) NULL
    , CREATE_DT DATE NULL
    , UPDATE_USER VARCHAR(12) NULL
    , UPDATE_DT DATE NULL
    , GROUP_DESC VARCHAR(100) NULL
    , PRIMARY KEY (GROUP_CD)
);
CREATE TABLE TB_CODE (
     CODE_CD VARCHAR(10) NOT NULL
    , CODE_NM VARCHAR(20) NOT NULL
    , CODE_SEQ INTEGER NULL
    , GROUP_CD VARCHAR(10) NOT NULL
    , USE_FG VARCHAR(1) NULL
    , CREATE_USER VARCHAR(12) NULL
    , CREATE_DT DATE NULL
    , UPDATE_USER VARCHAR(12) NULL
    , UPDATE_DT DATE NULL
    , CODE_GBN VARCHAR(12) NULL
    , CODE_DESC VARCHAR(100) NULL
    , PRIMARY KEY (CODE_CD, GROUP_CD)
);
CREATE TABLE TB_LARGE (
     LARGE_ID INTEGER NOT NULL
    , NAME VARCHAR(20) NOT NULL
    , PRIMARY KEY (LARGE_ID)
);
CREATE TABLE TB_USER (
      USER_ID VARCHAR(50) NOT NULL
    , USER_NAME VARCHAR(50) NOT NULL
    , EN_NAME VARCHAR(20) NULL
    , COMP_PHONE VARCHAR(20) NULL
    , PHONE VARCHAR(20) NULL
    , CELL_PHONE VARCHAR(20) NULL
    , COMPANY VARCHAR(50) NULL
    , JOB_POSITION VARCHAR(20) NULL
    , ASSIGNMENT VARCHAR(20) NULL
    , OFFICER_YN VARCHAR(20) NULL
    , FAX VARCHAR(20) NULL
    , ZIP_CODE VARCHAR(20) NULL
    , ADDRESS VARCHAR(50) NULL
    , COMP_ZIP_CODE VARCHAR(20) NULL
    , COMP_ADDRESS VARCHAR(50) NULL
    , EMAIL VARCHAR(20) NULL
    , DEPT_ID VARCHAR(20) NULL
    , PASSWORD VARCHAR(20) NOT NULL
    , PRIMARY KEY (USER_ID)
);

CREATE OR REPLACE PROCEDURE SP_DATA_CREATE (IN_LOOP_CNT    IN    NUMBER) IS

/******************************************************************************
   NAME:       PC_DATA_CREATE
   PURPOSE:    TB_LARGE 데이터생성

******************************************************************************/
BEGIN
    FOR i IN 1..IN_LOOP_CNT
    LOOP
        insert into TB_LARGE 
        values
        (
            (select NVL(MAX(LARGE_ID)+1,1) from tb_large), 
            (select 'ID:'||NVL(MAX(LARGE_ID)+1,1) from tb_large)
        );
    END LOOP;
       
   EXCEPTION
     WHEN NO_DATA_FOUND THEN
       NULL;
     WHEN OTHERS THEN
       -- Consider logging the error and then re-raise
       RAISE;
END SP_DATA_CREATE;






CREATE TABLE CODE_TB
(
  CODE_SE_CD   VARCHAR2(20 BYTE),
  CODE         VARCHAR2(10 BYTE),
  CODE_NM      VARCHAR2(20 BYTE),
  DESCRIPTION  VARCHAR2(100 BYTE),
  REG_DT       DATE
);

COMMENT ON TABLE CODE_TB IS '코드테이블';

COMMENT ON COLUMN CODE_TB.CODE_SE_CD IS '코드구분';

COMMENT ON COLUMN CODE_TB.CODE IS '코드';

COMMENT ON COLUMN CODE_TB.CODE_NM IS '코드명';

COMMENT ON COLUMN CODE_TB.DESCRIPTION IS '코드설명';

COMMENT ON COLUMN CODE_TB.REG_DT IS '등록일시';



CREATE TABLE LECTURER_TB
(
  LEC_NO        NUMBER,
  LEC_NM        VARCHAR2(10 BYTE),
  TEL_NO        VARCHAR2(11 BYTE),
  BIRTH_DY      VARCHAR2(8 BYTE),
  ADDRESS       VARCHAR2(50 BYTE),
  LEC_LV_SE_CD  VARCHAR2(10 BYTE),
  HIRE_DY       VARCHAR2(8 BYTE),
  REG_DT        DATE
);

COMMENT ON TABLE LECTURER_TB IS '강사 테이블';

COMMENT ON COLUMN LECTURER_TB.LEC_NO IS '강사번호';

COMMENT ON COLUMN LECTURER_TB.LEC_NM IS '강사명';

COMMENT ON COLUMN LECTURER_TB.TEL_NO IS '전화번호';

COMMENT ON COLUMN LECTURER_TB.BIRTH_DY IS '생년월일';

COMMENT ON COLUMN LECTURER_TB.ADDRESS IS '주소';

COMMENT ON COLUMN LECTURER_TB.LEC_LV_SE_CD IS '강사등급구분코드';

COMMENT ON COLUMN LECTURER_TB.HIRE_DY IS '고용일';

COMMENT ON COLUMN LECTURER_TB.REG_DT IS '등록일시';



CREATE TABLE CAREER_TB
(
  LEC_NO        NUMBER                          NOT NULL,
  CAREER_SE_CD  VARCHAR2(10 BYTE)               NOT NULL,
  CAREER_NO     NUMBER                          NOT NULL,
  DESCRIPTION   VARCHAR2(100 BYTE),
  START_DY      VARCHAR2(8 BYTE),
  END_DY        VARCHAR2(8 BYTE),
  SORT_NO       NUMBER,
  REG_DT        DATE
);

COMMENT ON TABLE CAREER_TB IS '강사 경력 테이블';

COMMENT ON COLUMN CAREER_TB.LEC_NO IS '강사번호';

COMMENT ON COLUMN CAREER_TB.CAREER_SE_CD IS '경력구분코드';

COMMENT ON COLUMN CAREER_TB.CAREER_NO IS '경력번호';

COMMENT ON COLUMN CAREER_TB.DESCRIPTION IS '설명';

COMMENT ON COLUMN CAREER_TB.START_DY IS '경력 시작일';

COMMENT ON COLUMN CAREER_TB.END_DY IS '경력 종료일';

COMMENT ON COLUMN CAREER_TB.SORT_NO IS '순서번호';

COMMENT ON COLUMN CAREER_TB.REG_DT IS '등록일시';


ALTER TABLE CODE_TB ADD (
  CONSTRAINT CODE_TB_PK
  PRIMARY KEY
  (CODE_SE_CD, CODE)
  );

ALTER TABLE LECTURER_TB ADD (
  CONSTRAINT LECTURER_TB_PK
  PRIMARY KEY
  (LEC_NO)
  );

ALTER TABLE CAREER_TB ADD (
  CONSTRAINT CAREER_TB_PK
  PRIMARY KEY
  (LEC_NO, CAREER_SE_CD, CAREER_NO)
  );

ALTER TABLE CAREER_TB ADD (
  CONSTRAINT CAREER_TB_R01 
  FOREIGN KEY (LEC_NO) 
  REFERENCES LECTURER_TB (LEC_NO)
  ENABLE VALIDATE);