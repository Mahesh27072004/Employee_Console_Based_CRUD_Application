package com.dao;

import com.dto.EmployeeDTO;

import java.util.ArrayList;

// in dao layer we call this java file as repository also
public interface CrudEmployeeRepository {
    String insert(EmployeeDTO dto);
    String read(String username, String password);

    String updateName(int eid, String ename,String password);

    String updateSal(int eid, int esalary, String password);

    String updateEaddress(int eid, String eaddress, String password);
    String updateUsername(int eid, String username, String password);
    String updatePassword(int eid, String newPassword, String oldPassword);

    String delete(int eid, String password);

    ArrayList<EmployeeDTO> readAll();
}
