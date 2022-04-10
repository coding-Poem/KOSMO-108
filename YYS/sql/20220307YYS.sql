SELECT*FROM EMP ORDER BY COMM DESC;

-- COUNT() 함수: 테이블의 로우 수를 보여준다.
 SELECT COUNT(*) FROM EMP;
 -- 14
 
 SELECT COUNT(EMPNO) FROM EMP;
 -- 14
 
 SELECT COUNT(COMM) FROM EMP;
 -- 4
 
 -- COUNT(*) 으로 체크하면 칼럼별로  다 돌면서 행의 수를 파악하므로,
 -- 리소스가 많이 든다.
 
 -- 따라서, 칼럼 하나를 출력시켜야 한다.
 -- 그러나, 칼럼에서 결측치가 있으면, 레코드 수가 제대로 출력이 되지 않는다.
 -- 따라서, SELECT COUNT(기본키) FROM 테이블;
 -- 이렇게 조회해야 한다. (이유 :  기본키 조건이 NOT NIULL이기 때문
 -- 기본키(PRIMARY KEY : PK) : 중복값이 없어야 한다.
 -- 유니크 : UNIQUE
 
 SELECT COUNT(EMPNO) FROM EMP;
-- 14

SELECT COUNT(DISTINCT(EMPNO)) FROM EMP;
-- 14
 
 -- 외래키(FOREIGN KEY) : 특정 테이블에 포함되어 있으면서
 -- 다른 테이블에 기본키로 지정된 키
 
 -- 스키마 : 테이블 + 로우 + 열 + NULL + PK + FK 전체의 개념
 -- 스키마 : 테이블 구성 요소를 의미한다.
 
 SELECT SYSDATE FROM DUAL;
 --  년, 월, 일에 대한 정보
 SELECT SYSTIMESTAMP FROM DUAL;
 -- 년,월,일,시간까지의 정보
 
 
 -- CHAR :  고정 길이 6칸에 A B CD가 들어오면 A B CD 그대로 저장
 -- VARCHAR : 가변 길이 6칸에 A B CD 가 들어오면 6칸에 그대로 저장하지 않고, 4칸으로 줄여서 저장
 
 
 -- 연습
 
 SELECT 
                A.EMPNO             AS EMPNO 
              , A.ENAME             AS ENAME
              , A.JOB                     AS JOB
               ,A.MGR                   AS MCR
               ,A.HIREDATE       AS HIREDATE
               ,A.SAL                    AS SAL
               ,A.COMM              AS COMM
               ,A.DEPTNO          AS  DEPTNO
FROM
            SCOTT.EMP A;
 
 -- 2022/03/07
 
 SELECT*FROM EMP;
 
 SELECT ROWID, A.EMPNO,  A.ENAME, A.JOB  FROM EMP A;
 
 SELECT*FROM DEPT;
 
SELECT COUNT(EMPNO) FROM EMP;
 -- 14, 갯수 셀 때는 Primary Key의 개수로 조회한다.
 -- 이유: SELECT COUNT(*)은 연산 횟수가 너무 많기 때문이다.
 
 SELECT COUNT(ENAME) FROM EMP;
 
 SELECT COUNT(JOB) FROM EMP;
 
 SELECT COUNT(MGR) FROM EMP;
 
 -- DEPT  테이블 조회하기
 SELECT*FROM DEPT;
 
 -- 데이터가 적기 때문에 이렇게 한 것!!
 
 -- 데이터가 많을 경우, Primary Key 를 COUNT 함수를 통해 조회해야 함.
 -- 테이블 더블 클릭 후, Model 클릭해서 보셈. 혹은 SQL 더블 클릭해서 보셈.
 -- DEPT 테이블의 Primary Key는 DEPTNO 이다.
 
 SELECT COUNT(DEPTNO) FROM DEPT;
 -- 4
 
 -- SELECT*FROM DEPT
 -- SELECT COUN(*) FROM DEPT 가 아니라
 -- SELECT COUNT(DEPTNO) FROM DEPT, 여기서 DEPTNO는 PRIMARY KEY
 --  마지막이 정석이다. (PRIMARY KEY는 NOT NULL 조건이기 때문)
 
 -- 테이블의 칼럼만 직접 눈으로 보고 싶다면??
 SELECT*FROM DEPT WHERE ROWNUM <=3;
 
 -- 이런 식으로 일정 갯수만 뽑아서 어떻게 생겼는지 직접 눈으로 보기(3개만 보기)
 -- SELECT*FROM DEPT 이렇게 전체 다 볼 필요없음
 
 
 
 SELECT B.DEPTNO AS DEPTNO, B.DNAME AS DNAME, B.LOC AS LOC FROM SCOTT.DEPT B;
 
 
 -- DESC : DESCRIBE : 테이블 구조 확인
 -- 테이블 칼럼 명, NULL 여부, 데이터 타입&사이즈
 
 DESC DEPT;
 
 DESC EMP;
 
 DESC TAB;
 
 /*
 DESC 예시
 
 이름        널?       유형           
--------- -------- ------------ 
TNAME     NOT NULL VARCHAR2(30) 
TABTYPE            VARCHAR2(7)  
CLUSTERID          NUMBER       
 */
 
 -- DISTINCT
 SELECT COUNT(DEPTNO) FROM EMP;
 -- 14
SELECT COUNT(DEPTNO) FROM EMP WHERE DEPTNO=10;
 -- 3
 SELECT COUNT(DEPTNO) FROM EMP WHERE DEPTNO=20;
 -- 5
 SELECT COUNT(DEPTNO) FROM EMP WHERE DEPTNO=30;
 --  6
 SELECT COUNT(DEPTNO) FROM EMP WHERE DEPTNO=40;
 -- 0
 
 -- MIN, MAX 로 확인해보기
 SELECT MAX(DEPTNO) FROM EMP;
 -- 30
 SELECT MAX(DEPTNO) FROM DEPT;
 -- 40
 SELECT MIN(DEPTNO) FROM EMP;
 -- 10
 SELECT MIN(DEPTNO) FROM DEPT;
-- 10

-- 중복을 제거한 EMP 테이블의 DEPTNO 종류
SELECT COUNT(DISTINCT DEPTNO) FROM EMP;
 -- 3
 
 -- 중복을 제거한 DEPT 테이블의 DEPTNO 종류
 SELECT COUNT(DISTINCT DEPTNO) FROM DEPT;
 -- 4
 
 --  중복을 제거한 EMP  테이블과 DEPT 테이블의 DEPTNO  종류
 SELECT COUNT(DISTINCT A.DEPTNO), COUNT(DISTINCT B.DEPTNO) FROM EMP A, DEPT B;
 -- 3, 4
  
  -- EMP 테이블에서 부서번호가 10번 부서의 사원번호를 (사원번호가) 높은 순으로 조회 하시오.
  -- ()안에 내용이 빠져있으면, 정렬의 기준에 대한 명시가 없으므로, 반드시 ()안의 내용을 필히 써야한다.
  
  SELECT*FROM EMP A WHERE A.DEPTNO=10 ORDER BY DEPTNO DESC;
  
  --글자인 경우 같은 것을 어떻게 추출할까?
  
  -- LIKE 연산자 쓰기
  SELECT*FROM EMP WHERE JOB LIKE  '%SAL%';

-- 그냥 검색해보기
  SELECT*FROM EMP WHERE JOB='SALESMAN';
  
-- 부서번호가 30이고 사원번호가 7499인 사원의 직책은 무엇인가?
SELECT JOB FROM EMP WHERE DEPTNO='30' AND EMPNO='7499';
-- SALESMAN
-- JAVA에서 데이터는 대부분 문자열로 처리하므로, 30, 7499가 아니라
-- '30','7499'으로 찾아야 한다.

-- 스미스 사원의 사원번호, 직책, 입사일을 조회하시오.
SELECT EMPNO, JOB, HIREDATE FROM EMP WHERE ENAME='SMITH';
-- 7369, CLERK, 80/12/17

SELECT EMPNO, JOB, HIREDATE FROM EMP WHERE ENAME=UPPER('smith');
-- UPPER로 소문자로 들어와도 대문자로 처리할 수 있다.

-- 80/12/17를 1980-12-17으로 바꾸어서 표현해보기
SELECT EMPNO, JOB, TO_CHAR(HIREDATE, 'YYYY-MM-DD')  FROM EMP WHERE ENAME=UPPER('smith');

-- 부서번호 20번 사원들의 입사일을 조회하시오. 입사일 형식은 YYYY.MM.DD
SELECT TO_CHAR(HIREDATE, 'YYYY.MM.DD') 
FROM EMP 
WHERE DEPTNO=20;

-- 오라클에서만 제공하는 DUMMY TABLE : DUAL (중요) --

DESC DUAL;

SELECT*FROM DUAL;

SELECT 1 FROM DUAL;

SELECT 1+2 FROM DUAL;

-- TO_DATE : 날짜 형식으로 바꾸는 함수
-- TO_CHAR : 날짜 형식을 바꾸는 함수
SELECT TO_CHAR(TO_DATE('80/12/17'), 'YYYY.MM.DD') FROM DUAL;

-- 오늘 날짜 형식 바꾸기
SELECT TO_CHAR(SYSDATE, 'YYYY.MM.DD') FROM DUAL;

-- DUAL 활용 방법 smith, SMITH 소문자 혹은 대문자로 변경
SELECT UPPER('smith') FROM DUAL;
SELECT LOWER('SMITH') FROM DUAL;


-- DUAL 테이블을 통해 사칙연산 연습해보기
SELECT 3*4 FROM DUAL;
-- 12

SELECT 3/4 FROM DUAL;
-- 0.75

SELECT 3-4 FROM DUAL;
-- -1

SELECT 3+4 FROM DUAL;
-- 7

SELECT NULL FROM DUAL;
-- (null)

SELECT ' ' FROM  DUAL;
-- null이 아닌 빈 공간으로 출력된다.

-- ========= 암기 ============
-- DUMP 연습하기
SELECT DUMP(NULL) FROM DUAL;

SELECT DUMP(' ') FROM DUAL;
--  Typ=96, Len=1:32

SELECT DUMP('  ') FROM DUAL;
-- Typ=96, Len=2:32,32
-- =========================

SELECT DUMP('   벨   로       그') FROM DUAL;
-- Typ=96 Len=19: 32,32,32,186,167,32,32,32,183,206,32,32,32,32,32,32,32,177,215

--  굉장히 유용한 함수이다.

-- 사원 테이블에서 5건만 조회 하시오.
SELECT*FROM EMP WHERE ROWNUM<=5;
-- 이렇게 무작정 명령문을 칠 것이 아니라 사원테이블에서 어떤 걸 어떤 순서에 맞게
-- 조회해야하는지 먼저 CHECK 해야 한다.

-- NULL 데이터 처리하기
SELECT COMM FROM EMP;
-- 14건의 데이터가 검색됨.

SELECT COUNT(COMM) FROM EMP;
-- 4 (결측치 빼고 4개 있음)

SELECT COUNT(NULL) FROM DUAL;
-- 0
SELECT COUNT(0) FROM DUAL;
-- 1

SELECT COUNT(COMM) FROM EMP WHERE COMM=NULL;
--  잘못된 표기

SELECT COMM FROM EMP WHERE COMM IS NULL;
-- NULL값 조회는 IS NULL으로 해야 함.

SELECT COMM FROM EMP WHERE COMM IS NOT NULL;
-- NULL값이 아닌 값을 조회시에는 IS NOT NULL으로 해야한다.

SELECT COUNT(COMM)  FROM EMP WHERE COMM IS NOT NULL;
-- 4건이 NULL 값이 아닌 것으로 표시 됨.

SELECT COUNT(COMM) FROM EMP WHERE COMM IS NULL;
-- 0: NULL값은 카운팅 되지 않음


SELECT NVL(COMM, 0) FROM EMP;
-- NULL 값을 0으로 수정하라

--EMP 테이블의 건수의 전체 건수는? (단, COMM 컬럼을 사용하세요.)

-- 1단계
SELECT NVL(COMM, 0) AS COMM FROM EMP;
-- NULL값이 0으로 바뀌었는지 확인

-- 2단계 집계해서 보기
SELECT COUNT(NVL(COMM, 0)) FROM EMP;
-- 14

--  LIKE 연산자 %(와일드 카드) 검색
-- 사원테이블에서 사원이름이 S로 시작하는 사원을 검색하시오.
SELECT *FROM EMP WHERE  ENAME LIKE 'S%';

-- 사원 테이블에서 사원이름이 S로 끝나는 사원을 검색하시오.
SELECT*FROM EMP WHERE ENAME LIKE '%S';

-- 사원 테이블에서 사원이름에 S가 들어가는 사원을 검색하시오.
SELECT*FROM EMP WHERE ENAME LIKE '%S%';

-- 사원 테이블에서 사원번호가 7로 시작하는 사원들을 검색하시오.
SELECT*FROM EMP WHERE EMPNO LIKE '7%';

-- 사원테이블에서 사원번호가 9로 끝나는 사원들을 검색하시오.
SELECT*FROM EMP WHERE EMPNO LIKE '%9';

-- LIKE 연산자를 쓸 때, 문자의 경우, 대소문자 구별때문에 UPPER를 함께 써주는 것이 좋다.
SELECT*FROM EMP WHERE ENAME LIKE 's%';
-- 아무 것도 출력 되지 않음
SELECT*FROM EMP WHERE ENAME LIKE UPPER('s%');

-- _(와일드 카드) 검색, 조회
SELECT*FROM EMP;

-- 두 번째 글자에 A가 들어가는 사람 조회
SELECT*FROM EMP WHERE ENAME LIKE '_A%';

-- 세 번째 글자에 A가 들어가는 사람 조회
SELECT*FROM EMP WHERE ENAME LIKE '__A%';

-- 중간에 A가 포함이 되지 않은 사람 조회
SELECT*FROM EMP WHERE ENAME NOT LIKE '%A%';

-- 중간에 A가 포함이 되는 사람 조회
SELECT*FROM EMP WHERE ENAME LIKE '%A%';

-- 날짜 데이터 조회
-- 1981년 1월 1일 이전에 입사한 사원을 출력하시오.
SELECT*FROM EMP ORDER BY HIREDATE ASC;
SELECT*FROM EMP WHERE HIREDATE<'81/01/01';
 -- SELECT*FROM EMP WHERE HIREDATE < '1981/01/01';
-- SELECT*FROM EMP WHERE HIREDATE < '1981.01.01';
-- SELECT*FROM EMP WHERE HIREDATE <'1981-01-01';
-- 다 된다.

-- ===========================================
SELECT*FROM EMP 
WHERE 
                TO_CHAR(HIREDATE, 'YYYY-MM-DD') < TO_CHAR(TO_DATE('81/01/01'), 'YYYY-MM-DD');
-- 날짜는 반드시, 데이터를 TO_CHAR를 통해 형식을 고정해준 뒤, 검색하여야 한다.
-- ===========================================

/*
SELECT TO_CHAR(첫 번째 변수 ,두 번째 변수) FROM EMP;
첫 번째 변수는 항상 DATE 타입이어야 한다.
두 번째 변수는 날짜 형식이어야 한다.
  */
  
SELECT TO_CHAR(HIREDATE, 'YYYY-MM-DD') FROM EMP;
-- 출력 가능

SELECT TO_CAHR('81/01/01', 'YYYY-MM-DD') FROM EMP;
-- 에러 출력 됨

SELECT TO_CHAR(TO_DATE('81/01/01'), 'YYYY-MM-DD') FROM EMP;
-- 에러 해결


-- 서브쿼리 등을 사용할 때 HIREDATE가 날짜여도 문제가 될 수 있으므로 
-- 반드시 TO_DATE를 씌여준뒤, 진행해야 한다.
SELECT TO_CHAR(TO_DATE(HIREDATE), 'YYYY-MM-DD') FROM EMP;

-- 2022-03-08
-- 복습하기
--==============================================

-- 문자 : 싱글쿼텥이션 : '문자열'
SELECT 'A' FROM DUAL;

-- 숫자: 숫자 또는 '숫자'(문자숫자)
SELECT 11 FROM DUAL;
-- 11
SELECT '11' FROM DUAL;
-- 11

-- null 처리하는 함수 : NVL(NULL, 치환하고 싶은 데이터)
SELECT NVL(NULL, 0) FROM DUAL;
-- 0

-- 날짜 처리하는 함수
SELECT '90/12/01' FROM DUAL;
-- 90/12/01
SELECT TO_DATE('90/12/01') FROM DUAL;
-- 90/12/01

SELECT TO_CHAR(TO_DATE('90/12/01'),  'YYYY-MM-DD') FROM DUAL;
-- 1990-12-01

SELECT SYSDATE FROM DUAL;
-- 22/03/08

SELECT TO_CHAR(TO_DATE(SYSDATE), 'YYYY-MM-DD') FROM DUAL;
-- 2022-03-08
-- 항상 SYSDATE가 날짜인 거 알아도 TO_DATE() 소괄호 안에 넣기 이래야 나중에 문제 안 생김.

-- 문자열 대소문자를 구별하기 때문에 UPPER 혹은 LOWER 사용하기
SELECT UPPER('smith') FROM DUAL;
-- SMITH 로 대문자로 치환되어서 출력됨

SELECT LOWER('SMITH') FROM DUAL;
-- smith로 소문자로 치환되어서 출력됨.

-- 검색 : LIKE '%', '_'
SELECT DISTINCT ENAME FROM EMP;

SELECT ENAME FROM EMP WHERE ENAME LIKE UPPER('%S');
-- JONES, ANAMS, JAMES
-- 검색시 UPPER로 올려서 검색하면 더 편하다.


SELECT ENAME FROM EMP WHERE ENAME LIKE UPPER('S%');
-- SMITH, SCOTT

SELECT ENAME FROM EMP WHERE ENAME LIKE UPPER('%S%');
-- SMITH, JONES, SCOTT, ADAMS, JAMES

SELECT ENAME FROM EMP WHERE ENAME LIKE UPPER('__A%');
-- BLAKE, CLARK, ADAMS : 세 번째 글자에 A가 있는 사람들만 출력

SELECT*FROM EMP WHERE COMM IS NULL;
-- COMM이 NULL인 데이터들을 전부 출력하라

SELECT*FROM EMP WHERE COMM IS NOT NULL;
-- COMM이 NULL이 아닌 데이터들을 전부 출력하라.

-- 데이터 정보보기

DESC EMP;
/*
이름       널?       유형           
-------- -------- ------------ 
EMPNO    NOT NULL NUMBER(4)    
ENAME             VARCHAR2(10) 
JOB               VARCHAR2(9)  
MGR               NUMBER(4)    
HIREDATE          DATE         
SAL               NUMBER(7,2)  
COMM              NUMBER(7,2)  
DEPTNO            NUMBER(2)    
*/

DESC DEPT;
/*
이름     널?       유형           
------ -------- ------------ 
DEPTNO NOT NULL NUMBER(2)    
DNAME           VARCHAR2(14) 
LOC             VARCHAR2(13) 
*/

SELECT*FROM EMP WHERE ROWNUM<3;
-- 가장 위의 두 줄만 출력하는 방법