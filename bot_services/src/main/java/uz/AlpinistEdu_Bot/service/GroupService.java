package uz.AlpinistEdu_Bot.service;

import uz.AlpinistEdu_Bot.model.Group;

import java.util.List;
import java.util.UUID;

public class GroupService implements BaseService<Group> {
    @Override
    public Group add(Group group) {
        return null;
    }

    @Override
    public Group get(UUID id) {
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