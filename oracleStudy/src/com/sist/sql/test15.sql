--2023-05-22
/*
    1) DDL : SELECT ==> 데이터 검색
             ------
    2) DML : INSERT, UPDATE, DELETE
             ----------------------
            데이터추가, 수정, 삭제
    -------------------------------- 웹개발자가 주로 사용하는 명령어
    3) DDL : CREATE, ALTER, DROP, RENAME, TRUNCATE
    ------------------------ DBA가 주로 사용하는 언어
        CREATE : 생성
            = TABLE = 저장장소 (데이터별로 구분)
                                ---------------- 컬럼
            = VIEW : 가상테이블 (기존의 테이블을 참조)
                     데이터가 메모리에 저장이 안됨
                     (보안, 재사용, SQL문장을 단순화)]
            = SEQUENCE : 자동 증가
            = INDEX : 검색속도 최적화
            = PL/SQL => 함수, 자동 이벤트
                함수 : 리턴형을 가지고 있다
                내장함수  / 사용자 정의 함수
                프로시저 : 리턴형이 없는 함수 => 기능 수행****
                트리거
            = DROP : CREATE로 만든 모든 것은 DROP으로 삭제한다
            = RENAME : 이름 변경
            = TRUNCATE : 데이터 잘라내기
            = ALTER : 수정(MODIFY), 삭제(DROP COLUMN), 추가(ADD) => 컬럼, 제약조건
    4) TCL : COMMIT, ROLLBACK
             COMMIT : 정상수행 => 저장 
             ROLLBACK : 비정상수행 => 취소
             트랜잭션 => 일괄처리
    5) DCL : GRANT, REVOKE
             ----- 권한부여 (hr => 사용자계정, VIEW, SEQUENCE, PL/SQL => 권한이 없다)
             권한 계정 : system / sysdba
             REVOKE : 권한 해제
        => 생성 : TABLE
           ------------ 정형화된 데이터를 저장
                        --------------- 프로그램에 필요한 데이터만 저장
            => 제약조건
                1) NOT NULL => 입력값이 반드시 필요
                2) UNIQUE => 중복이 없는 값 (NULL허용)
                   ------ 후보키
                3) 1 + 2 => NOT NULL + UNIQUE => PRIMARY KEY
                   PRIMARY KEY => 기본키 (테이블마다 한개이상 존재 권장)
                   => ROW단위로 제어할 수 있다
                   => ROW는 한줄 => 한개에 대한 정보 => ~VO
                      ---------- 인스턴스
                   => COLUMN => 멤버변수
                   => 이상현상을 방지, 무결성 원칙
                      -------- (수정, 삭제)
                4) 참조키 : 다른 테이블의 데이터를 참조
                    => FOREIGN KEY
                    => FOREIGN는 다른 테이블의 PRIMARY KEY참조
                5) CHECK => 미리 데이터를 설정 => 설정된 데이터만 첨부
                6) DEFAULT => 사용자가 입력이 없는 경우
                              미리 값을 설정한다
                           => 명시적 초기화
        1. SELECT => 데이터 검색 (웹사이트, 프로젝트 => 70%)
            형식)
                SELECT [DISTINCT] *|column_list
                FROM table_name|view_name|(SELECT~)
                                           ------- 인라인뷰
                [
                    WHERE 조건절
                    -------------------------
                    GROUP BY 그룹컬럼|함수
                    HAVING 그룹조건
                    ------------------------- * HAVING은 GROUP BY가 있는 경우에만 사용이 가능
                    ORDER BY 컬럼|함수 (ASC|DESC) => 정렬
                    ------------------ 인덱스 사용을 권장
                                       INDEX_ASC, INNDEX_DESC 
                ]       


*/