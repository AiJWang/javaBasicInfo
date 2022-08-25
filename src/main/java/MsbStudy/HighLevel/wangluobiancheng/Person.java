package MsbStudy.HighLevel.wangluobiancheng;

import java.io.Serializable;

public class Person implements Serializable {
    private String usrName;
    private String pwd;

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
