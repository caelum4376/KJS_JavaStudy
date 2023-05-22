-- 2023-05-17 오라클 JOIN
/*
    서로 다른 테이블(같은 테이블)에서 필요한 데이터를 추출하는 기술
    = 테이블은 관련된 데이터만 모아둔다 (테이블이 여러개로 나눠져 있다) => 정규화
    ex) 게시판/댓글, 영화/예매, 음식정정보/카테고리 => 조인, 서브쿼리, 뷰

    1. JOIN 종류
        = INNER JOIN
            등가조인 (EQUI_JOIN) => 데이터값이 같은 경우에 사용 (컬럼명은 다를 수도 있다)
                                    -------------------- 참조키 (FOREIGN KEY)
                                    연산자 : =
            비등가조인 (NON_EQUI_JOIN) => 데이터 포함여부, 연산자 : =외의 연산자사용
                                          AND, BETWEEN ~ AND
            자연조인 : 같은 컬럼명을 가지고 있다 (JOIN~USING)
        = 연습 : emp(사원정보)/dept(부서정보), book,customer(교재)
        = SELF 조인 (같은 테이블에서 작업)
        = 주의점 : 테이블에서 같은 컬럼명을 조회할 떄 => 구분
                   테이블명.컬럼명, 별칭명.컬럼명
                   ------------------------------ 애매한 정의
                   FROM 테이블명, 테이블명
                   FROM 테이블명 별칭, 테이블명 별칭
        = 이차 for문과 동일 => if(a=b)
        for() { => 왼쪽테이블
            for() { => 오른쪽테이블
                if(=) { EQUI_JOIN => if(>= && <=) NON_EQUI_JOIN
                    추출
                }
            }
        }

        = INNER JOIN 형식
            A : a,b,c
            B : b,d,e

            => Oracle JOIN
            SELECT a,A,b,c,d,e
            FROM A,B
            WHERE A.a = B.b

            => ANSI JOIN : 표준화(MySQL, MariaDB)
            SELECT a,A,b,c,d,e
            FROM A JOIN B
            ON A.a = B.b
            ----------------------------------------- 컬럼명이 동일
            SELECT a,A,b,c,d,e
            FROM A NARRAL JOIN B b컬럼을 검색해서 추출

            = JOIN ~ USING
            SELECT A JOIN B USING(b)

        = OUTER JOIN (INNTER JOIN+NULL값 처리)
            = LEFT OUTER JOIN
                *Oracle JOIN
                 SELECT A.a,A.b,B.a,B.c
                 FROM A,B
                 WHERE A.a = B.a(+)
                *ANSI JOIN
                 SELECT A.a,A.b,B.a,B.c
                 FROM A LEFT OUTER JOIN B
                 ON A.a = B.b
            = RIGHT OUTER JOIN
                *Oracle JOIN
                 SELECT A.a,A.b,B.a,B.c
                 FROM A,B
                 WHERE A.a(+) = B.a
                *ANSI JOIN
                 SELECT A.a,A.b,B.a,B.c
                 FROM A RIGHT OUTER JOIN B
                 ON A.a = B.b
            = FULL OUTER JOIN
*/
-- emp : empno, ename, job, hiredate, sal, DESCRIPTION
-- dept : dname, category, deptno
-- => 공통으로 사용되는 컬럼 : deptno

/*
    BOOK
        booki
        bookname
        publisher
        price
    CUSTOMER
        custid
        name
        address
        phone
    ORDERS
        orderid
        custid
        bookid
        saleprice
        orderdate
*/