package until;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CurrentSession {
    private static Configuration configuration;
    private final static SessionFactory sessionfactory;

    static {
        try{
            configuration = new Configuration().configure();//解析xml文件
            //读取xml节点生成session工厂
            sessionfactory = configuration.buildSessionFactory();
        }catch (HibernateException e){
            throw new ExceptionInInitializerError(e);
        }
    }
    private CurrentSession(){

    }

    /**
     * 获取Session
     * @return
     */
    public static Session currentSession(){
        return sessionfactory.getCurrentSession();
    }
}
