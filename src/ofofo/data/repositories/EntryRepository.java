package ofofo.data.repositories;

import ofofo.data.models.Diary;
import ofofo.data.models.Entry;

import java.util.List;

public interface EntryRepository {
    Entry save(Entry entry);
    List<Entry> findByTitle(String title);
    void delete(int id);
    void delete(Entry entry);
    long count();
    Entry findById(String username);

    boolean isEmpty();


}
