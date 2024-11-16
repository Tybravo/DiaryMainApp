//package ofofo.controllers;
//
//public class DiaryController {
//}

package ofofo.data.controllers;

import ofofo.data.models.Diary;
import ofofo.data.models.Entry;

import java.util.List;

public class DiaryController {
    private Diary diary;

    public DiaryController(String userName, String password) {
        diary = new Diary(userName, password);
    }

    public void addEntry(Entry entry) {
        diary.getEntries().add(entry);
    }

    public void removeEntry(Entry entry) {
        diary.getEntries().remove(entry);
    }

    public void lockDiary() {
        diary.lock();
    }

    public void unlockDiary() {
        diary.unlock();
    }

    public boolean isDiaryLocked() {
        return diary.isLocked();
    }

    public void changePassword(String newPassword) {
        diary.setPassword(newPassword);
    }

    public String getUserName() {
        return diary.getUsername();
    }

    public void setUserName(String userName) {
        diary.setUsername(userName);
    }

    public List<Entry> getEntries() {
        return diary.getEntries();
    }

    public void setEntries(List<Entry> entries) {
        diary.setEntries(entries);
    }

    @Override
    public String toString() {
        return diary.toString();
    }
}
