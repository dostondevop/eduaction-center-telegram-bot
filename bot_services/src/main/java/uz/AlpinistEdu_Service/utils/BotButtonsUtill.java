package uz.AlpinistEdu_Service.utils;

import lombok.experimental.UtilityClass;

import java.util.*;

import static uz.AlpinistEdu_Service.utils.MessagesUtill.*;

@UtilityClass
public class BotButtonsUtill {
    public static final List<String> GUEST_MAIN_MENU_BUTTONS = List.of(
            "Markaz haqida",
            "Kurslarimiz",
            "Filiallarimiz",
            "Bizning Ustozlarimiz",
            "Mutaxassis bilan aloqa",
            "Imtihonga ro'yxatdan o'tish");

    public static List<String> ADMIN_MAIN_MENU_BUTTONS = List.of(
            "Guests",
            "Teachers",
            "Students",
            "Products",
            "Groups",
            "TimeTables",
            "Send message to all users");

    public static List<String> TEACHER_MAIN_MENU_BUTTONS = List.of(
            "Grading Students",
            "Timetable",
            "Send message to Students"
    );

    public static final Map<String, List<String>> ADMIN_SECOND_INNER_MENU = Map.of(
            "Guests", List.of(
                    "List of Guests",
                    "Send message to all Guests",
                    "\uD83D\uDD19Back"
            ),
            "Teachers", List.of(
                    "Add Teacher",
                    "Delete Teacher",
                    "List of Teachers",
                    "\uD83D\uDD19Back"
            ),
            "Students", List.of(
                    "Add Student",
                    "Delete Student",
                    "List of Teachers",
                    "\uD83D\uDD19Back"
            ),
            "Products", List.of(
                    "Add Product",
                    "Delete Product",
                    "List of Products",
                    "\uD83D\uDD19Back"
            ),
            "Groups", List.of(
                    "Add Group",
                    "Delete Group",
                    "List of Groups",
                    "\uD83D\uDD19Back"
            ),
            "TimeTables", List.of(
                    "Add Time-table",
                    "Delete Time-table",
                    "List of Time-tables",
                    "\uD83D\uDD19Back"
            ),
            "Send message to all users", List.of(
                    "\uD83D\uDD19Back"
            )
    );

    public static final List<String> GUEST_ALL_SECOND_MENU_BUTTONS = List.of(
            "Umumiy ma'lumotlar",
            "Afzalliklar",
            "Yutuqlar",
            "Mr Fazliddin",
            "Mr Sunnat",
            "Ms Liliya",
            "Ms Aziza",
            "Mr Javoxir",
            "Mr MirzaAhmad",
            "Ingliz Tili",
            "Matematika",
            "Rus Tili",
            "Mental Arifmetika",
            "Sergeli",
            "Olmazor",
            "Uchtepa",
            "Chilonzor",
            "Yunusobod",
            "Yakkasaroy",
            "Tel:",
            "Gmail:",
            "Ro'yxatdan o'tish"
            );

//    "Parent", List.of(
//            "Add Parent", "Delete Parent", "List of available Parents",
//            "\uD83D\uDD19Back"
//            ),

    public static final Map<String, List<String>> GUEST_SECOND_MENU_BUTTONS = Map.of(
            "Markaz haqida", List.of(
                    "Umumiy ma'lumotlar",
                    "Afzalliklar",
                    "Yutuqlar",
                    "\uD83D\uDD19Back"
            ),
            "Bizning Ustozlarimiz", List.of(
                    "Mr Fazliddin",
                    "Mr Sunnat",
                    "Ms Liliya",
                    "Ms Aziza",
                    "Mr Javoxir",
                    "Mr MirzaAhmad",
                    "\uD83D\uDD19Back"
            ),
            "Kurslarimiz", List.of(
                    "Ingliz Tili",
                    "Matematika",
                    "Rus Tili",
                    "Mental Arifmetika",
                    "\uD83D\uDD19Back"
            ),
            "Filiallarimiz", List.of(
                    "Sergeli",
                    "Olmazor",
                    "Uchtepa",
                    "Chilonzor",
                    "Yunusobod",
                    "Yakkasaroy",
                    "\uD83D\uDD19Back"
            ),
            "Mutaxassis bilan aloqa", List.of(
                    "Tel:",
                    "Gmail:",
                    "\uD83D\uDD19Back"
            ),
            "Imtihonga ro'yxatdan o'tish", List.of(
                    "Ro'yxatdan o'tish",
                    "\uD83D\uDD19Back"
            )
    );

    public static String getInfo(String buttonName) {
        switch (buttonName) {
            case "Ingliz Tili" -> {
                return  TEXT_INGLIZ_TILI;
            }
            case "Matematika" -> {
                return  TEXT_MATHEMATIKA;
            }
            case "Rus Tili" -> {
                return TEXT_RUS_TILI;
            }
            case "Mental Arifmetika" -> {
                return TEXT_MENTAL_ARIFMETIKA;
            }

            // About us options
            case "Umumiy ma'lumotlar" -> {
                return TEXT_ABOUT_LEARNING_CENTER;
            }
            case "Afzalliklar" -> {
                return "Markazimizning afzalliklari...";
            }
            case "Yutuqlar" -> {
                return "Markazimizning yutuqlari...";
            }
            case "Sergeli" -> {
                return "Sergeli filialimiz haqida ma'lumot...";
            }
            case "Olmazor" -> {
                return "Olmazor filialimiz haqida ma'lumot...";
            }
            case "Uchtepa" -> {
                return "Uchtepa filialimiz haqida ma'lumot...";
            }
            case "Chilonzor" -> {
                return "Chilonzor filialimiz haqida ma'lumot...";
            }
            case "Yunusobod" -> {
                return "Yunusobod filialimiz haqida ma'lumot...";
            }
            case "Yakkasaroy" -> {
                return "Yakkasaroy filialimiz haqida ma'lumot...";
            }

            // Contact options
            case "Tel:" -> {
                return TEXT_PHONE_NUMBER;
            }
            case "Gmail:" -> {
                return "Bizning Gmail manzilimiz: [alpinistedu@gmail.com](mailto:muxammadaminerkinboev6899@gmail.com)";
            }

            // Subscription options
            case "Ro'yxatdan o'tish" -> {
                return "Imtihonga ro'yxatdan o'tish uchun quyidagi linkni bosing: [Ro'yxatdan o'tish](https://pdp.uz/)";
            }

            // Teacher options
            case "Mr Fazliddin" -> {
                return TEXT_TEACHER_FAZLIDDIN;
            }
            case "Mr Sunnat" -> {
                return TEXT_TEACHER_SUNNAT;
            }
            case "Ms Liliya" -> {
                return TEXT_TEACHER_LILIYA;
            }
            case "Ms Aziza" -> {
                return TEXT_TEACHER_AZIZA;
            }
            case "Mr Javoxir" -> {
                return TEXT_TEACHER_JAVOXIR;
            }
            case "Mr MirzaAhmad" -> {
                return TEXT_TEACHER_MIRZAAHMAD;
            }
            default -> {
                return "Tanlangan bo'lim uchun ma'lumot mavjud emas.";
            }
        }
    }
}


