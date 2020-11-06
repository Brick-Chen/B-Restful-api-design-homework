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
                .name("外乡人")
                .gender("male")
                .build();

        StudentDto studentDto2 = StudentDto.builder()
                .id(2)
                .name("格曼")
                .gender("male")
                .note("老猎人")
                .build();

        StudentDto studentDto3 = StudentDto.builder()
                .id(3)
                .name("加斯科因")
                .gender("male")
                .note("神父")
                .build();

        StudentDto studentDto4 = StudentDto.builder()
                .id(4)
                .name("玛丽亚")
                .gender("female")
                .note("星辰钟塔的玛丽亚")
                .build();

        StudentDto studentDto5 = StudentDto.builder()
                .id(5)
                .name("艾琳")
                .gender("female")
                .note("鸦姐")
                .build();

        StudentDto studentDto6 = StudentDto.builder()
                .id(6)
                .name("劳伦斯")
                .gender("male")
                .note("治愈教会")
                .build();

        StudentDto studentDto7 = StudentDto.builder()
                .id(7)
                .name("威廉大师")
                .gender("male")
                .note("拜尔金沃斯学院")
                .build();

        StudentDto studentDto8 = StudentDto.builder()
                .id(8)
                .name("月神")
                .gender("unknown")
                .note("古神祇")
                .build();


        students.put(1, studentDto1);
        students.put(2, studentDto2);
        students.put(3, studentDto3);
        students.put(4, studentDto4);
        students.put(5, studentDto5);
        students.put(6, studentDto6);
        students.put(7, studentDto7);
        students.put(8, studentDto8);
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
