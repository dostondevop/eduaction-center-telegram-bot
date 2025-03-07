package uz.AlpinistEdu_Service.service;

import uz.AlpinistEdu_Service.model.User;
import uz.AlpinistEdu_Service.model.connections.TeacherGroup;
import uz.AlpinistEdu_Service.utils.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TeacherGroupService implements BaseService<TeacherGroup> {
    @Override
    public TeacherGroup add(TeacherGroup teacherGroup) {
        return null;
    }

    @Override
    public TeacherGroup get(UUID id) {
        return null;
    }

    @Override
    public boolean has(TeacherGroup teacherGroup, List<TeacherGroup> list) {
        return false;
    }

    @Override
    public TeacherGroup getById(UUID id) {
        return null;
    }

    @Override
    public List<TeacherGroup> getList() {
        return List.of();
    }

    @Override
    public List<TeacherGroup> read() {
        return List.of();
    }

    @Override
    public void write(List<TeacherGroup> teacherGroups) {
    }
    public List<String> getGroupNamesByTeacherId (Long chatId) {
        User user = ObjectUtils.userService.getUserByChatId(chatId);
        List<TeacherGroup> list = read();
        List<String> names = new ArrayList<>();

        for (TeacherGroup teacherGroup: list) {
            if (teacherGroup.getTeacherId().equals(user.getId())) {
                names.add(ObjectUtils.groupService.get(teacherGroup.getGroupId()).getName());
            }
        }

        return names;
    }
}