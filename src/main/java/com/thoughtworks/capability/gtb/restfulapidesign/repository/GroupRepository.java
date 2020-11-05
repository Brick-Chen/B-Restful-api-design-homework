package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.GroupDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class GroupRepository {
    private final List<GroupDto> groups;

    public GroupRepository() {
        groups = new ArrayList<>();
    }
}
