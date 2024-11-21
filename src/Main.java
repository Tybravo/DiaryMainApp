
import ofofo.data.models.Diary;
import ofofo.data.models.Entry;
import ofofo.data.services.DiaryService;
import ofofo.data.services.DiaryServiceImpl;
import ofofo.data.services.EntryService;
import ofofo.data.services.EntryServiceImpl;

import java.util.Scanner;

public class Main {
    private static final DiaryService diaryService = new DiaryServiceImpl();
    private static final EntryService entryService = new EntryServiceImpl();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Welcome to Your Diary App Menu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Save Entry");
            System.out.println("4. Fetch Entries");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    saveEntry();
                    break;
                case 4:
                    fetchEntries();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting Diary App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static void register() {
        System.out.print("Enter username: "); String username = input.nextLine();
        System.out.print("Enter password: "); String password = input.nextLine();
        try {
            String result = diaryService.register(username, password);
            System.out.println(result);
        } catch (IllegalArgumentException display) {
            System.out.println(display.getMessage());
        }
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();
        try {
            Diary diary = diaryService.loginUsername(username);
            if (diary != null && diary.getPassword().equals(password)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password.");
            }
        } catch (IllegalArgumentException display) {
            System.out.println(display.getMessage());
        }
    }

    private static void saveEntry() {
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter title: ");
        String title = input.nextLine();
        System.out.print("Enter body: ");
        String body = input.nextLine();
        try {
            Entry entry = entryService.saveEntryWithDiaryId(username, title, body);
            System.out.println("Entry saved: " + entry.toString());
        } catch (IllegalArgumentException display) {
            System.out.println(display.getMessage());
        }
    }

    private static void fetchEntries() {
        System.out.print("Enter username: ");
        String username = input.nextLine();
        Diary diary = diaryService.findById(username);
        if (diary != null) {
            System.out.println("Entries for " + username + ":");
            for (Entry entry : diary.getEntries()) {
                System.out.println(entry);
            }
        } else {
            System.out.println("No entries found for username: " + username);
        }
    }


}
