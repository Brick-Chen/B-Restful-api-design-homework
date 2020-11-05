package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.StudentDto;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService() {
        this.studentRepository = new StudentRepository();
    }

    public StudentDto addStudent(StudentDto student) {
        int id = studentRepository.size() + 1;
        student.setId(id);
        return studentRepository.save(student);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public StudentDto getStudent(int id) {
        return studentRepository.getStudent(id);
    }

    public StudentDto update(StudentDto student) {
        StudentDto target = getStudent(student.getId());
        if (target != null) {
            target.setGender(student.getGender());
            target.setName(student.getName());
            target.setNote(student.getNote());
            return studentRepository.save(target);
        }
        return null;
    }

    public List<StudentDto> getAllStudents(String gender) {
        return studentRepository.findAll(gender);
    }
}
