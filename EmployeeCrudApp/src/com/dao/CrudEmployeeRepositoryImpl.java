package com.dao;

import com.dto.EmployeeDTO;
import com.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CrudEmployeeRepositoryImpl implements CrudEmployeeRepository{
    private String result;
    private PreparedStatement ps;

    public String insert(EmployeeDTO dto){
        try {
            String sql = "insert into xyz.mytable(eid,ename,eaddress,esalary,username,password) values(?,?,?,?,?,?);";
            Connection conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,dto.getEid());
            ps.setString(2,dto.getEname());
            ps.setString(3,dto.getEaddress());
            ps.setInt(4,dto.getEsalary());
            ps.setString(5,dto.getUsername());
            ps.setString(6,dto.getPassword());
            int i = ps.executeUpdate();

            if(i>0){
                result = "data inserted successfully!";
            }else{
                result = "Something went wrong";
            }
        }catch (Exception e){
            e.printStackTrace();
            result = "Something went wrong";
        }
        return result;
    }

    public String read(String username, String password){
        try {
            String sql = "select * from xyz.mytable where username=? and password=?";
            Connection conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(sql);
//            System.out.println("debug1");
            ps.setString(1,username);
//            System.out.println("debug2");
            ps.setString(2,password);
//            System.out.println("debug3");
            ResultSet rs = ps.executeQuery();


            if(rs.next()){
                int eid = rs.getInt("eid");
                String ename = rs.getString("ename");
                String eaddress = rs.getString("eaddress");
                String esalary = rs.getString("esalary");

                System.out.println("Retrieving data....");
                result = eid+"->"+ename+"->"+eaddress+"->"+esalary;
            }else{
                result = "No record of this user!!!";
            }
        }catch (Exception e){
            e.printStackTrace();
            result = "Something went wrong";
        }
        return result;
    }
    public ArrayList<EmployeeDTO> readAll(){
        ArrayList<EmployeeDTO> empDTO = new ArrayList<>();
        try {
            String sql = "select * from xyz.mytable";
            Connection conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int eid = rs.getInt("eid");
                String ename = rs.getString("ename");
                String eaddress = rs.getString("eaddress");
                int esalary = rs.getInt("esalary");
                String username = rs.getString("username");
                String password = rs.getString("password");

                EmployeeDTO dto = new EmployeeDTO( username,password, eid, ename, eaddress, esalary);
                empDTO.add(dto);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return empDTO;
    }
    public String updateName(int eid, String ename,String password){
        try {
            String sql = "update xyz.mytable set ename=? where eid=? and password=?";
            Connection conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,ename);
            ps.setInt(2,eid);
            ps.setString(3,password);
            int i= ps.executeUpdate();
            if(i>0){
                result= "Employee name updated successfully";
            }else{
                result = "No record found with matching eid and password!!!";
            }
        }catch (Exception e){
            e.printStackTrace();
            result = "Something went wrong";
        }
        return result;
    }
    public String updateSal(int eid, int esalary,String password){
        try {
            String sql = "update xyz.mytable set esalary=? where eid=? and password=?";
            Connection conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,esalary);
            ps.setInt(2,eid);
            ps.setString(3,password);
            int i= ps.executeUpdate();
            if(i>0){
                result= "Salary updated successfully!";
            }else{
                result = "No record found with matching eid and password!!!";
            }
        }catch (Exception e){
            e.printStackTrace();
            result = "Something went wrong";
        }
        return result;
    }

    public String updateEaddress(int eid, String eaddress,String password){
        try {
            String sql = "update xyz.mytable set eaddress=? where eid=? and password=?";
            Connection conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,eaddress);
            ps.setInt(2,eid);
            ps.setString(3,password);
            int i= ps.executeUpdate();
            if(i>0){
                result= "Employee address updated successfully";
            }else{
                result = "No record found with matching eid and password!!!";
            }
        }catch (Exception e){
            e.printStackTrace();
            result = "Something went wrong";
        }
        return result;
    }

    public String updateUsername(int eid, String username,String password){
        try {
            String sql = "update xyz.mytable set username=? where eid=? and password=?";
            Connection conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setInt(2,eid);
            ps.setString(3,password);
            int i= ps.executeUpdate();
            if(i>0){
                result= "username updated successfully";
            }else{
                result = "No record found with matching eid and password!!!";
            }
        }catch (Exception e){
            e.printStackTrace();
            result = "Something went wrong";
        }
        return result;
    }
    public String updatePassword(int eid, String newPassword,String oldPassword){
        try {
            String sql = "update xyz.mytable set password=? where eid=? and password=?";
            Connection conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,newPassword);
            ps.setInt(2,eid);
            ps.setString(3,oldPassword);
            int i= ps.executeUpdate();
            if(i>0){
                result= "password updated successfully";
            }else{
                result = "No record found with matching eid and password!!!";
            }
        }catch (Exception e){
            e.printStackTrace();
            result = "Something went wrong";
        }
        return result;
    }

    public String delete(int eid, String password){
        try {
            String sql = "delete from xyz.mytable where password=? and eid=?";
            Connection conn = ConnectionFactory.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,password);
            ps.setInt(2,eid);
            int i= ps.executeUpdate();
            if(i>0){
                return  "record deleted successfully";
            }else{
                return  "No record found with matching eid and password!!!";
            }
        }catch (Exception e){
            e.printStackTrace();
            return  "Something went wrong";
        }

    }


}
