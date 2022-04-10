SELECT * FROM TAB;
SELECT COUNT(*) FROM TAB;
SELECT * FROM TEST_T1; -- 테이블이 삭제됨

SELECT * FROM TEST_T2;

-- TEST_T2 테이블에 
-- TC2_1 : 본인 나이 
-- TC2_2 : 본인 이름 
-- TC2_3 : 현재날짜 
-- 입력하고, 조회하고,  ROLLBACK, 조회하기 
-- 입력하고, 조회하고,  COMMIT, 조회하기 

-- 데이터베이스에서 덤프 뜨세요

INSERT INTO TEST_T2 (  
                        TC2_1 -- place holder 1
                       ,TC2_2 -- place holder 2
                       ,TC2_3 -- SYSDATE
                    )
             VALUES (   
                        30      -- place holder 1
                       ,'박건원' -- place holder 2
                       ,SYSDATE
                    );
SELECT * FROM TEST_T2;
ROLLBACK;
COMMIT;

INSERT INTO TEST_T2 -- (TC2_1,   TC2_2,    TC2_3)
             VALUES (   27,  '박주형',  SYSDATE);
COMMIT;             

/*
컬럼 갯수가 같아야 한다.
INSERT INTO TEST_T2 -- (TC2_1,   TC2_2,    TC2_3)
             VALUES (   27,  '박주형');
SQL 오류: ORA-00947: 값의 수가 충분하지 않습니다
00947. 00000 -  "not enough values"
 */            
/*
오라클에는 에러 코드를 지원한다.
ORA-00947
ORA : 접두어 
00947 : 에러 코드 이면서 에러유형의 번호
*/
/*
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (   27,  '전건희');
SQL 오류: ORA-00947: 값의 수가 충분하지 않습니다
00947. 00000 -  "not enough values"
*/

INSERT INTO TEST_T2 (TC2_1,   TC2_2)
             VALUES (   27,  '전건희');
SELECT * FROM TEST_T2;

INSERT INTO TEST_T2 (TC2_1,   TC2_3)
             VALUES (   27,  SYSDATE);
SELECT * FROM TEST_T2;
COMMIT;

-- 자바 SQLMAP  에서 사용하기 
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (   ?,        ?,  SYSDATE);

DESC TEST_T2;

/*          
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES ('2.22',  한글 ,  '20220315');             
오류 발생 명령행: 60 열: 31
오류 보고 -
SQL 오류: ORA-00984: 열을 사용할 수 없습니다
00984. 00000 -  "column not allowed here"
*/


/*
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  한글 ,  '20220315');             
오류 발생 명령행: 69 열: 29
오류 보고 -
SQL 오류: ORA-00984: 열을 사용할 수 없습니다
00984. 00000 -  "column not allowed here"
*/

/*
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '한글' ,  2022년3월15일); 
명령의 78 행에서 시작하는 중 오류 발생 -
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '한글' ,  2022년3월15일)
오류 발생 명령행: 79 열: 43
오류 보고 -
SQL 오류: ORA-00917: 누락된 콤마
00917. 00000 -  "missing comma"
*/

/*
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '한글' ,  '2022년3월15일'); 
명령의 88 행에서 시작하는 중 오류 발생 -
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '한글' ,  '2022년3월15일')
오류 보고 -
ORA-01861: 리터럴이 형식 문자열과 일치하지 않음
*/

/*
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '한글' ,  2022315); 
명령의 96 행에서 시작하는 중 오류 발생 -
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '한글' ,  2022315)
오류 발생 명령행: 97 열: 39
오류 보고 -
SQL 오류: ORA-00932: 일관성 없는 데이터 유형: DATE이(가) 필요하지만 NUMBER임
00932. 00000 -  "inconsistent datatypes: expected %s got %s"
*/

/*
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '한글' ,  '2022315'); 
명령의 106 행에서 시작하는 중 오류 발생 -
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '한글' ,  '2022315')
오류 보고 -
ORA-01861: 리터럴이 형식 문자열과 일치하지 않음             
*/


INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '한글' ,  '20220315');             
-- 1 행 이(가) 삽입되었습니다.
SELECT * FROM TEST_T2;             
ROLLBACK;             
             
DESC TEST_T2;
--이름    널? 유형           
----- -- ------------ 
--TC2_1    NUMBER(7,2)  
--TC2_2    VARCHAR2(30) 
--TC2_3    DATE 

INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.2233,  '한글' ,  '20220315');             
SELECT * FROM TEST_T2;

INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (12345678.2233,  '한글' ,  '20220315');       
--명령의 149 행에서 시작하는 중 오류 발생 -
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (12345678.2233,  '한글' ,  '20220315');
--오류 보고 -
--ORA-01438: 이 열에 대해 지정된 전체 자릿수보다 큰 값이 허용됩니다.

INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  '한글이몇자나들어가는지궁금합니다.' ,  '20220315');
SELECT LENGTH('한글이몇자나들어가는지궁금합니다.') FROM DUAL;   

INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  'ABCDEFGHIJKLMNOPQRSTUVWXYZabcde' ,  '20220315');
--명령의 162 행에서 시작하는 중 오류 발생 -
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (2.22,  'ABCDEFGHIJKLMNOPQRSTUVWXYZabcde' ,  '20220315');
--오류 보고 -
--ORA-12899: "SCOTT"."TEST_T2"."TC2_2" 열에 대한 값이 너무 큼(실제: 31, 최대값: 30)

SELECT LENGTH('ABCDEFGHIJKLMNOPQRSTUVWXYZabcde') FROM DUAL;

INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (NULL,  NULL ,  NULL);
SELECT * FROM TEST_T2;

INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES ('NULL',  'NULL' ,  'NULL');
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (NULL,  'NULL' ,  'NULL');
--오류 보고 -
--ORA-01722: 수치가 부적합합니다
INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES ('NULL',  'NULL' ,  'NULL');
--오류 보고 -
--ORA-01722: 수치가 부적합합니다

SELECT * FROM TEST_T2;

INSERT INTO TEST_T2 (TC2_1,   TC2_2,    TC2_3)
             VALUES (30,  '박건원' ,  SYSDATE);
COMMIT;             

INSERT INTO TEST_T2
    SELECT * FROM TEST_T2 WHERE ROWNUM < 2;

SELECT * FROM TEST_T2;

INSERT INTO TEST_T2 (TC2_1, TC2_2)
    SELECT TC2_1, TC2_2 FROM TEST_T2 WHERE ROWNUM < 3;
    
SELECT * FROM TAB;    
DESC TEST_T3;

SELECT * FROM ALL_IND_COLUMNS;

CREATE TABLE TEST_T3 (
    T_NUM           VARCHAR2(20) PRIMARY KEY 
   ,T_ID            VARCHAR2(20) NOT NULL
   ,T_PW            VARCHAR2(20) NOT NULL
   ,T_NAME          VARCHAR2(50)    
   ,T_TEL           VARCHAR2(16)       
   ,T_HP            VARCHAR2(16)          
   ,T_ADDR          VARCHAR2(200)             
   ,T_EMAIL         VARCHAR2(100) NOT NULL            
   ,T_INSERTDATE    DATE
   ,T_UPDATEDATE    DATE
);

/*
테이블 생성 시 컬럼에 PRIMARY KEY 를 지정하면
시스템에서 해당 컬럼에 인덱스를 부여한다. 
인덱스 이름은 SYS_C00110565 이다. 

컬럼에 PRIMARY KEY 를 지정하면
해당 컬럼은 NOT NULL + UNIQUE 이다.
그 테이블에 해당 컬럼에는 꼭 데이터가 있어야 하고 <-- NOT NULL
그 데이터와 같은 것이 있으면 않된다 <-- UNIQUE
*/

-- TEST_T3	T_NUM	SYS_C0011056
SELECT  A.TABLE_NAME,  A.COLUMN_NAME, A.INDEX_NAME 
FROM    ALL_IND_COLUMNS A
WHERE   A.TABLE_NAME IN ('TEST_T3');


