-- 문자 : 싱글쿼테이션 : '문자열'
SELECT '문자열' FROM DUAL;

-- 숫자 : 숫자 또는 '숫자'(문자숫자)
SELECT 11, '11' FROM DUAL;

-- null 처리하는 함수 : NVL(NULL, 치환하고싶은 데이터)
SELECT NVL(NULL, 0) FROM DUAL;

-- 날짜 처리하는 함수 : 
-- TO_DATE() : 날짜 모양을 한 문자열을 날짜 데이터 형식으로 변환한다. 
SELECT '90/12/01' FROM DUAL;
SELECT TO_DATE('90/12/01') FROM DUAL;

-- TO_CHAR(첫번째 매개변수, 두번째 매개변수) : SimpleDateFormat
-- 첫번째 매개변수 : DATE 타입이어야 한다.
-- 두번째 매개변수 : 날짜 형식 :  YYYY-MM-DD, YYYY/MM/DD, YYYY.MM.DD
SELECT TO_CHAR(TO_DATE('90/12/01'), 'YYYY-MM-DD') FROM DUAL;

-- 날짜 처리하는 데이터타입 : 
-- 현재 날짜 : SYSDATE, SYSTIMESTAMP
SELECT TO_CHAR(TO_DATE(SYSDATE), 'YYYY-MM-DD') FROM DUAL;

-- 문자열 대소문자를 구별 했다.
-- 대문자로 변환하는 함수 : UPPER()
SELECT UPPER('smith') FROM DUAL;

-- 소문자로 변환하는 함수 : LOWER()
SELECT LOWER('SMITH') FROM DUAL;

-- 검색 : LIKE '%', '_'
SELECT ENAME FROM EMP WHERE ENAME LIKE '%S';
SELECT ENAME FROM EMP WHERE ENAME LIKE '_A%';

SELECT ENAME FROM EMP WHERE ENAME LIKE 'S%';
SELECT ENAME FROM EMP WHERE ENAME LIKE '%S%';

-- 데이터 아이체킹
-- NULL CHECK
SELECT COMM FROM EMP WHERE COMM IS NULL;
SELECT COMM FROM EMP WHERE COMM IS NOT NULL;
-- 데이터타입 DATE 컬럼의 날짜 형식 
-- 숫자
-- 문자

-- DESC : 테이블 구조 : 컬럼명, 데이터 타입,  사이즈, NULL 여부
DESC EMP;

-- DISTINCT
SELECT DISTINCT EMPNO, DEPTNO FROM EMP;
SELECT DISTINCT DEPTNO, EMPNO FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;

-- ROWNUM()
SELECT * FROM EMP WHERE ROWNUM <= 10;

SELECT * FROM DUAL;
SELECT COUNT(*) FROM TAB;
SELECT 1, 2, A.* FROM  TAB A;
SELECT 1 FROM  TAB;

SELECT COUNT(*) FROM EMP;
SELECT 1, 2, 3, A.* FROM EMP A;
SELECT 1 FROM EMP A;


-- WHERE 절 
/*
SELECT
    SELECT 절 : SELECT * FROM DUAL;    
FROM 
    FROM 절 :  SELECT * FROM DUAL;
WHERE 
    WHERE 절 : SELECT * FROM DUAL;
    WHERE 절은 항상 TRUE 일 때만 수행한다.
    1=1 : 개발할 때만 사용한다.
    1=1 : 보안취약 점검 대상이다. 운영(계) REAL SERVER 에서는 사용금지이다.
    
연산자 및 서브쿼리를 사용할 수 있다.
AND, OR, IN, FROM ~ TO 연산, <, >, <=, >= ..... 
*/

SELECT * FROM EMP WHERE 1=1;
SELECT * FROM EMP WHERE 1=2;

/*
조건이 여러개인 쿼리를 만들 때는 
항상 조건 하나씩 쿼리를 만들어서 눈으로 확인한다.
확인이 되면 
쿼리문을 조합한다.

<-- 단문 쿼리로 확인해
<-- 복문 쿼리리 바로 쓰지말고 단문 쿼리로 확인하고 해 
*/

-- 부서번호 10 직책 MANAGER 
SELECT * FROM EMP WHERE DEPTNO = 10;
SELECT * FROM EMP WHERE JOB = 'MANAGER';

SELECT * FROM EMP 
WHERE 1=2
AND   DEPTNO = 10 
AND   JOB = 'MANAGER';

