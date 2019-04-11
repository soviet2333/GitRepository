package dao;

import entity.Dept;

import java.io.Serializable;
import java.util.List;

public class DeptDao extends BaseDao{
    public Dept load(Serializable deptno){ return currentSession().load(Dept.class,deptno); }
    public void save(Dept dept){
        currentSession().save(dept);
    }
    public void delete(Dept dept){
        currentSession().delete(load(dept.getDeptno()));
    }

    /**
     * 内联查询
     * @return
     */
    public List<Object[]> select(){
        String hql = "from Dept d inner join d.empSet"; //inner 可以省略
        return currentSession().createQuery(hql).list();
    }

    /**
     * 迫切内联查询
     * @return
     */
    public List<Dept> select2(){
        String hql = "from Dept d inner join fetch d.empSet"; //inner 可以省略  distinct可以排掉重复的对象
        //String hql2 = "from Emp e where e.dept.deptName = ?"; 隐式内链接
        return currentSession().createQuery(hql).list();
    }

    /**
     * 左外连接
     * @return
     */
    public List<Dept> select3(){
        String hql = "from Dept d left join fetch d.empSet"; //
        return currentSession().createQuery(hql).list();
    }
    /**
     * 对于Query接口的list()方法与iterate()方法来说，都可以实现获取查询的对象，
     * 但是list()方法返回的每个对象都是完整的（对象中的每个属性都被表中的字段填充上了），
     * 而iterator()方法所返回的对象中仅包含了主键值（标识符），
     * 只有当你对iterator中的对象进行操作时，
     * Hibernate才会向数据库再次发送SQL语句来获取该对象的属性值。
     * 函数
     * min(); 最小值
     * max(); 最大值
     * avg(); 平均值
     *        如果不清楚返回值的类型，可以使用 变量名.getClass().getName();查看类型
     * 操作set的函数
     * size()或者size 获得set的大下坡
     * minIndex() 或者 minIndex 对于建了索引的集合，获得最小的索引
     * maxIndex() 或者 maxIndex 对于建了索引的集合，获得最大的索引
     * elements() 获取集合中的所有元素
     * minElement() 或者 minElement 获得最小的元素
     * maxElement() 或者 maxElement 获得最大的元素
     */
    public Object select4(){
        //String hql = "select count(id) from Dept"; 求总条数
        String hql = "select sum(id) from Dept";
        return currentSession().createQuery(hql).uniqueResult();
    }
}
