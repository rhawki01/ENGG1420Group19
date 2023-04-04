/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group19.pkg1;

/**
 *
 * @author jacob
 */
import java.util.List;

public class PrintProcessingElement {
    public static List<Entry2> printProcessingElement(List<Entry2> entries) {
        for (Entry2 entry : entries) {
            if (entry.isLocal()) {
                System.out.println("Name: " + entry.getValue() + ", Length: " +
                        entry.getValue().length() + ", Path: " + entry.getValue());
            } else {
                System.out.println("EntryId: " + entry.getEntryId() + ", Name: " +
                        entry.getValue() + ", Length: " + entry.getValue().length() +
                        ", Path: " + "(" + entry.getRepoId() + ", " + entry.getEntryId() + ")");
            }
        }
        return entries;
    }
}
