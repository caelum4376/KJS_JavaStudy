-- 2023-05-15 오ㅋ라클 2일차 (155page) ORDER BY (정렬)
/* 
        정렬 : 
            1) 내림차순(DESC), 올림차순(ASC) => 생략이 가능
                EX) 사원정보 => 급여가 많은 순서
                SELECT *
                FROM EMP
                ORDER BY SAL DESC;

                사원정보 => 급여가 작은 순서
                SELECT *
                FROM EMP
                ORDER BY SAL;
                => EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO -- 컬럼순서
                SELECT *
                FROM EMP
                ORDER BY SAL(6) ASC;
                            --- 생략이 가능하다
                        1     2      3
                SELECT ENAME, SAL, HIREDATE
                FROM EMP
                ORDER BY 2 => 컬럼의 위치 지정 => 2번쨰 있는 컬럼을 이용해서 정렬
                오라클은 자동 정렬이 되어있지 않다
            
            2) 이중 정렬 => 답변형 게시판
               ---------
               ORDER BY SAL ASC, ENAME DESC
                        -------- 같은 값이 있는 경우 => ENAME정렬 
*/
