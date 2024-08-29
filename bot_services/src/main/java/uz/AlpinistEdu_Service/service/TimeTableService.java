package uz.AlpinistEdu_Service.service;

import uz.AlpinistEdu_Service.model.TimeTable;

import java.util.List;
import java.util.UUID;

public class TimeTableService implements BaseService<TimeTable> {
    @Override
    public TimeTable add(TimeTable timeTable) {
        return null;
    }

    @Override
    public TimeTable get(UUID id) {
        return null;
    }

    @Override
    public boolean has(TimeTable timeTable, List<TimeTable> list) {
        return false;
    }

    @Override
    public TimeTable getById(UUID id) {
        return null;
    }

    @Override
    public List<TimeTable> getList() {
        return List.of();
    }

    @Override
    public List<TimeTable> read() {
        return List.of();
    }

    @Override
    public void write(List<TimeTable> timeTables) {
    }
}