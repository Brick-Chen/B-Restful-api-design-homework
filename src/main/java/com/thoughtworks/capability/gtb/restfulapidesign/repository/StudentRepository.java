package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.StudentDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentRepository {
    private final Map<Integer, StudentDto> students;

    public StudentRepository() {
        students = new HashMap<>();
        init();
    }

    private void init() {
        StudentDto studentDto1 = StudentDto.builder()
                .id(1)
                .name("太阳骑士")
                .gender("male")
                .build();

        StudentDto studentDto2 = StudentDto.builder()
                .id(2)
                .name("灰烬骑士")
                .gender("female")
                .build();

        StudentDto studentDto3 = StudentDto.builder()
                .id(3)
                .name("无名")
                .gender("male")
                .build();
        students.put(1, studentDto1);
        students.put(2, studentDto2);
        students.put(3, studentDto3);
    }

    public StudentDto save(StudentDto student) {
        students.put(student.getId(), student);
        return student;
    }

    public List<StudentDto> findAll(String gender) {
        if (gender == null) {
            return new ArrayList<>(this.students.values());
        }
        return this.students.values().stream().filter(studentDto -> studentDto.getGender().equals(gender))
                .collect(Collectors.toList());
    }

    public void deleteById(int id) {
        students.remove(id);
    }

    public StudentDto getStudent(int id) {
        return students.getOrDefault(id, null);
    }

    public int size() {
        return students.size();
    }
}
