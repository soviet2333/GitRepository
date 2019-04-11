package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Dept implements Serializable {
    private long deptno;
    private String dname;
    private String loc;
    private Set<Emp> empSet = new HashSet<Emp>();

    public Set<Emp> getEmpSet() {
        return empSet;
    }

    public void setEmpSet(Set<Emp> empSet) {
        this.empSet = empSet;
    }

    public long getDeptno() {
        return deptno;
    }

    public void setDeptno(long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
