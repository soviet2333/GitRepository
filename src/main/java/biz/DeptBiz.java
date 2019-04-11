package biz;

import dao.DeptDao;
import entity.Dept;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import java.util.List;

public class DeptBiz {
    private DeptDao deptDao = new DeptDao();

    /**
     * 内联查询
     * @return
     */
    public List<Object[]> select(){
        Transaction tx = null;
        Dept dept = null;
        List<Object[]> list = null;
        try {
            tx = deptDao.currentSession().beginTransaction();
            list = deptDao.select();
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
        return list;
    }

    /**
     * 内联迫切查询
     * @return
     */
    public List<Dept> select2(){
        Transaction tx = null;
        List<Dept> list = null;
        try {
            tx = deptDao.currentSession().beginTransaction();
            list = deptDao.select2();
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
        return list;
    }
    /**
     * 左外连接
     * @return
     */
    public List<Dept> select3(){
        Transaction tx = null;
        List<Dept> list = null;
        try {
            tx = deptDao.currentSession().beginTransaction();
            list = deptDao.select3();
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
        return list;
    }
    /**
     * 函数
     */
    public Object select4(){
      Transaction tx = null;
      long count = 0;
      try{
          tx = deptDao.currentSession().beginTransaction();
          count = (long)deptDao.select4();
          tx.commit();
      }catch (HibernateException e){
          e.printStackTrace();
          if(tx!=null){
              tx.rollback();
          }
      }
      return count;
    }



























    /*public Dept load(Integer deptNo){
        Transaction tx = null;
        Dept dept = null;
        try {
            tx = deptDao.currentSession().beginTransaction();
            dept = deptDao.load(deptNo);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
        return dept;
    }*/

    public void save(Dept dept){

    }

    public void delete(Dept dept){
        Transaction tx = null;
        try {
            tx = deptDao.currentSession().beginTransaction();
            deptDao.delete(dept);
            tx.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            if(tx!=null){
                tx.rollback();
            }
        }
    }
}
