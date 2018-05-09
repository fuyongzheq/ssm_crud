package com.ssm.test;

import com.ssm.dao.DepartmentMapper;
import com.ssm.dao.EmployeeMapper;
import com.ssm.domain.Department;
import com.ssm.domain.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContent.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;
    @Test
    public void test(){
        System.out.println(departmentMapper);
//        departmentMapper.insertSelective(new Department(null,"开发部"));
//        departmentMapper.insertSelective(new Department(null,"测试部"));
//        employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@163.com",1));
        //批量插入，使用可以执行批量操作的sqlsession
         EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
         for (int i=0;i<1000;i++){
             String uid = UUID.randomUUID().toString().substring(0,5)+i;
             mapper.insertSelective(new Employee(null,uid,"M",uid+"@163.com",1));
         }


    }
}
