package full.impl;

import full.PrintLetterAndAverage;

import java.io.IOException;
import java.util.*;

import static utils.LoggerUtils.print;
import static utils.LoggerUtils.printl;

public class PrintMapAndService implements PrintLetterAndAverage {
    private double average;
    @Override
    public void printMapFull(Map<String, Integer> map, String text) {
        var treeMap = new TreeMap<>(map);

        printl(text);
        printl("\nЧастота:");
        printMap(treeMap);
        printAverageMap(treeMap,text);
        printSymbols(treeMap);
    }

    private void printMap(Map<String, Integer> map) {
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            printl("%s - %s", entry.getKey(), entry.getValue() );
        }
    }
    private void printAverageMap(Map<String, Integer> map,String text) {
        average = (double) text.length() / map.size();
        printl("\nСреднее значение: %s/%s = %s", text.length(), map.size(), average);
    }

    private void printSymbols(Map<String, Integer> map)
    {
        int averageToInt = (int) Math.round(average);
        List<String> symbols = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == averageToInt){
                symbols.add(entry.getKey());
            }
        }
        // Проверка , если значений равных averageToInt нету.
        if(symbols.isEmpty()) {
            printl("Значений равному averageToInt нету.");
        }

        for (String sym : symbols){
            char symChar = sym.charAt(0);
            print(sym + "(%s) ", (int) symChar );
        }
    }

    // работа с текстом которая не реализована .
    private void printText(String text){
        printl(text);
    }
}
