-- 2023-05-19 3장 정리
/*
    SQL
    ---
     DQL : SELECT (데이터를 검색)
     ---------------------------------------------- 단위 ROW
     DDL : 데이터 정의언어
        = CREATE(생성 => 데이터 저장공간) 
        = ALTER(ADD, MODIFY, DROP, RENAME) => 수정
        = DROP : 삭제
        = RENAME : 이름변경
        = TRUNCATE : 데이터 잘라내기
     ----------------------------------------------- 단위 COLUMN
     SELECT 문장 (데이터의 변경사항은 없다, 데이터 검색) => 저장(COMMIT), 취소(ROLLBACK)이 없다

     문자열 처리
     -----------
        = 문자열 결합 : || => SELECT ename||job ~
        = 별칭 (내장함수 이용) => SELECT MAX(sal) "최대값" ~~
        = 중복없는 데이터 => SELECT DISTINCT deptno ~~
                                    --------------- 다른 컬럼이 있는 경우에는 적용이 안된다
        = 문자, 날짜는 반드시 ''를 이용한다
                ----예약일
          String sql = "SELECT * FROM emp WHERE ename = 'KING'";
          String ename = "KING";
          String name = "홍길동";
          String sex = "남자";
          String addr = "서울";
          int age = 25;
          String sql = "INSERT INTO member VALUES(''' + name + "','" + sex + "','" + addr + "','" + age + "'");
        --------------------------------------------------------------------------------------------------------
        = 오라클에서는 명령문이 종료하면 ;을 사용
          자바에서는 ;을 사용하지 않는다
        = 오라클에서는 DML을 사용하면 COMMIT, DDL => 자동저장
          자바에서는 AUTOCOMMIT을 사용한다 ===> ROLLBACK (트랜잭션프로그램)
     1) 형식 => 순서
        SELECT *(전체데이터) | column_list(필요한 데이터)
        FROM (table_name|view_name|SELECT~)
        ------------------------------------------------- 필수조건
        [
            WHERE 조건문 (컬럼|함수 연산자 값)
                                    ------
            GROUP BY 그룹컬럼명|함수 --------------- 그룹별로 따로 처리 (부서별, 입사년도별, 직위)
            HAVING 그룹컬럼|함수 ---------- GROUP BY가 있는 경우에만 사용이 가능
                                            단독사용이 불가능
            ORDER BY  컬럼|함수:숫자(ASC|DESC)
                                     --- 생략이 가능
            => 이중 정렬 => ,로 구분 => 단답형 게시판, 대대글...
        ]
        ========> ORDER BY는 권장하지 않는다 => INDEX를 권장한다
                  INDEX_ASC(), INDEX_DESC()
        ========> SELECT은 웹에서 70%
     2) 조건 검색 => 연산자
        = 산술연산자 (+,-,*,/) => ROW단위 통계 (함수로 지원하지 않는다)
                                  필요하면 사용자 정의로 제작 (FUNCTION)
          '10'+1 ==> TO_NUMBER('10')+1 => 11 (자동 변환이 된다)
                     --------------- 권장하지 않는다
          'A'+1 ==> 오류발생 ==> ASCII('A')+1 ==> 66
          ----- 'A'||1 => A1
          ----- 무조건 산술처리만 가능하다
          / => 0으로 나누면 오류발생, 정수/정수 = 실수
          SUM, AVG => COLUMN  
          SELECT뒤에서 처리
        = 비교연산자 : =, <>(!=, ^=), <, >, <=, >=   ====> (true/false) => WHERE 뒤에
        = 논리연산자
        = 데이터베이스 연산자
          NULL처리 => IS NULL, IS NOT NULL
          => 조건이 NULL이면 전체데이터를 읽어온다 : NVL()이용
          => 데이터값이 NULL값일때 브라우저에서는 NULL출력을 한다
          NOT => 부정 연산자
                NOT IN(), NOT BETWEEN(예약일이 아닌), NOT LIKE
          LIKE => 포함문자, 시작문자, 끝문자... 글자수...
                  % => 문자의 갯수가 지정이 안된 상태
                  _ => 한글자
                  => A로 시작 ==> 'A%' ==> 서제스트(자동완성기)
                                           ------------------- 메인페이지 검색기
                  => A로 끝 ==> '%A'
                  => A가 포함 ==> '%A%' ==> 가장많이 사용
                    => 최근 => REGEXP_LIKE() (정규함수식)
                  => 3번쨰가 A ==> '__A%'
          IN => OR가 여러개 => 다중조건 (체크박스) => 동적쿼리 (MyBATIS, JPA)
          BETWEEN ~ AND : 기간, 범위 => AND <=
                          이하/이상
     3) 오라클에서 지원하는 함수
        단일행 함수 => ROW단위 처리
            = 문자관련
                LENGTH() : 문자의 갯수 => LENGTH('aaa') = 3, LENGTH('홍길동') = 3
                SUBSTR() : 문자열을 자르는경우
                            => SUBSTR(문자열, 문자시작위치, 갯수) => 오라클은 문자시작번호가 1이다
                            => SUBSTR('123456789', 3, 2) ==> 34
                INSTR() : 문자의 위치번호
                            => INSTR(문자열, 찾는문자, 시작위치, 몇번째위치)
                            => INSTR('Hello', 'l' 1, 2) ==> 4
                RPAD() : 문자의 갯수가 모자라는 경우에 다른 문장으로 대체
                            => RPAD(문자열, 출력한문자 갯수, 대체할 문자)
                            => RPAD('admin', 10, '*')
                                             --- => admin*****
                            => RPAD('admin', 3, '*')
                                             -- => adm
            = 숫자관련ㅐ
                ROUND() : 반올림 => ROUND(실수, 자리수)
                                    ROUDN(75.678, 2) ==> 75.68
                TRUNC() : 버림 => TRUNC(실수, 자리수)
                                  TRUNC(75.678, 2) ==> 75.67
                CEIL() : 올림 => CEIL(실수)
                                 CEIL(75.68) ==> 76 ==> 총페이지 나누기
                                 ***SELECT CEIL(COUNT(*)/10.0) FROM BOARD
                                 사이트의 핵심은 사용자 편의 => 이미지(15), 테이블(10~15) => ***페이지 나누기(기법)
                MOD() : 나머지 => MOD(10,2) => 10%2
            = 날짜관련
                SYSDATE : 시스템의 시간을 읽어 온다
                MONTHS_BETWEEN : 기간의 개월수 => 호봉/퇴직금
                MONTHS_BETWEEN(현재, 과거) => MONTHS_BETWEEN(SYSDATE, HIREDATE)
            = 변환
                TO_CHAR : 문자열 변환
                -------
                    SimpleDateFormat => 날짜 변환
                    TO_CHAR(HIREDATE, 'YYYY-MM-DD')
                                       ---------- 패턴
                                       년도 : YY/YYYY RR/RRRR
                                       월 : MM 일 : DD
                                       시간 : HH/HH24
                                       분 : MI
                                       초 : SS
                    DecimalFormat => 숫자 변환
                        TO_CHAR(10000, '999,999')
                                => TO_CHAR(10000, '$999,999')
                                => TO_CHAR(10000, 'L999,999')
                        TO_CHAR(SYSDATE, 'YYYY년도 MM월 DD일') ==> 오류
                        TO_CHAR(SYSTATE, 'YYYY"년도" MM"월" DD"일"')
            = 기타
                NVL : NULL값을 대체
                    => NVL(값, 대체값)
                           --  ------ 데이터형이 동일해야 된다
                    => NVL(comm, '없음') => 오류
                           ---- NUMBER
                       NVL(TO_CHAR(comm, '없음')
                DECODE, CASE => PL/SQL(FUNCTION, PROCEDURE, TRIGGER)
        집계함수 => Column단위 처리
            SUM => 총합 => SUM(컬럼) => SUM(sal)
            AVG => 평균 => AVG(컬럼)
            MAX => 최대값 => MAX(컬럼)
            COUNT => ROW의 갯수 => COUNT(컬럼), COUNT(*) => NULL값을 포함
                                   ------NULL값을 제외
            CUBE / ROLLUP => 통계 (GROUP BY에서 주로 사용)
            RANK() =======> RANK() OVER(ORDER BY 컬럼 ASC|DESC)
                1 2 2 4
            DENSE_RANK() => DENSE_RANK() OVER(ORDER BY 컬럼 ASC|DESC)
                1 2 2 3

            GROUP BY => 그룹으로 묶어서 따로 처리하는 명령어
            => GROUP BY 컬럼 / 함수
            => 이중 GROUP BY deptno, job
                             ------ 부서별로 나눠서 처리
                                    ------ 직위별로 다시 나눠서 처리
            조건 : HAVING 그룹함수
            => 집계함수와 컬럼명은 동시에 사용할 수 없다 => GROUP BY를 이용하면 가능
                SELECT SUM(sal), ename, job
                FROM emp ====> 오류
                SELECT job, SUM(sal)
                FROM emp
                GROUP BY job
            => 집계함수와 단일행 함수는 동시에 사용이 불가능 => GROUP BY를 이용하면 가능
                SELECT SUM(sal), SUBSTR()
                FROM emp ==> 오류
                SELECT SUBSTR(), SUM(sal)
                FROM emp
                GROUP BY SUBSTR()
                

     4) 다른 테이블 연결 => 정규화 : 조인, 서브쿼리
        JOIN => SELECT문장에서만 사용이 가능
        ---- 두개 이상의 텓이블을 연결해서 필요한 데이터 추출
        = SELECT 컬럼대신 ------- 스칼라 서브쿼리 (JOIN을 대체)
        = FROM 테이블대신 사용--- 인라인뷰 => 보안, 페이지나누기
        = WHERE 문장 조건값------ 서브쿼리
        조인종류
            INNER JOIN (INTERSECT => 교집합) => NULL일 경우 처리하지 않는다
                        => 연산자 (=, BETWEEN, 논리연산자) => 같은 값, 포함
                => EQUI_JOIN (동등조인) ==> 연산자(=)
                => NON_EQUI_JOIN (비동등조인) ==> =외의 다른 연산자
                => NATURAL JOIN => SQL문장이 간결 => 같은 컬럼을 가지고 있다
                => JOIN ~ USING => SQL문장이 간결 => 같은 컬럼을 가지고 있다
                => 형식
                    오라클 조인 (오라클, MySQL)
                        SELECT A.a, A.b, B.b B.c
                        FROM A, B
                        WHERE A.b = B.b;
                        SELECT aa.a, aa.b, bb.b bb.c ==> 컬럼마다(테이블명,별칭명으로 구분 => 컬럼명이 다른)
                        FROM A aa, B bb => 테이블의 별칭
                        WHERE aa.b = bb.b;
                    ANSI 조인 => 표준화
                        SELECT A.a, A.b, B.b B.c
                        FROM A (INNER)JOIN B
                        ON A.b = B.b;
                    NATURAL JOIN
                        SELECT a, b, C
                        FROM A NATURAL JOIN B => 구분할 수 없다
                    JOIN ~ USING
                        SELECT a, b, C
                        FROM A JOIN B USING(b)
                    *** 조인시 반드시 컬럼명이 같은 것은 아니다
                        ==> 같은 값을 가지고 있는 컬럼이 있는 경우에 처리가 가능
                        WHERE mgr = empno
                        WHERE no = bno
            OUTER JOIN  => INNER JOIN은 NULL값인 경우, 값이 없는 경우 처리 불가능
                            => 보완
                            => INTERSECT + MINUS
                형식)
                    LEFT OUTER JOIN
                    = SELECT A.a, A.b B.c
                      FROM A, B
                      WHERE A.a = B.a(+)
                    = SELECT A.a, A.b B.c
                      FROM A LEFT OUTER JOIN B
                      ON A.a = B.a
                    RIGHT OUTER JOIN
                    = SELECT A.a, A.b B.c
                      FROM A, B
                      WHERE A.a(+) = B.a
                    = SELECT A.a, A.b B.c
                      FROM A RIGHT OUTER JOIN B
                      ON A.a = B.a
        ------------------------------------------ 조인 (조인은 데이터값을 결합)
        SQL문장을 연결해서 => 한번에 수행이 가능하게 만든다 : 서브쿼리
        = 서브쿼리의 종류
            ------------------------------------------
            1) 단일행 서브쿼리 : 컬럼1, 결과값1 => 받아서 처리
            2) 다중행 서브쿼리 : 컬럼1, 결과값 여러개 => 10, 20, 30
                                        -------------
                                        전체수행 IN(10,20,30)
                                        한개를 선택 => 최대값(30),최소값(10)
                                        DEPTNO > ANY(10,20,30) => 최소값(10)
                                            => deptno > 10
                                            deptno > any(select distinct deptno from emp)
                                            => deptno > (select min(deptno) from emp)
                                        DEPTNO < ANY(10,20,30) => 최대값(30)
                                            => deptno < 30
                                        DEPTNO > ALL(10,20,30) => 최대값(30)
                                            => deptno > 30
                                        DEPTNO < ALL(10,20,30) => 최소값(10)
                                            => detpno < 10
            ------------------------------------------ WHERE 뒤에
            3) 스칼라 서브쿼리 => SELECT뒤에
            4) 인라뷰 => FROM뒤에 => ROWNUM
            ------------------------------------------ 5장 (고급쿼리)
            SELECT - --> 메인쿼리
            FROM table_name
            WHERE 컬럼 = (SELECT ~)
                          서브쿼리(1, 여러개)
            서브쿼리에서 결과값을 받아서 메인쿼리로 전송해서 실행하는 방식
                장점 : 다른 테이블 연결이 가능, DML전체에서 사용이 가능
                        JOIN보다 처리 속도가 빠르다(권장)
                단점 : SQL문장이 길어진다
                => 퍼포먼스가 좋다, 가독성이 약하다
            ------------------------------------------------- 기본 쿼리
            필요한 데이터를 저장한 후에 처리 => 데이터를 저장하기 위해서는 저장공간이 필요 => 테이블
            DDL => 데이터 정의언어 ===> COMMIT 없이 자동 저장, 복구할 수 없다 => 백업
            ---
              = CREATE : 생성
                => table, view, index, sequence, function, procedure, trigger
                =>        ------------------------------------------- 권환이 없다 (사용자 계정)
                           사용자 계정 : HR, 관리자 계정 : system, sysdba
                형식)
                    CREATE TABLE table_name(
                        컬럼명 데이터형[제약조건(여러개 사용이 가능)],
                            => 컬럼생성과 동시에 제약조건이 생성 => 컬럼레벨
                            => NOT NULL, DEFAULT
                        컬럼명 데이터형[제약조건(여러개 사용이 가능)],
                        컬럼명 데이터형[제약조건(여러개 사용이 가능)],
                        [제약조건], ==> 테이블생성이 종료 후 생성 => 테이블레벨
                            => KEY종류
                            => PRIMARY KEY : 유일값 (NULL값을 허용하지 않는다)
                            => CHECK : 지정된 데이터만 출력
                            => FOREIGN KEY : 다른 테이블의 값을 참조 => 조인
                            => UNIQUE : 후보키 지정 => 유일값 (NULL값을 포함)
                        [제약조건] 
                            1. PRIMARY KEY는 기본키 (테이블에는 기본키 한개 이상 첨부가 가능)
                               ------------ ROW구분자 (중복이 없다)
                            2. PRIMARY KEY (empno, ename)
                                => 1, A
                                => 2, B
                                => 2, A
                            => 이상현상을 방지 (무결성) => 수정, 삭제(원하지 않는 데이터삭제 방지)
                    )

                1) NOT NULL
                    컬럼명 데이터형 CONSTRAINT 테이블명_컬럼명_nn NOT NULL
                                               ------------------- 중복없이 사용
                                                    |
                                                권장 => 제약조건은 변경, 삭제
                            => ALTER TABLE table_name DROP CONSTRAINT 테이블명_컬럼명_nn;
                    컬럼명 데이터형 NOT NULL => DROP후에 다시 테이블 제작
                2) UNIQUE => 전화(인증), 이메일
                             ID찾기, 비밀번호 찾기 => 이메일 전송(JMail)
                    CONSTRAINT 테이블명_컬럼명_uk UNIQUE(컬럼명)
                3) PRIMARY KEY => 중복체크, 자동증가(숫자)
                    CONSTRAINT 테이블명_컬럼명_pk PRIMARY KEY(컬럼명)
                4) FOREIGN KEY
                    CONSTRAINT 테이블명_컬럼명_fk FOREIGN KEY(컬럼명)
                    REFERENCES 참조테이블(참조컬럼)
                5) CHECK => 라디오버튼, 콤보박스
                    CONSTRAINT 테이블명_컬럼명_ck CHECK(컬럼명 IN('A','B','C'...))
                6) DEFAULT
                    컬럼명 데이터형 DEFAULT 값 ==> 날짜 (SYSDATE)
            ---------------------------------- 테이블에 값이 있는 경우
              = ALTER : 변경
                => 컬럼을 추가
                    ALTER TABLE table_name ADD 컬럼명 데이터형 [제약조건]
                => 컬럼을 삭제
                    ALTER TABLE table_name DROP COLUMN 컬럼명
                => 데이터 변경
                    ALTER TABLE table_name MODIFY 컬럼명 데이터형 [제약조건]
                => 제약조건 추가
                    ALTER TABLE table_name ADD 컬럼명 데이터형 CONSTRAINT cons_name_pk,fk,uk,ck
                    ALTER TABLE table_name MODIFY 컬럼명 데이터형 CONSTRAINT cons_name_nn
                => 제약조건 삭제
                    ALTER TABLE table_name DROP CONSTRAINT cons_name
                => 제약조건명 변경
                    ALTER TABLE table_name RENAME CONSTRAINT old_name TO new_name
                => 컬럼명 변경
                    ALTER TABLE table_name RENAME COLUMN old_name TO new_name
                => 제약조건 확인
                    SELECT *
                    FROM user_constraints
                    WHERE table_name = '대문자 테이블명'
                    => user_constraints, user_tables, user_views...
              = DROP : 삭제 (완전삭제 => 테이블+테이블)
                DROP TABLE table_name
              = RENAME : 이름변경 => 시노님(별칭) => 전역
                RENAME old_name TO new_name
              = TRUNCATE : 데이터 잘라내기 (데이터만 삭제 => 테이블은 존재)
                TRUNCATE TABLE table_name
                ------------------------------------ROLLBACK을 사용해서 복구할 수 없다
                => 145page : SELECT형식
                => 149page : 연산자 종류
                => 157page : GROUP BY => 집계함수
                => 161page : GROUP BY 주의점 => 컬럼명과 집계함수가 동시에 사용할 수 없다
                             SELECT문장의 순서, 실행순서
                   SELECT ----- 5
                   FROM ------- 1
                   WHERE ------ 2
                   GROUP BY --- 3
                   HAVING ----- 4
                   ORDER BY --- 6
                => 162page : 조인 ==> 169page의 조인형식
                => 170page : 서브쿼리 => 173page확인 (서브쿼리 실행순서)
                => 179pgae : DDL
                    CREATE형식, 순서
                => 180page : 문자데이터형
                => 183page : 오라클 데이터형
                => 184page ~ 185page : ALTER => ADD, MODIFY, DROP
                => 186page : DROP
            --------------------------------------------------------------------------------
            DML : 데이터 조작하는 언어
                => 형식이 한개씩 있다
                INSERT(데이터추가) / UPDATE(데이터수정) / DELETE(데이터삭제)
                => 회원가입             회원수정            회원탈퇴
                => 단위가 ROW단위 (한줄추가, 한줄삭제)
*/