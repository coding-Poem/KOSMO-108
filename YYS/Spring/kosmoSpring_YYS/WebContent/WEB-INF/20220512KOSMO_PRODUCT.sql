/*       ####################  ��ǰ    ####################     */
CREATE TABLE KOSMO_PRODUCT(
        MNUM  VARCHAR2(20) PRIMARY KEY --��ǰ��ȣ
        ,MID  VARCHAR2(20)                                     --��ǰ���̵�
        ,MCNT  NUMBER                                 --����
        ,MNAME  VARCHAR2(300)                           --��ǰ��
        ,MPRICE  NUMBER                             --����
        ,MDES  VARCHAR2(300)                               --��ǰ����
        ,MCOM  VARCHAR2(300)                             --��ǰ������
        ,MIMG  VARCHAR2(300)                                -- �̹������� (��� Ȥ�� �̹��� �̸�)
        ,MINSERTDATE  DATE   NOT NULL           --�����
        ,MUPDATEDATE  DATE  NOT NULL            --������
        ,MDELETEYN  VARCHAR(1) NOT NULL --��ǰ��Ͽ���
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

-- SELECT ALL ����
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



-- DELETE ����
SELECT*FROM KOSMO_PRODUCT;

UPDATE KOSMO_PRODUCT
SET MUPDATEDATE=SYSDATE, MDELETEYN='N'
WHERE MNUM='M202205160004';

SELECT MDELETEYN, MUPDATEDATE
FROM KOSMO_PRODUCT
WHERE MNUM='M202205160004';

ROLLBACK;

/*       ####################  ȸ��    ####################     */
CREATE TABLE KOSMO_MEMBER(
    KMNUM VARCHAR2(20) PRIMARY KEY -- ȸ����ȣ
   ,KMID VARCHAR2(20) -- ȸ�����̵�
   ,KMPW VARCHAR2(300) -- ȸ����й�ȣ
   ,KMNAME VARCHAR2(100) -- ȸ���̸�
   ,KMHP VARCHAR2(16)   -- ȸ���޴�����ȣ
   ,KMEMAIL VARCHAR2(200)   --ȸ���̸���
   ,KMZONE VARCHAR2(6) -- ȸ�������ȣ
   ,KMROAD VARCHAR2(200) --ȸ�����θ��ּ�
   ,KMROAD2 VARCHAR2(200)  --ȸ�����θ���ּ�
   ,KMJIBUN VARCHAR2(200) -- ȸ�������ּ�
   ,KMIMAGE VARCHAR2(200) --ȸ������
   ,MDELETEYN VARCHAR2(1) NOT NULL -- ��Ͽ���
   ,MINSERTDATE DATE NOT NULL --�����
   ,MUPDATEDATE DATE NOT NULL   --������
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


/*       ####################  ��ٱ��� ���̺�   ####################     */
DROP TABLE KOSMO_CART;
CREATE TABLE KOSMO_CART(
    MCNUM VARCHAR2(20) PRIMARY KEY --��ٱ��Ϲ�ȣ
    ,KMNUM VARCHAR2(20)                              -- ȸ����ȣ
    ,MID  VARCHAR2(20)                                     --��ǰ���̵�
    ,MCNT  NUMBER                                 --����
    ,MNAME  VARCHAR2(300)                           --��ǰ��
     ,MPRICE  NUMBER                               --����
    ,MPRICESUM NUMBER                                   -- ���� �����
    ,MDES  VARCHAR2(300)                               --��ǰ����
    ,MCOM  VARCHAR2(300)                             --��ǰ������
    ,MIMG  VARCHAR2(300)                                -- �̹������� (��� Ȥ�� �̹��� �̸�)
    ,MINSERTDATE  DATE   NOT NULL           --�����
    ,MUPDATEDATE  DATE  NOT NULL            --������
    ,MDELETEYN  VARCHAR(1) NOT NULL --��Ͽ���
);



