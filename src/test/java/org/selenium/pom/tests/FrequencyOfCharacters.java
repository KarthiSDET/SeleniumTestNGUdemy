package org.selenium.pom.tests;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FrequencyOfCharacters {

    public static void freqOfCharInString(String inputString){
        HashMap<Character,Integer> charFreqMap = new LinkedHashMap<>();
        for(char ch : inputString.toCharArray()) {
            if(charFreqMap.containsKey(ch)) {
                charFreqMap.put(ch, charFreqMap.getOrDefault(ch,0) + 1);
            }
            else {
                charFreqMap.put(ch,1);
            }
        }
        for(Map.Entry<Character,Integer> freqEntry : charFreqMap.entrySet()) {
            System.out.println("Character: " + freqEntry.getKey() + " Frequency: " + freqEntry.getValue());
        }
    }

    public static void main(String[] args) {
        freqOfCharInString("composition");
    }
}
