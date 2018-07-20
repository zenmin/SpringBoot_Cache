package com.zm.springbootcache.controller;

import com.zm.springbootcache.bean.Employee;
import com.zm.springbootcache.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/7/1 16:49
 */

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/index/{value}")
    public String getAll(Model model,@PathVariable String value){
        List<Employee> allEmp = empService.getAllEmp(new String(value));
        System.out.println(allEmp);
        model.addAttribute("list",allEmp);

        return "list";
    }


    @ResponseBody
    @GetMapping("/getemp/{id}")
    public Employee getEmpById(@PathVariable Integer id){
        Employee empByid = empService.getEmpByid(id);
        return empByid;
    }


    @ResponseBody
    @GetMapping("/update")
    public Employee getEmpById(Employee employee){
        Employee empByid = empService.updateByid(employee);
        return empByid;
    }

    @ResponseBody
    @GetMapping("/del/{id}")
    public int delEmpById(@PathVariable  Integer id){
        int i = empService.delEmployee(id);
        return i;
    }
}
