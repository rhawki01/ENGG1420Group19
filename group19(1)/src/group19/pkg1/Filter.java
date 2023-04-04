/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group19.pkg1;

/**
 *
 * @author jacob
 */


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;

public class Filter {

    public static List<File> LengthFilter(List<File> entries, long length, String operator){
        List<File> filteredEntries = new ArrayList<>();
        for (File entry : entries){
            if (entry.isFile()){
                long entryLength = entry.length();
                boolean isValid;
                
                switch (operator){
                    case "EQ" -> isValid = (entryLength == length);
                        
                    case "NEQ" -> isValid = (entryLength != length);
                        
                    case "GT" -> isValid = (entryLength > length);
                        
                    case "GTE" -> isValid = (entryLength >= length);
                        
                    case "LT" -> isValid = (entryLength < length);
                        
                    case "LTE" -> isValid = (entryLength <= length);
                        
                    default -> throw new IllegalArgumentException("Invalid operator: " + operator);
                }
                
                if (isValid){
                    filteredEntries.add(entry);
                }
            }
        }
        return filteredEntries;
    }
    
    public static List<String> NameFilter(List<String> entries, String key) {
        
        List<String> filteredEntries = new ArrayList<>();
        for (String entry : entries){
            if (entry.contains(key)){
                filteredEntries.add(entry);
            }
        }
        return filteredEntries;
    }
    
    public static List<File> CountFilter(List<File> entries, String key, int min) throws IOException {
        
        List<File> output = new ArrayList<>();
        
        for (File entry : entries){
            if (entry.isFile() && countOccurrences(entry, key) >= min) {
                output.add(entry);
            }
        }
        return output;
    }
    
    private static int countOccurrences(File file, String key) throws IOException{
        
        int count = 0;
        String content = new String(Files.readAllBytes(file.toPath()));
        int pos = content.indexOf(key);
        while (pos >= 0){
            count++;
            pos = content.indexOf(key, pos + 1);
        }
        return count;
    }     
}
