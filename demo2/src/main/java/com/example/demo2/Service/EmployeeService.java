package com.example.demo2.Service;

import com.example.demo2.DTO.EmployeeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployee();
    EmployeeDTO getoneEmployee(Integer id);
    void delelteEmployee(int id);
    ResponseEntity<EmployeeDTO> savedelelteEmployee(EmployeeDTO employeeDTO);
    ResponseEntity<EmployeeDTO> updateEmployee(Integer id, EmployeeDTO employeeDTO);
}