SELECT * FROM EMP 
WHERE 1=1
AND   DEPTNO = 10 
AND   JOB = 'MANAGER';

SELECT * FROM EMP 
WHERE 1=2
AND   DEPTNO = 10 
AND   JOB = 'MANAGER';

-- 부서번호 10 직책 MANAGER 
SELECT * FROM EMP WHERE DEPTNO = 10;
SELECT * FROM EMP WHERE JOB = 'MANAGER';

SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB = 'MANAGER';

SELECT * FROM EMP 
WHERE 1=1
OR    DEPTNO = 10 
OR    JOB = 'MANAGER';

SELECT * FROM EMP 
WHERE 1=2
OR   DEPTNO = 10 
OR   JOB = 'MANAGER';

-- 부서번호 10 20 사원
SELECT * FROM EMP WHERE DEPTNO = 10;
SELECT COUNT(*) FROM EMP WHERE DEPTNO = 10;
SELECT * FROM EMP WHERE DEPTNO = 20;
SELECT COUNT(*) FROM EMP WHERE DEPTNO = 20;

SELECT * FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 20;
SELECT COUNT(*) FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 20;

-- IN() : 같은 컬럼에 여러개의 값을 조회 할 때 
SELECT COUNT(*) FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 20;

-- 커미션이 300, 500, 1400 사원
SELECT * FROM EMP WHERE COMM IN (300, 500, 1400);
SELECT * FROM EMP WHERE COMM = 300 OR COMM = 500 OR COMM = 1400;

SELECT * FROM EMP WHERE COMM NOT IN (300, 500, 1400);

-- 10번 부서인 사원들 출력 
SELECT * FROM EMP WHERE DEPTNO = 10;

-- 10번 부서가 아닌 사원들 출력 
SELECT * FROM EMP WHERE NOT DEPTNO = 10;
SELECT * FROM EMP WHERE DEPTNO <> 10;
SELECT * FROM EMP WHERE DEPTNO != 10;
SELECT * FROM EMP WHERE DEPTNO ^= 10;

-- 급여 1000에서 1500 사이인 사원을 조회 하시오 
SELECT * FROM EMP WHERE SAL >= 1000;
SELECT * FROM EMP WHERE SAL <= 1500;

-- FROM ~ TO 구간 검색 
SELECT * FROM EMP 
WHERE SAL >= 1000
AND   SAL <= 1500;

SELECT  A.* 
FROM    EMP A
WHERE   1=1
AND     A.SAL <= 1500
AND     A.SAL >= 1000;

-- 급여가 1000 미만 이거나 1500 초과인 사원을 조회 

SELECT * FROM EMP A
WHERE 1=1
AND (SAL < 1000
OR SAL > 1500);

-- FROM ~ TO : 구간 검색 
-- BETWEEN A AND B
-- 특정 컬럼의 데이터 값이 하한값(A) 와 상한값(B) 사이에 포함된 로우를 반환한다.
SELECT * FROM EMP
WHERE  1=1
AND    SAL BETWEEN 1000 AND 1500;

SELECT * FROM EMP
WHERE 1=1
AND SAL >= 1000
AND SAL <= 1500;

-- 1981년에 입사한 사원을 조회하시오, 검색하시오, 출력하시오 
-- 19810101 ~ 19811231
-- 구간검색, BETWEEN A AND B
-- 81/02/20 자바처럼 문자열 쪼갤수 있나 ??  
-- 테이블 앨리어스
SELECT HIREDATE FROM EMP WHERE ROWNUM <= 5;

SELECT A.* FROM SCOTT.EMP A
WHERE  1=1
AND    A.HIREDATE BETWEEN '1981/01/01' AND '1981/12/31';

SELECT A.* FROM SCOTT.EMP A
WHERE  1=1
AND    A.HIREDATE <= '1981/12/31'
AND    A.HIREDATE >= '1981/01/01'; 

SELECT A.* FROM SCOTT.EMP A
WHERE  1=1
AND    A.HIREDATE <= TO_CHAR(TO_DATE('1981/12/31'), 'YYYYMMDD')
AND    A.HIREDATE >= TO_CHAR(TO_DATE('1981/01/01'), 'YYYYMMDD'); 

