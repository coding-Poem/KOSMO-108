--20220315 YYS

SELECT*FROM TEST_T2;

-- Q. TEST_T2 테이블에
-- TC2_1 : 본인 나이
-- TC2_2 : 본인 이름
-- TC2_3: 현재날짜
-- 를 입력하고, 조회하고, ROLLBACK, 조회하기

DESC TEST_T2;
/*
이름    널? 유형           
----- -- ------------ 
TC2_1    NUMBER(7,2)  
TC2_2    VARCHAR2(30) 
TC2_3    DATE     
*/

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (27, 'YUNYOSEOB', SYSDATE);
-- TC2_1에는 숫자를 입력
-- TC2_2에는 문자열을 입력
-- TC2_3에는 현재 날짜를 입력

SELECT*FROM TEST_T2;

/*
1.3	바차2 문자열	22/03/15
27	YUNYOSEOB	22/03/15
*/

ROLLBACK;

SELECT*FROM TEST_T2;
/*
1.3	바차2 문자열	22/03/15
*/

-- 트랜잭션 : 쪼갤 수 없는 업무 처리의 최소단위이며, 거래내역이라고 한다.
-- SQL 구조 언어로 작업한다. (DDL, DML, DCL, TCL)

-- 트리거 : 방아쇠라는 뜻, DB에서 작업, 트랜잭션과는 다른 개념이다.
-- PL/SQL 에서 사용한다.

-- 테이블1이 있으면 테이블을 백업할 백업 테이블1(테이블1 히스토리)이 있다.
-- 테이블1에서 백업 테이블1(테이블1 히스토리)로 통신할 때
-- 트리거가 발생한다.

-- SQL 구조 언어로 작업을 하면 기존테이블에서 테이블 히스토리로 넘어가는
-- 과정에서 트리거가 발생하는 것이다.

-- 파일을 복사하는 것을 DUMP 뜬다고 한다.

-- Q. TEST_T2 테이블에
-- TC2_1 : 본인 나이
-- TC2_2 : 본인 이름
-- TC2_3: 현재날짜
-- 를 입력하고, 조회하고, COMMIT, 조회하기

DESC TEST_T2;
/*
이름    널? 유형           
----- -- ------------ 
TC2_1    NUMBER(7,2)  
TC2_2    VARCHAR2(30) 
TC2_3    DATE   
*/

INSERT INTO TEST_T2 -- (TC2_1, TC2_2, TC2_3) : 전체 컬럼이면 생략가능
-- 그러나, 생략을 지양한다.
-- 테이블 컬럼을 정확히 인지하고 있어도, 실수할 수 있기 때문
VALUES (27, 'YUNYOSEOB', SYSDATE);

SELECT*FROM TEST_T2;

COMMIT;
ROLLBACK;

SELECT*FROM TEST_T2;
/*
1.3	바차2 문자열	22/03/15
27	YUNYOSEOB	22/03/15
*/

-- DML이 아닌 SQL 구조 언어는 AUTO COMMIT이다.
-- ROLLBACK 명령어로 되돌릴 수 없다.


-- ###################################################
-- ### 오라클에서 INSERT VALUES 에서 흔하게 나는 오류 모음 ######

-- ### INSERT 칼럼, 형식 에러 ##############################

-- 오라클에는 에러 코드를 지원한다.

INSERT INTO TEST_T2
VALUES (27, 'YUN');
/*
SQL 오류: ORA-00947: 값의 수가 충분하지 않습니다
00947. 00000 -  "not enough values"
*/

-- 가장 흔하게 나는 오류임. 이래서 반드시
-- INSERT INTO 테이블 이름 (칼럼이름1...칼럼이름N)
-- 을 써주어야 함. 

INSERT INTO TEST_T2(TC2_1, TC2_2)
VALUES (27, 'YUN');
-- 정상적으로 입력이 됨.

-- 조심해야 할 상황
DESC TEST_T3;
/*
이름           널?       유형            
------------ -------- ------------- 
T_NUM        NOT NULL VARCHAR2(20)  
T_ID         NOT NULL VARCHAR2(20)  
T_PW         NOT NULL VARCHAR2(20)  
T_NAME                VARCHAR2(50)  
T_TEL                 VARCHAR2(16)  
T_HP                  VARCHAR2(16)  
T_ADDR                VARCHAR2(200) 
T_EMAIL      NOT NULL VARCHAR2(100) 
T_INSERTDATE          DATE          
T_UPDATEDATE          DATE    
*/

