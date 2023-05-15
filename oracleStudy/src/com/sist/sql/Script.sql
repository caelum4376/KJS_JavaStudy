SELECT EMPNO, ENAME, JOB, HIREDATE, DNAME, LOC
FROM EMP, DEPT;

-- 조인
/*
 * 		1. INNER JOIN
 * 			= 동등조인 => EUQI_JOIN (=)
 * 			= 세타조인 (비동등조인) => =외의 다른 연산자 (비교연산자, ???
 * 			--------- NULL값이 있는 경우에 처리를 할 수 없다
 * 			= 자연조인 : NATUREL JOIN => 알아서 찾는 역할
 * 		2. OUTER JOIN => NULL값을 처리해주는 조인
 * 			= LEFT OUTER JOIN
 * 			= RIGHT OUTER JOIN
 * 			= FULL OUTER JOIN
 * 
 * 
 */

SELECT ename||' '||job FROM emp; -- || OR
--SELECT 문장형식
SELECT * FROM emp;
/*
 * 		EMP (사원정보)
 * 		-----------
 * 		 EMPNO : 사번
 * 		 ENAME : 사원이름
 * 		 JOB : 직위
 * 		 MGR : 사수번호 (사수의 사번)
 * 		 HIREDATE : 입사일
 * 		 SAL : 급여
 * 		 COMM : 성과급
 * 		 DEPTNO : 부서번호 = DEPT테이블과 조인
 * 		=> 한사원에 대한 정보
 * 		=> 한사원에 대한 표현
 * 		   자바
 * 		   Sawon s1 = new Sawon()
 * 		   Sawon s2 = new Sawon()
 * 		   => 오라클 => ROW	
 */
-- 사원정보 중에 사원명, 직위, 입사일, 급여
-- SELECT ename, job, hiredate, sal FROM emp;
-- 사원의 정보중에 이름과 급여 => king은 급여가 5000달러입니다
SELECT ename||'은 급여가 '||sal||'달러입니다' AS 사원급여
FROM emp;

-- 사원정보에서 직위(job)를 가지고 오는데 중복없는 직위를 출력
SELECT DISTINCT job FROM emp;
-- 사원, 이름, 직위, 입사일, 급여 => 별칭
SELECT empno "사번", ename AS 이름, job "직위", hiredate AS 입사일, sal "급여" 
FROM emp;

-- book 테이블에서 책이름과 출판사를 출력하시오
-- 책이름, 출판사, 가격 ==> 별칭을 부여하고 출력
-- 책이름의 출판사는 XXX이고 가격은 1000원입니다
SELECT * FROM book;

SELECT bookname AS 책이름, publisher AS 출판사, PRICE AS 가격 FROM book;
SELECT bookname||'의 출판사는 '||publisher||'이고 가격은 '||price||'입니다' AS 책정보 FROM book;

-- 145page
-- 출판사 중복없이 데이터만 출력
SELECT DISTINCT publisher FROM book; 

