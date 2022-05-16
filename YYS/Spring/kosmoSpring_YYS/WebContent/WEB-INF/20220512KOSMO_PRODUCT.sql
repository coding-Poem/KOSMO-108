CREATE TABLE KOSMO_PRODUCT(
        MNUM  VARCHAR2(20) PRIMARY KEY --��ǰ��ȣ
        ,MID  VARCHAR2(20)                                     --��ǰ���̵�
        ,MCNT  VARCHAR2(20)                                 --����
        ,MNAME  VARCHAR2(300)                           --��ǰ��
        ,MPRICE  VARCHAR2(20)                               --����
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











