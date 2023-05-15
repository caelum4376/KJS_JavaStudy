-- 2023-05-15 오라클 2일차
/*
    Table : 데이터 저장 장소
    ----- 기능별로 분리해서 저장
          ------------- Column
    => 2차원 구조 : Table, Column => 중복을 최소화
    emp(사원정보) = 오라클의 예제파일, dept(부서정보), book(책정보)
                                                       ------------ 교재에서 지원
    emp(사원정보)
      = empno : 사번 ==> 중복없는 데이터
      = ename : 이름
      = job : 직위
      = mgr : 사수 사번
      = hiredate : 입사일
      = sal : 급여
      = comm : 성과급
      = deptno : 부서번호 ==> 부서 테이블과 연결
      -----------------------------------------------------
      오라클의 데이터형       자바 데이터형
      문자형      ============> String
        CHAR
        VARCHAR2
        CLOB
      숫자형      ============> int, double
        NUMBER
        NUMBER(4)
        NUMBER(7, 2)
      날짜형      ============> java.util.Date
        DATE
        TIMESTAMP(기록경주)
      기타형      ============> inputStream
        BFILE
        BLOB
      ------------------- 테이블에서 컬럼명, 데이터형확인 ==> DESC table명
      SQL 기초 (142page)
      --- 사용자 요청에 따른 데이터를 추출, 수정, 삭제, 추가 ==> 문자열형식 문법
      SQL의 기본 문법
        1) 지정된 명령문만 사용이 가능
        2) 명령문은 대소문자 구분이 없다 (오라클 개발자 => 키워드는 대문자로 작성)
        3) 형식
            ex) SELECT 컬럼명...
                FROM 테이블명
                WHERE 조건문
        4) 명령문이 종료가 되면 ;을 사용한다 => 자바에서 ;을 포함하고 있다
        5) 데이터가 변경시에는 추가, 수정, 삭제시에는 반드시 COMMIT을 전송한다
        6) 컬럼은 순서가 없다...
        7) 오라클의 모든 번호는 1번부터 시작한다
            Hello   Hello
            01234   12345
        ------------------------------------------------------------------
        SQL의 종류
        ***DQL : SELECT => 데이터를 추출(검색)
        ------
        ***DML : 데이터 조작언어 (INSERT, UPDATE, DELETE)
        ------
        ***DDL : CREATE, ALTER, DROP, RENAME, TRUNCATE
        ***DCL : GRANT, REVOKE
        ***TCL : COMMIT, ROLLBACK
        ------
        ==========> 공유하는 데이터를 검색
        1) SELECT : 데이터 검색 (웹사이트 => 80%)
          => 형식, 연산자, 내장함수, 조인, 서브쿼리(부속질의)
          1. 형식 => 명령문 순서를 기억
            SELECT [DISTINCT] *|컬럼리스트
            => 전체 데이터를 읽기 / 프로그램에 필요한 컬럼만 읽을 수 있다
               ------------------   -----------------------------------------------------------------
                                    1           2               3           4               5
                            SELECT  empno,      ename,          hiredate,   job,            sal
                                    NUMBER      VARCHAR2        DATE        VARCHAR2        NUMBER
                                    getInt(1)   getString(2)    getDate(3)  getString(4)    getInt(5)
                 * => SELECT * => *은 사용하면 데이터베이스에 등록된 순서
            FROM table명|view명|SELECT~
            ** SELECT문장은 table을 대신 사용이 가능 (인라인뷰)
                            컬럼 대신 사용이 가능 (스칼라 서브쿼리)
            SELECT  (SELECT~), (SELECT~)
            FROM    (SELECT~)
            -------------------------------------------------------- 필수조건
            *** 오라클의 단점 : 오류시에 건너뛰고 다음 문장을 수행
            1) 정상 2) 정상 3) 오류 4) 정상 5) 정상 ===> 1,2,4,5
                       입고    재고    데이터읽기 ===>    
            옵션 사항
            [
                WHERE   조건문 (컬럼명 연산자 값) => TRUE/FALSE => 자바(IF문)
                GROUP BY    컬럼명 => 그룹별로 나눠서 처리
                HAVING  그룹에 대한 조건 ==> GROUP BY와 같이 사용
                ORDER BY    정렬할 때 사용 => 속도가 늦다 (인덱스 사용 권장)
            ]

            WHERE 문장을 사용하기 위해서는 반드시 연산자
            *** 주의점 : 값(NULL)인 경우에는 연산처리가 안된다 ==> 모든 값이 NULL
            일반 연산자
                1) 산술연산자 : SELECT뒤에서 주로 사용 (+,-,*,/) %는 MOD()
                    => 형변환이 없다
                       TO_CHAR(), TO_NUMBER(), TO_DATE() => 형변환
                       문자열변환 숫자변한     날짜변환
                       '1' + 2 => 3
                       --- 자동변환
                       'A'+1 => 오류발생
                    => / => 0으로 나눌 수 없다, 정수/정수 = 실수
                    => 날짜도 산술연산이 가능
                2) 비교연산자 : WHERE뒤에서 사용
                    = 같다
                    != 같지 않다 (<>, ^=) => 권장사항 (<>)
                    <
                    >
                    <=
                    >=
                3) 논리연산자 : AND, OR => &&(입력값 받는 경우에 사용) || (문자열 결합) 
            데이터베이스 연산자
              1) IN => OR연산이 많은 경우에 사용
                EX) WHERE deptno = 10 OR deptno = 20 OR deoptno = 30
                    WHERE dept IN(10, 20, 30)
              2) BETWEEN~AND : 기간이나 범위를 포함한 경우 => 예약일, 페이지나누기
                1~100 사이
                WHERE no >= 1 AND no <= 100
                WHERE no BETWEEN 1 AND 100 => 1포함, 100포함
            3) NOT : 부정연산자 => !를 사용하면 오류
                NOT IN(), NOT BETWEEN, NOT LIKE
            4) NULL : NULL일 경우에는 연산처리가 안된다
               IS NULL (NULL인 경우), IS NOT NULL(NULL이 아닌 경우)
            5) LIKE : 유사문자열 검색
                    % => 문자열의 갯수를 확인 안됨
                    _ => 문자 한개 __A => 3번쨰 자리가 A
                => startsWith => 'A%' = 'Java%'
                => endsWith =>  '%A' => '%Java'
                => contains => '%A%' => '%Java%'
                *** 오라클(데이터베이스)는 ""를 사용하지 않는다 "은 사용한다"
                ''는 문자열, 날짜는 반드시 사용
                ""는 인용부호, 별칭, 한글
                => 글자수를 아는 경우 ==> _을 이용한다

            기타
            || => 문자열 결합 사용
            & => 입력값을 받는 경우에 사용
            DISTINCT => 중복없는 데이터추출
            별칭 => 컬럼 "", 컬럼 AS 별칭
            => 연산만 처리, 내장함수 처리 => 컬럼명이 없는 경우에는 DUAL연습 테이블을 이용한다
                ex) SELECT '1'+1 FROM (DUAL);
*/

