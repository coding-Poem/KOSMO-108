--2022-03-14
SELECT*FROM EMP;

/*
SQL Structured Query Language 

DQL : Data Query Language : 테이블의 데이터를 조회, 검색
            SELECT

DML : Data Manipulation Language : 테이블의 데이터를 저장, 수정, 삭제
            INSERT, UPDATE, DELETE
            
            -- DML 쿼리의 경우, 트랜잭션은 처리해야 한다.
            **중요!!**
            1. 메모리에 적재된다.
            2. ROLLBACK : 메모리에 적재된 내용을 삭제된다.
            3. COMMIT :  메모리에 적재된 내용을 파일에 적재한다.
            4. 외부 응용프로그램에서는 테이블 내용 중 파일에 적재된 내용만 조회가 가능하다.
    
    
DDL : Data Definition Language : 테이블을 포함한 여러 객체를 생성, 수정, 삭제
            CREATE, ALTER, DROP
            
            -- DDL 쿼리는 트랜잭션이 바로 적용된다.

TCL : Transaction Contorl Language : 트랜잭션 데이터의 영구 저장, 취소 등
            COMMIT, ROLLBACK, SAVEPOINT

DCL : Data Control Language : 데이터 사용 권한 부여 및 취소
            GRANT, REVOKE


-- DDL : Data Definition Language : 테이블을 포함한 여러 객체를 생성, 수정, 삭제
-- CREATE, ALTER, DROP

-- 테이블 만들기
 CREATE TABLE 계정.테이블이름 (
     컬럼명 1 데이터타입1(사이즈)
     , 컬럼명2 데이터타입 2
     , 컬럼명3 데이터타입3  (사이즈)
     .....
     , 컬럼명N 데이터타입N (사이즈));
    
--  (사이즈)는 없을 수도 있다.



-- 스코트 계정에 테이블 이름이 TEST_T1 테이블을 생성하시오.
-- 컬럼은 4개이다.
-- 첫 번째 컬럼의 이름은 TC1이고, 데이터 타입은 VARCHAR2 이고, 사이즈는 10이다.
-- 두 번째 컬럼의 이름은 TC2이고, 데이터 타입은 VARCHAR2이고, 사이즈는 20이다.
-- 세 번째 컬럼의 이름은 TC3이고, 데이터 타입은 NUMBER이고, 사이즈는 기본값이다.
-- 네 번째 컬럼의 이름은 TC4이고, 데이터 타입은 DATE이다.
-- DATE 타입을 사이즈를 적지 않는다.

**중요!!**
-- CREATE TABLE 명령어 : 데이터베이스 엔진에게 테이블 공간을 만들어주세요.

CREATE TABLE SCOTT.TEST_T1 : 데이터베이스 엔진에게 스코트 계정에다가 TEST_T1이라는
테이블을 만들어주세요 라는 의미
*/

CREATE TABLE SCOTT.TEST_T1(
    TC1 VARCHAR2(10)
    ,TC2 VARCHAR2(20)
    ,TC3 NUMBER
    ,TC4 DATE
);

-- 테이블 생성됐는지 확인하는 방법
SELECT*FROM TAB;
DESC TEST_T1;
-- DESCRIBE

CREATE TABLE SCOTT.TEST_2(
    TC2_1 NUMBER(7, 2)
    ,TC2_2 VARCHAR2(30)
    ,TC2_3 DATE
);

/*
스코트 계정에 TEST_2 테이블을 만들어주세요.

컬럼은 총 3개에요.

첫 번째 컬럼 이름은 TC2_1이고, 데이터 타입은 NUMBER이며, 사이즈는 7자리까지이면서 
소수점 둘 째자리 까지 표시해주세요.

두 번째 컬럼 이름은 TC2_2이고, 데이터 타입은 VARCHAR2이며, 사이즈는 30으로 할게요.

세 번째 컬럼 이름은 TC2_3이고, 데이터 타입은 DATE에요. DATE는 사이즈가 없어요.

라고, 오라클 데이터베이스 엔진에게 요청한다.
*/

SELECT*FROM TAB;

-- TEST_2 테이블 이름은 TEST_T2로 바꾸기

RENAME TEST_2 TO TEST_T2;

SELECT*FROM TAB;

-- 테이블(필터링) : 새로고침하기

CREATE TABLE TEST_T3
    -- 계정 생략됨. (SCOTT)
    T_NUM               VARCHAR2(20) PRIMARY KEY
    -- PK는 NOT NULL 조건이여야 하고 UNIQUE 해야함
    ,T_ID                    VARCHAR2(20) NOT NULL
    ,T_PW                 VARCHAR2(20) NOT NULL
    ,T_NAME           VARCHAR2(50)
    ,T_TEL                VARCHAR2(16)
    ,T_HP                  VARCHAR2(16)
    ,T_ADDR            VARCHAR2(200)
    ,T_EMAIL           VARCHAR2(100) NOT NULL
    ,T_INSERTDATE DATE
    ,T_UPDATEDATE DATE
);

SELECT*FROM TAB;
DESC TEST_T3;

/*
-- CREAT TABLE ~ AS 구문 : 기존 테이블을 이용해서 테이블 만드는 것 
-- 기존 테이블에서 순수하게 컬럼 만 또는 컬럼 && 데이터만 복사하는 것이다.
-- WHERE 1=1, WHERE 1=2
-- 단 오브젝트는 복사가 되지 않음 
-- 오브젝트 : PRIMARY KEY, INDEX ..... etc 
*/



