/*
SQL Structured Query Language 에스큐엘, 씨퀄 

DQL Data Query Language 테이블의 데이터를 조회, 검색
    SELECT

DML Data Manipulation Language 테이블의 데이터를 저장, 수정, 삭제
    INSERT, UPDATE, DELETE
    DML 쿼리는 트랜잭션은 처리해야 한다. 
	1. 메모리에 적재된다.
	2. ROLLBACK : 메모리에 적재된 내용을 삭제한다.
	3. COMMIT : 메모리에 적재된 내용를 파일에 적재한다. 
	4. 외부 응용프로그램에서는 테이블 내용중 파일에 적재된 내용만 조회가 가능한다.
    
DDL Data Definition Language 테이블을 포함한 여러 객체를 생성, 수정, 삭제
    CREATE, ALTER, DROP
    DDL 쿼리는 트랜잭션이 바로 적용된다. 
    
TCL Transaction Control Language 트랜잭션 데이터의 영구 저장, 취소 등
    COMMIT, ROLLBACK, SAVEPOINT

DCL Data Control Language 데이터 사용 권한 부여 및 취소
    GRANT, REVOKE
*/

-- DDL Data Definition Language 테이블을 포함한 여러 객체를 생성, 수정, 삭제
-- CREATE, ALTER, DROP

-- 테이블 만들기 
/*
CREATE TABLE [계정].테이블이름 (
    컬럼명1 데이터타입1(사이즈)
   ,컬럼명2 데이터타입2
   ,컬럼명3 데이터타입3(사이즈)
   ....
   ,컬럼명N 데이터타입N(사이즈)
);
*/
/*
스코트 계정에 테이블 이름이 TEST_1 테이블을 생성하시오 
컬럼 4개 이다.
첫 번째 컬럼의 이름은 TC1 이고 테이터 타입은 바차2 이고 사이즈는 10 이다.
두 번째 컬럼의 이름은 TC2 이고 테이터 타입은 바차2 이고 사이즈는 20 이다.
세 번째 컬럼의 이름은 TC3 이고 테이터 타입은 넘버 이고 사이즈는 기본값 이다.
세 번째 컬럼의 이름은 TC4 이고 테이터 타입은 DATE 이다. DATE 타입을 사이즈를 적지 않느다.
*/

-- CREATE TABLE 명령어 : 데이터베이스 엔진에게 테이블 공간은 만들어주세요 
-- CREATE TABLE SCOTT.TEST_T1 : 데이터베이스 엔진에게 스코드 계정에다가 TEST_T1 이라는 테이블을 만들어 주세오 
                       
CREATE TABLE SCOTT.TEST_T1 (
    TC1 VARCHAR2(10)
   ,TC2 VARCHAR2(20) 
   ,TC3 NUMBER
   ,TC4 DATE
);
-- CREATE TABLE SCOTT.TEST_T1

SELECT * FROM TAB;
DESC TEST_T1;

-- 주석
CREATE TABLE SCOTT.TEST_2 (
    TC2_1 NUMBER(7, 2)
   ,TC2_2 VARCHAR2(30)
   ,TC2_3 DATE
);
-- Table SCOTT.TEST_2이(가) 생성되었습니다.

SELECT * FROM TAB;

-- 테이블 이름 변경해 보기 
RENAME TEST_2 TO TEST_T2;
SELECT * FROM TAB;

CREATE TABLE TEST_T3 (
    T_NUM VARCHAR2(20) PRIMARY KEY 
   ,T_ID VARCHAR2(20) NOT NULL
   ,T_PW VARCHAR2(20) NOT NULL
   ,T_NAME VARCHAR2(50)    
   ,T_TEL VARCHAR2(16)       
   ,T_HP VARCHAR2(16)          
   ,T_ADDR VARCHAR2(200)             
   ,T_EMAIL VARCHAR2(100) NOT NULL            
   ,T_INSERTDATE DATE
   ,T_UPDATEDATE DATE
);

SELECT * FROM TAB;
DESC TEST_T3;


