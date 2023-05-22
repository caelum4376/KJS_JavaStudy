--2023-05-18 오라클(DDL) => 170P (table제작, DML(INSERT, UPDATE, DELETE))
/*
    오라클 => 데이터베이스 시스템
              -------------------
              데이터 관리 (데이터 저장) => 메모리에저장하는 구조생성(DDL)
              데이터 제어 => 검색(SELECT), 수정(UPDATE), 삭제(DELETE), 추가(INSERT) (DML)
            
            DDL : 데이터 정의 언어(179p)
                => 데이터를 저장할 공간 (TABLE)
                => 생성
                    TABLE : 데이터 저장 장소
                    VIEW : 가상 테이블
                    INDEX : 검색 속도의 향상
                    SEQUENCE : 자동 증가번호 (PRIMARY KEY)
                    PL/SQL => FUNCTION, PROCEDURE, TRIGGER
                    --------------------------------------
                    명령어 (DDL) => COMMIT을 사용하지 않는다 => 복구를 할 수 없다
                                 => DML(ROW단위), DDL(컬럼단위)
                                 => 데이터베이스 담당자 (DBA)
                        1) CREATE : 생성
                        2) ALTER : 수정, 추가
                        3) DROP : 삭제
                        4) RENAME : 이름변경
                        5) TRUNCATE : 데이터 잘라내기
            => TABLE 생성
                1) 오라클의 데이터형 => 컬럼명 데이터형
                    문자형
                        CHAR(1~2000byte)
                         => 고정 바이트 (글자수 동일 => 남자/여자, y/n)
                         => CHAR(10)
                            --------
                            저장하는 데이터 => 'A'(1byte) => 메모리 10byte
                            => 메모리 누수 현상이 많이 있다
                            => 한글 : 3byte
                        VARCHAR2(1~4000byte) => 오라클에만 있는 데이터형
                                => 데이터베이스 (VARCHAR)
                         => 가변 바이트, 가장 많이 사용되는 문자열
                         => VARCHAR2(10)
                            ------------
                            저장되는 데이터 => 'A'(1byte) => 메모리 1byte
                        CLOB(4기가)
                         => 가변 바이트 => 문자열 저장 => 줄거리, 레시프제작, 자기소개, 회사소개
                        ---------------------------------------------------- 자바 (String)ㅔ
                        ***** 사용형식
                              성별 => sex CHAR(6)
                              이름 => name VARCHAR2(34)
                            줄거리 => story CLOB
                    숫자형
                        NUMBER(38) => int, long, DOUBLE
                        NUMBER(4) => 0~9999
                        NUMBER => default : 8자리
                        NUMBER(7, 2) => 7자리 저장, 소수점으로 2자 사용이 가능
                                        ----------  -------------------
                                            |정수           |실수
                        => 맛집 평점 ===> NUMBER(2, 1)
                        -----------------------------------------------------
                        ***** 사용형식
                              게시판 번호 => board_no NUMBER => SEQUENCE
                              평점        => score NUMBER(2,1)
                              조회수      => hit NUMBER
                                             hit NUMBER DEFAULT 0 => 입력이 없을시 디폴트값 0 설정(초기값)
                    날짜형
                        DATE : default ===> java.util.Date
                        TIMESTAMP : 기록 경주
                        -----------------------------------
                        ***** 사용형식
                              등록일 => regdate DATE => regdate DATE DEFAULT SYSDATE
                    기타형 => 동영상, 사진, 이미지(로고)
                        BLOB => 2진파일
                        BFILE => File형식으로 저장
                        ------------------------------------
                        ***** 사용형식
                              이미지 => image BLOB
                                        image BFILE
                        ------------------------------------
                        ***** 중요시 => 실제 오라클에 저장될떄
                                        TABLE명, 컬럼명 ========> 대문자로 저장이 된다
                        WHERE table_name = 'emp'; => 검색이 안됨
                        WHERE table_name = 'EMP'; => 검색이 가능
                1-1) 테이블명(식별자)
                    1. 같은 데이터베이스(XE)에서 같은 이름의 테이블명을 사용할 수 없다
                        => 현재 생성된 테이블명 확인
                        => DESC table => 데이터형, 컬럼명
                        => SELECT * FROM TAB;
                    2.문자로 시작한다 (알파벳, 한글) => 알파벳 (운영체재 문제)
                        => 알파벳인 경우에 대소문자를 구분하지 않는다
                        => 실제 오라클 저장은 대문자로 저장됨
                    3. 테이블명의 길이는 30자까지 가능(한글 10글자)
                        => 테이블명과 컬럼명이 동일 할 수 있다
                    4. 숫자사용이 가능 (앞에 사용할 수 없다)
                    5. 키워드는 사용할 수 없다 (SELECT, CREATE...)
                    6. 특수문자 사용이 가능 (_) => 2개 이상의 단어가 있는 경우
                2) 정형화된 데이터(프로그램에 필요한 데이터만 추가) => 제약조건
                    => 이상현상 방지 (수정, 삭제)
                    1. NOT NULL : NULL값을 허용하지 않는다
                       name VARCHAR2(34) NOT NULL
                       => *필수 입력 (무조건 입력이 되어야 한다) => 입력이 안된 경우에는 오류발생
                    2. UNIQUE : 유일값 (중복이 없는 값 => null값은 허용)
                       => 후보키(전화번호, 이메일)
                       email VARCHAR2(100) UNIQUE
                    3. PRIMARY KEY => NOT NULL + UNIQUE
                       => 기본키 (모든 테이블은 기본키 한개이상을 가지고 있는 것을 권장)
                            => ROW 구분자
                       => 주로 사용 NUMBER, (게시물 번호, 맛집 번호, 영화 번호)
                          ----------------- 자동증가
                          => 예외 => ID
                    4. FOREIGN KEY : 참조키 (다른 테이블의 실제 값을 참조해서 가지고 온다)
                       => 반드시 PRIMARY KEY를 참조한다
                       => 테이블 <==> 테이블
                       => 영화 == 리뷰
                          영화 == 예매 (영화번호)
                          JOIN ==> ustid, bookid
                       => emp : deptno, dept : deptno
                                ------         ------
                                   |             |
                             Foreign key      primary key
                        reply_no NUMBER FOREIGN KEY
                        REFERENCES board(board_no)
                        => 삭제할 떄
                           참조하고 있는 데이터를 삭제 => 참조된 데이터 삭제
                        => ON DELETE CASCADF ==> 시스템점검 
                    5.CHECK : 저장된 데이터값만 테이블에 저장
                        => ComboBox, 라디오, 체크
                        => 부서명 => 개발부, 영업부, 총무부, 기획부 => 자재부
                        => 카테고리, 메뉴
                    6. 제약조건이 아니다
                        => 디폴트 값을 지정 => DEFAULT
                        => regdate DATE DEFAULT SYSDATE
                           int NUMBER DEFAULT
                3) 형식
                    CREATE TABLE table_name(
                         컬럼명 데이터형 [제약조건], ===> 여러개 사용 가능
                         컬럼명 데이터형 [제약조건],
                         컬럼명 데이터형 [제약조건] ==> 컬럼레벨 (NOT NULL, DEFAULT)
                         ...
                         [제약조건], ===> 테이블레벨 =>  보통 마지막에 생성
                         [제약조건]                     (FOREIGN, PRIMARY, CHECK, UNIQUE)
                    )
                ---------------------------- 권장 -----> 제약조건의 이름을 부여 => 제약조건만 변경
                    약식
                    CREATE TABLE table_name(
                        컬럼명 데이터형 PRIMARY KEY,
                        컬럼명 데이터형 NOT NULL
                    )
                ----------------------------- 제약조건 변경시에 테이블을 삭제후 다시 제작
                4) 데이터베이스 (XE => 모든 테이블을 제작)
                    => 같은 이름의 테이블을 생성하면 안된다(유일값)
                    => 테이블안에서 같은 테이블을 만들 수 없다

*/