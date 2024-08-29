package uz.AlpinistEdu_Service.utils;

import lombok.experimental.UtilityClass;
import uz.AlpinistEdu_Service.service.*;

@UtilityClass
public class ObjectUtils {
    public static GroupService groupService = new GroupService();
    public static ParentStudentService parentStudentService = new ParentStudentService();
    public static TeacherGroupService teacherGroupService = new TeacherGroupService();
    public static UserService userService = new UserService();
    public static PointService pointService = new PointService();
    public static ProductService productService = new ProductService();
    public static StudentGroupService studentGroupService = new StudentGroupService();
    public static TimeTableService timeTableService = new TimeTableService();
}