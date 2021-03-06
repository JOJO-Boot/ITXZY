package com.bootmvc.dao;

import com.bootmvc.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    //模拟数据库汇中数据

    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer, Department>();//创建一个部门表

        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(101,"市场部"));
        departments.put(103,new Department(101,"教研部"));
        departments.put(104,new Department(101,"运营部"));
        departments.put(105,new Department(101,"后勤部"));
    }
    //获取所哟部门信息
    public Collection<Department> getDepartment(){
        return departments.values();
    }
    //通过id得到部门
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
