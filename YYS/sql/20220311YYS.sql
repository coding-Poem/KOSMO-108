-- 20220311 DAO패턴

-- 데이터 전체검색
SELECT*FROM EMP;

SELECT*FROM EMP WHERE ROWNUM<=3;
-- 앞의 세개 행만 보기


-- 전체 검색
SELECT
                A.EMPNO                                                                        AS   EMPNO
               , A.ENAME                                                                       AS   ENAME
                ,A.JOB                                                                               AS   JOB
               , A.MGR                                                                            AS    MGR
               , TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')     AS   HIREDATE
               , A.SAL                                                                              AS  SAL
                ,A.COMM                                                                        AS COMM
                ,A.DEPTNO                                                                    AS DEPTNO
FROM EMP A
ORDER BY 1 DESC;

-- 사번 검색
-- 월급과 수당은 민감한 정보이므로 출력하지 않는다.

SELECT
                A.EMPNO         AS EMPNO
               , A.ENAME        AS ENAME
                ,A.JOB                AS JOB
               , TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')     AS HIREDATE
                ,A.DEPTNO       AS DEPTNO
                
 FROM EMP A
 
 WHERE  A.EMPNO  LIKE '%7%';
            
-- 사원 이름  검색

SELECT
                A.EMPNO         AS EMPNO
               , A.ENAME        AS ENAME
                ,A.JOB                AS JOB
               , TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')     AS HIREDATE
                ,A.DEPTNO       AS DEPTNO
                
 FROM EMP A
 
 -- 내 방식 : WHERE  A.ENAME= 'ALLEN';
 -- 강사님 방식
 WHERE  A.ENAME     LIKE UPPER( '%S%');


-- 사번, 이름 검색(EMPNO, ENAME)

SELECT
                A.EMPNO         AS EMPNO
               , A.ENAME        AS ENAME
                ,A.JOB                AS JOB
               , TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')     AS HIREDATE
                ,A.DEPTNO       AS DEPTNO
                
 FROM EMP A
 
 WHERE A.EMPNO = 7499 --?
 -- AND       A.ENAME=UPPER('ALLEN'); --?
 AND       A.ENAME LIKE UPPER( '%A%'); --?
            
SELECT*FROM EMP;

-- 직책검색(JOB)

SELECT
                A.EMPNO         AS EMPNO
               , A.ENAME        AS ENAME
                ,A.JOB                AS JOB
               , TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')     AS HIREDATE
                ,A.DEPTNO       AS DEPTNO
                
 FROM EMP A
 
 --  WHERE A.JOB='MANAGER'; --?
 WHERE A.JOB LIKE UPPER('%MANAGER%'); --?
            
-- 날짜 검색

SELECT
                A.EMPNO         AS EMPNO
               , A.ENAME        AS ENAME
                ,A.JOB                AS JOB
               , TO_CHAR(A.HIREDATE, 'YYYY-MM-DD')     AS HIREDATE
                ,A.DEPTNO       AS DEPTNO
                
 FROM EMP A
 
 WHERE
                 TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') 
                 >= TO_CHAR(TO_DATE('81/01/01'), 'YYYYMMDD') --?
AND       TO_CHAR(TO_DATE(A.HIREDATE), 'YYYYMMDD') 
                <=TO_CHAR(TO_DATE('82/01/01'), 'YYYYMMDD'); --?
            
                   
            
SELECT*FROM EMP;
