-- 2023-05-15 오라클 정리 (SELECT, 연산자, 함수정리)
/*
    SQL문장 => 형식 (문법사항)
    ---
    DQL : SELECT(데이터를 추출) => 검색, 목록, 상세보기
    => SELECT
        1) 형식
            column => 데이터를 구분 (파일 => |,)
            ---------------------------------------------------------------
            SELECT *(저장된 전체데이터 읽기) | column_list(원하는 목록만 출력)
            FROM table명 (table은 전체 데이터를 저장한 장소 => column별로 구분됨)
            --------------------------------------------------------------- 필수 조건
            [
                WHERE 조건문 (컬럼명|함수명 연산자 값)
                GROUP BY 그룹컬럼명|함수명
                HAVING 그룹조건
                ORDER BY 컬럼|함수명 (ASC|DESC) => 올림/내림 => 정렬
            ]
            WHERE - ORDER BY (ORDER BY - WHERE - 오류)
            WHERE - GROUP BY
            GROUP BY - ORDER BY
            =>
                SELECT =========> 5
                FROM =========> 1
                WHERE =========> 2
                GROUP BY =========> 3
                HAVING =========> 4
                ORDER BY =========> 6
        2) 연산자
            = 산술연산자 => 산술처리 (문자열 결합은 하지 않는다 => ||)
            + - * / => 'A'+1 (오류) => ASCII('A')+1 ==> 66
            '10'+10 => 20 => TO_NUMBER('10')+10
             -- 정수형으로 변경후에 연산
             -- 자동 형변환은 존재, 강제 형변환은 없다(int)(X)
             -- 실수 => 정수 : ROUND(), CEIL(), TRUNC()
             -- / => 0으로 나눌 수 없다. 정수/정수 => 실수
             -- 주로 사용되는 위치 : SELECT뒤에서 사용
                -------------- 통계 (Column단위 통계가 존재, ROW단위는 존재하지 않는다)
            --------------------------------------
                name    kor     eng     math
            --------------------------------------
                홍길동    80      80       80
            --------------------------------------
                심청이    90      90       90
            --------------------------------------
                        170     170      170 => SUM(kor)
                         85      85       85 => AVG(kor) => 집계함수
            = 비교연산자
                = (같다), <>, ^=, != (같지 않다) => 권장(<>)
                = <, >, <=, >=
                = 문자열이나 날짜까지 적용이 된다 hiredate >= '81/01/01'
                = 날짜형은 문자열 형식으로 저장되어 있다 -- 'YY/MM/DD'
            = 논리연산자 : AND, OR
                AND = 기간, 범위포함시에 주로 사용
                OR = 범위나 기간을 벗어날 경우에 주로 사용
                *** &&(입력기호), ||(문자열 결합)
            = 데이터베이스에서만 사용되는 연산자
                NOT : 부정연산자(!) => !를 사용하지 않는다
                NULL : 연산시에 NULL값인 경우에는 결과값이 NULL(연산처리가 안된다)
                    IS NULL, IS NOT NULL
                IN : OR가 여러개일 경우에 사용
                BETWEEN ~ AND : 기간이 범위를 출력할때
                LIKE : 검색
                    % => 글자수와 관련없음
                    _ => 한글자
                    '문자%' => startsWith
                    '%문자' => endsWitd
                    '%문자%' => contains
        3) 내장함수 (FUNCTION => 리턴형을 가지고 있다)
            오라클에서 지원하는 함수 / 사용자 정의 함수
            = 함수 (리턴형을 가지고 있다) => FUNCTION
              CREATE FUNCTION function_name() RETURN VARCHAR2 (내장함수)
            = 프로시저 (리턴형이 없는 함수) => PROCEDURE
              CREATE PROCEDURE proc_name (매개변수 목록)
            = 내장함수는 주로 사용처 => SELECT뒤, WHERE뒤, GROUP BY, ORDER BY뒤...
            --------------------------------------- PL/SQL
            내장함수의 종류(암기)
            = 단일행 (ROW단위처리) 함수
              1. 문자함수
                - LENGTH() => 문자갯수
                LENGTH('Oracle') ==> 6 ==> 비밀번호
                ---------------------------------
                - UPPER => 대문자변환
                UPPER(문자열) => UPPER('oracle') ==> ORACLE
                - LOWER => 소문자변환
                LOWER(문자열) => LOWER('ORACLE') ==> oracle
                - INITCAP => 이니셜 변환
                INITCAP(문자열) => INITCAP('oracle') => Oracle
                SELECT ENAME
                FROM EMP
                WHERE UPPER(ENAME) LIKE '%UPPER('')%'
                ----------- 항상 프로그램은 사용자 중심 (대문자, 소문자..)
                --------------------------------- 명령문은 대소문자를 구분하지 않는다
                                                  실제 저장된 데이터는 대소문자 구분
                => 오라클 SQL로 제작, 자바 라이브러리로 처리
                                   ---------------- 웹개발자 자바로 코딩
                => 웹개발자 : 오라클자체가 아니라 자바에서 사용되는 오라클

                - SUBSTR : 문자열을 자르는 경우 => subString()
                  *** 자바는 문자번호 0번부터 시작 / 오라클은 1번부터 시작
                  SUBSTR(문자열, 시작번호, 갯수)
                  ORACLE       ORACLE
                  012345(자바)  123456(오라클)
                  substring(1,3) => 1,2 => RA
                  substr('ORACLE',1,2) => OR ==> 날짜, 주소, 우편번호
                - INSTR : 요청한 문자의 번호
                  indexOf => 앞에서부터 찾기
                  lastIndexOf => 뒤에서부터 찾기
                  INSTR(문자열, 찾는문자, 시작위치)
                  INSTR('Hello','l',1,2) => 1앞에서부터, -1뒤에서부터

                  H E L L O
                  1 2 3 4 5
                 -5-4-3-2-1
                - TRIM : 특정문자 제거 (공백 포함)
                  LTRIM => 왼쪽만 제거
                  LTRIM(문자열, 제거할문자) => LTRIM('AAABBBAAA','A') => BBBAAA
                  **LTRIM(문자열) => 공백을 제거
                  RTRIM => 오른쪽만 제거
                  TRIM => 좌우제거
                  TRIM(제거할문자 FROM 문자열)
                    => TRIM('A' FROM 'ABCDA') ==> BCD
                - LPAD, RPAD : 글자수에 맞게 특수문자를 출력
                  LPAD(문자열, 출력할 글자수, 문자)
                  LPAD('Admin', 10, '#') ==> #####Admin
                  LPAD('Admin', 3, '#') ==> Adm
                  RPAD('Admin', 10, '#') ==> Admin#####
                  RPAD('Admin', 3, '#') ==> Adm
                - REPLACE : 문자변경
                  REPLACE(문자열, 문자, 변경할문자)
                  REPLACE('Hello', 'l', 'o') ==> Heooo
                - CONCAT => ||
                  ASCII('A') => 65
              2. 숫자함수 : NUMBER => 정수/실수 = 숫자
                - ROUND : 반올림함수 => ROUND(숫자(실수), 숫자(자리수))
                  ROUND(75.89, 1) => 75.9
                  ROUND(75.89, 0) => 76.0
                - CEIL : 올림함수 => CEIL(숫자) => CEIL(75.0) = 75, CEIL(75.1) = 76
                        => 총페이지 구하기
                  SELECT CEIL(COUNT(*)/10.0) FROM EMP
                              -------- 14/10.0 => 1.4 => 2
                - TRUNC(숫자, 자리수) => 버림함수 => TRUNC(75.5) => 75
                - MOD : 나머지 % => MOD(10,2) => 10%2
              3. 날짜함수
                  SYSDATE : 시스템 날짜 읽기
                    => 숫자형(산술연산 가능) => new
                  MONTHS_BETWEEN : 기간의 개월수 읽기
                    => MONTHS_BETWEEN(현재날짜, 과거날짜)
                    => MONTHS_BETWEEN(SYSDATE, '23/01/01') => 날짜를 문자열 표현
                                                'YY/MM/DD' 예약일 증록, 매출
              4. 변환함수
                  TO_CHAR ==> 날짜 변환, 숫자 변환
                              ---------
                              YYYY / YY, MM / M, DD / D, HR24 / MI / SS
              5. 기타함수
                  NVL : NULL값인 경우에 다른 값을 변경해서 사용하는 함수
                  => 웹에서 한번도 안빠지는 경우
                  => NULL일 경우 에러발생
                  => NVL(컬럼(숫자,문자), 대체값)
                                          ------ 데이터형 일치
                  DECODE : switch
                  CASE : 다중if
                    CASE
                    WHEN DEPTNO = 10 THEN '개발부'
                    WHEN DEPTNO = 20 THEN '영업부'
            = 집합함수 (COLUMN단위 처리) 함수
              => 컬럼명이나 단일행 함수를 같이 사용할 수 없다
              => 컬럼명이나 단일행 함수를 동시에 사용하려면 반드시 GROUP BY를 사용한다
              => 최대값(전체대상) : MAX(컬럼명)
                 최소값 : MIN(컬럼명)
                 SUM(컬럼명) => 총합
                 AVG(컬럼명) => 평균
                 COUNT(*), COUNT(컬럼명) => ROW의 갯수
                 --------  -------------
                 NULL포함  NULL미포함
                 RANK : 순위 결정
                 => RANK() OVER(ORDER BY SAL DESC)
                    1 2 2 4
                 => DENSE_RANK() OVER(ORDER BY SAL ASC)
                    1 2 2 3
              => SUM / AVG => 장바구니
              => MAX => 자동증가번호
              => COUNT => 아이디중복체크, 로그인, 검색결과
        3-1) GROUP BY : 같은 속성값(컬럼값)끼리 그룹을 묶어서 그룹별 통계
                        ----------- 같은값을 가지고 있는
                        ----------- 컬럼값, 함수를 이용할 수 있다
                        ----------- 집계(통계)
            실행순서와 SELECT의 순서
              SELECT -------- 5
              FROM ---------- 1
              WHERE --------- 2
              GROUP BY ------ 3
              HAVING -------- 4
              ORDER BY ------ 6
              주의점)
                    집계함수를 이용할때는 단일행 함수, 컬럼명을 사용할 수 없다
                    SELECT의 순서를 잘 기억
        --------------------------------------------------------------- 기초과정
        고급쿼리
        4) 조인 / 서브쿼리
*/