/* 149page
 * ------- 조건검색
 * select
 * from
 * where ==> if역할
 * => where 컬럼명 연산자 값
 * 			------------ true 문장 수행
 * 연산자
 *  산술연산자 : WHERE문장에서 사용보다는 SELECT에서 주로 사용
 * 				+, -, *, / (%=MOD())
 * 				=> 산술만 가능 => 'a'+1(x) 'a'||1 숫자+숫자
 * 				=> / => 나누기 (0으로 나눌수 없다), 정수/정수 = 실수
 *  비교연산자 : =(같다)
 * 			  !=(같지않다), <>(권장), ^=
 * 			  <, >, <=, >=
 * 			  ----------------------- 문자열/날짜도 적용
 * 			   day => '23/05/11' AND day <= '23/05/15'
 *  논리연산자 : 	AND, OR
 * 				AND : 범위, 기간 포함
 * 				OR : 포함이 안된 상태
 * 				부서번호가 10이거나 20이거나 30에 있는 사원 정보 출력
 * 				WHERE deptno=10 OR deptno=20 OR deptno=30
 * 				-------------------------------------------
 * 				=> WHERE deptno IN(10,20,30)
 * 				WHERE deptno>=10 AND deptno=20 OR deptno=30
 * 				-------------------------------------------
 * 				=> WHERE deptno BETWEEN 10 AND 30
 *  데이터베이스에서 사용하는 연산자
 * ------------------------
 * BETWEEN ~ AND : 포함(범위, 기간) >= AND <=
 * 		=> NONEQUI_JOIN, 페이지 나누기
 * IN : OR가 많은 경우에 주로 사용 => VIEW(다중 VIEW)
 * NOT : 부정 연산자
 * 		WHERE NOT (deptno >= 10 AND deptno <=30)
 * 		WHERE deptno NOT BETWEEN 10 AND 30
 * 		WHERE deptno NOT IN(10,20,30)
 * 		NOT LIKE
 * 		예약일이 아닌 날..., 등록이 안된 사람
 * LIKE : 문자열 검색
 * 		  startsWith : 시작문자열
 * 			=> WHERE title LIKE 'A%', 'AA%'
 * 		  endsWith : 끝나는 문자열
 * 			=> WHERE title LIKE '%A', '%AA'
 * 		  contains : 포함된 문자열
 * 			=> WHERE title LIKE '%A%'
 * 			=> 자바 : WHERE title LIKE '%'||A||'%'
 * 			   ----------------------------------오라클
 * 					 WHERE title LIKE CONCAT('%','A','%') => MYSQL
 * 			A, B, C, D
 * 			WHERE title LIKE '%A%' OR
 * 			title LIKE '%B%' OR
 * 			title LIKE '%C%' OR
 * 			title LIKE '%D%' OR
 * 			=> 최근에는 변경
 * 				WHERE REGEXP_LIKE(title, '[A-Z]')
 * 		  표현법
 * 			_ : 한글자
 * 			% : 문자갯수가 지정이 없는 상태
 * 			WHERE ename LIKE '___G' => KING
 * 			WHERE ename LIKE '__A__'
 * 			WHERE ename LIKE '%A%'
 * 		NULL : 값이 없는 상태 => 연산처리를 할 수 없다
 * 				1+null = null
 *	 			0은 값이 존재하는 상태, null은 값 자체가 없는 상태
 * 			-NVL(컬럼명,0) => 컬럼값이 NULL일 경우 0으로 치환
 * 				NULL값인 경우 ===> IS NULL
 * 				NULL값이 아닌 경우 ===> IS NOT NULL
 * 		*** 문자열이나 날짜 비교시에 비교연산자를 사용한다
 * 			---------------------------------
 * 			WHERE ename='KING';
 * 			WHERE ename='KING'; => 
 * 	
 * NULL
 * 
 * 
 * 
 */

SELECT ename, sal+NVL(comm,0) FROM emp;

-- 성과급을 받는 사람의 이름, 급여, 성과급
SELECT ename, sal, comm FROM EMP WHERE comm IS NOT NULL AND comm<>0;
SELECT ename, sal, comm FROM EMP WHERE comm IS NULL;

SELECT comm FROM emp WHERE ename<'KING';
SELECT sysdate-1, sysdate, sysdate+1
FROM dual;

SELECT '1'+1 FROM DUAL;

-- emp에 저장된 모든 사원 정보를 출력 => *
SELECT * FROM EMP;

-- 사원별로 원하는 데이터만 추출 => 컬러명, 컬럼명...
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP;

-- 조건에 맞는 데이터만 추출 => 연산자 사용 => WHERE
-- 비교연산자 = (1. 비교연산자(같다), 2.대입연산자)
/*
 * 	WHERE 뒤에 (=) 비교연산자
 * 	다른 명령문 뒤에 있는 경우는 대입연산자
 * 	------------ UPDATE
 * 	SELECT ~
 * 	FROM ~
 * 	WHERE EMPNO = 7788 => 비교연산자
 * 
 * 	UPDATE ~
 * 	ENAME = '홍길동'
 * 	WHERE EMPNO = 7788
 */
-- = (같다) => 149page
SELECT *
FROM EMP
WHERE EMPNO = 7788; -- 상세보기

-- <> (!=, ^=)
-- MANAGER가 아닌 사원의 모든 정보 추출
SELECT *
FROM EMP
WHERE JOB != 'MANAGER';
SELECT *
FROM EMP
WHERE JOB <> 'MANAGER';
SELECT *
FROM EMP
WHERE JOB ^= 'MANAGER';

