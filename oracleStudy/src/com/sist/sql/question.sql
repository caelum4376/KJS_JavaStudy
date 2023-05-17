
-- 문제풀이
/*
    1. emp에서 급여가 2000 이상인 사람을 출력하세요.

    Select * from emp where sal >= 2000;

    2. emp에서 급여 sal가 2000 이상인 사람의 이름 ename과 사번 empno을 출력하세요.

    Select ename, empno from emp where sal >= 2000;

    3. emp에서 이름이 'FORD'인 사람의 사번 empno과 급여 sal을 출력하세요

    select empno, sal from emp where ename = 'FORD';

    4. emp에서 입사일자 hiredate가 82년 이후에 입사한 사람의
       이름과 입사일자를 출력하세요.
    (날짜를 넣을때는 YY/MM/DD형태를 사용하면된다.)

    SELECT ename, hiredate FROM emp WHERE hiredate >= '82/01/01';

    5. emp에서 이름이 J가 들어가는 사원의 이름과 사번을 출력하세요.

    SELECT ename, empno FROM emp WHERE ename LIKE '%J%';

    6. emp에서 이름이 S로 끝나는 사원의 이름과 사번을 출력하세요.

    SELECT ename, empno FROM emp WHERE ename LIKE '%S';

    7. emp에서 이름의 두번째 글자가 A가 들어가는 사원의 이름과 사번을 출력하세요.

    SELECT ename, empno FROM emp WHERE ename LIKE '_A%';

    8. emp에서 보너스가 300이거나 5000이거나 1400인 사람의
        이름, 사번, 보너스를 출력하세요.

    SELECT ename, empno, comm FROM emp WHERE comm IN (300, 5000, 1400);

    9. emp에서 보너스가 500에서 4000 사이의 사원의 이름과 사번, 보너스를 출력하세요.
    SELECT ename, empno, comm FROM emp WHERE comm BETWEEN 500 AND 4000;

    10. emp에서 부서가 10이고 직책이 CLERK인
         직원이름,사번,직책(job),부서(deptno)를 출력하세요.

    SELECT ename, empno, job, deptno FROM emp WHERE deptno = 10 AND job = 'CLERK';

    11. emp에서 입사일자가 82년 이후이거나 직책이 MANAGER인 사람의
         이름과 입사일자를 출력하세요.

    SELECT ename, hiredate FROM emp WHERE hiredate >= '82/01/01' OR job = 'MANAGER'; 

    12. emp에서 부서번호가 10이 아닌 직원의 사번,이름,부서번호를 출력하세요.

    SELECT empno, ename, deptno FROM emp WHERE deptno != 10;

    13. emp에서 이름에 A가 없는 직원의 사번과 이름을 출력하세요.

    SELECT empno, ename FROM emp WHERE ename NOT LIKE '%A%';

    14. emp에서 보너스가 500에서 1400이 아닌 직원의 사번과 보너스를 출력하세요.

    SELECT empno, comm FROM emp WHERE comm NOT BETWEEN 500 AND 1400 OR comm IS NULL;

    15. emp에서 매니저를 갖지 않은 직원이름을 출력하세요.
    -- null값은 is null로 표현한다.

    SELECT ename FROM emp WHERE mgr IS NULL;

    16. emp에서 커미션을 받는(커미션이 null값이 아닌) 직원이름과 커미션을 출력하세요.

    SELECT ename, comm FROM emp WHERE comm IS NOT NULL;

    17. emp에서 사번, 이름, 급여를 출력하는데 급여가 적은사람부터 출력하세요.

    SELECT empno, ename, sal FROM emp ORDER BY sal;

    18. emp에서 사번, 이름, 급여를 출력하는데 급여가 많은 사람부터 출력하세요.

    SELECT empno, ename, sal FROM emp ORDER BY sal DESC;

    19. emp에서 사번, 이름, 급여를 출력하는데 이름이 빠른사람부터 출력하세요.

    SELECT empno, ename, sal FROM emp ORDER BY ename;

    20. emp에서 사번, 이름, 입사일을 출력하는데 입사일자가 최근인 사람부터 출력하세요.

    SELECT empno, ename, hiredate FROM emp ORDER BY hiredate DESC;

    21. emp에서 사번, 이름, 급여를 출력하는데 먼저 급여가 많은 순서로
         그리고 이름이 빠른 순서로 정열하세요.

    SELECT empno, ename, sal FROM emp ORDER BY sal DESC, ename;

*/

-- 1. 각 부서별로 최대 급여를 구하세요
select deptno, max(sal)
from EMP
group by deptno;

-- 2. 각 직급별로 최대 급여를 구하세요
select job, max(sal)
from emp
group by job;

-- 3. 각 부서별로 평균 급여를 구하세요
select deptno "부서번호", sum(sal), avg(sal) "평균급여"
from EMP
group by deptno;

-- 4. 각 직급 별의 인원수를 구하세요
select job, count(*)
from EMP
group by job;

-- 5. 각 부서별 보너스를 받는 인원수 출력
select deptno, count(*)
from EMP
where comm is not null
group by DEPTNO;

-- 6. 각 년도별로 입사한 인원수를 구하세요
select to_char(hiredate, 'rrrr'), count(*)
from EMP
group by to_char(hiredate, 'rrrr');

-- 7. 부서별 평균급여를 구하고 그 결과 평균급여가 2000 이상인 부서만 출력하세요
select deptno, avg(sal)
from EMP
group by deptno
having avg(sal) >= 2000
order by deptno