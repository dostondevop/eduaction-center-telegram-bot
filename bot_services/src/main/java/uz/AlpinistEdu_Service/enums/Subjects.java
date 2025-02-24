package uz.AlpinistEdu_Service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Subjects {
    ENGLISH("Ingliz tili"),
    MATHEMATICS("Matematika"),
    RUSSIAN("Rus tili"),
    MENTAL_ARITHMETICS("Mental Arifmetika"),
    HISTORY("Tarix"),
    MOTHER_TONGUE("Ona tili"),
    BIOLOGY("Biologiya"),
    CHEMISTRY("Kimyo"),
    LAW("Huquq");
    private String name;
}