INSERT INTO TEST_T3 (T_ADDR)
VALUES ('SEOUL');

/*
오류 보고 -
ORA-01400: NULL을 ("SCOTT"."TEST_T3"."T_NUM") 안에 삽입할 수 없습니다

항상 NOT NULL 조건이 있는 칼럼이 있는지 필히 확인해야 한다.
PK와 NOT NULL 조건이 있는 칼럼에는 NULL 값이 들어갈 수 없다.
*/

-- JAVA에서 SQLMAP 에서 사용하기
-- INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
-- VALUES( ? , ? , SYSDATE);

DESC TEST_T2;
/*
이름    널? 유형           
----- -- ------------ 
TC2_1    NUMBER(7,2)  
TC2_2    VARCHAR2(30) 
TC2_3    DATE       
*/

-- VARCHAR2 데이터 타입에 싱글쿼테이션(' ') 뺄 때 나는 에러
INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES ('2.22', 한글, '20220315');

/*
SQL 오류: ORA-00984: 열을 사용할 수 없습니다
00984. 00000 -  "column not allowed here"

주의 : '2.22' 때문에 에러가 나는 것이 아니다. (문자숫자 입력가능)
*/

-- DATE 데이터 타입에 맞지 않는 형식으로 입력할 때 생기는 에러 1
INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES(2.22, '한글', 2022년 3월 15일);

/*
SQL 오류: ORA-00917: 누락된 콤마
00917. 00000 -  "missing comma"
*/

-- DATE 데이터 타입에 맞지 않는 형식으로 입력할 때 생기는 에러 2
INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (2.22, '한글', '2022년 3월 15일');

/*
ORA-01861: 리터럴이 형식 문자열과 일치하지 않음

특이사항 : SQL오류 : ~~ 라는 말이 뜨지 않음
*/

-- DATE 데이터 타입에 맞지 않는 형식으로 입력할 때 생기는 에러 3
INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (2.22, '한글', 2022315);
/*
SQL 오류: ORA-00932: 일관성 없는 데이터 유형: DATE이(가) 필요하지만 NUMBER임
00932. 00000 -  "inconsistent datatypes: expected %s got %s"

NUMBER 라서 에러 발생
*/

-- DATE 데이터 타입에 맞지 않는 형식으로 입력할 때 생기는 에러 4

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (2.22,  '한글', 20220315);
/*
SQL 오류: ORA-00932: 일관성 없는 데이터 유형: DATE이(가) 필요하지만 NUMBER임
00932. 00000 -  "inconsistent datatypes: expected %s got %s"
*/

-- DATE 데이터 타입에 맞지 않는 형식으로 입력할 때 생기는 에러 5

INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (2.22, '한글', '2022315');

/*
오류 보고 -
ORA-01861: 리터럴이 형식 문자열과 일치하지 않음

-- 특이사항 : SQL오류 : ~~ 라는 말이 뜨지 않음
yyyyMMdd 형식이 아니라서 에러 발생
*/


INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (2.22, '한글','20220315');
-- 1행이 잘 삽입이 된다.

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES('2.25', '한글1', '20220315');

ROLLBACK;

-- #####################################################

-- ### INSERT 사이즈 에러 ##################################

DESC TEST_T2;
/*
이름    널? 유형           
----- -- ------------ 
TC2_1    NUMBER(7,2)  
TC2_2    VARCHAR2(30) 
TC2_3    DATE    
*/

-- NUMBER(7,2)에 소수점 넷째자리까지 입력시 발생하는 오류

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (2.2233, '한글', '20220315');
-- 1행 삽입은 된다. 

SELECT*FROM TEST_T2 WHERE TC2_1 = '2.2233';
-- 그러나 아무것도 출력 되지 않는다. 

SELECT*FROM TEST_T2;
-- TC2_1의 데이터 타입은 NUMBER(7,2)이다.
-- 따라서, 소수점 둘 째 자리 이하는 전부 버려진다.
-- ORA 에러로 표시되지 않으니, 꼭 주의하자.

-- NUMBER(7,2)에 8자리 이상의 숫자를 입력할 때 생기는 에러

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (123456789.2233, '한글', '20220315');
/*
오류 보고 -
ORA-01438: 이 열에 대해 지정된 전체 자릿수보다 큰 값이 허용됩니다.

-- 특이사항 : SQL오류 : ~~ 라는 말이 뜨지 않음
*/

