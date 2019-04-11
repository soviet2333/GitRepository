package dao;

import entity.Dept;
import entity.Emp;

import java.io.Serializable;
import java.util.List;

public class EmpDao extends BaseDao{
    public List<Emp> findByDept(Dept dept){
        String hql = "from Emp where dept = ?";
        return currentSession().createQuery(hql).setParameter(0,dept).list();
    }
    public List<Emp> findAll(String sql){
        String hql = "from "+sql+"";
        return currentSession().createQuery(hql).setParameter(0,sql).list();
    }
    public Emp load(Serializable empno){
        return (Emp)currentSession().load(Emp.class,empno);
    }



}
