package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.GroupDto;
import com.thoughtworks.capability.gtb.restfulapidesign.dto.StudentDto;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    private static final int GROUP_NUM_MIN = 1;
    private static final int GROUP_NUM = 6;
    private final GroupRepository groupRepository;

    public GroupService() {
        this.groupRepository = new GroupRepository();
    }

    public GroupDto updateGroupName(Integer id, String name) {
        return groupRepository.updateName(id, name);
    }

    public List<GroupDto> groupStudents(List<StudentDto> students) {
        Collections.shuffle(students);
        int num = students.size() / GROUP_NUM;
        int remain = students.size() % GROUP_NUM;
        groupRepository.deleteAll();
        int groupNum = 1;
        for(int i = 0; i < num * GROUP_NUM; i += num) {
            List<StudentDto> studentsGroup = new ArrayList<>(students.subList(i, i + num));
            GroupDto groupDto = GroupDto.builder()
                    .id(groupNum)
                    .name("group" + groupNum)
                    .members(studentsGroup)
                    .build();
            groupRepository.save(groupDto);
            ++groupNum;
        }

        for(int i = 0; i < remain; ++i) {
            GroupDto groupDto = groupRepository.find(i + 1);
            List<StudentDto> group;
            if (groupDto == null) {
                group = new ArrayList<>();
                groupDto = GroupDto.builder()
                        .id(i + 1)
                        .name("group" + groupNum)
                        .members(group)
                        .build();
                groupRepository.save(groupDto);
            } else {
                group = groupDto.getMembers();
            }
            group.add(students.get(num * GROUP_NUM + i));

        }

        return groupRepository.findAll();
    }

    public List<GroupDto> getGroup(Integer id) {
        if (id == null) {
            return groupRepository.findAll();
        }
        if (id < GROUP_NUM_MIN || id > GROUP_NUM || id > groupRepository.count() || groupRepository.count() == 0) {
            return null;
        }
        return groupRepository.findAll().subList(id - 1, id);
    }

}
