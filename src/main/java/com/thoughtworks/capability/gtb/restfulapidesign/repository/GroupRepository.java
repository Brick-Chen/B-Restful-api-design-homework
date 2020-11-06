package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.GroupDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupRepository {
    private final Map<Integer, GroupDto> groups;

    public GroupRepository() {
        groups = new HashMap<>();
    }

    public GroupDto updateName(Integer id, String name) {
        if (groups.containsKey(id)) {
            GroupDto group =  groups.get(id);
            group.setName(name);
            groups.put(id, group);
            return group;
        }
        return null;
    }

    public void save(GroupDto groupDto) {
        groups.put(groupDto.getId(), groupDto);
    }

    public void deleteAll() {
        groups.clear();
    }

    public GroupDto find(Integer id) {
        return groups.getOrDefault(id, null);
    }

    public List<GroupDto> findAll() {
        return new ArrayList<>(groups.values());
    }

    public int count() {
        return groups.size();
    }

}
