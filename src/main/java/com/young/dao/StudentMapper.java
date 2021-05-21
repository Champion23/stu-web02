package com.young.dao;

import com.young.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

    //删除学生
    void deleteByPrimaryKey(Integer id);
    // 通过主键 查询 学生
    Student selectByPrimaryKey(Integer id);
    // 通姓名 查询 学生
    Student selectByName(String name);
    // 通 账号 查询 学生
    Student selectByAdmin(String admin);
    //查询所有
    List<Student> findAll();
    //添加学生
    void save(Student student);
    // 通过主键 有选择性地 改变 学生信息
    void updateByPrimaryKeySelective(Student student);
    // 根据数学成绩排序
    List<Student> getRankByMath();
    // 更新学生信息
    int updateByPrimaryKey(Student record);
}