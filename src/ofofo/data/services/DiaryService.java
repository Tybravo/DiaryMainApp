package ofofo.data.services;


import ofofo.data.models.Diary;

public interface DiaryService {
    String register(String username, String password);
    Diary loginUsername(String username);
    Diary loginPassword(String password);
    String loginSuccess(String username, String password);
    Diary findById(String username);
    Diary findByPass(String password);
    int count();

    String getUsername();

    boolean isLocked();
    void lock();
    void unLock();

}
