package ofofo.data.services;

import ofofo.data.models.Diary;
import ofofo.data.models.Entry;
import ofofo.data.repositories.DiaryRepository;
import ofofo.data.repositories.DiaryRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class EntryServiceImpl implements EntryService {
    private final DiaryRepository diaryRepository = new DiaryRepositoryImpl();
    private final DiaryService diaryService = new DiaryServiceImpl();
    private final List<Entry> entries;
    private long count = 0;


    public EntryServiceImpl() {
        entries = new ArrayList<>();
    }


    @Override
    public void saveEntryWithDiaryId(String username, String title, String body) {
        Diary user = diaryService.findById(username.toLowerCase());
        Entry entry = new Entry(username, title, body);
        entry.setUsername(username.toLowerCase());
        entry.setTitle(title);
        entry.setBody(body);

        entries.add(entry);
        count++;
    }


    @Override
    public Entry save(Entry entry) {
        entries.add(entry);
        count++;
        return entry;
    }

    @Override
    public List<Entry> findByTitle(String title) {
        return List.of();
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public void delete(Entry userName) {
        for(int index = 0; index < entries.size(); index++) {
            if(entries.get(index).equals(userName)) {
                entries.remove(index);
                //count = count + 1;
            }
        }
        count--;
        //count = count + 1;
    }

    @Override
    public void update(String username, String title, String body) {
        Diary user = diaryService.findById(username.toLowerCase());
        Entry entry = new Entry(username, title, body);
        entry.setUsername(username.toLowerCase());
        entry.setTitle(title);
        entry.setBody(body);

        entries.add(entry);
        count++;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public Entry findById(int id) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}
