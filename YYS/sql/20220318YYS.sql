--2022-03-18

SELECT*FROM TEST_T4 ORDER BY T1 ASC;

/*
ISUD 할 때 주의 사항

================JAVA============================

 SELECT :  PreparedStatement  : excuteQuery() 메서드를 사용한다.
 
 INSERT : PreparedStatement : excuteUpdate() 메서드를 사용한다.
 
==========================================================
 INSERT INTO TEST_T4 (T1, T2, T3, T4, T5) VALUES ( ?, ?, ?, 'Y', SYSDATE)";
 -- 반드시 Y를 입력하고, SYSDATE로 언제 삽입되었는지 기록 해주어야만 한다.
 ==========================================================
 
 UPDATE : PreparedStatement : excuteUpdate() 메서드를 사용한다.
 
 ==========================================================
 UPDATE TEST_T4 SET T2 = ?, T5 = SYSDATE WHERE T4 = 'Y' AND T1 = ? 
 ==========================================================
 
 -- UPDATE할 때, 현재 날짜를 반드시 입력한다.
 -- 반드시  WHERE 절에서 Y인지 확인하고,  PK가 맞는지 확인한다.
 
 DELETE :  PreparedStatement : excuteUpdate() 메서드를 사용한다.
 -- 그러나 DELETE TABLE 테이블이름 WHERE 조건; 을 쓰지 않는다.
 
 ==========================================================
 -- UPDATE TEST_T4 SET T4 = 'N', T5 = SYSDATE WHERE T4 = 'Y' AND T1 = ? 
 ==========================================================
 
 -- UPDATE로 쓴다,  WHERE 절에  특정 컬럼의 'Y'와 PK 조건을 확인하고
 -- 특정 컬럼을 'N'으로 수정해서 DELETE라고 처리한다.
 
 =================================================

*/

DESC TEST_T4;
SELECT*FROM TEST_T4;

SELECT NVL(MAX(SUBSTR(A.T1, -4)), 0)+1 AS COMM_NUM FROM TEST_T4 A;

CREATE TABLE TEST_T6(
    T1  VARCHAR2(20) PRIMARY KEY,
    T2 VARCHAR2(20) NOT NULL,
    T3  NUMBER(3),
    T4 VARCHAR2(1) NOT NULL,
    T5 DATE,
    T6 DATE
);

DESC TEST_T6;