--##################################################################
SELECT A.* FROM SCOTT.EMP A
WHERE  1=1
AND    TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') <= TO_CHAR(TO_DATE('1981/12/31'), 'YYYYMMDD')
AND    TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') >= TO_CHAR(TO_DATE('1981/01/01'), 'YYYYMMDD'); 
--##################################################################

--##################################################################
SELECT A.* FROM SCOTT.EMP A
WHERE  1=1       
AND    TO_CHAR(TO_DATE(A.HIREDATE), 'YYYY') = '1981';

SELECT SUBSTR('81/02/20', 1, 2) FROM DUAL;

SELECT A.HIREDATE FROM SCOTT.EMP A
WHERE  1=1       
AND   SUBSTR(A.HIREDATE, 1, 2) = '81';

SELECT SUBSTR(A.HIREDATE, 1, 2) AS HIREDATE FROM SCOTT.EMP A
WHERE  1=1       
AND   SUBSTR(A.HIREDATE, 1, 2) = '81';
--##################################################################

-- 스택 STACK, 큐 QUEUE

-- SUBSTR(문자열, 시작위치, 길이)
SELECT SUBSTR('SMITH', 1, 2) FROM DUAL;
SELECT SUBSTR('SMITH', 1) FROM DUAL;
SELECT SUBSTR('SMITH', -1, 2) FROM DUAL;
SELECT SUBSTR('SMITH', -1) FROM DUAL;
SELECT SUBSTR('SMITH', -3, 2) FROM DUAL;
SELECT SUBSTR('SMITH', -3) FROM DUAL;

SELECT NVL(NULL, 0) FROM DUAL;
SELECT NVL(NULL, 'A') FROM DUAL;
SELECT NVL(NULL, 'AB') FROM DUAL;

--############################################
SELECT NULL FROM DUAL;
SELECT NULL + 1 FROM DUAL;
SELECT NVL(NULL, 0) + 1 FROM DUAL;
--############################################

SELECT SAL, COMM FROM EMP;

--########################
-- 박건원 
SELECT SAL 
FROM EMP;

SELECT COMM
FROM EMP; 

SELECT COMM, SAL
FROM EMP;
--########################

SELECT COMM FROM EMP;
SELECT COMM FROM EMP WHERE COMM > 0;
SELECT NVL(COMM, 0) AS COMM FROM EMP WHERE COMM > 0;

-- 산술 연산자 + - * /
-- 사원의 급여와 연봉을 출력하시오 
SELECT 1 + 2 FROM DUAL;
SELECT 1 * 2 FROM DUAL;
SELECT 1 * 12 FROM EMP;

SELECT SAL, SAL * 12 AS TSAL FROM EMP;

SELECT DEPTNO * 100, DNAME, LOC  FROM DEPT;

-- 사원의 급여와 연봉, 수당을 출력하시오 
SELECT SAL, (SAL * 12) AS TSAL, COMM FROM EMP;

SELECT 'M' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '0001' FROM DUAL;

-- 사원의 급여와 연봉, 수당, 수당을 포함한 연봉 을 출력하시오 
SELECT SAL, (SAL * 12) AS TSAL, COMM, (SAL*12)+COMM AS CSAL FROM EMP;
-- 컬럼을 조회 할 때는 NULL 여부를 꼭 체크해야 하고
-- 숫자 관련 데이터는 NULL 이면 디폴트 값으로 치환해 놓아야 한다. 
-- 문자열 관련 데이터는 NULL 이면 정해진 값으로 치환해 놓아야 한다. 
SELECT 
        A.SAL                       AS SAL   -- 급여
       ,A.SAL * 12                  AS TSAL  -- 연봉
       ,NVL(A.COMM, 0)              AS COMM  -- 수당 
       ,A. SAL * 12 + NVL(COMM, 0)  AS CSAL  -- 수당을포함한 연봉
FROM 
        EMP A
ORDER BY TSAL DESC;     

SELECT 
        A.SAL                       
       ,A.SAL * 12                  
       ,NVL(A.COMM, 0)              
       ,A. SAL * 12 + NVL(COMM, 0)  
FROM 
        EMP A
ORDER BY 3 DESC; 


-- 모든사원에게 급여를 300원을 인상해준다.
-- 사원이름 , 급여, 인상된 급여(연봉)를 출력하시오 
SELECT 
        A.ENAME             AS ENAME
       ,A.SAL               AS SAL
       ,A.SAL * 12 + 300    AS GSAL
FROM    EMP A;