CREATE TABLE EMP_T1 AS
SELECT*FROM EMP WHERE 1=2;
-- WHERE 1=2이면, 컬럼만 나오고 데이터는 들어오지 않음
-- EMP테이블의 컬럼으로 새로운 테이블을 만들고 싶을 때 사용
-- 기존 테이블을 가지고 새로운 테이블을 만들 때 사용

SELECT*FROM EMP_T1;
-- EMP 테이블의 컬럼만 생성되었다.

CREATE TABLE EMP_T2 AS
SELECT*FROM EMP WHERE 1=1;

SELECT*FROM EMP_T2;
-- 테이블을 복사할 때, 사용
-- WHERE 1=1이기 때문에 데이터도 다같이 복사된다.
-- EMP 테이블의 컬럼과 레코드 모두 똑같이 생성되었다.

-- 테이블 지우기
DROP TABLE TEST_T1;

SELECT*FROM TAB;
-- 삭제한 TEST_T1 테이블 자리에
-- BIN$IUQk2JrcRK6BLrrQcK65KA==$0 이라는 이상한 게 뜨는데,
-- 내 알바아니다. DBA가 알아서 하는 거임

-- 테이블 변경
SELECT*FROM TAB;

SELECT*FROM TEST_T2;
DESC TEST_T2;

-- 테이블에 컬럼 추가
-- TEST_T2 테이블에 사이즈가 100이고, 데이터타입이
-- VARCHAR2인 TT라는 칼럼을 추가할게요.
-- 오라클에서 테이블에 컬럼을 추가하면 기존 컬럼의 맨 뒤에 
-- 컬럼이 생성된다. (중요!!!)

ALTER TABLE TEST_T2
ADD TT VARCHAR2(100);

SELECT*FROM TEST_T2;
DESC TEST_T2;

-- 테이블 컬럼 이름 변경
ALTER TABLE TEST_T2
RENAME COLUMN TT TO TT_RENAME;

SELECT*FROM TEST_T2;
DESC TEST_T2;

-- 테이블 컬럼 사이즈 변경
ALTER TABLE TEST_T2
MODIFY TT_RENAME VARCHAR2(50);
-- TT_RENAME    VARCHAR2(100) 에서 VARCHAR2(50)으로 바꾸겠다는 의미

SELECT*FROM TEST_T2;
DESC TEST_T2;
-- TT_RENAME    VARCHAR2(50)

-- 테이블 컬럼 삭제
ALTER TABLE TEST_T2
DROP COLUMN TT_RENAME;

SELECT*FROM TEST_T2;
DESC TEST_T2;
-- 테이블에서 TT_RENAME이라는 컬럼이 삭제됨.


-- DML

SELECT*FROM TAB;
DESC TEST_T2;

-- 테이블 TEST_T2 에서 ISUD, CRUD 하기
-- INSERT INTO 테이블 VALUES ();
-- UPDATE 테이블 SET 컬럼;
-- DELETE 테이블;

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.3, '바차 2 문자열', SYSDATE);

COMMIT;
-- 커밋 완료. 


-- 커밋이 완료되어야만, 외부에서 DML로 작업한 결과물을
-- 활용하는 것이 가능하다.

-- SQL Structure Language중에서 DML만 COMMIT을 안하고 조회하면
-- 파일 없이 메모리에 있는 것만 조회한다. (다른 SQL Structure Language는 해당 X)
-- 이럴 경우, 외부에서 활용이 불가하다.
-- 따라서, 외부에서 쓸거면 반드시 COMMIT 을 써야한다.
-- COMMIT을 써야만, 파일로 만들어져서 외부에서 사용이 가능하다.

-- 커밋을 잘 못해서 이전으로 되돌리고 싶을 경우? ROLLBACK

SELECT*FROM TEST_T2;

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.31, '바차 2 문자열1', SYSDATE);

SELECT*FROM TEST_T2;

ROLLBACK;

SELECT*FROM TEST_T2;
-- 이전 COMMIT 상태로 돌아갔다.

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.31, '바차 2 문자열1', SYSDATE);

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.32, '바차 2 문자열2', SYSDATE);

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.33, '바차 2 문자열3', SYSDATE);

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.34, '바차 2 문자열4', SYSDATE);

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.35, '바차 2 문자열5', SYSDATE);


SELECT*FROM TEST_T2;
SELECT COUNT(*) FROM TEST_T2;
-- 6

ROLLBACK;

SELECT*FROM TEST_T2;
SELECT COUNT(*) FROM TEST_T2;
-- 1

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.31, '바차 2 문자열1', SYSDATE);

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.32, '바차 2 문자열2', SYSDATE);

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.33, '바차 2 문자열1', SYSDATE);

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.34, '바차 2 문자열4', SYSDATE);

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (1.35, '바차 2 문자열5', SYSDATE);

COMMIT;
-- 커밋 완료.

SELECT*FROM TEST_T2;
SELECT COUNT(*) FROM TEST_T2;
-- 6

ROLLBACK;

SELECT COUNT(*) FROM TEST_T2;
-- 6

-- 커밋을 하고 난 뒤에, ROLLBACK을 하면 
-- 이전 COMMIT 상태로 돌아가기 때문에 COUNT(*)RK
-- 6이 나온다.

SELECT*FROM TEST_T2;

DELETE FROM TEST_T2
WHERE TC2_1 >= 1.32;

SELECT*FROM TEST_T2;
COMMIT;
--=========================================



