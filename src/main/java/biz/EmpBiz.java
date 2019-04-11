package biz;

import dao.DeptDao;
import dao.EmpDao;
import entity.Dept;
import entity.Emp;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import until.CurrentSession;

import java.io.Serializable;
import java.util.List;

public class EmpBiz {
    private EmpDao empDao = new EmpDao();
    public List<Emp> findByDept(Dept dept){
        Transaction tx = null;
        List<Emp> empList = null;
        try{
            tx = empDao.currentSession().beginTransaction();
            empList = empDao.findByDept(dept);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null) {
                tx.rollback();
            }
        }
        return empList;
    }

    /**
     * 查询全部
     * @return
     */
    public List<Emp> findAll(){
        Transaction tx = null;
        List<Emp> empList = null;
        String sql = "Emp";
        try {
            tx = empDao.currentSession().beginTransaction();
            empList = empDao.findAll(sql);
            for (Emp emp : empList) {
                System.out.print("员工名字"+emp.getEname()+"员工所在部门为"+emp.getDept().getDname()+"\n");
            }
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }
        return empList;
    }
    /**
     * 查询单个
     */
    /*public Emp load(Integer empno){
        Transaction tx = null;
        Emp emp = null;
        try {
            tx = empDao.currentSession().beginTransaction();
            emp = empDao.load(empno);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
        }
        return emp;
    }*/

    public Emp changeDept(long empno,long deptno){
        Transaction tx = null;
        Emp emp = null;
        try {
            tx = CurrentSession.currentSession().beginTransaction();
            emp = empDao.load(empno);
            Dept dept = new DeptDao().load(deptno);
            emp.setDept(dept);
            dept.getEmpSet().add(emp);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
        return emp;
    }
}