SELECT LENGTH('한글이몇자나들어가는지궁금합니다.') FROM DUAL;
-- 17

-- TC2_2    VARCHAR2(30) 이므로, 들어갈 것만 같다.

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (2.22, '한글이몇자나들어가는지궁금합니다.', '20220315');
/*
오류 보고 -
ORA-12899: "SCOTT"."TEST_T2"."TC2_2" 
열에 대한 값이 너무 큼(실제: 33, 최대값: 30)

-- 특이사항 : SQL오류 : ~~ 라는 말이 뜨지 않음

그러나, 한글의 경우 1글자에 크기가 1이 아니라 에러가 나옴
*/

SELECT LENGTH('AAAAAAAAAAAAAAAAA') FROM DUAL;
-- 17

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (2.22, 'AAAAAAAAAAAAAAAAA', '20220315');
-- LENGTH함수로 길이 출력시 같은 17이지만, 문제 없이 1행이 잘 삽입된다.

-- ######################################################
-- 에러 출력 순서

DESC TEST_T2;
/*
이름    널? 유형           
----- -- ------------ 
TC2_1    NUMBER(7,2)  
TC2_2    VARCHAR2(30) 
TC2_3    DATE    
*/


INSERT INTO TEST_T2 (TC2_1, TC2_2, TC2_3)
VALUES (NULL, NULL, NULL);
-- NULL값이 전부 입력된다.

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES ('NULL','NULL','NULL');
/*
오류 보고 -
ORA-01722: 수치가 부적합합니다

NUMBER(7,2)에는 숫자 혹은 문자 숫자만 들어갈 수 있다.
'NULL'은 문자 숫자가 아니여서 에러가 출력된다.
*/

INSERT INTO TEST_T2(TC2_1, TC2_2, TC2_3)
VALUES (NULL, 'NULL','NULL');
/*
오류 보고-
ORA-01841: 년은 영이 아닌 -4713 과 +4713 사이의 값으로 지정해야 합니다.

날짜 데이터에 'NULL'이 들어올 수 없기 때문에 나타나는 에러이다.

-- DATE에 NULL은 들어올 수 있지만, 'NULL'은 들어올 수는 없다.
*/

-- ############## INSERT INTO 테이블이름 SELCT*FROM###########
SELECT*FROM TEST_T2;

INSERT INTO TEST_T2
    SELECT*FROM TEST_T2 WHERE ROWNUM<2;
-- 가장 위의 1개의 행이 삽입 됨

SELECT*FROM TEST_T2;

INSERT INTO TEST_T2(TC2_1, TC2_2)
    SELECT TC2_1, TC2_1 FROM TEST_T2 WHERE ROWNUM<3;
-- 칼럼이 TC2_1, TC2_2인 가장 위의 두 개의 행 데이터가 삽입됨
COMMIT;

-- ##############################################

DESC TEST_T3;
/*
이름           널?       유형            
------------ -------- ------------- 
T_NUM        NOT NULL VARCHAR2(20)  
T_ID         NOT NULL VARCHAR2(20)  
T_PW         NOT NULL VARCHAR2(20)  
T_NAME                VARCHAR2(50)  
T_TEL                 VARCHAR2(16)  
T_HP                  VARCHAR2(16)  
T_ADDR                VARCHAR2(200) 
T_EMAIL      NOT NULL VARCHAR2(100) 
T_INSERTDATE          DATE          
T_UPDATEDATE          DATE     
*/

SELECT*FROM ALL_IND_COLUMNS;

SELECT  A.TABLE_NAME,  A.COLUMN_NAME, A.INDEX_NAME 
FROM    ALL_IND_COLUMNS A
WHERE   A.TABLE_NAME IN ('TEST_T3');
-- INDEX 한국말로 색인 (영어사전에서 a,b,c,d....같은 것)
-- 결과 : TEST_T3	T_NUM	SYS_C0011056

-- PRIMARY KEY

/*
테이블 생성 시 컬럼에 PRIMARY KEY를 지정하면
시스템에서 해당 컬럼에 인덱스를 부여한다.
인덱스 이름은 SYS_C0011056 이다.

컬럼에 PRIMARY KEY를 지정하면
해당 컬럼은 NOT NULL + UNIQUE 이다.
그 테이블에 해당 컬럼에는 꼭 데이터가 있어야 하고 <-- NOT NULL
그 데이터와 같은 것이 있으면 안 된다. <--UNIQUE
*/

