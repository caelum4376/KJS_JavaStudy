-- 2023-05-11 오라클
/*
            특징
            1) 실시간 접근성 => 자동실행
               => 필요시마다 접근이 가능하게 만든다
	2) 계속된 변화 (상품 올리기, 뮤직순위 변경, 댓글...)
               => INSERT(추가), UPDATE(수정), DELETE(삭제)...
            3) 동시 공유 (모든 사용자가 같은 데이터를 제어) ==> 공유
            4) 내용에 따른 참조
                자바처럼 주소로 접근하는 것이 아니라 실제 저장된 데이터값 참조

                - 누구나 언제든 접근이 가능하다 => 데이터를 참조할 수 있다

            27page
	시스템 구성요소
	-----------------
	1) DBMS (실제 저장된 데이터와 응용프로그램과 연결) = 오라클
	   => 연동시에 오라클이 인식할 수 있는 언어를 이용해야 사용이 가능
		        ------------------------------- SQL
	2) 데이터베이스 : 폴더 (기본 데이터베이스 : XE)
	   => CREATE DATABASE mydb
	3) 데이터 모델
	   => 데이터를 저장하는 기법
	    ex) 문자, 숫자, 날짜
	         문자형 => CHAR, VARCHAR2, CLOB
		         CHAR(1~200byte) => 고정형
		         CHAR(10) => 'a' => 메모리 크기가 10byte에 저장 => 메모리 누수
		         VARCHAR2(1~4000byte) => 가변형
		         VARCHAR2(10) => 'a' ==> 1byte만 할당
		         CLOB => 4기가 => 가변형
	         ------------------------------------------------------ 자바 : String
                      숫자형 => NUMBER(38)
	                        NUMBER(4), NUMBER(7, 2) => 전체숫자는 7중에 2자리 소수점으로 이용한다
	         -------------------------- 자바 : int, double
	          날짜저장 => DATE, TIMESTAMP(보안)
			  ------ java.util.Date
	          기타형 => BFILE/BLOB(binary형태로 저장)
	                        동영상, 사진
	          ****** 기술면접 : BFILE/BLOB구분
	= 키에 대한 종류
	   => 기본키 : 중복이 없는 데이터 = ID, 나머지 숫자 => PRIMARY KEY
	   => 후보키 : 기본키를 대체 = 전화번호, 이메일 => UNIQUE
	   => 참조키 : 다른 테이블의 데이터를 참조(조인) => FOREIGN KEY
	   => 제약조건
	------------------------------------------ 데이터베이스 모델링
	4. 데이터베이스의 발전 과정
	   1) 파일시스템 => 관리가 어렵다, 다른 파일과 연결해서 사용하기 어렵다, 보안에 취약하다
	   2) 데이터베이스 시스템 => 명령문이 문자열로 만들어지기 때문에 배우기가 쉽다
				 SQL => 암기 => 실행속도가 빠르게...
				 다른데이터와 연결이 쉽다
				 ---------------------------- JOIN, SUBQUERY
	   3) 웹 데이터베이스 시스템 => ***
		데이터베이스 연결 (MyBatis, JPA, Hibernate) => 프로그램 (Spring, NodeJS)
	   4) 분산 데이터베이스 시스템 : 백업
		장점 => 중복의 최소화, 일관성, 독립적, 관리기능, 프로그램과 호환성이 좋다
	5. 오라클 발전과정
	   i => internet => 8i, 9i
	   g => grid(편집툴) => 10g, 11g
	   c => component => 12c~21c
	--------------------------------------------------------------------------------------
		메모리저장	파일저장		DBMS에 저장
	--------------------------------------------------------------------------------------
		변수		라이브러리	오라클 툴(SQLDeveloper)
		배열		
		클래스
	--------------------------------------------------------------------------------------
		자바		자바		SQL
	--------------------------------------------------------------------------------------
		응용프로그램			응용프로그램과 오라클 연동
	--------------------------------------------------------------------------------------
	45page
	--------
	   응용 프로그램 (자바)
	      | => 오라클 연결시 사용되는 언어 (SQL) => 구조화된 쿼리언어
	      |					 ------------------- 검색
	   오라클 (데이터베이스 시스템)
	      | => 오라클은 c언어로 제작됨 (자바 => c언어 형식)
	      |	-------------------------- printf(), 람다, NIO
	      | 	 람다 => 자바스크립트 (화살표)
	      |	ex)
	      |		function myName() {}
	      |		let myName=()=>{}
	      |		함수포인터 => 1.8
	      |	    => read/write
	   하드디스크 (데이터 저장)
	---------------------------------------------------------------------------------------
	46page
	=> 데이터베이스 언어(SQL) => 문자열 형식으로 만들어져 있다
	     SQL : 명령문으로 만들어져 있다
		 대소문자 구분이 없다 (명령문에서는)
		select, SELECT, Select ...
		=> 대소문자 구분 : 저장된 데이터는 대소문자 구분
		     KING => king
		=> 오라클 개발자 약속 => 키워드나 테이블명은 대문자 나머지 소문자
		   SELECT 컬럼명...
		   FROM 테이블명
		   WHERE 컬럼명 연산자 값
		=> MYSQL편집기 => 소문자
		=> 응용(X) => 형식은 반드시 암기 => 순서
	     1) DML : 데이터를 조작하는 언어
		1) SELECT => 데이터를 검색할 목적 (사이트의 85%)
			= 형식, 연산자, 내장함수, (***JOIN, SUBQUERY)
					         -------------------- SQL문장이 길어진다
					         => 다른 테이블 연결 => 관련된 데이터 가지고 오기
			*** 자바, 오라클 => 답변이 없는 경우는 무조건 떨어진다
		2) INSERT => 데이터를 테이블에 추가 => ROW단위
		3) UPDATE => 데이터를 수정 => ROW단위
		4) DELETE => 데이터를 삭제 => ROW단위
		------------------- 중복이 없는 값이 필요
		CURD => CREATE UPDATE READ DELETE
	     2) DDL : 데이터를 정의하는 언어
		1) table (데이터 저장 장소 : 파일(자바))
		   단위
		   bit     =    byte    =    word    =    record    =    table
				        단어            ROW
		   CREATE TABLE~~
		2) view (가상테이블 = 메모리에 저장이 안된다 : 보안, 재사용)
		   CREATE VIEW~~
		3) SEQUENCE (자동 증가번호) => 중복없는 데이터를 만들 때 사용
		4) ************
		   INDEX : 검색속도의 최적화
		5) PL-SQL 
		   프로시저 (메소드) => 함수를 만드는 언어
		   사용자 정의 함수 : Function / Procedure / Trigger
				변수, 연산자, 제어문
				공통으로 사용되는 댓글을 메소드화
		DDL명령문
		-----------   ****** DML은 COMMIT이 없으면 저장이 안됨
			    ****** DDL은 COMMIT을 사용하지 않는다
		  = CREATE : 생성 => CREATE TABLE, CREATE VIEW, CREATE SEQUENCE...
				    CREATE INDEX, CREATE FUNCTION...
				    CREATE TRIGGER
		  = ALTER : 추가, 수정, 삭제
			  => Column단위
		  = DROP : 테이블 자채를 선제 => 복구가 안된다)
		  = TRUNCATE : 데이터를 잘라내기 (전체데이터만 지울때)
		  - RENAME : 테이블이나 컬럼명을 변경할때 사용
	     3) DCL : 데이터를 제어하는 언어 => DBA전용 => system, sysdba, hr(사용자 계정)
		  = GRANT : 권한을 부여
		  = REVOKE : 권한을 해제
	     4) TCL : 트랜젝션 제어하는 언어 (일괄처리)
		==> INSERT, UPDATE, DELETE에서만 적용
		==> SELECT문은 검색 (다시 저장할 필요가 없다)
		= 정상적으로 저장 : COMMIT
		= 명령문 취소 : ROLLBACK
*/