-- 오라클의 단점 = SQL문장의 종류가 많다
-- 조인 = 서브쿼리
-- < 작다 => 날짜, 문자열 => 적용
-- 급여가 1500보다 작은 사원의 이름, 급여 추출
SELECT ENAME, SAL
FROM EMP
WHERE SAL > 2500;

-- <= 이하
-- 사원정보에서 급여가 3000이하인 사원의 모든 정보 출력
-- FROM		WHERE 	SELECT 
SELECT *
FROM EMP
WHERE SAL <= 3000;

-- >= 이상
-- 사원정보에서 급여가 3000이상인 사원의 모든 정보 출력
SELECT *
FROM EMP e 
WHERE SAL >= 3000;

-- 문제 => 책정보에서 가격이 20000미만인 책의 모든 정보를 추출
SELECT *
FROM BOOK b
WHERE PRICE < 20000;

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


-- 사원정보에서 사원의 모든 정보 => 급여가 많은 순서로 출력
SELECT *
FROM EMP
ORDER BY SAL DESC;

SELECT *
FROM EMP
ORDER BY SAL ASC;

SELECT *
FROM EMP
ORDER BY 6;

-- 이중 정렬
SELECT EMPNO, ENAME, SAL, HIREDATE
FROM EMP e 
ORDER BY SAL DESC, ENAME ASC;

SELECT *
FROM EMP
ORDER BY 3 DESC, 2;

-- 문제 책정보에서 가격을 내림차순으로 검색
-- 같은 가격이면 출판사를 올림차순으로 출력
SELECT *
FROM BOOK b 
ORDER BY PRICE DESC, PUBLISHER; -- ORDER BY 4 DESC, 3

/*
 * 		SELECT => 데이터검색
 * 		------
 * 			1. 형식
 * 			2. 조건 (연산자)
 * 			3. 내장함수
 * 			4. 정렬
 * 			5. 그룹
 * 			6. 그룹조건
 * 
 * 		내장함수 (라이브러리) => 사용자 정의 (PL/SQL)
 * 		---------------
 * 			단일행 함수 => ROW단위 처리
 * 				1) 문자함수 (String)
 * 				   -----
 * 				   = 변환
 * 					 대문자 변환 => UPPER('aaa') => AAA
 * 					 소문자 변환 => LOWER('AAA') => aaa
 * 					 이니셜 변환 => INITCAP('aaa') => Aaa
 * 				   = 제어
 * 					 문자열 자르기 => SUBSTR()
 * 					 문자열의 위치확인 => INSTR()
 * 					 특정문자열 제거 => TRIM()
 * 								= LTRIM() => 왼쪽만
 * 								= RTRIM() => 오른쪽만
 * 								= TRIM() => 좌우
 * 					 ***특정문자열 변경 => REPLACE()
 * 					 문자열 결합 => CONCAT => ||
 * 					 문자열을 다른 문자로 출력 => LPAD()
 * 										= RPAD()
 * 					 문자의 갯수 확인 => LENGTH()
 * 				2) 숫자함수 (Math)
 * 				   = 올림함수(총페이지) => CEIL()
 * 				   = 반올림함수 => ROUND()
 * 				   = 버림함수 => TRUNC()
 * 				   = 나머지 => % = > MOD()
 * 				3) 날짜함수 (Date, Calendar)
 * 				   = 시스템의 시간 읽기 => SYSDATE
 * 				   = 기간의 개월수 읽기 => MONTHS_BETWEEN
 * 				   = AOD_MONTHS
 * 				   = NEXT_DAY, LAST_DAY
 * 				4) 변환함수 (~Format)
 * 				   = 문자열변환 => TO_CHAR***
 * 				   = 숫자변환 => TO_NUMBER
 * 				   = 날짜변환 => TO_DATE
 * 				5) 기타함수 (다중 조건문, 선택문, NULL값 처리)
 * 				   = NULL값을 다른 값으로 변경해서 사용 => NVL()***
 * 				   = SWITCH~CASE => DECODE()
 * 				   = 다중IF문 => CASE
 * 			집합행 함수 => 전체 ROW에 대한 처리
 * 				1) ROW의 갯수확인 => COUNT()
 * 					=> 로그인, 아이디중복, 장바구니...
 * 				2) MAX()
 * 				3) MIN()
 * 				4) SUM()
 * 				5) AVG()
 * 			분석함수 => 통계
 * 				1) RANK
 * 					1 2 2 4...
 * 				   DENSE_RANK
 * 					1 2 2 3...
 * 				2) CUBE
 * 				3) ROLLUP
 */
