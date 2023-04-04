/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group19.pkg1;

public class Entry2 {

    
    private boolean isLocal; // flag indicating whether the entry is local or remote
    private String value; // the value of the entry, either a local path or remote (repoId, entryId) pair
    private String repoId; // the id of the Laserfiche Repository (only applicable for remote entries)
    private int entryId; // the id of the entry (only applicable for remote entries)

    // constructor for local entries
    public Entry2(String value) {
        this.isLocal = true;
        this.value = value;
    }
    
    // constructor for remote entries
    public Entry2(String repoId, int entryId) {
        this.isLocal = false;
        this.repoId = repoId;
        this.entryId = entryId;
        this.value = "(" + repoId + ", " + entryId + ")";
    }

    // getter for isLocal flag
    public boolean isLocal() {
        return isLocal;
    }

    // getter for value
    public String getValue() {
        return value;
    }

    // getter for repoId (only applicable for remote entries)
    public String getRepoId() {
        if (isLocal) {
            throw new IllegalStateException("Cannot get repoId for local entry");
        }
        return repoId;
    }

    // getter for entryId (only applicable for remote entries)
    public int getEntryId() {
        if (isLocal) {
            throw new IllegalStateException("Cannot get entryId for local entry");
        }
        return entryId;
    }
    
    // toString method for Entry objects
    @Override
    public String toString() {
        return value;
    }
}