-- 산술연산자 (+,-,*,/)
SELECT 100+20, TO_NUMBER('100')+20, 'A'||20
FROM DUAL;
SELECT 10/3
FROM DUAL;

-- 복합연산자 => AND, OR 
-- AND => 범위, 기간 포함
-- OR => 범위에 없는 경우에 주로 사용
-- (조건) AND (조건) => 조건이 모두 TRUE => TRUE 
-- BETWEEN ~ AND 
-- (조건) OR (조건) => 조건이 한개이상 TRUE => TRUE
-- IN

-- 사원정보에서 급여가 1500이상 3000이하인 사원의 모든 정보 추출
SELECT *
FROM EMP
WHERE SAL >= 1500 AND SAL <= 3000;

SELECT *
FROM EMP e 
WHERE SAL BETWEEN 1500 AND 3000;

-- OR 연산 1500이상 3000이하
SELECT *
FROM EMP
WHERE SAL <1500 OR SAL >=3000;

-- 날짜
-- 1980년에 입사한 사원의 모든 정보를 추출
SELECT *
FROM EMP e 
WHERE HIREDATE BETWEEN '80/01/01' AND '80/12/31'; 

SELECT *
FROM EMP e ;

-- IN연산자 => OR연산이 많은 경우 => 서브쿼리
-- 사용방법 WHERE 컬럼명 IN(값, 값...)
-- 부서번호가 10, 20인 사원의 모든 정보를 가지고 온다
SELECT *
FROM EMP e 
WHERE DEPTNO = 10 OR DEPTNO = 20;

SELECT *
FROM EMP
WHERE DEPTNO IN(10,20);

