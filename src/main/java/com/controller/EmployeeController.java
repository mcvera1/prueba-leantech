package com.controller;

import com.controller.dto.EmployeeDto;
import com.gateway.model.Employee;
import com.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get/employees")
    public List<EmployeeDto> getEmployee(@RequestParam(value = "name", required = false) String name,
                                         @RequestParam(value = "position", required = false) String position) {
        return EmployeeResponse.fromModel(employeeService.getEmployee(name, position));
    }

    @PostMapping("/create/employee")
    public void saveEmployee(@RequestBody EmployeeService.EmployeeRequest request) {
        employeeService.createEmployee(request);
    }

    @PutMapping("/update/employee")
    public Employee updateEmployee(@RequestBody EmployeeService.EmployeeRequest request) {
        return employeeService.updateEmployee(request);
    }

    @DeleteMapping("/delete/employee/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
