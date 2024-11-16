package ofofo.data.models;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private String userName;
    private String password;
    private boolean locked = false;
    private List<Entry>entries =new ArrayList<>();

//    public Diary() {
//
//    }
    public Diary(String userName, String password) {
        this.userName = userName;
        this.password = password;
        entries = new ArrayList<>();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public String toString() {
        return "userName=" + userName;
    }



    public void lock() {
        locked = true;
    }
    public void unlock() {
        locked = false;
    }

    public boolean isLocked() {
        return locked;
    }
}