-- 문제 책정보에서 출판사명이 굿스포츠, 대한미디어
SELECT *
FROM BOOK
WHERE PUBLISHER IN('굿스포츠', '대한미디어');

-- 
-- 사원정보에서 급여가 2000에서 3000까지의 사원의 모든 정보
SELECT *
FROM EMP e 
WHERE SAL BETWEEN 2000 AND 3000;

-- 문제 책정보에서 가격이 10000이상 20000이하인 책의 모든 정보
SELECT *
FROM BOOK b 
WHERE PRICE BETWEEN 10000 AND 20000;

-- NOT : 부정 (반대)
-- 사원정보에서 MANAGER, SALESMAN아닌 사원의 모든 정보
SELECT *
FROM EMP e 
WHERE JOB NOT IN ('MANAGER', 'SALESMAN');

-- 사원정보에서 81년에 입사한 사원이 아닌 경우의 모든 정보
SELECT *
FROM EMP e 
WHERE HIREDATE NOT BETWEEN '81/01/01' AND '81/12/31';

-- LIKE문장 => 포함, 시작문자, 끝문자
-- 검색프로그램 => contains()
-- 형식) WHERE 컬럼명 LIKE '패턴'
-- &, ==> %는 글자수가 모르는 경우, _한글자만
-- 페턴 : '검색어%':검색어로 시작, '%검색어':검색어로 끝, '%검색어%': 검색어 포함
-- '__A__' => 5글자중에 3번쨰 문자가 A인 데이터를 찾는다

-- 검색어%
-- 사원 정보에서 A자로 시작하는 사원의 모든 정보
SELECT *
FROM EMP e 
WHERE ENAME LIKE 'A%';

-- 사원 정보에서 N자로 끝나는 사원의 모든 정보
SELECT *
FROM EMP e 
WHERE ENAME LIKE '%N';

-- 사원 정보에서 B자를 포함하는 사원의 모든 정보
SELECT *
FROM EMP e 
WHERE ENAME LIKE '%B%';

-- 사원 정보에서 3번째 글자가 O자인 사원의 정보
SELECT *
FROM EMP e 
WHERE ENAME LIKE '__O%';

-- 데이터베이스는 명령문에서는 대소문작 구분이 없다. 단, 저장된 데이터에서는 구분이 있다

-- 두개이상 검색 => 사원이름 중에 EN/IN을 포함하고 있는 사원의 모든 정보
SELECT *
FROM EMP e 
WHERE ENAME LIKE '%EN%' OR ENAME LIKE '%IN%';

-- 문제 81년에 입사한 사원의 모든 정보를 추출
SELECT *
FROM EMP e 	
WHERE HIREDATE LIKE '81%';

-- 문제 5월달에 입사한 사원의 모든 정보
SELECT *
FROM EMP e 
WHERE HIREDATE LIKE '___05___';

-- 문제 사원정보에서 사원의 이름중에 A,B,C,K가 포함된 사원의 모든 정보 추출
SELECT *
FROM EMP e 
WHERE ENAME LIKE '%A%' OR  ENAME LIKE '%B%' OR  ENAME LIKE '%C%' OR ENAME LIKE '%K%';

-- 조건이 많은 경우에는 패턴을 이용한다
SELECT *
FROM EMP e 
WHERE REGEXP_LIKE(ENAME, 'A|B|C|K');

-- 두번째 글자가 구인 책제목
SELECT *
FROM BOOK b 
WHERE BOOKNAME LIKE '_구%';

SELECT * FROM EMP;

-- 사원 정보에서 급여가 1000이상이고 직위가 사원인 사원의 모든 정보
SELECT *
FROM EMP
WHERE SAL >= 1000 AND JOB = 'CLERK';

-- 직위가 사원이거나 관리자인 사원의 모든 정보
SELECT *
FROM EMP e 
WHERE JOB = 'CLERK' OR JOB = 'MANAGER';

SELECT *
FROM EMP e 
WHERE JOB IN ('CLERK','MANAGER');

-- NULL값일때 처리 => IS NULL, IS NOT NULL
-- 사원정보 중에 성과급을 받는 사원의 모든 정보
SELECT *
FROM EMP e 
WHERE COMM IS NOT NULL AND COMM<>0;

-- 사원중에 성과급이 없는 사원의 모든 정보 추출
SELECT *
FROM EMP e 
WHERE COMM IS NULL OR COMM=0;