CREATE TABLE TEST_T4(
    T1 VARCHAR2(20) PRIMARY KEY -- NOT NULL 이고 UNIQUE
    ,T2 VARCHAR2(20) NOT NULL -- NOT NULL이어야 한다.
    ,T3 NUMBER(4,3) -- NULL 허용
    ,T4 VARCHAR2(1) -- NULL 허용
    ,T5 DATE -- NULL 허용
);

DESC TEST_T4;
/*
이름 널?       유형           
-- -------- ------------ 
T1 NOT NULL VARCHAR2(20) 
T2 NOT NULL VARCHAR2(20) 
T3          NUMBER(4,3)  
-- NUMBER(4,3) : 4는 전체자릿수, 3은 소수점자리
-- 따라서, 정수자릿수는 하나밖에 못옴.
T4          VARCHAR2(1)  
T5          DATE  
*/

SELECT*FROM TEST_T4;
SELECT A.TABLE_NAME, A.COLUMN_NAME, A.INDEX_NAME
FROM ALL_IND_COLUMNS A
WHERE A.TABLE_NAME IN('TEST_T4');
-- ALL_IND_COLUMNS 테이블에서
-- alias를 A로 설정하고,
-- A.TABLE_NAME이 TEST_T4 에 있으면
-- A.TABLE_NAME과 A.COLUMN_NAME과 A.INDEX_NAME 칼럼을
-- 출력하세요.

-- 결과 : TEST_T4	T1	SYS_C0011058

INSERT INTO TEST_T4(T1,     T2,   T3,   T4,     T5)
VALUES                   ('1',  '윤요섭',27,   'Y',    SYSDATE);
/*
오류 보고 -
ORA-01438: 이 열에 대해 지정된 전체 자릿수보다 큰 값이 허용됩니다.

어디서 난 에러인지 찾아보기
T1은 PK이므로, NULL 못 넣고, 중복값을 넣을 수 없다.
*/

INSERT INTO TEST_T4(T1, T2,     T3, T4, T5)
VALUES                    ('2',NULL,NULL,NULL,NULL);

/*
오류 보고 -
ORA-01400: NULL을 ("SCOTT"."TEST_T4"."T2") 안에 삽입할 수 없습니다.

-- T2 NOT NULL VARCHAR2(20) 인데
-- NULL 입력해서 오류
*/

INSERT INTO TEST_T4(T1, T2,     T3,T4,  T5)
VALUES                   ('2','윤요섭',NULL, NULL, NULL);
-- 1행이 삽입 됨

INSERT INTO TEST_T4(T1,T2,T3,T4,T5)
VALUES ('2','윤요섭',27, NULL, NULL);
/*
오류 보고 -
ORA-01438: 이 열에 대해 지정된 전체 자릿수보다 큰 값이 허용됩니다.

T3          NUMBER(4,3)  
네 자리에 세 자리를 입력하여 나타나는 오류
*/

INSERT INTO TEST_T4(T1,T2,T3,T4,T5)
VALUES ('2','윤요섭',1.333, NULL, NULL);
-- T1에 2가 이미 있는데, 또 생성하면 무결성 제약 조건을 위배한다.
-- PK는 NULL이 오면 안 되고, 값이 UNIQUE 해야 한다.

/*
오류 보고 -
ORA-00001: 무결성 제약 조건(SCOTT.SYS_C0011058)에 위배됩니다

TABLE_NAME     COLUMN_NAME        INDEX_NAME
TEST_T4	                    T1	                   SYS_C0011058

-- INDEX_NAME 안에 VALUE는 중복이 되어서는 안 된다.
*/

INSERT INTO TEST_T4(T1,T2,T3,T4,T5)
VALUES ('1','윤요섭',1.333, NULL, NULL);


INSERT INTO TEST_T4(T1,T2,T3,T4,T5)
VALUES (NULL,'윤요섭',1.345, NULL, NULL);

/*
오류 보고 -
ORA-01400: NULL을 ("SCOTT"."TEST_T4"."T1") 안에 삽입할 수 없습니다

PK의 자리에는 NULL이 올 수 없다.
*/

SELECT*FROM TEST_T4;

UPDATE TEST_T4
SET T4='Y'
WHERE T1=2;

