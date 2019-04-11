package dao;

import org.hibernate.Session;
import until.CurrentSession;

public class BaseDao {
    public Session currentSession(){
        return CurrentSession.currentSession();
    }
}
