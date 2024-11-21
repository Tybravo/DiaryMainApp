
package ofofo.controllers;

import ofofo.data.models.Diary;
import ofofo.data.services.DiaryService;

public class DiaryControllers {

    public DiaryService diaryService = new DiaryService() {

        @Override
        public String register(String username, String password) {
            return diaryService.register(username, password);
        }

        @Override
        public Diary loginUsername(String username) {
            return diaryService.loginUsername(username);
        }

        @Override
        public Diary loginPassword(String password) {
            return diaryService.loginPassword(password);
        }

        @Override
        public String loginSuccess(String username, String password) {
            return diaryService.loginSuccess(username, password);
        }

        @Override
        public Diary findById(String username) {
            return null;
        }

        @Override
        public Diary findByPass(String password) {
            return null;
        }

        @Override
        public int count() {
            return 0;
        }

        @Override
        public String getUsername() {
            return "";
        }

        @Override
        public boolean isLocked() {
            return false;
        }

        @Override
        public void lock() {

        }

        @Override
        public void unLock() {

        }

    };

    }