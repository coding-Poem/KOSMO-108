-- 2022-03-08

SELECT 1 FROM EMP;
-- 행의 개수만큼 1이 출력된다.

SELECT 2 FROM EMP;
-- 행의 개수만큼 2가 출력된다.

-- DISTINCT
SELECT DISTINCT EMPNO FROM EMP;
-- 14건 검색

SELECT DISTINCT EMPNO, DEPTNO FROM EMP;
-- 14건 검색

SELECT DISTINCT DEPTNO FROM EMP;
-- 3건 검색

SELECT DISTINCT DEPTNO, EMPNO FROM EMP;
-- 14건 검색

-- WHERE 절 연습
-- WHERE 절은 항상 TRUE 일 때만 수행된다.
/*
SELECT
    SELECT 절 : SELECT*FROM DUAL;
FROM
    FROM 절 : SELECT*FROM DUAL;
WHERE
    WHERE 절 : SELECT*FROM DUAL;
    WHERE 절은 항상 TRUE 일 때만 수행한다.
    1=1 : 개발할 때만 사용한다.
    1=1 : 단, 보안취약 점검 대상이다. 
            운영(계) REAL SERVER에서는 절대 사용 금지이다.
*/


SELECT*FROM EMP WHERE 1=1;
-- 14건 전부 잘 출력됨

SELECT*FROM EMP WHERE 1=2;
-- 아무것도 출력되지 않음
-- 쿼리 실행 순서 : FROM - WHERE - GROUP BY-HAVING-SELECT-ORDER BY


-- Q. 부서번호가 10번이고 직책이 MANAGER인 사원을 출력하시오.
-- 내 답안
SELECT*FROM EMP WHERE DEPTNO=10 AND JOB LIKE UPPER('%ANAGE%');

/*
복문 쿼리는 쿼리를 한 방에 쓰는 것을 의미하나, 정석대로 할거면
단문 쿼리(쿼리로 하나씩 확인해보는 작업)을 거쳐야 한다.
*/

-- 강사님 답안 : 부서번호 10 직책 MANAGER
-- 테이블 정의서를 먼저 보고, 단문쿼리로 작성
SELECT*FROM EMP WHERE DEPTNO=10;
-- 3명의 정보가 출력됨.
SELECT * FROM EMP WHERE JOB = 'MANAGER';
-- 3명의 정보가 출력됨.
SELECT * FROM EMP WHERE DEPTNO = 10 AND JOB = 'MANAGER';
-- 1명의 정보가 출력됨.

SELECT*FROM EMP
WHERE 1=1
AND DEPTNO=10
AND JOB='MANAGER';
/*
EMPNO ENAME  JOB           MGR  HIREDATE  SAL   COMM    DEPTNO
7782	    CLARK	MANAGER	7839	 81/06/09	 2450	  (null) 	       10
*/

SELECT*FROM EMP
WHERE 1=2
AND DEPTNO=10
AND JOB='MANAGER';
/*
EMPNO ENAME  JOB   MGR  HIREDATE  SAL   COMM    DEPTNO
*/

-- Q. 부서번호 10 이거나 직책이 MANAGER인 사원 정보를 출력하시오.
SELECT*FROM EMP WHERE DEPTNO=10;
-- 3명의 정보가 출력됨.
SELECT * FROM EMP WHERE JOB = 'MANAGER';
-- 3명의 정보가 출력됨.
SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB = 'MANAGER';
-- 5 명의 정보가 출력된다.

SELECT*FROM EMP
WHERE 1=1
OR DEPTNO=10
OR JOB='MANAGER';
-- 14건
-- 세 개 조건 중 하나가 14개 다 만족하기 때문에 전부 출력됨.

SELECT*FROM EMP
WHERE 1=2
OR DEPTNO=10
OR JOB='MANAGER';
--5건 세 개 조건중 두 개 합이 5개라 5개가 출력됨.

-- Q. 부서번호가 10번, 20번인 사원을 조회해보세요.
SELECT COUNT(*) FROM EMP WHERE DEPTNO=10;
-- 3명의 정보가 출력된다.
SELECT COUNT(*) FROM EMP WHERE DEPTNO=20;
-- 5명의 정보가 출력된다.

-- PULL SCAN 자리에 PK 를 넣어서 조회하면 안 되는지?!