UPDATE TEST_T4
SET T4='F'
WHERE T1=1;

SELECT*FROM TEST_T4 WHERE T4='Y';
-- T4 : 레코드의 생존여부를 표시한다.
-- DELETE 명령어로 행을 지워도
-- HISTORY 테이블에 기록이 남아있기 때문에
-- (트리거까지 깔끔하게 지워지지 않음.)
-- 제대로 삭제가 되지 않는다.
-- 따라서 이런 식으로 Y (YES) OR N(NO)로
-- 살아있는 데이터인지 죽어있는 데이터인지 표시를 해주는 
-- 식으로 한다.

INSERT INTO TEST_T4(T1, T2, T3, T4, T5)
VALUES('3','전건희',2,'Y',SYSDATE);

SELECT*FROM TEST_T4;

UPDATE TEST_T4
SET T2='박건원'
WHERE T1=1;

UPDATE TEST_T4
SET T3=1.123
WHERE T1=1;

UPDATE TEST_T4
SET T4=NULL
WHERE T1=1;

UPDATE TEST_T4
SET T5=NULL
WHERE T1=1;

UPDATE TEST_T4
SET T2='박주형'
WHERE T1=2;

UPDATE TEST_T4
SET T3=7
WHERE T1=2;

UPDATE TEST_T4
SET T5=SYSDATE
WHERE T1=2;

SELECT*FROM TEST_T4;
COMMIT;


-- 테이블 컬럼 사이즈  TEST_T4
ALTER TABLE TEST_T4
MODIFY T3 NUMBER(6,3);
-- T3          NUMBER(4,3)  
-- 칼럼 사이즈 변경할 때는 기존 칼럼에 데이터가 있을 때,
-- 사이즈를 줄이면 바뀌지 않는다.
-- 이유 :  데이터가 잘려나가야 하기 때문에
-- 그렇기 때문에 사이즈를 늘려야만 칼럼 수정이 가능하다.
-- 따라서, MODIFY T3 NUMBER(2,3) 이렇게는 바꿀 수 없다.

DESC TEST_T4;

SELECT*FROM TEST_T4;

-- UPDATE
-- 1. 변경할 칼럼 값 조회해보기

/*
UPDATE 테이블이름
SET 컬럼명 = 값,  컬럼명=값
WHERE 컬럼명 =값
*/
UPDATE TEST_T4
SET T3=30
WHERE T2='박건원' AND T1='1';


SELECT*FROM TEST_T4 ORDER BY T1 ASC;

-- 박주형 27
UPDATE TEST_T4
SET T3=27
WHERE T2='박주형' AND T1=2;

-- 전건희 27
UPDATE TEST_T4
SET T3=27
WHERE  T2='전건희' AND T1=3;

SELECT*FROM TEST_T4 ORDER BY T1 ASC;


-- 박건원 T4 : Y, T5 : SYSDATE
UPDATE TEST_T4
SET T4='Y', T5=SYSDATE
-- SET 은 AND나 OR 가 아니라 구분자가 콤마(,) 이다.
WHERE T1=1 AND T2='박건원';

SELECT*FROM TEST_T4 ORDER BY T1 ASC;

COMMIT;

SELECT*FROM TEST_T4 ORDER BY 1;

-- MAX 값 채번 로직
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '신익현', 26, 'Y', SYSDATE);
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '한지혜', 26, 'Y', SYSDATE);
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '김별', 23, 'Y', SYSDATE);
/*
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '윤요섭',27,'Y',SYSDATE);
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '민경호',27,'Y',SYSDATE);
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '송정흔', 27, 'Y', SYSDATE);
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '박성훈', 27, 'Y', SYSDATE);
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '우한슬',29,'Y',SYSDATE);
INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '황신애',23,'Y',SYSDATE);
*/

/*
명령의 595 행에서 시작하는 중 오류 발생 -

INSERT INTO TEST_T4 (T1,T2,T3,T4,T5) 
VALUES ((SELECT NVL(MAX(T1), 0)+1 FROM  TEST_T4), '황신애',23,'Y',SYSDATE)
오류 보고 -
ORA-00001: 무결성 제약 조건(SCOTT.SYS_C0011058)에 위배됩니다
*/

