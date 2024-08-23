package com.example.demo2.Service;

import com.example.demo2.DTO.EmployeeDTO;
import com.example.demo2.Repository.EmployeeRepository;
import com.example.demo2.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    private EmployeeDTO convertToDTO(EmployeeEntity employee) {
        // Implement conversion logic from Employee to EmployeeDTO
        return new EmployeeDTO(employee.getId(),employee.getIndentifer(), employee.getFirstname(), employee.getLastname(), employee.getEmail(), employee.getDate(), employee.getRole());
    }

    private EmployeeEntity convertToEntity(EmployeeDTO employeeDTO) {
        // Implement conversion logic from EmployeeDTO to Employee
        return new EmployeeEntity(employeeDTO.getId(), employeeDTO.getIndentifer(),employeeDTO.getFirtname(), employeeDTO.getLastname(), employeeDTO.getEmail(), employeeDTO.getDate(), employeeDTO.getRole());
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return employeeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getoneEmployee(Integer id) {
        Optional<EmployeeEntity> optionalStudent = employeeRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return convertToDTO(optionalStudent.get());
        } else {
            throw new RuntimeException("Student not found with id " + id);
        }
    }
    @Override
    public void delelteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }
    @Override
    public ResponseEntity<EmployeeDTO> savedelelteEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employee = convertToEntity(employeeDTO);
        EmployeeEntity savedemployee = employeeRepository.save(employee);
        EmployeeDTO resultDTO = convertToDTO(savedemployee);
        return ResponseEntity.ok(resultDTO);
    }
    @Override
    public ResponseEntity<EmployeeDTO> updateEmployee(Integer id, EmployeeDTO employeeDTO) {
        if (employeeRepository.existsById(id)) {
            EmployeeEntity employee = convertToEntity(employeeDTO);
            employee.setId(id);
            EmployeeEntity updatedEmployee = employeeRepository.save(employee);
            EmployeeDTO updatedEmployeeDTO = convertToDTO(updatedEmployee);
            return ResponseEntity.ok(updatedEmployeeDTO);
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

}
