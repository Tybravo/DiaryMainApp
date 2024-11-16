package ofofo.data.services;

import ofofo.data.models.Diary;
import ofofo.data.repositories.DiaryRepository;
import ofofo.data.repositories.DiaryRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class DiaryServiceImpl implements DiaryService {
    private final DiaryRepository diaryRepository = new DiaryRepositoryImpl();
    private final List<Diary> diaries = new ArrayList<>();
    private boolean locked = false;
    private int count = 0;

    @Override
    public String register(String username, String password) {
        Diary checkedUsername = diaryRepository.findById(username.toLowerCase());
        if (checkedUsername != null) {
            throw new IllegalArgumentException("Username is already taken");
        } else {
            Diary diary = new Diary(username, password);
            diary.setUsername(username.toLowerCase());
            diary.setPassword(password.toLowerCase());
            diaryRepository.save(diary);
            count++;
            return "Registration successful :)";
        }
    }

    @Override
    public void loginUsername(String username) {
        Diary fetchedUsername = diaryRepository.findById(username.toLowerCase());
        if (fetchedUsername == null) {
            throw new IllegalArgumentException("Cannot find username");
        }
    }

    @Override
    public void loginPassword(String password) {
        Diary fetchedPassword = diaryRepository.findByPass(password.toLowerCase());
        if (fetchedPassword == null) {
            throw new IllegalArgumentException("Wrong password");
        }
    }

    @Override
    public String loginSuccess(String username, String password) {
        return "";
    }

    @Override
    public Diary findById(String username) {
        Diary checkedUsername = diaryRepository.findById(username.toLowerCase());
        if(checkedUsername != null) {
            return diaryRepository.findById(username.toLowerCase());
        }
        return null;
    }


    @Override
    public Diary findByPass(String password) {
        Diary checkedUsername = diaryRepository.findByPass(password.toLowerCase());
        if(checkedUsername != null) {
            return diaryRepository.findByPass(password.toLowerCase());
        }
      return diaryRepository.findByPass(password.toLowerCase());
    }

    @Override
    public void lock() {
        locked = true;
    }

    @Override
    public void unLock() {
        locked = false;
    }

    @Override
    public boolean isLocked() {
        return locked;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public String getUsername() {
        return "";
    }




}
