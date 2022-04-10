-- 2022-03-10

SELECT 'M' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '0001' FROM DUAL;

SELECT 'M' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '0002' FROM DUAL;


SELECT DISTINCT DEPTNO FROM EMP;

SELECT DISTINCT MGR FROM EMP;

SELECT DISTINCT JOB FROM EMP;

SELECT DISTINCT COMM FROM EMP;

SELECT DISTINCT*  FROM EMP;
-- 전부 다 출력 됨

SELECT DISTINCT DEPTNO, EMPNO FROM EMP;
-- 칼럼이 두 개이면  두 개의 칼럼이 전부 중복일때만 제거해주는듯?

SELECT AA.* FROM (SELECT HIREDATE FROM EMP WHERE ROWNUM <= 1) AA;
-- 서브쿼리에 HIREDATE가 있을 경우, DATE 타입에서  문자열로 바뀌게 되버림
-- 따라서, 날짜를 다룰 때는 필히 TO_DATE()를 해주어야만 한다.


SELECT HIREDATE, JOB FROM EMP WHERE ROWNUM<=1;
-- FROM 절의 서브 쿼리 문

SELECT   TO_CHAR(TO_DATE(AA.HIREDATE), 'YYYY-MM-DD') AS HIREDATE
                     ,AA.JOB                                                                                                AS JOB
FROM (SELECT HIREDATE, JOB FROM EMP WHERE ROWNUM <= 1) AA; 

-- 서브 쿼리문 수행이 끝난 뒤 FROM 에서 HIREDATE를 TO_DATE, TO_CHAR 
-- 'YYYY-MM-DD'로 바꾸고, JOB이랑 함께 출력하라.


--======================================
SELECT*FROM EMP ORDER BY COMM NULLS FIRST;
-- null 값 먼저 출력해주세요.

SELECT*FROM EMP  ORDER BY COMM NULLS LAST;
-- null 값을 마지막에 출력해주세요.

-- null 값 조회시 유용하게 쓰자

--======================================

-- NULL 있는 컬럼을 정렬 하면, 소트 하면, ORDER BY 하면
-- 오라클은 ORDER BY 하면 DEFAULT 가 ASCENDING 
SELECT * FROM EMP ORDER BY COMM;
SELECT * FROM EMP ORDER BY MGR;

--NULL 대체

-- NVL

SELECT NVL(NULL, 0) FROM DUAL;

-- NVL2 (NULL인지 아닌 지 확인)

SELECT NVL2(NULL, 'NOT NULL', 'NULL') FROM DUAL;
SELECT NVL2('AA', 'NOT NULL', 'NULL') FROM DUAL;

SELECT NVL2(COMM, 'NOT NULL','NULL') FROM EMP;
------------------------

-- NOT 연산자 지양



SELECT*FROM EMP WHERE EMPNO LIKE '%4%';


SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO '%'|| 7 || '%';

SELECT
                A.EMPNO     AS EMPNO
                ,A.ENAME     AS ENAME
               , A.JOB               AS JOB
               , A.MGR               AS MGR
                ,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD') AS HIREDATE
FROM  EMP A
WHERE 1=1
AND TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD')>=TO_CHAR(TO_DATE('80/01/01'), 'YYYYMMDD')
AND TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD')<=TO_CHAR(TO_DATE('81/01/01'), 'YYYYMMDD');


