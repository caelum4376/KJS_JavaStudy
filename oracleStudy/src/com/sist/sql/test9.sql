-- 2023-05-16 JOIN / SUBQUERY => 고급쿼리
/*
    JOIN
    ----
      두개 이상의 테이블에 필요한 데이터를 추출하는 명령어 (테이블을 나눠서 처리 => 정규화)
      정규화 : 중복을 제거, 단일값을 설정
      다른 테이블 : JOIN
      같은 테이블 : SELF JOIN
      ------------------------> 이차 for => IF
      조인의 종류
       => INNER JOIN ======> 교집합 (INTERSECT)
          주의점
            => 같은 컬럼명을 사용하는지 확인
               ----------- table명.컬럼명
               ----------- 별칭명.컬럼명
               별칭을 사용할때는
               FROM 테이븖명 별칭명 => FROM EMP E
            => 여러개의 테이블 지정
                FROM 테이블명, 테이블명
            => 중요시 => NULL값인 경우에는 처리가 불가능 => 보완 (OUTER JOIN)
            => 조건이 있는 경우는 반드시 AND
            => 자바에서는 조인을 포함클래스라고 한다
                class Emp {
                    Dept d = new Dept()
                }
                class Dept {}
            => INNER JOIN (INTERSECT)
         1) EQUI_JOIN (=연산자 값이 같은 경우) 
            => Oracle JOIN
            SELECT EMPNO, ENAME, JOB, HIREDATE, DNAME, LOC
                   ---------------------------  ----------
                                EMP                DEPT  
            FROM EMP, DEPT
            WHERE EMP.DEPTNO = DEPT.DEPTNO;
            => ANSI JOIN (모든 데이터베이스에서 사용이 가능)
            SELECT EMPNO, ENAME, JOB, HIREDATE, DNAME, LOC
            FROM EMP JOIN DEPT
            ON EMP.DEPTNO = DEPT.DEPTNO;
            
         2) NON_EQUI_JOIN (=외의 다른 연산자 사용 => BETWEEN ~ AND)
         ----------------------- 다른 컬럼명일떄도 가능 (같은 값을 가지고 있다)
         3) NATURAL JOIN ()
         4) JOIN~USING
         => Oracle JOIN
         => ANSI JOIN
       => OUTER JOIN
*/