SELECT*FROM TEST_T4 ORDER BY T1 ASC;
-- 11, '황신애', 23, 'Y', SYSDATE 가 입력되지 않음
/*
1	박건원	30	Y	22/03/15
10	박성훈	27	Y	22/03/15
2	박주형	27	Y	22/03/15
3	전건희	27	Y	22/03/15
4	신익현	26	Y	22/03/15
5	한지혜	26	Y	22/03/15
6	김별	23	Y	22/03/15
7	윤요섭	27	Y	22/03/15
8	민경호	27	Y	22/03/15
9	송정흔	27	Y	22/03/15
*/

SELECT*FROM TEST_T4;

SELECT AVG(T3) FROM TEST_T4;
-- 26.7

SELECT HIREDATE FROM EMP ORDER BY HIREDATE;
SELECT MAX(HIREDATE) FROM EMP;
-- 87/05/23
SELECT MIN(HIREDATE) FROM EMP;
-- 80/12/17

SELECT*FROM EMP WHERE ROWNUM <2;

SELECT AVG(SAL) FROM EMP;
-- 2073.214285714285714285714285714285714286

SELECT AVG(COMM) FROM EMP;
-- 550

SELECT SUM(COMM) FROM EMP;
-- 2200

SELECT SUM(SAL) FROM EMP;
-- 29025

SELECT AVG(SAL)+AVG(COMM) FROM EMP;
-- 2623.214285714285714285714285714285714286

SELECT MAX(SAL) + MAX(COMM) FROM EMP;
-- 6400

-- ROLLBACK

SELECT*FROM TEST_T4;

-- 순서 SELECT로 UPDATE 할 칼럼과 로우 조회
SELECT T4, T5 FROM TEST_T4 WHERE T1='3';

UPDATE TEST_T4
SET T4='N', T5=SYSDATE
WHERE T1=3;

SELECT T4, T5 FROM TEST_T4 WHERE T1='2';

-- 전건희, 한지혜, 신익현 탈퇴 처리
SELECT*FROM TEST_T4;
SELECT T4, T5 FROM TEST_T4 WHERE T1='5' OR T1='4';

UPDATE TEST_T4
SET T4='N', T5=SYSDATE
WHERE T1 IN ('5','4');

SELECT*FROM TEST_T4;

SELECT*FROM TEST_T4 
WHERE T4='Y'
ORDER BY T1 ASC;

SELECT*FROM TEST_T4 
WHERE T4='N'
ORDER BY T1 ASC;

SELECT*FROM TEST_T4 
WHERE T4 LIKE UPPER('%Y%')
ORDER BY T1 ASC;

SELECT*FROM TEST_T4 
WHERE T4 LIKE UPPER('%N%')
ORDER BY T1 ASC;

-- DELETE vs TRUNCATE vs DROP

SELECT*FROM TEST_T2;
/*
1.3	바차2 문자열	22/03/15
27	YUNYOSEOB	22/03/15
		
1.3	바차2 문자열	22/03/15
1.3	1.3	
27	27	
*/

SELECT*FROM TEST_T2 WHERE TC2_1=1.3;
DELETE FROM TEST_T2 WHERE TC2_1=1.3;
-- 1 행 이(가) 삭제되었습니다.
SELECT*FROM TEST_T2;
ROLLBACK;

-- DELETE vs TRUNCATE
SELECT*FROM TEST_T2;
DELETE FROM TEST_T2;
SELECT*FROM TEST_T2;
-- 데이터가 전부 사라짐
ROLLBACK;
SELECT*FROM TEST_T2;
-- ROLLBACK 키워드로 데이터가 다시 복구가 된다.

-- TRUNCATE TABLE TEST_T2;
-- Table TEST_T2이(가) 잘렸습니다.
-- SELECT*FROM TEST_T2;
-- 데이터가 전부 사라진다.
-- ROLLBACK;
-- 롤백 완료.
-- SELECT*FROM TEST_T2;
-- ROLLBACK 명령어로 데이터가 복구가 되지 않는다.
-- TRUNCATE 명령어는 ROLLBACK이 되지 않으므로,
-- 사용을 지양한다. (대형사고 우려)

-- DROP TABLE TEST_T2
-- 테이블 자체를 삭제해 버린다.

-- DELETE : 데이터 삭제 : ROLLBACK 가능
-- TRUNCATE : 데이터 삭제 : ROLLBACK 불가능
-- DROP : 테이블 삭제 : ROLLBACK 불가능

SELECT*FROM TEST_T4;
SELECT*FROM TEST_T4 ORDER BY T1 ASC;