package uz.AlpinistEdu_Service.service;

import uz.AlpinistEdu_Service.model.Point;

import java.util.List;
import java.util.UUID;

public class PointService implements BaseService<Point> {
    @Override
    public Point add(Point point) {
        return null;
    }

    @Override
    public Point get(UUID id) {
        return null;
    }

    @Override
    public boolean has(Point point, List<Point> list) {
        return false;
    }

    @Override
    public Point getById(UUID id) {
        return null;
    }

    @Override
    public List<Point> getList() {
        return List.of();
    }

    @Override
    public List<Point> read() {
        return List.of();
    }

    @Override
    public void write(List<Point> points) {

    }
}