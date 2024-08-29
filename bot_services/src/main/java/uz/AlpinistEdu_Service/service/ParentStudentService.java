package uz.AlpinistEdu_Service.service;

import uz.AlpinistEdu_Service.model.connections.ParentStudent;

import java.util.List;
import java.util.UUID;

public class ParentStudentService implements BaseService<ParentStudent> {
    @Override
    public ParentStudent add(ParentStudent parentStudent) {
        return null;
    }

    @Override
    public ParentStudent get(UUID id) {
        return null;
    }

    @Override
    public boolean has(ParentStudent parentStudent, List<ParentStudent> list) {
        return false;
    }

    @Override
    public ParentStudent getById(UUID id) {
        return null;
    }

    @Override
    public List<ParentStudent> getList() {
        return List.of();
    }

    @Override
    public List<ParentStudent> read() {
        return List.of();
    }

    @Override
    public void write(List<ParentStudent> parentStudents) {

    }
}