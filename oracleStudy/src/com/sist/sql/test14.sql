--2023-05-19 DML => 데이터 조작언어
/*
    187p => INSERT / UPDATE / DELETE
    1) INSERT : 데이터추가
        = INSERT ALL
            => 데이터를 나눠서 저장할때 사용하는 방법
        = INSERT : 전체 컬럼값을 등록할때
            => INSERT INTO table_name(*이 생략) VALUES(...)
            => DEFAULT가 있는 경우에도 값을 설정
        = INSERT : 필요한 데이텀나 등록
            => INSERT INTO table_name(컬럼명.컬럼명...) VALUE(지정된 컬럼만...)
            => NOT NULL이 있는 경우에는 반드시 첨부
                CHECK, FOREIGN, PRIMARY => 반드시 첨부
            => 생략 => DEFAULT의 경우
    2) UPDATE : 데이터를 수정
        UPDATE table_name SET
        컬럼명 = 값, 컬럼명 = 값...
        [WHERE 조건] ************** 반드시 사용 (조건이 없는 경우는 전체 데이터 변경)
        => 확인 => 저장/취소 => COMMIT/ROLLBACK 사용
                                -------------------- 자바에서는 자동으로 수행
                                try ===> COMMIT
                                catch ===> ROLLBACK
    3) DELETE : 데이터를 삭제 ===> ROW단위 삭제
        DELETE FROM table_name
        [WHERE 조건] =====> 반드시 사용(조건이 없는 경우 전체 데이터 삭제)
*/
-- 테이블 복사
CREATE TABLE emp_10
AS
  SELECT * FROM emp WHERE deptno = 10;