-- 단일함수 (문자함수)
-- 변환 : UPPER / LOWER / INITCAP => String
SELECT ENAME "이름", UPPER(ENAME) "대문자", LOWER(ENAME) "소문자", INITCAP(ENAME) "이니셜"
FROM EMP;
-- UPPER('문자열') => 대문자 변환
-- LOWER('문자열') => 소문자 변환
-- INITCAP('문자열') => 첫자만 대문자 변환
-- 사용빈도는 거의 없다(한글)
-- SELECT UPPER('홍길동') FROM DUAL; 한글인 경우에는 적용되지 않는다
-- LENGTH => 문자갯수, LENGTHB => 바이트갯수 (한글 => 3Byte)
-- LENGTH('문자열'), LENGTH('문자열')
-- 영문이나 숫자는 동일 => 한글은 갯수와 바이트수가 다르다
-- 데이터 저장 => VARCHAR2(10) => 한글은 3글자만 저장이 가능
SELECT LENGTH('ABCDE'), LENGTHB('ABCDE'), LENGTH('홍길동'), LENGTHB('홍길동') FROM DUAL;

-- 이름 글자수가 5개인 사원의 정보
SELECT *
FROM EMP e WHERE LENGTH(ENAME)=5;

-- ***RPAD / LPAD =>
-- LPAD('문자열',글자수,'문자')
-- LPAD('admin',10,'*') => *****admin
SELECT LPAD('admin',10,'*'), RPAD('admin',10,'*')  FROM dual;

-- SUBSTR => subString : 문자열을 자르는 경우에 사용
-- SUBSTR('문자열', 시작번호, 갯수)
-- SUBSTR('123456789', 3, 2) => 34
-- 시작번호는 1번부터 (자바는 0번부터)
-- SUBSTR
SELECT ENAME, RPAD(SUBSTR(ENAME,1,1), LENGTH(ENAME), '*')
FROM EMP;

-- 날짜 => 05에 입사한 사원의 정보
SELECT *
FROM EMP
WHERE SUBSTR(HIREDATE, 4, 2) = '05';

-- 81년에 입사한 사원의 모든 정보
SELECT *
FROM EMP
WHERE SUBSTR(HIREDATE,1,2)=81;
-- WHERE HIREDATE >= '81/01/01' AND HIREDATE <= '81/12/31'
-- WHERE HIREDTAE BETWEEN '81/01/01' AND '81/12/31'
-- WHERE HIREDATE LIKE '81%'
-- WHERE SUBSTR(HIREDATE,1,2) = 81; 
-- 결과값 추출은 동일 => SQL문장은 여러개가 존재
-- SELECT SUBSTR('Hello Java', -1, 2) FROM DUAL;

-- INSTR => indexOf, lastIndexOf
-- INSTR(문자열, 찾는문자, 시작위치, 횟수)
SELECT INSTR('Hello Oracle', 'e', 1, 1) FROM DUAL;
SELECT INSTR('Hello Oracle', 'e', 1, 2) FROM DUAL;

-- jAVAjAVA => 2 => 2번째 있는 e자의 위치번호
-- 세번쨰 자리에 O자가 있는 사람의 정보
SELECT *
FROM EMP e
WHERE ENAME LIKE '__O%';

SELECT *
FROM EMP e 
WHERE INSTR(ENAME, 'O', 1, 1) = 3;

-- CONCAT
SELECT CONCAT('Hello', ' Oracle') FROM DUAL;

SELECT 'Hello'||' Oracle' FROM DUAL;

-- REPLACE 다른 문자로 변경
-- REPLACE('문자열', '찾는문자', '대체할문자')
-- REPLACE('Oracle', 'e', 'k') => Oraclk
-- REPLACE('Hello Java', 'a', 'b') => Hello Jbvb
-- REPLACE('Hello Java', 'Java', 'Oracle')
-- REPLACE('URL', '&', '#')
SELECT ENAME, REPLACE(ENAME, 'A', 'K')
FROM EMP;

