package uz.AlpinistEdu_Bot.utils;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class BotConstanta {
    public static String START = "/start";
    public static String HELLO = "Hello ";
    public static String REGISTERED_AS_GUEST = "! You have been registered as a guest.";
    public static String SELECT_FROM_MENU = "Select from the menu!";
    public static String PLEASE_SHARE_PHONE_NUMBER = "Please share your phone number:";
    public static String GUESTS_BUTTON = "Guests";
    public static String TEACHERS_BUTTON = "Teachers";
    public static String STUDENTS_BUTTON = "Students";
    public static String PRODUCTS_BUTTON = "Products";
    public static String GROUPS_BUTTON = "Groups";
    public static String PARENTS_BUTTON = "Parents";
    public static String TIMETABLE_BUTTON = "TimeTables";
    public static String BACK_BUTTON = "Back";

    public static List<String> ADMIN_GUEST_MENU_BUTTONS = List.of("List of guests", "Send message to all guests", "⬅️Back");
    public static List<String> ADMIN_MAIN_MENU_BUTTONS = List.of("Guests", "Teachers", "Students", "Products", "Groups", "TimeTables", "Send message to all users");
}