package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository EmployeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        EmployeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return EmployeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = EmployeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return EmployeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        EmployeeRepository.deleteById(theId);
    }
}
