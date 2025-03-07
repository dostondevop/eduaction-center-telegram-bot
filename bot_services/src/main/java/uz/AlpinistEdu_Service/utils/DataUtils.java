package uz.AlpinistEdu_Service.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class DataUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public static <T> void write(String path, List<T> list) {
        try {
            objectMapper.writeValue(new File(path), list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> read(String path, TypeReference<List<T>> type) {
        List<T> list = new ArrayList<>();
        try {
            list = objectMapper.readValue(new File(path), type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}