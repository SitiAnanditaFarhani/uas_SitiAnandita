package com.example.ptsii_sitiananditafarhani.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String Id;
    private String Name;

    public LoggedInUser(String Id, String Name) {
        this.Id = Id;
        this.Name = Name;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }
}

