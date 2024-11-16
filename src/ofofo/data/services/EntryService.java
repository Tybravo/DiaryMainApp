package ofofo.data.services;

import ofofo.data.models.Entry;

import java.util.List;

public interface EntryService {
    //Entry save(Entry entry);
    void saveEntryWithDiaryId(String username, String title, String body);
    Entry save(Entry entry);
    List<Entry> findByTitle(String title);
    void delete(int id);
    void delete(Entry userName);
    void update(String username, String title, String body);
    long count();
    Entry findById(int id);

    boolean isEmpty();

    //void saveEntryWithDiaryId(String username, String title, String body);
}
