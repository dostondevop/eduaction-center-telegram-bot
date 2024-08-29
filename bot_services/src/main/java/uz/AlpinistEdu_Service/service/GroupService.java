package uz.AlpinistEdu_Service.service;

import uz.AlpinistEdu_Service.model.Group;

import java.util.List;
import java.util.UUID;

public class GroupService implements BaseService<Group> {
    @Override
    public Group add(Group group) {
        return null;
    }

    @Override
    public Group get(UUID id) {
        List<Group> groups = read();

        for (Group group: groups) {
            if (group.getId().equals(id)) {
                return group;
            }
        }
        return null;
    }

    @Override
    public boolean has(Group group, List<Group> list) {
        return false;
    }

    @Override
    public Group getById(UUID id) {
        return null;
    }

    @Override
    public List<Group> getList() {
        return List.of();
    }

    @Override
    public List<Group> read() {
        return List.of();
    }

    @Override
    public void write(List<Group> groups) {

    }
}