package com.emreunaldi.springboot.business.services.impl;

import com.emreunaldi.springboot.business.dto.EmployeeDto;
import com.emreunaldi.springboot.business.services.EmployeeServices;
import com.emreunaldi.springboot.data.entity.EmployeeEntity;
import com.emreunaldi.springboot.data.repository.EmployeeRepository;
import com.emreunaldi.springboot.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeServices {
    // Service kısmında db ile ilgili işlemleri burda yaparız
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;


    // LIST
    // localhost:8000/api/v1/employess
    @GetMapping("/employees")
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        Iterable<EmployeeEntity> employeeEntityList = employeeRepository.findAll();

        for (EmployeeEntity employee : employeeEntityList) {
            EmployeeDto employeeDto = entityToDto(employee);
            employeeDtoList.add(employeeDto);
        }
        return employeeDtoList;
    }


    // SAVE
    // localhost:8000/api/v1/employess
    @PostMapping("/employees")
    @Override
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = dtoToEntity(employeeDto);
        employeeRepository.save(employeeEntity);

        return employeeDto;
    }


    // FIND
    // localhost:8000/api/v1/employess/1
    @GetMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) throws Throwable {
        EmployeeEntity employeeEntity = (EmployeeEntity) employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id : " + id));
        EmployeeDto employeeDto = entityToDto(employeeEntity);

        return ResponseEntity.ok(employeeDto);
    }


    // UPDATE
    // localhost:8000/api/v1/employess/1
    @PutMapping("/employess/{id}")
    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDetails) throws Throwable {
        EmployeeEntity employeeEntity = dtoToEntity(employeeDetails); // ModelMapper
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id : " + id));

        employee.setFirstName(employeeEntity.getFirstName());
        employee.setEmailId(employeeEntity.getEmailId());
        employee.setLastName(employeeEntity.getLastName());

        EmployeeEntity updatedEmploye = (EmployeeEntity) employeeRepository.save(employee);
        EmployeeDto employeeDto = entityToDto(updatedEmploye);

        return ResponseEntity.ok(employeeDto);
    }


    // DELETE
    // localhost:8000/api/v1/employess/1
    @DeleteMapping("/employess/{id}")
    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) throws Throwable {
        EmployeeEntity employeeEntity = (EmployeeEntity) employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id : " + id));
        employeeRepository.delete(employeeEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }


    // ----------------------------------------- Model Mapper
    @Override
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = modelMapper.map(employeeEntity, EmployeeDto.class);
        return employeeDto;
    }


    @Override
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        return employeeEntity;
    }
}
