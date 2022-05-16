CREATE TABLE KOSMO_PRODUCT(
        MNUM  VARCHAR2(20) PRIMARY KEY --상품번호
        ,MID  VARCHAR2(20)                                     --상품아이디
        ,MCNT  VARCHAR2(20)                                 --수량
        ,MNAME  VARCHAR2(300)                           --상품명
        ,MPRICE  VARCHAR2(20)                               --가격
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











