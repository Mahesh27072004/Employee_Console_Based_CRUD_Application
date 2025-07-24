package com.service;


import com.dto.EmployeeDTO;

import java.util.ArrayList;

// benefits of interface
// 1. works as standardization(contract or design or blueprint)
// 2. helps to achieve multiple inheritance
// 3. runtime polymorphism
// 4. loose coupling
public interface EmployeeService {
    String insertService(EmployeeDTO dto);
    String readService(String username, String password);

    String updateENameService(int eid, String ename,String password);
    String updateEsalaryService(int eid, int esalary, String password);
    String updateEaddressService(int eid, String eaddress, String password);
    String updateUsernameService(int eid, String username, String password);

    String updatePasswordService(int eid, String newPassword, String oldPassword);

    String deleteService(int eid, String password);

    ArrayList<EmployeeDTO> readAllService();
}
