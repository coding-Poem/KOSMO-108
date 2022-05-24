/*       ####################  상품    ####################     */
CREATE TABLE KOSMO_PRODUCT(
        MNUM  VARCHAR2(20) PRIMARY KEY --상품번호
        ,MID  VARCHAR2(20)                                     --상품아이디
        ,MCNT  NUMBER                                 --수량
        ,MNAME  VARCHAR2(300)                           --상품명
        ,MPRICE  NUMBER                             --가격
        ,MDES  VARCHAR2(300)                               --상품설명
        ,MCOM  VARCHAR2(300)                             --상품제조사
        ,MIMG  VARCHAR2(300)                                -- 이미지파일 (경로 혹은 이미지 이름)
        ,MINSERTDATE  DATE   NOT NULL           --등록일
        ,MUPDATEDATE  DATE  NOT NULL            --수정일
        ,MDELETEYN  VARCHAR(1) NOT NULL --상품등록여부
);


SELECT*FROM KOSMO_PRODUCT;

INSERT INTO KOSMO_PRODUCT(MNUM, MID, MCNT, MNAME, MPRICE, MDES,  MCOM,  MIMG, MINSERTDATE, MUPDATEDATE, MDELETEYN)
VALUES ('1', 'hello', '3', 'hi', '3000', 'des',  'com',  'img.jpg', SYSDATE, SYSDATE, 'Y');

ROLLBACK;

DESC KOSMO_PRODUCT;

SELECT NVL(MAX(SUBSTR(A.MNUM, -4)), 0) + 1 AS MNUM  FROM KOSMO_PRODUCT  A;

-- SELECT ALL
SELECT
        A.MNUM  AS MNUM
        ,A.MID   AS MID
        ,A.MCNT AS MCNT
        ,A.MNAME AS MNAME
        ,A.MPRICE AS MPRICE
        ,A.MDES  AS MDES
        ,A.MCOM  AS MCOM
        ,A.MIMG  AS MIMG
        ,TO_CHAR(TO_DATE(A.MINSERTDATE), 'YYYY-MM-DD') AS MINSERTDATE  
        ,TO_CHAR(TO_DATE(A.MUPDATEDATE), 'YYYY-MM-DD') AS MUPDATEDATE  
        ,A.MDELETEYN  AS  MDELETEYN
FROM KOSMO_PRODUCT A
WHERE A.MDELETEYN='Y';

SELECT*FROM KOSMO_PRODUCT;


SELECT 
            A.MNUM AS MNUM
            ,A.MNAME AS MNAME
           ,TO_CHAR(TO_DATE(A.MINSERTDATE), 'YYYY-MM-DD') AS MINSERTDATE  
FROM KOSMO_PRODUCT A;

-- SELECT ALL 로직
SELECT*FROM(
SELECT
        A.MNUM  AS MNUM
        ,A.MID   AS MID
        ,A.MCNT AS MCNT
        ,A.MNAME AS MNAME
        ,A.MPRICE AS MPRICE
        ,A.MDES  AS MDES
        ,A.MCOM  AS MCOM
        ,A.MIMG  AS MIMG
        ,TO_CHAR(TO_DATE(A.MINSERTDATE), 'YYYY-MM-DD') AS MINSERTDATE  
        ,TO_CHAR(TO_DATE(A.MUPDATEDATE), 'YYYY-MM-DD') AS MUPDATEDATE  
        ,A.MDELETEYN  AS  MDELETEYN
        ,CEIL(ROW_NUMBER() OVER(ORDER BY A.MNUM)/ 3) AS  pageSize		
		,COUNT(A.MNUM) OVER() AS totalCount 
FROM KOSMO_PRODUCT A
WHERE A.MDELETEYN='Y'
)WHERE pageSize=3;

-- SELECT MERCHANDISE
SELECT
         A.MNUM  AS MNUM
        ,A.MID   AS MID
        ,A.MCNT AS MCNT
        ,A.MNAME AS MNAME
        ,A.MPRICE AS MPRICE
        ,A.MDES  AS MDES
        ,A.MCOM  AS MCOM
        ,A.MIMG  AS MIMG
        ,TO_CHAR(TO_DATE(A.MINSERTDATE), 'YYYY-MM-DD') AS MINSERTDATE  
        ,TO_CHAR(TO_DATE(A.MUPDATEDATE), 'YYYY-MM-DD') AS MUPDATEDATE  
FROM KOSMO_PRODUCT A
WHERE A.MDELETEYN='Y'
AND A.MNUM='M202205160001';

SELECT*FROM KOSMO_PRODUCT;



-- DELETE 로직
SELECT*FROM KOSMO_PRODUCT;

