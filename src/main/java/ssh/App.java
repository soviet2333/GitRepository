package ssh;


import biz.DeptBiz;
import entity.Dept;
import entity.Emp;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    /**
     * 测试查询
     */

    public void select() {
        DeptBiz deptBiz = new DeptBiz();
        List<Object[]> list = deptBiz.select();
        for (Object[] object:list){
            for (int i = 0; i < object.length; i++) {
                if(object[i] instanceof Dept){
                    Dept dept = (Dept)object[i];
                    System.out.print("地名"+dept.getLoc()+"\t");
                }else if(object[i] instanceof Emp){
                    Emp emp = (Emp)object[i];
                    System.out.println("员工名字"+emp.getEname());
                }
            }
        }
    }

    /**
     * 测试迫切内链接查询
     * 测试左外链接查询
     */
    @Test
    public void select2(){
        DeptBiz deptBiz = new DeptBiz();
        //List<Dept> list = deptBiz.select2();
        List<Dept> list = deptBiz.select3();
        for (Dept dept : list){
            System.out.print("部门名字"+dept.getDname()+"\t\n");
            Iterator<Emp> iterator = dept.getEmpSet().iterator();
            while (iterator.hasNext()){
                Emp emp = iterator.next();
                System.out.println("员工名字"+emp.getEname());
            }
        }
    }

    /**
     * 函数
     */

    public void select4(){
        DeptBiz deptBiz = new DeptBiz();
        long count = (long)deptBiz.select4();
        System.out.println(count);
    }
}
