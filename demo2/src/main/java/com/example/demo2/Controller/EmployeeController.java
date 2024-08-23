package com.example.demo2.Controller;

import com.example.demo2.DTO.EmployeeDTO;
import com.example.demo2.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public EmployeeDTO getoneEmployee(@PathVariable("id") Integer id) {
        return employeeService.getoneEmployee(id);
    }
    @PostMapping
    public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.savedelelteEmployee(employeeDTO);
        return new ResponseEntity<>("Employee successfully saved or updated!", HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
        try {
            employeeService.delelteEmployee(id);
            return new ResponseEntity<>("Employee successfully deleted!", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Employee not found with id: " + id, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> UpdaEmployee(@PathVariable("id") int id,@RequestBody  EmployeeDTO employeeDTO) {
        try {
            employeeService.updateEmployee(id, employeeDTO);
            return new ResponseEntity<>("Employee successfully updated!", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Employee not found with id: " + id, HttpStatus.NOT_FOUND);
        }
    }
}