-- CREAT TABLE ~ AS 구문 : 기존 테이블을 이용해서 테이블 만드는 것 
-- 기존 테이블에서 순수하게 컬럼 만 또는 컬럼 && 데이터만 복사하는 것이다.
-- WHERE 1=1, WHERE 1=2
-- 단 오브젝트는 복사가 되지 않음 
-- 오브젝트 : PRIMARY KEY, INDEX ..... etc 
CREATE TABLE EMP_T1 AS 
SELECT * FROM EMP WHERE 1=2;

SELECT * FROM EMP_T1;

CREATE TABLE EMP_T2 AS 
SELECT * FROM EMP WHERE 1=1;

SELECT * FROM EMP_T2;

SELECT * FROM TAB;

-- 테이블 삭제 
DROP TABLE TEST_T1;
-- Table TEST_T1이(가) 삭제되었습니다.

SELECT * FROM TAB;

-- 테이블 변경
SELECT * FROM TAB;
SELECT * FROM TEST_T2;
DESC TEST_T2;

-- 테이블에 컬럼 추가 
-- 오라클에서 테이블에 컬럼을 추가하면 기존 컬럼의  맨 뒤에 컬럼이 생성된다.  
ALTER TABLE TEST_T2 
ADD TT VARCHAR2(100);
SELECT * FROM TEST_T2;
DESC TEST_T2;

-- 테이블 컬럼 이름 변경
ALTER TABLE TEST_T2
RENAME COLUMN TT TO TT_RENAME;
SELECT * FROM TEST_T2;
DESC TEST_T2;

-- 테이블 컬럼 사이즈 변경  
ALTER TABLE TEST_T2
MODIFY TT_RENAME VARCHAR2(50);
SELECT * FROM TEST_T2;
DESC TEST_T2;

-- 테이블 컬럼 삭제 
ALTER TABLE TEST_T2
DROP COLUMN TT_RENAME;
SELECT * FROM TEST_T2;
DESC TEST_T2;


-- DML Data Manipulation Language 테이블의 데이터를 저장, 수정, 삭제
--    INSERT, UPDATE, DELETE
--    DML 쿼리는 트랜잭션은 처리해야 한다.
SELECT * FROM TAB;
DESC TEST_T2;
DESC TEST_T3;
DESC EMP_T1;
DESC EMP_T2;


-- 오라클 데이터베이스에서 INSERT 문을 실행하면 두 가지 동작을 해야한다.
-- INSERT INTO ~ VALUES 구문으로 인서트를 요청하면 
-- 1. 먼저 메모리에 내용을 저장한다.
-- 이 상태에서 SELECT 를 할 수 있다. 

-- COMMIT 명령을 수행하면
-- 2. 파일에 영구적으로 내용을 저장한다. 
-- 외부 프로그램(자바)에서는 파일에 있는 내용만 조회가 가능하다. 

-- 테이블 TEST_T2 에서 ISUD CRUD 하기 
-- INSERT INTO 테이블 VALUES ();
INSERT INTO TEST_T2 (TC2_1, TC2_2,         TC2_3)
             VALUES (1.3,   '바차2 문자열',  SYSDATE); 
-- 1 행 이(가) 삽입되었습니다.
SELECT * FROM TEST_T2; <-- COMMIT 전에는 메모리에 있는 것을 조회 한 것이다. 
COMMIT;
-- 커밋 완료.
SELECT * FROM TEST_T2;

-- ROLLBACK
INSERT INTO TEST_T2 (TC2_1, TC2_2,         TC2_3)
             VALUES (1.31,   '바차2 문자열1',  SYSDATE); 
-- 1 행 이(가) 삽입되었습니다.             
SELECT * FROM TEST_T2;
ROLLBACK;
-- 롤백 완료.
SELECT * FROM TEST_T2;
-- 1.3	바차2 문자열	22/03/14 
-- ROLLBACK 을 하면 바로 전에 입력했던 내용이 삭제되고 
-- COMMIT 된 내용만 조회가 된다.



-- UPDATE 테이블 SET 컬럼;
-- DELETE 테이블; 
