package uz.AlpinistEdu_Service.utils.studentUtill;

import java.util.List;
import java.util.Map;

public class StudentBotButtonsConstantsUtill {
    public static final List<String> STUDENT_MAIN_MENU_BUTTONS = List.of(
            "Coins",
            "Market",
            "Teachers",
            "Courses");

    public static final Map<String, List<String>> STUDENT_SECOND_MENU_OPTIONS = Map.of(
            "Coins", List.of(
                    "My coins",
                    "Buy coins",
                    "Sell coins",
                    "\uD83D\uDD19Orqaga"
            ),
            "Market", List.of(
                    "Buy items",
                    "My items",
                    "\uD83D\uDD19Orqaga"
            ),
            "Teachers",List.of(
                    "Teacher 1",
                    "Teacher 2",
                    "Teacher 3",
                    "\uD83D\uDD19Orqaga"
            ),
            "Courses",List.of(
                    "Course 1",
                    "Course 2",
                    "Course 3",
                    "\uD83D\uDD19Orqaga"
            )
    );

    public static String getInfoStudent(String buttonName) {
        switch (buttonName) {
            case "My coins" -> {
                return "Your coins: 100";
            }
            case "Buy coins" -> {
                return "Buy coins";
            }
            case "Sell coins" -> {
                return "Sell coins";
            }
            case "Buy items" -> {
                return "Buy items";
            }
            case "Sell items" -> {
                return "Sell items";
            }
            case "My items" -> {
                return "Your items";
            }
            case "Teacher 1" -> {
                return "Teacher 1";
            }
            case "Teacher 2" -> {
                return "Teacher 2";
            }
            case "Teacher 3" -> {
                return "Teacher 3";
            }
            default -> {
                return "Unknown button";
            }
        }
    }

}