SELECT COUNT(*) FROM EMP WHERE DEPTNO=10 OR DEPTNO=20;
-- 8건 나옴

SELECT COUNT(EMPNO) FROM EMP WHERE DEPTNO=10 OR DEPTNO=20;
-- 기본키로 조회해도 COUNT함수를 사용했기 때문에 8건 나옴.

-- IN() : OR 연산자 대체해서 사용
-- 같은 컬럼에 여러 개의 값을 조회할 때

SELECT*FROM EMP WHERE DEPTNO IN (10,20);

SELECT COUNT(*) FROM EMP WHERE DEPTNO IN (10,20);
-- 8 

-- 커미션이 300, 500, 1400 사원을 조회 하시오. (OR 와 IN 둘 다 해보기)

-- OR 연산자로 해보기
SELECT COMM FROM EMP;
SELECT*FROM EMP WHERE COMM='300' OR COMM='500' OR COMM='1400';
SELECT COUNT(EMPNO) FROM EMP WHERE COMM='300' OR COMM='500' OR COMM='1400';
-- 3

-- IN 연산자로 해보기
SELECT*FROM EMP WHERE COMM IN ('300','500','1400');
SELECT COUNT(EMPNO) FROM EMP WHERE COMM IN ('300', '500', '1400');
-- 3

-- 10번 부서에 있는 사원을 출력하시오.
SELECT*FROM EMP
WHERE DEPTNO IN ('10');

SELECT*FROM EMP
WHERE DEPTNO='10';

-- 10번 부서가 아닌 사원을 출력하시오.
-- ======3가지 방법======
SELECT*FROM EMP
WHERE DEPTNO NOT IN ('10');

SELECT*FROM EMP
WHERE DEPTNO <> '10';

SELECT*FROM EMP
WHERE DEPTNO!='10';

SELECT*FROM EMP
WHERE DEPTNO ^=10;

-- NOT 연산자들은 사용을 지양하는 것이 좋다
-- NULL값을 카운트하지 않기 때문
-- ===================

SELECT*FROM EMP WHERE COMM NOT IN (300,500,1400);
-- NULL은 카운트하지 않기 때문에 1건만 나온다.

-- 급여 1000에서 1500 사이인 사원을 조회 하시오.
SELECT COUNT(*) FROM EMP WHERE SAL>=1000; 
-- 12
SELECT COUNT(*) FROM EMP WHERE SAL<=1500;
-- 7
SELECT COUNT(*) FROM EMP WHERE SAL>=1000 AND SAL<=1500;
-- 5

--===========================
-- FROM ~ TO 구간 검색이라고 한다하더라.
--===========================

SELECT*FROM EMP 
WHERE SAL>=1000 
AND SAL<=1500;

-- 아래 쿼리문이 정석
SELECT A.* FROM EMP A
WHERE A.SAL<=1500
AND A.SAL>=1000;
-- 1500미만을 먼저 검색후, 1000이상을 검색해야
-- 검색 효율이 좋다고 주장하는 사람이 있기 때문에
-- 이렇게 사용하는 것을 지향한다.


--Q. 급여가 1000 미만 이거나 1500 초과인 사원을 조회
SELECT*FROM EMP WHERE SAL<1000;
-- 2명의 정보가 출력
SELECT*FROM EMP WHERE SAL>1500;
-- 7명의 정보가 출력

SELECT COUNT(*) FROM EMP WHERE SAL>1500;

SELECT A.*
FROM EMP A
WHERE A.SAL<'1000'
OR
A.SAL>'1500';

SELECT COUNT(*)
FROM EMP A
WHERE A.SAL<'1000'
OR
A.SAL>'1500';
-- 9

-- BETWEEN A AND B
SELECT*FROM EMP
WHERE 1=1
AND SAL BETWEEN 1000 AND 1500;
-- 5건 나옴

SELECT*FROM EMP A
WHERE 1=1
AND (A.SAL<=1500 
AND A.SAL>=1000);
-- 5건 나옴

-- Q. 1981년에 입사한 사원을 조회하시오. 검색하시오. 출력하시오.
SELECT HIREDATE FROM EMP WHERE ROWNUM<=5;

