package utils;

import java.util.HashMap;
import java.util.Map;
public class TextUtils {

    public static Map<String, Integer> getMapChar(String text) {
        String clearString = text.replaceAll("[^A-Za-zА-Яа-я0-9]", "");
        String[] splitted = clearString.split("");

        Map<String, Integer> map = new HashMap<>();
        for (String t : splitted)
        {
            Integer count = map.get(t);
            map.put(t, (count == null) ? 1 : count + 1);
        }
        return map;
    }
}