CREATE TABLE TEST_T4 (
    T1 VARCHAR2(20) PRIMARY KEY -- NOT NULL + UNIQUE
   ,T2 VARCHAR2(20) NOT NULL 
   ,T3 NUMBER(4,3) -- NULL 허용
   ,T4 VARCHAR2(1) -- NULL 허용
   ,T5 DATE -- NULL 허용
);

DESC TEST_T4;

SELECT * FROM TEST_T4;
DESC TEST_T4;
SELECT  A.TABLE_NAME,  A.COLUMN_NAME, A.INDEX_NAME 
FROM    ALL_IND_COLUMNS A
WHERE   A.TABLE_NAME IN ('TEST_T4');

INSERT INTO TEST_T4 (T1,       T2,   T3,   T4,       T5)
            VALUES  ('1', '박건원',   30,  'Y',  SYSDATE);

INSERT INTO TEST_T4 (T1,       T2,   T3,   T4,       T5)
            VALUES  ('1',    NULL,   NULL,  NULL,  NULL);            

INSERT INTO TEST_T4 (T1,       T2,   T3,   T4,       T5)
            VALUES  ('1',  '박건원',   NULL,  NULL,  NULL); 
ROLLBACK;

INSERT INTO TEST_T4 (T1,       T2,    T3,   T4,       T5)
            VALUES  ('1',  '박건원',   30,  NULL,  NULL); 

INSERT INTO TEST_T4 (T1,       T2,      T3,   T4,       T5)
            VALUES  ('1',  '박건원',     1.333,  NULL,  NULL); 
SELECT * FROM TEST_T4;

INSERT INTO TEST_T4 (T1,       T2,   T3,   T4,       T5)
            VALUES  ('2', '박주형',   7,  'Y',  SYSDATE);            
INSERT INTO TEST_T4 (T1,       T2,   T3,   T4,       T5)
            VALUES  ('2', '전건희',   2,  'Y',  SYSDATE);            
--오류 보고 -
--ORA-00001: 무결성 제약 조건(SCOTT.SYS_C0011058)에 위배됩니다
--TEST_T4	T1	SYS_C0011058

INSERT INTO TEST_T4 (T1,       T2,   T3,   T4,       T5)
            VALUES  (NULL, '전건희',   2,  'Y',  SYSDATE); 
--오류 보고 -
--ORA-01400: NULL을 ("SCOTT"."TEST_T4"."T1") 안에 삽입할 수 없습니다 

-- INDEX 
-- PRIMARY KEY = NOT NULL + UNIQUE

INSERT INTO TEST_T4 (T1,       T2,   T3,   T4,       T5)
            VALUES  ('3', '전건희',   2,  'Y',  SYSDATE); 
COMMIT;



-- 테이블 컬럼 사이즈 TEST_T4  
ALTER TABLE TEST_T4
MODIFY T3 NUMBER(6,3);
DESC TEST_T4;
/*
UPDATE 테이블이름 
SET 컬럼명 = 값, 컬럼명 = 값
WHERE 컬럼명 = 값
*/

-- 1. 변경할 컬럼 값 조회 해보기
SELECT T3 FROM TEST_T4 WHERE T2 = '박건원' AND T1 = '1';
-- 2. 값을 확인 했으면 UPDATE 구문으로 변경하기 
UPDATE TEST_T4 
SET T3 = 30 
WHERE T2 = '박건원' AND T1 = '1';
-- 3. 값을 확인하고 ROLLBACK , COMMIT
COMMIT;
-- 박주형 27
UPDATE TEST_T4 
SET T3 = 27 
WHERE T2 = '박주형' AND T1 = '2';
-- 전건희 27
UPDATE TEST_T4 
SET T3 = 27 
WHERE T2 = '전건희' AND T1 = '3';
COMMIT;
-- 박건원 Y, SYSDATE 변경
UPDATE TEST_T4 
SET T4 = 'Y', T5 = SYSDATE 
WHERE T2 = '박건원' AND T1 = '1';

SELECT * FROM TEST_T4 ORDER BY 1;
ROLLBACK;

