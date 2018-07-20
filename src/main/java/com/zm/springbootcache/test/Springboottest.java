package com.zm.springbootcache.test;

import com.zm.springbootcache.bean.Employee;
import com.zm.springbootcache.dao.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/7/13 14:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboottest {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate myRedisTemplate;

    @Test
    public void getList(){
        List<Employee> employees = employeeMapper.selectByExample(null);
        System.out.println(employees);
    }
    
    @Test
    public void TestRedis(){
        //String
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        //hash
        HashOperations<String, Object, Object> stringObjectObjectHashOperations = stringRedisTemplate.opsForHash();
        //list
        ListOperations<String, String> stringStringListOperations = stringRedisTemplate.opsForList();
        //set
        SetOperations<String, String> stringStringSetOperations = stringRedisTemplate.opsForSet();
        //Zset
        ZSetOperations<String, String> stringStringZSetOperations = stringRedisTemplate.opsForZSet();

        stringStringValueOperations.set("name","zm");
        String name = stringStringValueOperations.get("name");
        System.out.println(name);

        stringStringListOperations.leftPush("mylist","1");
        stringStringListOperations.leftPush("mylist","2");
        stringStringListOperations.leftPush("mylist","3");
        stringStringListOperations.leftPush("mylist","4");

        String mylist = stringStringListOperations.leftPop("mylist");
        List<String> mylist1 = stringStringListOperations.range("mylist", 0, -1);
        System.out.println(mylist1);

        ValueOperations valueOperations = myRedisTemplate.opsForValue();
        Employee employee = employeeMapper.selectByPrimaryKey(1);
        valueOperations.set("emp",employee);
        valueOperations.get("emp");


    }

    




}