-- 사원을 조회해보기 방법1====================
-- 이 방법이 가장 좋다=======================
SELECT*FROM SCOTT.EMP A
WHERE 1=1
AND TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD')
        <= TO_CHAR(TO_DATE('1981/12/31'), 'YYYYMMDD')
AND TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD')
        >=TO_CHAR(TO_DATE('1981/01/01'), 'YYYYMMDD');
/* 
    이유 1: HIREDATE를 TO_DATE로 바꾼뒤 TO_CHAR로
             일정 형식으로 바꿈. 깔끔하게 한 형식으로 바꿨음
    이유 2: 값의 범위를 정확하게 사용해주었음.
*/
--====================================

-- 사원을 조회해보기 방법2=====================
SELECT A.* FROM SCOTT.EMP A
WHERE 1=1
AND TO_CHAR(TO_DATE(A.HIREDATE), 'YYYY')='1981';
-- 년도만 조회하여 비교하는 방법이다.
--=====================================

--사원을 조회 하는 방법3=======================
SELECT A.HIREDATE FROM SCOTT.EMP A
WHERE 1=1
AND SUBSTR(A.HIREDATE, 1,2) ='81';
--======================================

--검색하는 방법4========================
SELECT SUBSTR(A.HIREDATE, 1, 2) AS HIREDATE FROM SCOTT.EMP A
WHERE 1=1
AND SUBSTR(A.HIREDATE, 1,2)='81';
--==================================

--조회하는 방법5=========================
SELECT A.* FROM SCOTT.EMP A
WHERE 1=1
AND A.HIREDATE BETWEEN '1981/01/01' AND '1981/12/31';
--===================================

--조회하는 방법6==========================
SELECT A.* FROM SCOTT.EMP A
WHERE 1=1
AND A.HIREDATE <= '1981/12/31'
AND A.HIREDATE >= '1981/01/01';
--====================================


--STACK, QUEUE
-- STACK : LIFO
-- 입력: push(), (파이썬에서는 append())
-- 출력: pop()

-- QUEUE : FIFO

SELECT SUBSTR('SMITH', 1,2) FROM DUAL;
-- SM
SELECT SUBSTR('SMITH',-1,2) FROM DUAL;
-- H
-- -1인 H뒤에 두 개 출력

SELECT SUBSTR('SMITH',-3,2) FROM DUAL;
-- IT
-- -3인 I뒤에 두 개 출력

SELECT SUBSTR('SMITH',-3) FROM DUAL;
-- -3인 I 뒤에 전부 출력

SELECT NVL(NULL, 'AB') FROM DUAL;
SELECT NVL(NULL, 0) FROM DUAL;
SELECT NVL(NULL, 'A')FROM DUAL;

--========중요=============
SELECT NULL FROM DUAL;
-- (null)
SELECT NULL+1 FROM DUAL;
-- (null)
SELECT NVL(NULL, 0) +1 FROM DUAL;
-- 1
--========================


SELECT*FROM EMP WHERE COMM IS NOT NULL;


-- 내가 만든 답
SELECT COUNT(*) FROM EMP WHERE COMM IS NOT NULL AND COMM>0;
-- 3

-- 강사님 답
SELECT COMM FROM EMP;
SELECT COMM FROM EMP WHERE COMM>0;
SELECT NVL(COMM, 0) AS COMM FROM EMP WHERE COMM>0;
SELECT COUNT(NVL(COMM, 0)) AS COMM FROM EMP WHERE COMM>0;
-- 3

-- 산술 연산자
-- 사원의 급여와 연봉을 출력하시오.
-- + - * /

SELECT SAL, (SAL*12) AS TSAL FROM EMP;

-- Q. 사원의 급여와 연봉, 수당을 출력하시오.
-- SAL, SAL*12 AS TSAL, COMM
SELECT A.SAL, (A.SAL*12) AS TSAL, A.COMM 
FROM EMP A;

-- Q. 사원의 급여와 연봉, 수당, 수당을 포함한 연봉을 출력하시오.
-- SAL, (SAL*12), COMM, (COMM+(SAL*12))
-- 내 답
SELECT 
         A.SAL AS SAL
         , (A.SAL*12) AS TSAL
         , A.COMM AS COMM
         , (A.COMM+(A.SAL*12)) AS TSALBONUS 
FROM EMP A;


