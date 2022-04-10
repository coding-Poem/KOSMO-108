scott 계정 unlock
1. sys 또는 system 계정으로 로그인 하기 
?>sqlplus "/as sysdba" <- sys
?>sqlplus system/1234 <- system

sql>ALTER USER scott IDENTIFIED BY tiger ACCOUNT UNLOCK;


SELECT * FROM EMP;

SELECT ROWID, A.EMPNO, A.ENAME, A.JOB FROM EMP A;

-- COUNT()함수 : 테이블의 로우 수를 보여준다. 테이블의 레코드 수를 보여준다.
SELECT COUNT(*) FROM EMP;
SELECT COUNT(EMPNO) FROM EMP;
SELECT COUNT(COMM) FROM EMP;

SELECT ROWID, EMPNO FROM EMP;
--유니크  UNIQUE NOT NULL

/*
스키마 
테이블 로우 열 NULL PK FK 
*/


SELECT SYSDATE FROM DUAL;
SELECT SYSTIMESTAMP FROM DUAL;

-- SELECT
/*
SELECT 키워드 : 테이블에서 데이터를 질의하는(조회하는) 키워드 
    SELECT 절 : 테이블에서 조회하고 싶은 컬럼이름을 순차적으로 적는다, 구분자는 ,(CSV)
FROM 키워드 : 데이터를 조회하고 싶은 테이블 이름을 정하는 키워드 
    FROM 절 : 조회하고자하는 테이블 이름을 순차적으로 적는다. 구분자 , 
WHERE 키워드 : 데이터를 조회하는 조건을 적는 키워드 
    WHERE 절 : 조회 조건을 적는데 AND(그리고 연산) 키워드 와 OR(또는 연산) 키워드를 이용할 수 있다. 

SELECT
    SELECT 절
FROM 
    FROM 절 
WHERE 
    WHERE 절 
*/

-- EMP 테이블에서 데이블 테이터 전체를 조회하시오 
-- * : 와일드 카드 : 테이블 전체를 의미한다. : FULL SCAN : 풀 스캔 
-- 질의문은 항상 ; 종결해야 한다.
SELECT * FROM EMP;
-- 테이블은 계정명.테이블이름
SELECT * FROM SCOTT.EMP;

-- 테이블 이름은 항상 테이블 앨리어스(별칭)을 사용한다. 
-- 테이블 앨리어스 : 자바에서 객체의 참조변수와 같은 역활을 한다. 
-- FROM 절에서 테이블에 테이블 앨리어스(별칭)을 사용하면 
-- 해당 테이블의 컬럼을 조회할 때 테이블 앨리어스를 사용해서 컬럼을 지정해야한다. 
SELECT A.*, B.* FROM SCOTT.EMP A, SCOTT.EMP B;
SELECT B.* FROM SCOTT.EMP B;

-- AS 컬럼 앨리어스(별칭) 식별자 
-- AS EMPNO 는 A.EMPNO 의 별칭이다.
-- 사원번호 : 주석
SELECT 
        A.EMPNO     AS EMPNO    -- 사원번호
       ,A.ENAME     AS ENAME    -- 사원이름
       ,A.JOB       AS JOB      -- 사원직책
       ,A.MGR       AS MCR      -- 상관사원번호
       ,A.HIREDATE  AS HIREDATE -- 입사일
       ,A.SAL       AS SAL      -- 급여    
       ,A.COMM      AS COMM     -- 수당
       ,A.DEPTNO    AS DEPTNO   -- 부서번호 
FROM 
        SCOTT.EMP A;

-- AS 키워드 꼭 사용하세요         
SELECT 
        A.EMPNO     EMPNO    -- 사원번호
       ,A.ENAME     ENAME    -- 사원이름
       ,A.JOB       JOB      -- 사원직책
       ,A.MGR       MCR      -- 상관사원번호
       ,A.HIREDATE  HIREDATE -- 입사일
       ,A.SAL       SAL      -- 급여    
       ,A.COMM      COMM     -- 수당
       ,A.DEPTNO    DEPTNO   -- 부서번호 
FROM 
        SCOTT.EMP A;
        
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE,
       SAL, COMM, DEPTNO 
FROM    EMP;

-- EMP 테이블에서 사원번호, 부서, 입사일을 조회 하시오
SELECT
    A.EMPNO     AS EMPNO    -- 사원번호
   ,A.JOB       AS JOB      -- 부서
   ,A.HIREDATE  AS HIREDATE -- 입사일
FROM 
    EMP A;

-- 조회된 데이터 정렬하기 , SORT 하기 
-- ORDER BY DESC, ASC    
-- Ascending 오름 차순
-- Desending 내림 차순
/*
SELECT *
FROM   T
WHERE  조건식
ORDER BY 컬럼명1 [ASC|DESC], 컬럼명2 [ASC|DESC], 컬럼명3 [ASC|DESC] ... 
*/

SELECT ROWID, A.* FROM EMP A;        
SELECT ROWID, A.* FROM EMP A ORDER BY A.EMPNO ASC;  -- DEFAULT 
SELECT ROWID, A.* FROM EMP A ORDER BY A.EMPNO DESC;
SELECT ROWID, A.* FROM EMP A ORDER BY 1 DESC;

-- SELECT 절에 있는 컬럼 EMPNO 1, ENAME 2, JOB 3, MGR 4
-- SELECT 절에서 순차적으로 나열된 컬럼명의 순서가 INDEX 이다. 
SELECT EMPNO, ENAME, JOB, MGR FROM EMP A ORDER BY 1 ASC;  -- DEFAULT 