UPDATE KOSMO_PRODUCT
SET MUPDATEDATE=SYSDATE, MDELETEYN='N'
WHERE MNUM='M202205160004';

SELECT MDELETEYN, MUPDATEDATE
FROM KOSMO_PRODUCT
WHERE MNUM='M202205160004';

ROLLBACK;

/*       ####################  회원    ####################     */
CREATE TABLE KOSMO_MEMBER(
    KMNUM VARCHAR2(20) PRIMARY KEY -- 회원번호
   ,KMID VARCHAR2(20) -- 회원아이디
   ,KMPW VARCHAR2(300) -- 회원비밀번호
   ,KMNAME VARCHAR2(100) -- 회원이름
   ,KMHP VARCHAR2(16)   -- 회원휴대폰번호
   ,KMEMAIL VARCHAR2(200)   --회원이메일
   ,KMZONE VARCHAR2(6) -- 회원우편번호
   ,KMROAD VARCHAR2(200) --회원도로명주소
   ,KMROAD2 VARCHAR2(200)  --회원도로명상세주소
   ,KMJIBUN VARCHAR2(200) -- 회원지번주소
   ,KMIMAGE VARCHAR2(200) --회원사진
   ,MDELETEYN VARCHAR2(1) NOT NULL -- 등록여부
   ,MINSERTDATE DATE NOT NULL --등록일
   ,MUPDATEDATE DATE NOT NULL   --수정일
);

SELECT*FROM KOSMO_MEMBER;

SELECT NVL(MAX(SUBSTR(A.KMNUM, -4)), 0) + 1 AS MNUM FROM KOSMO_MEMBER  A;

DESC KOSMO_MEMBER;
-- INSERT
INSERT INTO KOSMO_MEMBER(KMNUM, KMID, KMPW, KMNAME, KMHP
                                                                    , KMEMAIL,     KMZONE, KMROAD, KMROAD2
                                                                    ,KMJIBUN, KMIMAGE, MDELETEYN, MINSERTDATE, MUPDATEDATE)
VALUES    ('1', '1', '1', '1', '1'
                     , '1',     '1', '1', '1'
                    ,'1', '1', 'Y', SYSDATE, SYSDATE);
                    
ROLLBACK;

-- SELECT ALL
SELECT*FROM(
SELECT
        A.KMNUM  AS  KMNUM
        , A.KMID AS KMID
        , A.KMPW AS KMPW
        , A.KMNAME AS KMNAMEAS
        , A.KMHP AS KMHP
         , A.KMEMAIL AS KMEMAIL
         ,  A.KMZONE AS KMZONE
         , A.KMROAD AS KMROAD
         , A.KMROAD2 AS KMROAD2
         ,A.KMJIBUN AS KMJIBUN
         , A.KMIMAGE AS KMIMAGE
         , A.MDELETEYN AS MDELETEYN
         , TO_CHAR(TO_DATE(A.MINSERTDATE), 'YYYY-MM-DD') AS MINSERTDATE
         , TO_CHAR(TO_DATE(A.MUPDATEDATE), 'YYYY-MM-DD') AS MUPDATEDATE
         ,CEIL(ROW_NUMBER() OVER(ORDER BY A.KMNUM)/ 3 ) AS PAGESIZE
         ,COUNT( A.KMNUM) OVER() AS TOTALCOUNT 
FROM KOSMO_MEMBER A
WHERE MDELETEYN='Y'
)
WHERE PAGESIZE=PAGESIZE;

-- SELECT
-- SELECT ALL
SELECT
        A.KMNUM  AS  KMNUM
        , A.KMID AS KMID
        , A.KMPW AS KMPW
        , A.KMNAME AS KMNAMEAS
        , A.KMHP AS KMHP
         , A.KMEMAIL AS KMEMAIL
         ,  A.KMZONE AS KMZONE
         , A.KMROAD AS KMROAD
         , A.KMROAD2 AS KMROAD2
         ,A.KMJIBUN AS KMJIBUN
         , A.KMIMAGE AS KMIMAGE
         , A.MDELETEYN AS MDELETEYN
         , TO_CHAR(TO_DATE(A.MINSERTDATE), 'YYYY-MM-DD') AS MINSERTDATE
         , TO_CHAR(TO_DATE(A.MUPDATEDATE), 'YYYY-MM-DD') AS MUPDATEDATE
FROM KOSMO_MEMBER A
WHERE MDELETEYN='Y';

select*from KOSMO_MEMBER;
commit;

-- login check
SELECT 
        A.KMID AS KMID
        ,A.KMPW AS KMPW
FROM KOSMO_MEMBER A
WHERE A.MDELETEYN='Y'
AND A.KMID='kimStar_ID'
AND A.KMPW='123456';

