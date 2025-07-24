package com.dto;

public class EmployeeDTO {
    private String username;
    private String password;
    private  int eid ;
    private String ename;
    private String eaddress;
    private int esalary;

    public EmployeeDTO(String username, String password,int eid, String ename, String eaddress, int esalary) {
        this.username = username;
        this.password=password;
        this.eid = eid;
        this.ename = ename;
        this.eaddress = eaddress;
        this.esalary = esalary;
    }

    public int getEid() {
        return eid;
    }

    public String getEname() {
        return ename;
    }

    public int getEsalary() {
        return esalary;
    }

    public String getEaddress() {
        return eaddress;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setEaddress(String eaddress) {
        this.eaddress = eaddress;
    }

    public void setEsalary(int esalary) {
        this.esalary = esalary;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", eid=" + eid +
                ", ename='" + ename + '\'' +
                ", eaddress='" + eaddress + '\'' +
                ", esalary=" + esalary +
                '}';
    }
}
