package ofofo.controllers;

import ofofo.data.models.Entry;
import ofofo.data.services.EntryService;

import java.util.List;

public class EntryControllers {

    public EntryService entryService = new EntryService() {

        @Override
        public Entry saveEntryWithDiaryId(String username, String title, String body) {
            return entryService.saveEntryWithDiaryId(username, title, body);
        }

        @Override
        public Entry save(Entry entry) {
            return entryService.save(entry);
        }

        @Override
        public List<Entry> findByTitle(String title) {
            return List.of();
        }

        @Override
        public void delete(int id) {
            return;
        }

        @Override
        public void delete(Entry userName) {

        }

        @Override
        public void update(String username, String title, String body) {

        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public Entry findById(int id) {
            return null;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    };

}