update kosmo_member
set kmid='umeume', kmemail='umeume@naver.com'
where kmnum='KM202205200004';

commit;

/*       ####################  장바구니 테이블   ####################     */
DROP TABLE KOSMO_CART;
CREATE TABLE KOSMO_CART(
    MCNUM VARCHAR2(20) PRIMARY KEY --장바구니번호
    ,KMNUM VARCHAR2(20)                              -- 회원번호
    ,MNUM  VARCHAR2(20)                                -- 상품번호
    ,MID  VARCHAR2(20)                                     --상품아이디
    ,MCNT  NUMBER                                 --수량
    ,MNAME  VARCHAR2(300)                           --상품명
     ,MPRICE  NUMBER                               --가격
    ,MPRICESUM NUMBER                                   -- 가격 누계액
    ,MDES  VARCHAR2(300)                               --상품설명
    ,MCOM  VARCHAR2(300)                             --상품제조사
    ,MIMG  VARCHAR2(300)                                -- 이미지파일 (경로 혹은 이미지 이름)
    ,MINSERTDATE  DATE   NOT NULL           --등록일
    ,MUPDATEDATE  DATE  NOT NULL            --수정일
    ,MDELETEYN  VARCHAR(1) NOT NULL --등록여부
);

SELECT*FROM KOSMO_CART;

SELECT NVL(MAX(SUBSTR(A.MCNUM, -4)), 0) + 1 AS KMNUM FROM KOSMO_CART  A;

INSERT INTO KOSMO_CART(MCNUM, KMNUM,  MID, MCNT, MNAME, MPRICE
                            , MPRICESUM,  MDES, MCOM, MIMG
                            ,MINSERTDATE,MUPDATEDATE, MDELETEYN)
VALUES (
'1', '1',  '1', '1', '1', '1'
 , '1',  '1', '1', '1'
,SYSDATE,SYSDATE, 'Y'
);

ROLLBACK;

-- SELECT ALL

SELECT*FROM(
SELECT
    A.MCNUM                       AS    MCNUM                --장바구니번호
    ,A.KMNUM                      AS    KMNUM                             -- 회원번호
    ,A.MNUM					  AS  MNUM                  -- 상품번호
    ,A.MID                               AS       MID                --상품아이디
    ,A.MCNT                          AS   MCNT             --수량
    ,A.MNAME                      AS     MNAME     --상품명
     ,A.MPRICE                      AS  MPRICE        --가격
    ,A.MPRICESUM              AS   MPRICESUM               -- 가격 누계액
    ,A.MDES                           AS  MDES   --상품설명
    ,A.MCOM                         AS MCOM   --상품제조사
    ,A.MIMG                            AS MIMG   -- 이미지파일 (경로 혹은 이미지 이름)
     , A.MDELETEYN AS MDELETEYN
    , TO_CHAR(TO_DATE(A.MINSERTDATE), 'YYYY-MM-DD') AS MINSERTDATE
    , TO_CHAR(TO_DATE(A.MUPDATEDATE), 'YYYY-MM-DD') AS MUPDATEDATE
    ,CEIL(ROW_NUMBER() OVER(ORDER BY A.KMNUM)/ #{pageSize} ) AS pageSize	
    ,COUNT( A.MCNUM) OVER() AS totalCount 
FROM KOSMO_CART A
WHERE A.MDELETEYN='Y'
)
WHERE PAGESIZE=#{curPage};

SELECT*FROM KOSMO_CART;

UPDATE KOSMO_CART
SET MDELETEYN='Y'
WHERE KMNUM='GUEST'
AND MDELETEYN='N';

ROLLBACK;

COMMIT;

-- ################ 게시판 ###################

-- 게시판
CREATE TABLE KOSMO_BOARD(
     KBNUM VARCHAR2(20) PRIMARY KEY 
    ,KBSUBJECT VARCHAR2(200)
    ,KBNAME VARCHAR2(100)
    ,KBCONTENT VARCHAR2(2000) 
    ,KBFILE VARCHAR2(200) 
    ,KBPW VARCHAR2(300)
   ,MDELETEYN VARCHAR2(1) NOT NULL -- 등록여부
   ,MINSERTDATE DATE NOT NULL --등록일
   ,MUPDATEDATE DATE NOT NULL   --수정일
);

SELECT*FROM KOSMO_BOARD;

SELECT A.TABLE_NAME, A.INDEX_NAME
FROM ALL_IND_COLUMNS A;

SELECT  /*+ INDEX_DESC(A SYS_C0013161) */
        NVL(MAX(SUBSTR(A.KBNUM, -4)), 0) + 1  KBNUM 
FROM    KOSMO_BOARD A;

