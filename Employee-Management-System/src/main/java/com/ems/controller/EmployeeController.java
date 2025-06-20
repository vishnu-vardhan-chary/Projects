package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ems.entity.Employee;
import com.ems.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
    
    @GetMapping("/ems")
    public String ems() {
        return "index";
    }
    
    @GetMapping("/about")
    public String about() {
        return "about";
    }
    
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
    
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "home";
    }
    
    @PostMapping("/searchByName")
    public String searchByName(@RequestParam("search_value") String name, Model model) {
        model.addAttribute("employees", employeeService.searchEmployeeByName(name));
        return "home";
    }
    
    @PostMapping("/searchBySalary")
    public String searchBySalary(@RequestParam("search_value") String salaryStr, Model model) {
        if (salaryStr.isEmpty()) {
            return "redirect:/home";
        }
        try {
            double salary = Double.parseDouble(salaryStr);
            model.addAttribute("employees", employeeService.searchEmployeeBySalary(salary));
        } catch (NumberFormatException e) {
            // Optionally, add an error message to the model if salary is not a valid number.
            model.addAttribute("error", "Invalid salary format");
            model.addAttribute("employees", employeeService.getAllEmployees());
        }
        return "home";
    }
    
    @PostMapping("/searchByAddress")
    public String searchByAddress(@RequestParam("search_value") String address, Model model) {
        model.addAttribute("employees", employeeService.searchEmployeeByAddress(address));
        return "home";
    }
    
    @GetMapping("/addEmployee")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "add_employee";
    }
    
    @PostMapping("/saveEmployee")
    public String saveEmployee(@Validated @ModelAttribute Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "add_employee";
        }
        employeeService.saveEmployee(employee);
        return "redirect:/home";
    }
    
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/home";
    }
    
    @GetMapping("/editEmployee/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        Employee emp = employeeService.getEmployee(id);
        model.addAttribute("employee", emp);
        return "update_employee";
    }
    
    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/home";
    }
}
