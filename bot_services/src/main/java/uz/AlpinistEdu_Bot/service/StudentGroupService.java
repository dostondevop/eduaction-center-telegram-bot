package uz.AlpinistEdu_Bot.service;

import uz.AlpinistEdu_Bot.model.connections.StudentGroup;

import java.util.List;
import java.util.UUID;

public class StudentGroupService implements BaseService<StudentGroup> {
    @Override
    public StudentGroup add(StudentGroup studentGroup) {
        return null;
    }

    @Override
    public StudentGroup get(UUID id) {
        return null;
    }

    @Override
    public boolean has(StudentGroup studentGroup, List<StudentGroup> list) {
        return false;
    }

    @Override
    public StudentGroup getById(UUID id) {
        return null;
    }

    @Override
    public List<StudentGroup> getList() {
        return List.of();
    }

    @Override
    public List<StudentGroup> read() {
        return List.of();
    }

    @Override
    public void write(List<StudentGroup> studentGroups) {

    }
}