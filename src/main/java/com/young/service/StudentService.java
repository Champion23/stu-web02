package com.young.service;

import com.young.dao.StudentMapper;
import com.young.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 闫亮23
 * @version 1.0
 */
@Service
public class StudentService implements StudentMapper {


    @Autowired
    StudentMapper studentMapper;

    @Override
    public void deleteByPrimaryKey(Integer id) {
        studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Student selectByPrimaryKey(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public Student selectByName(String name) {
        return studentMapper.selectByName(name);
    }

    @Override
    public Student selectByAdmin(String admin) {
        return studentMapper.selectByAdmin(admin);
    }

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public void save(Student student) {
        studentMapper.save(student);
    }

    @Override
    public void updateByPrimaryKeySelective(Student student) {
    studentMapper.updateByPrimaryKeySelective(student);
    }

    //排序功能
    @Override
    public List<Student> getRankByMath() {
        return     studentMapper.getRankByMath();
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return 0;
    }
}

//
//    public  Student get(String id){
//        return studentMapper.selectByPrimaryKey(id);
//    }
//    @Override
//    public int insert(Student record) {
//        return 0;
//    }
//    @Override
//    public int insertSelective(Student record) {
//        return 0;
//    }


