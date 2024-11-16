package ofofo.data.repositories;

import ofofo.data.models.Diary;
import java.util.List;

public interface DiaryRepository {
    void save(Diary diary);
    void delete(Diary diary);
    long count();
    Diary findById(String username);
    boolean isEmpty();
    Diary findByPass(String password);
    List<Diary> findByTitle(String title);
    
    void deleteAll();
    void deleteAllById(String username);
    //void deleteById(String id);
    //boolean existsById(String id);
}