-- ASCII => 문자열 숫자변환
-- ASCII('문자') = 숫자
-- ASCII('A') = 65
SELECT ASCII('D') FROM DUAL;

-- TRIM => 특정문자를 제거 (좌우에만 제거가 가능)
-- LTRIM : 왼쪽만 제거
-- RTRIM : 오른쪽만 제거
-- TRIM : 좌우 제거
SELECT ENAME, LTRIM(ENAME, 'A'), RTRIM(ENAME, 'K')
FROM EMP;

SELECT TRIM('a' FROM 'aaaaaaaHello Javaaaaaa')
FROM DUAL;

/*
 * 	1. LENGTH : 문자 갯수
 *  2. SUBSTR : 문자를 자르는 경우
 *  3. INSTR : 문자의 위치
 *  4. RPAD : 빈공간에 원하는 문자 출력
 *  5. REPLACE : 문자를 대체
 */

-- 숫자관련 함수
/*
 * 	1. ROUND : 반올림
 * 		ROUND(75.345, 2) => 75.35
 * 		ROUND(75.345, 1) => 75.3
 * 	2. CEIL : 올림
 * 		CEIL(75.1) => 76
 * 		CEIL(75.0) => 75
 *  3. TRUNC : 버림
 * 		TRUNC(75.567) => 75
 * 		TRUNC(75.45) => 75
 *  4. MOD : 나머지
 * 		MOD(number, 3)
 * 		MOD(10, 3) = 10%3 => 1
 */

SELECT ROUND(75.345, 2), ROUND(75.345, 1)
FROM DUAL;

SELECT CEIL(75.1), CEIL(75.0)
FROM DUAL;

SELECT TRUNC(75.567), TRUNC(75.45)
FROM DUAL;

SELECT ENAME, EMPNO
FROM EMP e 
WHERE MOD(EMPNO, 2) = 0;

/*
 *	SYSDATE : 시스템의 시간을 읽어온다
 *	=> 날짜 등록을 하지 않는다
 *	MONTHS_BETWEEN : 기간의 개월수를 읽어 온다 (시간) => 소수점	
 * 	ADD_MONTHS : 지정된 개월의 날짜 읽기
 *  NEXT_DAY : 다음날부터 시작해서 다음에 돌아오는 요일은 몇일
 * 	LAST_DAY : 월 지정 => 지정된 월의 마지막 날 확인
 * 	ROUND***, TRUNC***
 */

SELECT SYSDATE FROM DUAL;

-- 내일, 어제 => 산술연산이 가능
SELECT SYSDATE-1 "어제", SYSDATE "오늘", SYSDATE+1 "내일"
FROM DUAL;

-- NEXT_DAY
SELECT NEXT_DAY(SYSDATE, '월')
FROM DUAL;

-- LAST_DAY
SELECT LAST_DAY('23/03/01')
FROM DUAL;

-- MONTHS_BETWEEN
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) "근무개월",
		ROUND(TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))/12) "년차"
FROM EMP;

-- ADD_MONTHS(SYSDATE, 4)
SELECT ADD_MONTHS(SYSDATE, 6)
FROM DUAL;

-- 변환함수
/*
 *	TO_CHAR*** : 문자열 변경 => 숫자, 날짜
 *	------- SimpleDateFormat (날짜변환)
 *			DecimalFormat (숫자변환)
 *		=> yy, yyyy (대소문 구분이 없다) 년도
 *			m, mm 월
 *			d, dd 일
 *			h, hh 시간
 *			hh24
 *			mi : 분
 *			ss : 초
 *		숫자 => 999,999 => $99,999 => L999,999
 *	TO_NUMBER : 
 *	TO_DATE
 */
SELECT ENAME, SAL, TO_CHAR(SAL, '$999,999'), TO_CHAR(SAL, 'L999,999')
FROM EMP;

SELECT ENAME, HIREDATE, TO_CHAR(HIREDATE, 'YYYY/MM/DD HH24:MI:SS')
FROM EMP;