-- MAX 값 채번로직 
INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '신익현', 26,  'Y',  SYSDATE); 
INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '한지혜', 26,  'Y',  SYSDATE); 
INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '김별', 23,  'Y',  SYSDATE); 
--INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '윤요섭', 27,  'Y',  SYSDATE); 
--INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '민경호', 27,  'Y',  SYSDATE); 
--INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '송정흔', 27,  'Y',  SYSDATE); 
--INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '박성훈', 27,  'Y',  SYSDATE); 
--INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '우한슬', 29,  'Y',  SYSDATE); 
--INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '황신애', 23,  'Y',  SYSDATE);
--INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '김영하', 22,  'Y',  SYSDATE);
--INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ((SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T4), '김민배', 32,  'Y',  SYSDATE);

SELECT NVL(MAX(NULL), 0) + 1 FROM DUAL;
CREATE TABLE TEST_T5 ( T1 VARCHAR2(20) PRIMARY KEY);
SELECT NVL(MAX(T1), 0) + 1 FROM TEST_T5;

SELECT * FROM TEST_T5;
INSERT INTO TEST_T5 VALUES (1);
INSERT INTO TEST_T5 VALUES (10);

SELECT HIREDATE FROM EMP ORDER BY HIREDATE;
SELECT MAX(HIREDATE) FROM EMP ORDER BY HIREDATE;
SELECT MIN(HIREDATE) FROM EMP ORDER BY HIREDATE;

SELECT * FROM TEST_T4 ORDER BY 1;

SELECT T4, T5 FROM TEST_T4 WHERE T1 = '3';

UPDATE TEST_T4
SET T4 = 'N', T5 = SYSDATE
WHERE T1 = '3';

COMMIT;

UPDATE TEST_T4
SET T4 = 'N', T5 = SYSDATE
WHERE T1 IN ('4', '5');

SELECT * FROM TEST_T4 WHERE T4 = 'Y' ORDER BY 1;
SELECT * FROM TEST_T4 WHERE T4 = 'N' ORDER BY 1;

SELECT * FROM TEST_T2;
/*
DELETE  FROM 테이블
WHERE 컬럼명 = 값;
*/

SELECT * FROM TEST_T2 WHERE TC2_1 = '2.22';
DELETE FROM TEST_T2 WHERE TC2_1 = '2.22';
ROLLBACK;

SELECT * FROM TEST_T2 WHERE TC2_1 = '1.3';
DELETE FROM TEST_T2 WHERE TC2_1 = '1.3';

DELETE FROM TEST_T2;
-- 10개 행 이(가) 삭제되었습니다.
TRUNCATE TABLE TEST_T2;
-- Table TEST_T2이(가) 잘렸습니다.

SELECT*FROM TEST_T4 ORDER BY T1 ASC;

UPDATE TEST_T4
SET  T3='27';

UPDATE TEST_T4
SET T3='30'
WHERE T1=1;

COMMIT;


/*
DML Data Manipulation Language 테이블의 데이터를 저장, 수정, 삭제
    INSERT, UPDATE, DELETE
    DML 쿼리는 트랜잭션은 처리해야 한다. COMMIT ROLLBACK
	1. 메모리에 적재된다.
	2. ROLLBACK : 메모리에 적재된 내용을 삭제한다.
	3. COMMIT : 메모리에 적재된 내용를 파일에 적재한다. 
	4. 외부 응용프로그램에서는 테이블 내용중 파일에 적재된 내용만 조회가 가능한다.

INSERT 
    1. 컬럼 갯수, 순서 와 값 갯수 순서 일치시키기 
    2. 데이터 타입 확인하기
    3. 데이터 사이즈 확인하기 
    4. NULL 데이터 확인하기 
UPDATE 
    1. 수정할 컬럼 및 데이터 확인하기
    2. 조건절 꼭 확인하기
    3. 수정 하고나서 수정 항목 확인하고 커밋 하기 
DELETE    
    1. 삭제할 컬럼 및 데이터 확인하기
    2. 조건절 꼭 확인하기
    3. 삭제하고나서 삭제 항목 확인하고 커밋 하기 
    4. TRUNCATE 명령어를 실행하면 ROLLBACK 을 할 수 없다.
*/