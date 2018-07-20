package com.zm.springbootcache.service;

import com.zm.springbootcache.bean.Employee;
import com.zm.springbootcache.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/7/1 16:49
 *
 * 测试SqlProvider  现在mybatis的ANNOTATEDMAPPER模式  把mapper xml文件抽成了SqlProvider.java
 */
@Service
@CacheConfig(cacheNames = "emps")
public class EmpService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * Cacheable属性
     * cacheNames/value:缓存组件名字  CacheManager管理的多个Cache
     * key:Cache的key
     * keyGenerator:ket的生成器，可以自己定义key的id
     * cacheManager:指定缓存管理器
     * condition:指定条件  符合条件在缓存
     * unless：否定缓存  当unless指定的条件=true就不会缓存  还可以根据结果进行缓存
     * sync:是否使用异步模式
     *
     * SpringcCache默认cachemanager是 ConCurrentMapCacheManager  默认cache 是ConCurrentMapCache
     *
     * 过程：
     * 默认使用方法参数的值作为key去从Cache中取  没有就执行方法 然后缓存  有就直接返回缓存
     * @return
     */
    //查拳全部
    @Cacheable(cacheNames = "emps")
    public List<Employee> getAllEmp(String args){
        return employeeMapper.selectByExample(null);
    }

    //按id查询
    @Cacheable(cacheNames = "emps",key = "#id",condition = "#id>0") //id大于0才缓存  j结果不为空才缓存
    public Employee getEmpByid(Integer id){
        return employeeMapper.selectByPrimaryKey(id);
    }

    //更新
    @CachePut(value = "emps",key = "#employee.id")   //方法执行完成后更新emps中 key为employee.id的数据
    public Employee updateByid(Employee employee){
        employeeMapper.updateByPrimaryKey(employee);
        return employee;
    }

    /**
     * 方法执行后清除缓存   key默认是参数
     * beforeInvocation：缓存清除是否在方法执行之前执行 如=true如果当前方法出异常 不管方法是否 出错  都会执行清除
     * @param id
     */
    //删除
    @CacheEvict(value = "emps",key = "#id"/*,allEntries = true*/)   //allEntries = true*删除所有缓存
    public int delEmployee(Integer id) {
        int i = employeeMapper.deleteByPrimaryKey(id);
        return i;
    }
}
