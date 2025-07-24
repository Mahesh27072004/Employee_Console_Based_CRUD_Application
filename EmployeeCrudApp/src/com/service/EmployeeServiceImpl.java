package com.service;

import com.dao.CrudEmployeeRepository;
import com.dao.CrudEmployeeRepositoryImpl;
import com.dto.EmployeeDTO;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.ArrayList;

public class EmployeeServiceImpl implements  EmployeeService {
    private String result;
    private CrudEmployeeRepository crudEmp;
    public EmployeeServiceImpl(){
        this.crudEmp = new CrudEmployeeRepositoryImpl();
    }
    @Override
    public String insertService(EmployeeDTO dto){

        String result = validate(dto);
        if(result.equals("Valid")){
            //Data will be passed to dao layer from here
            return crudEmp.insert(dto);
            // result will be sent back to controller
        }else{
            return result;
            // if data is invalid then result will sent back to controller layer
        }

    }

    public String validate(EmployeeDTO dto) {
        int eid = dto.getEid();
        String ename = dto.getEname();
        String eaddress = dto.getEaddress();
        int esal = dto.getEsalary();
        String username = dto.getUsername();
        String password = dto.getPassword();

        String result = null;
        if (eid < 1 || eid > 999) {
            result = "Invalid ID: must be between 1 to 999";
        } else if (ename.length() < 2 || ename.length() > 50) {
            result = "Invalid employee name: must be between 2 and 50 characters";
        } else if (eaddress.length() < 5 || eaddress.length() > 100) {
            result = "Invalid address: must be between 5 and 100 characters.";
        }else if(esal<=0 || esal>100000){
            result = "Invalid Salary";
    }else if (username.length()<6 || username.length()>30) {
            result = "Invalid username: username must be between 6 and 30 characters.";
        } else if (password.length()<8 || password.length()>20) {
            result = "Invalid password: password must be between 8 and 20 characters.";
        }else{
            result="Valid";
        }

        return result;
    }

    public String readService(String username,String  password){
        result = validate(username, password);
        if(result.equals("Valid")){
            return crudEmp.read(username, password);
            // result will be sent back to controller
        }else{
            return result;
            // if data is invalid then result will sent back to controller layer
        }
    }
    public String validate(String username, String password) {
        if (username.length()<6 || username.length()>30) {
            result = "Invalid username: username must be between 6 and 30 characters.";
        } else if (password.length()<8 || password.length()>20) {
            result = "Invalid password: password must be between 8 and 20 characters.";
        }else{
            result="Valid";
        }

        return result;
    }
    public ArrayList<EmployeeDTO> readAllService(){
            return crudEmp.readAll();
    }


    public String updateENameService(int eid, String ename, String password){
        result = validateEname(eid, ename, password);
        if(result.equals("Valid")){
            return crudEmp.updateName(eid, ename, password);
        }else{
            return result;
        }
    }
    public String validateEname(int eid, String ename, String password) {
        if (eid<1 || eid>999) {
            result = "Invalid Employee Id: id must be between 1 to 999.";
        } else if (ename.length()<6 || ename.length()>30) {
            result = "Invalid Employee name: password must be between 6 and 30 characters.";
        }else if (password.length()<8 || password.length()>20) {
            result = "Invalid password: password must be between 8 and 20 characters.";
        }else{
            result="Valid";
        }
        return result;
    }

    public String updateEsalaryService(int eid, int esalary, String password){
        result = validateSal(eid, esalary, password);
        if(result.equals("Valid")){
            return crudEmp.updateSal(eid, esalary, password);
        }else{
            return result;
        }
    }
    public String validateSal(int eid, int esalary, String password) {
        if (eid<1 || eid>999) {
            result = "Invalid Employee Id: id must be between 1 to 999.";
        } else if (esalary<100 || esalary>100000) {
            result = "Invalid Employee salary: salary must be between 100 and 100000.";
        } else if (password.length()<8 || password.length()>20) {
            result = "Invalid password: password must be between 8 and 20 characters.";
        } else{
            result="Valid";
        }
        return result;
    }

    public String updateEaddressService(int eid, String eaddress, String password){
        result = validateEaddress(eid, eaddress, password);
        if(result.equals("Valid")){
            return crudEmp.updateEaddress(eid, eaddress, password);
        }else{
            return result;
        }
    }
    public String validateEaddress(int eid, String eaddress, String password) {
        if (eid<1 || eid>999) {
            result = "Invalid Employee Id: id must be between 1 to 999.";
        } else if (eaddress.length() < 5 || eaddress.length() > 100) {
            result = "Invalid address: must be between 5 and 100 characters.";
        }else if (password.length()<8 || password.length()>20) {
            result = "Invalid password: password must be between 8 and 20 characters.";
        } else{
            result="Valid";
        }
        return result;
    }

    public String updateUsernameService(int eid, String username, String password){
        result = validateUser(eid, username, password);
        if(result.equals("Valid")){
            return crudEmp.updateUsername(eid, username, password);
        }else{
            return result;
        }
    }
    public String validateUser(int eid, String username, String password) {
        if (eid<1 || eid>999) {
            result = "Invalid Employee Id: id must be between 1 to 999.";
        } else if (username.length() < 6 || username.length() > 30) {
            result = "Invalid username: must be between 6 and 30 characters.";
        }else if (password.length()<8 || password.length()>20) {
            result = "Invalid password: must be between 8 and 20 characters.";
        } else{
            result="Valid";
        }
        return result;
    }

    public String updatePasswordService(int eid, String newPassword, String oldPassword){
        result = validatepass(eid, newPassword, oldPassword);
        if(result.equals("Valid")){
            return crudEmp.updatePassword(eid, newPassword, oldPassword);
        }else{
            return result;
        }
    }
    public String validatepass(int eid, String newPassword, String password) {
        if (eid<1 || eid>999) {
            return  "Invalid Employee Id: id must be between 1 to 999.";
        } else if (newPassword.length() < 8 || newPassword.length() > 20) {
            return  "Invalid new password: must be between 8 and 20 characters.";
        }else if (password.length()<8 || password.length()>20) {
            return  "Invalid old password: must be between 8 and 20 characters.";
        } else{
            return "Valid";
        }
    }

    public String deleteService(int eid, String password){
        result = validateDel(eid, password);
        if(result.equals("Valid")){
            return crudEmp.delete(eid, password);
        }else{
            return result;
        }
    }
    public String validateDel(int eid, String password){
        if (eid<1 || eid>999) {
            return  "Invalid Employee Id: id must be between 1 to 999.";
        } else if (password.length() < 8 || password.length() > 20) {
            return  "Invalid new password: must be between 8 and 20 characters.";
        }else {

            return "Valid";
        }
    }

}
