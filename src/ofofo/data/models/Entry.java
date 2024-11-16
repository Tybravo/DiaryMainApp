package ofofo.data.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Entry {
        private int id;
        private String username;
        private String title;
        private String body;
        private LocalDateTime localDate = LocalDateTime.now();
        private List<Entry>entries =new ArrayList<>();


        public Entry(String username, String title, String body) {
        this.username = username;
        this.title = title;
        this.body = body;
        entries = new ArrayList<>();
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public LocalDateTime getLocalDate() {
            return localDate;
        }

        public void setLocalDate(LocalDateTime localDate) {
            this.localDate = localDate;
        }

        public List<Entry> getEntries() {
            return entries;
    }

        public void setEntries(List<Entry> entries) {
            this.entries = entries;
    }

        public String getUsername() {
            return username;
    }

        public void setUsername(String username) {
            this.username = username;
    }

}
