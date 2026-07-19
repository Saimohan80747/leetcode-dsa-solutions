# Write your MySQL query statement below
with t as(
    select d.name as Department,e.name as Employee,e.salary, dense_rank() over(partition by d.name order by e.salary desc) as rnk
     from
    Employee e inner join Department d  on e.departmentId=d.id 
)

select t.Department,t.Employee,t.salary from t
where t.rnk<4