-- 10번 부서의 사원들에게 수당을 300원씩 일괄 지급하시오 
-- 사원이름, 수당을 출력하시오 

SELECT   A.ENAME                    AS ENAME
        ,NVL(A.COMM,0) +300         AS COMM
FROM
         EMP A
WHERE
         A.DEPTNO = 10;
        
-- 1981년 9월 입사자, 수당 500 지급 
-- 사원번호, 사원이름, 직책, 입사일(YYYY-MM-DD), 수당을 출력하시오 
SELECT 
        A.EMPNO                             AS EMPNO
       ,A.ENAME                             AS ENAME
       ,A.JOB                               AS JOB
       ,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')   AS HIREDATE
       ,NVL(A.COMM, 0) + 500                AS COMM
FROM    EMP A
WHERE   1=1
AND     TO_CHAR(A.HIREDATE, 'YYYYMM') = '198109';

SELECT 
        A.EMPNO                             AS EMPNO
       ,A.ENAME                             AS ENAME
       ,A.JOB                               AS JOB
       ,TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')   AS HIREDATE
       ,NVL(A.COMM, 0) + 500                AS COMM
FROM    EMP A
WHERE   1=1
AND     TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') <= TO_CHAR(TO_DATE('1981/09/31'), 'YYYYMMDD')
AND     TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') >= TO_CHAR(TO_DATE('1981/09/01'), 'YYYYMMDD'); 

-- 1981년 2월 20일 부터 1981년 5월 1일 사이에 입사한 사원의 
-- 이름, 직책, 입사일(YYYY.MM.DD), 급여, 연봉, 상여금을 출력하시오 
-- 출력 순서는 연봉이 많은 순서로 출력 하시오 

--#########################################################
-- 서민정 반장님 
SELECT 
        --A.*  
         A.ENAME
        ,A.JOB
        ,TO_CHAR(TO_DATE(A.HIREDATE,'YYYY.MM.DD'))
        ,NVL(A.SAL,0)
        ,NVL(A.SAL,0) * 12
        ,NVL(A.COMM,0)
FROM 
        EMP A
WHERE   1 = 1
AND     TO_CHAR(TO_DATE(A.HIREDATE),'YYYY-MM-DD') >= TO_CHAR(TO_DATE('1981-02-20'),'YYYY-MM-DD')
AND     TO_CHAR(TO_DATE(A.HIREDATE),'YYYY-MM-DD') <= TO_CHAR(TO_DATE('1981-05-01'),'YYYY-MM-DD')
ORDER BY 5 DESC;
--#########################################################

SELECT EMPNO, ENAME, JOB, MGR FROM EMP WHERE EMPNO = 7369 AND ENAME = UPPER('smith');

SELECT 'M' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '0001' FROM DUAL;
SELECT 'M' || TO_CHAR(SYSDATE, 'YYYYMMDD') || '0002' FROM DUAL;

SELECT * FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT COMM FROM EMP;
SELECT DISTINCT MGR FROM EMP;
SELECT DISTINCT DEPTNO, EMPNO FROM EMP;

SELECT * FROM EMP WHERE ROWNUM <= 10;

SELECT AA.* FROM (SELECT HIREDATE FROM EMP WHERE ROWNUM <= 1) AA;

SELECT   TO_CHAR(TO_DATE(AA.HIREDATE), 'YYYY-MM-DD') AS HIREDATE
        ,AA.JOB                                      AS JOB
FROM (SELECT HIREDATE, JOB FROM EMP WHERE ROWNUM <= 1) AA;

-- NULL 있는 컬럼을 정렬 하면, 소트 하면, ORDER BY 하면
-- 오라클은 ORDER BY 하면 DEFAULT 가 ASCENDING 
SELECT * FROM EMP ORDER BY COMM;
SELECT * FROM EMP ORDER BY MGR;

SELECT * FROM EMP ORDER BY COMM DESC;
SELECT * FROM EMP ORDER BY MGR DESC;

SELECT * FROM EMP ORDER BY COMM NULLS FIRST;
SELECT * FROM EMP ORDER BY COMM NULLS LAST;

SELECT NULL + 1 FROM DUAL;

SELECT NVL(NULL, 0) FROM DUAL;
SELECT NVL(NULL, 'AA') FROM DUAL;

SELECT NVL2(NULL, 'NOT NULL', 'NULL') FROM DUAL;
SELECT NVL2('AA', 'NOT NULL', 'NULL') FROM DUAL;
