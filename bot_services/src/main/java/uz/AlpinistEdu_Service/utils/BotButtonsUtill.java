package uz.AlpinistEdu_Service.utils;

import lombok.experimental.UtilityClass;

import java.util.*;

@UtilityClass
public class BotButtonsUtill {
    public static final List<String> GUEST_MAIN_MENU_BUTTONS = List.of(
            "Markaz haqida",
            "Kurslarimiz",
            "Filiallarimiz",
            "Bizning Ustozlarimiz",
            "Mutaxassis bilan aloqa",
            "Imtihonga ro'yxatdan o'tish",
            "\uD83D\uDD19Orqaga");

    public static final Map<String, List<String>> SECOND_MENU_OPTIONS = Map.of(
            "Markaz haqida", List.of(
                    "Umumiy ma'lumotlar",
                    "Afzalliklar",
                    "Yutuqlar",
                    "\uD83D\uDD19Orqaga"
            ),
            "Bizning Ustozlarimiz", List.of(
                    "Mr Fazliddin",
                    "Mr Sunnat",
                    "Ms Liliya",
                    "Ms Aziza",
                    "Mr Javoxir",
                    "Mr MirzaAhmad",
                    "\uD83D\uDD19Orqaga"
            ),
            "Kurslarimiz", List.of(
                    "Ingliz Tili",
                    "Matematika",
                    "Rus tili",
                    "Mental Arifmetika",
                    "\uD83D\uDD19Orqaga"
            ),
            "Filiallarimiz", List.of(
                    "Sergeli",
                    "Olmazor",
                    "Uchtepa",
                    "Chilonzor",
                    "Yunusobod",
                    "Yakkasaroy",
                    "\uD83D\uDD19Orqaga"
            ),
            "Mutaxassis bilan aloqa", List.of(
                    "Tel:",
                    "Gmail:",
                    "\uD83D\uDD19Orqaga"
            ),
            "Imtihonga ro'yxatdan o'tish", List.of(
                    "Ro'yxatdan o'tish",
                    "\uD83D\uDD19Orqaga"
            )
    );

    public static String getInfo(String buttonName) {
        switch (buttonName) {
            case "Ingliz Tili" -> {
                return  "Ingliz tili haqida ma'lumot...";
            }
            case "Matematika" -> {
                return  "Matematika haqida ma'lumot...";
            }
            case "Rus tili" -> {
                return "Rus tili haqida ma'lumot...";
            }
            case "Mental Arifmetika" ->{
                return "Mental arifmetika haqida ma'lumot...";
            }

            // About us options
            case "Umumiy ma'lumotlar" -> {
                return "Markaz haqida umumiy ma'lumotlar...";
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
                return "Bizning telefon raqamimiz: +998 XX XXX XXX";
            }
            case "Gmail:" -> {
                return "Bizning Gmail manzilimiz: [alpinistedu@gmail.com](mailto:muxammadaminerkinboev6899@gmail.com)";
            }
            case "Ro'yxatdan o'tish" -> {
                return "Imtihonga ro'yxatdan o'tish uchun quyidagi linkni bosing: [Ro'yxatdan o'tish](https://pdp.uz/)";
            }
            default -> {
                return "Tanlangan bo'lim uchun ma'lumot mavjud emas.";
            }
        }
    }
}