-- 강사님 답
SELECT
         A.SAL AS SAL
         ,(A.SAL*12) AS TSAL
         ,NVL(A.COMM, 0) AS COMM
         ,NVL(A.COMM, 0) + (A.SAL*12) AS CSAL
FROM EMP A;

-- Q. 사원의 급여와 연봉, 수당, 수당을 포함한 연봉을  연봉이 높은 순으로 출력하시오.
--  급여: SAL, 연봉 :SAL*12, 수당 : COMM, 수당을포함한 연봉 : COMM+(SAL*12)

-- Q. 모든 사원에게 급여를 연봉의 300원을 인상해준다.
-- 사원이름, 급여, 인상전급여를 출력하시오.
-- 사원이름: ENAME, 급여:SAL+300, 인상전급여: SAL

SELECT 
         NVL(A.ENAME, 0) AS ENAME
         ,NVL(A.SAL*12 +'300', 0) AS ASAL
         ,NVL(A.SAL, 0) AS BSAL
FROM EMP A;

-- Q. 10번 부서의 사원들에게 수당을 300원씩 일괄 지급하시오.
-- 사원이름, 수당을 출력하시오.
-- 사원이름 : ENAME, 수당 : COMM (일괄지급되기 이전)
-- 300원씩 일괄 지급된 수당: COMM+300 AS COMM

SELECT
        A.ENAME                      AS ENAME
        ,NVL((A.COMM+'300'), 0) AS COMM
FROM EMP A
WHERE A.DEPTNO='10';

-- Q. 1981년 9월 입사자들에게 수당을 500원씩 지급한다.
-- 사원번호, 사원이름, 직책, 입사일, 수당을 출력하시오.
-- 입사일 형식 (YYYY-MM-DD)

SELECT A.EMPNO                                                      AS EMPNO
          ,A.ENAME                                                       AS ENAME
          ,A.JOB                                                            AS JOB
          ,TO_CHAR(TO_DATE(A.HIREDATE), 'YYYY-MM-DD') AS HIREDATE
          ,NVL(A.COMM, 0)+'500'                                    AS COMM
FROM 
        EMP A
WHERE 1=1
AND
      TO_CHAR(A.HIREDATE, 'YYYYMM') 
      ='198109';
      
      
-- Q. 1981년 2월 20일 부터 1981년 5월 1일 사이에 입사한
--     사원의 이름, 직책, 입사일(YYYY.MM.DD), 급여, 연봉, 상여금을
--     출력하시오.
--     출력 순서는 연봉이 많은 순서로 출력하시오.

-- 사원의 이름: ENAME, 직책:JOB, 입사일:HIREDATE, 급여:SAL,
-- 연봉:SAL*12 수당:COMM

-- 1ST 방법
SELECT
         A.ENAME                                                         AS ENAME  -- 사원의 이름
         ,A.JOB                                                              AS JOB           -- 직책
         ,TO_CHAR(TO_DATE(A.HIREDATE), 'YYYY.MM.DD')   AS HIREDATE -- 입사일(YYYY.MM.DD)
         ,A.SAL                                                              AS SAL --급여
         ,(A.SAL*12)                                                        AS TSAL --연봉
         ,NVL(A.COMM, 0)                                               AS COMM --상여금
FROM 
        EMP A
WHERE
       1=1
       AND
        -- 1981년 2월 20일 부터 1981년 5월 1일 사이
        TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') 
        <= TO_CHAR(TO_DATE('19810501'), 'YYYYMMDD')
        AND
        TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') 
        >= TO_CHAR(TO_DATE('19810220'), 'YYYYMMDD')
ORDER BY TSAL DESC;

-- 2ND 방법
SELECT
        A.ENAME                                                          AS ENAME
        ,A.JOB                                                              AS JOB
        ,TO_CHAR(TO_DATE(A.HIREDATE), 'YYYY.MM.DD')   AS HIREDATE
        ,A.SAL                                                              AS SAL
        ,(A.SAL*12)                                                        AS TSAL
        ,NVL(A.COMM, 0)                                               AS COMM
FROM 
        EMP A
WHERE
        1=1
        AND
        TO_CHAR(A.HIREDATE, 'YYYY')='1981'
        AND
        TO_CHAR(A.HIREDATE, 'MMDD')<='0501'
        AND
        TO_CHAR(A.HIREDATE, 'MMDD')>='0220'
ORDER BY TSAL DESC;

