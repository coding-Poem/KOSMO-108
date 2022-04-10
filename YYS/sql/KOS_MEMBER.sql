-- KOS_MEMBER 과제 (첫 번째 과제 끝난 후, KOS_MEMBER => KOS_MEMBER1 로 변경하였음.
-- 2022 03 31
CREATE TABLE SCOTT.KOS_MEMBER(
            MNUM VARCHAR2(20) PRIMARY KEY,
            MNAME VARCHAR2(50),
            MID VARCHAR2(50) NOT NULL,
            MPW VARCHAR2(300) NOT NULL,
            MHP VARCHAR2(16) NOT NULL,
            MEMAIL VARCHAR2(200) NOT NULL,
            MGENDER VARCHAR2(10),
            MHOBBY VARCHAR2(100),
            MLOCAL VARCHAR2(200),
            MMSG VARCHAR2(2000),
            DELETEYN VARCHAR2(1) NOT NULL,
            INSERTDATE DATE,
            UPDATEDATE DATE
);


-- =================================
COMMIT;
-- 실험으로 insert 해보기

INSERT INTO KOS_MEMBER(MNUM,MNAME,MID,MPW,MHP,MEMAIL,MGENDER,MHOBBY,MLOCAL,MMSG,DELETEYN,INSERTDATE,UPDATEDATE)
VALUES (123,'PGW','RIVEF','123','01023351912','RIVENF@NAVER.COM','M','BIKE','SEOUL','MSG','Y',SYSDATE,SYSDATE);
COMMIT;

SELECT*FROM KOS_MEMBER;
SELECT COUNT(MNUM) FROM KOS_MEMBER;
/*
           MNUM VARCHAR2(20) PRIMARY KEY,
            MNAME VARCHAR2(50),
            MID VARCHAR2(50) NOT NULL,
            MPW VARCHAR2(300) NOT NULL,
            MHP VARCHAR2(16) NOT NULL,
            MEMAIL VARCHAR2(200) NOT NULL,
            MGENDER VARCHAR2(10),
            MHOBBY VARCHAR2(100),
            MLOCAL VARCHAR2(200),
            MMSG VARCHAR2(2000),
            DELETEYN VARCHAR2(1) NOT NULL,
            INSERTDATE DATE,
            UPDATEDATE DATE
*/

/*    **DQL :: Data Query Language :: SELECT**    */
--전체 조회
SELECT               A.MNUM                                                                                                           AS      MNUM --회원번호  	:: COLUMN_ID :: 1
                              ,A.MNAME                                                                                                         AS      MNAME --회원이름	:: COLUMN_ID :: 2
                              ,A.MID                                                                                                                  AS      MID --아이디		:: COLUMN_ID :: 3
                              ,A.MPW                                                                                                               AS      MPW --패스워드	:: COLUMN_ID :: 4 
                              ,A.MHP                                                                                                                AS      MHP --핸드폰번호	:: COLUMN_ID :: 5
                              ,A.MEMAIL                                                                                                         AS     MEMAIL --이메일		:: COLUMN_ID :: 6
                              ,A.MGENDER                                                                                                     AS    MGENDER --성별		:: COLUMN_ID :: 7
                              ,A.MHOBBY                                                                                                       AS       MHOBBY --취미		:: COLUMN_ID :: 8
                              ,A.MLOCAL                                                                                                       AS      MLOCAL --지역		:: COLUMN_ID :: 9
                              ,A.MMSG                                                                                                            AS      MMSG --내용		:: COLUMN_ID :: 10
                              , A.DELETEYN                                                                                                  AS      DELETEYN --회원여부	:: COLUMN_ID :: 11
                              ,TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYY-MM-DD')          AS      INSERTDATE --등록일		:: COLUMN_ID :: 12
                              ,TO_CHAR(TO_DATE(A.UPDATEDATE), 'YYYY-MM-DD')        AS      UPDATEDATE --수정일		:: COLUMN_ID :: 13
FROM                 SCOTT.KOS_MEMBER A -- SCOTT 계정의 KOS_MEMBER 테이블 :: ALIAS(별칭)는 A
WHERE              A.DELETEYN='Y' -- 회원여부가 'Y'인 경우만 조회 (삭제회원은 조회하지 않는다.)
ORDER BY        MNUM  ASC;  -- PRIMARY KEY인 MNUM 칼럼을 오름차순으로 정렬
/*
ORDER BY 절에 컬럼 이름이 A.MNUM이 아닌 MNUM인 이유
FROM - WHERE - SELECT - ORDER BY 절 순으로 실행 되므로,
SELECT의 ALIAS명을  ORDER BY 절의 칼럼으로 입력해야 한다.
ASC : 오름차순으로 정렬하세요.
*/

-- 회원 번호 조회
SELECT               A.MNUM                                                                                                           AS      MNUM --회원번호  	:: COLUMN_ID :: 1
                              ,A.MNAME                                                                                                         AS      MNAME --회원이름	:: COLUMN_ID :: 2
                              ,A.MID                                                                                                                  AS      MID --아이디		:: COLUMN_ID :: 3
                              ,A.MPW                                                                                                               AS      MPW --패스워드	:: COLUMN_ID :: 4 
                              ,A.MHP                                                                                                                AS      MHP --핸드폰번호	:: COLUMN_ID :: 5
                              ,A.MEMAIL                                                                                                         AS     MEMAIL --이메일		:: COLUMN_ID :: 6
                              ,A.MGENDER                                                                                                     AS    MGENDER --성별		:: COLUMN_ID :: 7
                              ,A.MHOBBY                                                                                                       AS       MHOBBY --취미		:: COLUMN_ID :: 8
                              ,A.MLOCAL                                                                                                       AS      MLOCAL --지역		:: COLUMN_ID :: 9
                              ,A.MMSG                                                                                                            AS      MMSG --내용		:: COLUMN_ID :: 10
                              , A.DELETEYN                                                                                                  AS      DELETEYN --회원여부	:: COLUMN_ID :: 11
                              ,TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYY-MM-DD')          AS      INSERTDATE --등록일		:: COLUMN_ID :: 12
                              ,TO_CHAR(TO_DATE(A.UPDATEDATE), 'YYYY-MM-DD')        AS      UPDATEDATE --수정일		:: COLUMN_ID :: 13
FROM                 SCOTT.KOS_MEMBER A -- SCOTT 계정의 KOS_MEMBER 테이블 :: ALIAS(별칭)는 A
WHERE              A.DELETEYN='Y'  -- 회원여부가 'Y'인 경우만 조회 (삭제회원은 조회하지 않는다.)
AND                    A.MNUM LIKE  '%||123||%'
-- 회원번호 :: MNUM :: place holder 1
ORDER BY        MNUM  ASC; -- PRIMARY KEY인 MNUM 칼럼을 오름차순으로 정렬

-- 회원 이름 조회
SELECT               A.MNUM                                                                                                           AS      MNUM --회원번호  	:: COLUMN_ID :: 1
                              ,A.MNAME                                                                                                         AS      MNAME --회원이름	:: COLUMN_ID :: 2
                              ,A.MID                                                                                                                  AS      MID --아이디		:: COLUMN_ID :: 3
                              ,A.MPW                                                                                                               AS      MPW --패스워드	:: COLUMN_ID :: 4 
                              ,A.MHP                                                                                                                AS      MHP --핸드폰번호	:: COLUMN_ID :: 5
                              ,A.MEMAIL                                                                                                         AS     MEMAIL --이메일		:: COLUMN_ID :: 6
                              ,A.MGENDER                                                                                                     AS    MGENDER --성별		:: COLUMN_ID :: 7
                              ,A.MHOBBY                                                                                                       AS       MHOBBY --취미		:: COLUMN_ID :: 8
                              ,A.MLOCAL                                                                                                       AS      MLOCAL --지역		:: COLUMN_ID :: 9
                              ,A.MMSG                                                                                                            AS      MMSG --내용		:: COLUMN_ID :: 10
                              , A.DELETEYN                                                                                                  AS      DELETEYN --회원여부	:: COLUMN_ID :: 11
                              ,TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYY-MM-DD')          AS      INSERTDATE --등록일		:: COLUMN_ID :: 12
                              ,TO_CHAR(TO_DATE(A.UPDATEDATE), 'YYYY-MM-DD')        AS      UPDATEDATE --수정일		:: COLUMN_ID :: 13
FROM                 SCOTT.KOS_MEMBER A -- SCOTT 계정의 KOS_MEMBER 테이블 :: ALIAS(별칭)는 A
WHERE              A.DELETEYN='Y'  -- 회원여부가 'Y'인 경우만 조회 (삭제회원은 조회하지 않는다.)
AND                    A.MNAME LIKE UPPER('%PGW%')
-- 회원이름 :: MNAME :: place holder 1
ORDER BY        MNUM  ASC; -- PRIMARY KEY인 MNUM 칼럼을 오름차순으로 정렬


-- 날짜 조회 (등록일 조회)
-- 수정일 조회는 java ISUD 과제 할 때, 수정일 조회 로직 관련 질문을 했을 때,
-- 수정일 조회 방법은 따로 있으므로, 등록일만 하라고 하셨다.

SELECT               A.MNUM                                                                                                           AS      MNUM --회원번호  	:: COLUMN_ID :: 1
                              ,A.MNAME                                                                                                         AS      MNAME --회원이름	:: COLUMN_ID :: 2
                              ,A.MID                                                                                                                  AS      MID --아이디		:: COLUMN_ID :: 3
                              ,A.MPW                                                                                                               AS      MPW --패스워드	:: COLUMN_ID :: 4 
                              ,A.MHP                                                                                                                AS      MHP --핸드폰번호	:: COLUMN_ID :: 5
                              ,A.MEMAIL                                                                                                         AS     MEMAIL --이메일		:: COLUMN_ID :: 6
                              ,A.MGENDER                                                                                                     AS    MGENDER --성별		:: COLUMN_ID :: 7
                              ,A.MHOBBY                                                                                                       AS       MHOBBY --취미		:: COLUMN_ID :: 8
                              ,A.MLOCAL                                                                                                       AS      MLOCAL --지역		:: COLUMN_ID :: 9
                              ,A.MMSG                                                                                                            AS      MMSG --내용		:: COLUMN_ID :: 10
                              , A.DELETEYN                                                                                                  AS      DELETEYN --회원여부	:: COLUMN_ID :: 11
                              ,TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYY-MM-DD')          AS      INSERTDATE --등록일		:: COLUMN_ID :: 12
                              ,TO_CHAR(TO_DATE(A.UPDATEDATE), 'YYYY-MM-DD')        AS      UPDATEDATE --수정일		:: COLUMN_ID :: 13
FROM                 SCOTT.KOS_MEMBER A -- SCOTT 계정의 KOS_MEMBER 테이블 :: ALIAS(별칭)는 A
WHERE              A.DELETEYN='Y'  -- 회원여부가 'Y'인 경우만 조회 (삭제회원은 조회하지 않는다.)
AND                    TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYYMMDD') >= TO_CHAR(TO_DATE('2022-03-01'), 'YYYYMMDD')
-- 등록일 fromdate :: place holder 1 
AND                     TO_CHAR(TO_DATE(A.INSERTDATE), 'YYYYMMDD') <= TO_CHAR(TO_DATE('2022-04-01'), 'YYYYMMDD')
-- 등록일 todate :: place holder 	 2 
ORDER BY        MNUM  ASC; -- PRIMARY KEY인 MNUM 칼럼을 오름차순으로 정렬

-- 회원 정보 입력
SELECT*FROM KOS_MEMBER;

SELECT NVL(MAX(SUBSTR(A.MNUM, -4)), 0) + 1 AS COMM_NUM FROM KOS_MEMBER A;

INSERT INTO SCOTT.KOS_MEMBER(
MNUM
,MNAME
,MID
,MPW
,MHP
,MEMAIL
,MGENDER
,MHOBBY
,MLOCAL
,MMSG
,DELETEYN
,INSERTDATE
,UPDATEDATE)
VALUES (
456--?
YYS--,?
imyoseob--,?
1234--,?
01091389471--,?
imyoseob@naver.com--,?
M--,?
game--,?
--,?
--,?
,'Y'--,'Y'
,SYSDATE
,SYSDATE
);

commit;

SELECT NVL(MAX(SUBSTR(A.MNUM, -4)), 0) + 1 AS COMM_NUM FROM KOS_MEMBER A;
SELECT*FROM KOS_MEMBER;

RENAME KOS_MEMBER TO KOS_MEMBER1;

COMMIT;