package com.numbersapi.javacore;

import com.numbersapi.javacore.module.getHtml;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;



public class Main {
    public static void main(String[] args) {
        String numberUrl;

        try {
            numberUrl = getHtml.getRandomNumb();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Ошибка при создании URI: " + e.getMessage(), e);
        }

        System.out.println(numberUrl);
        Frequency(numberUrl);
    }

    public static void Frequency(String url)
    {
        Map<Character, Integer> freq = new HashMap<>();

        // Частота каждого Character
        for (char c : url.toCharArray()) {
            if( c != ' ' && c != '.') {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }
        // Частота значений
        int characterFreq = 0;

        // Вывод в консоль .
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
            characterFreq += entry.getValue();
        }

        AverageFrequency(freq, characterFreq);
    }

    public static void AverageFrequency(Map<Character,Integer> frequency,int sizeFreq)
    {
        double averageFrequency = (double) sizeFreq / frequency.size();

        // округлённое значение averageFrequency
        int avgFrequency = (int) Math.round(averageFrequency);
        System.out.println("\nСредняя частота значений char: " + avgFrequency + "\n");

        for(Map.Entry<Character,Integer> empty : frequency.entrySet())
        {
            char character = empty.getKey();
            int freq = empty.getValue();

            if(freq == avgFrequency){
                System.out.print(character + "(" + (int)character + ")" + " ");
            }
        }

    }
}
