package com.thoughtworks.capability.gtb.restfulapidesign.api;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.GroupDto;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/groups")
public class GroupController {
    private final GroupService groupService;
    private final StudentService studentService;

    public GroupController(GroupService groupService, StudentService studentService) {
        this.groupService = groupService;
        this.studentService = studentService;
    }

    @PostMapping
    public GroupDto setGroupName(@RequestParam Integer id, @RequestParam String groupName) {
        return groupService.updateGroupName(id, groupName);
    }

    @GetMapping
    public List<GroupDto> group() {
        return groupService.groupStudents(new ArrayList<>(studentService.getAllStudents(null)));
    }

    @GetMapping("/res")
    public List<GroupDto> getGroup(@RequestParam Integer id) {
        return groupService.getGroup(id);
    }
}
