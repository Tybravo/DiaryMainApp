import ofofo.data.models.Diary;
import ofofo.data.models.Entry;
import ofofo.data.services.DiaryService;
import ofofo.data.services.DiaryServiceImpl;
import ofofo.data.services.EntryServiceImpl;
import ofofo.data.repositories.DiaryRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.*;


public class EntryServiceImplTest {
    public EntryServiceImpl entryService;
    @BeforeEach
    public void setUp() {
        entryService = new EntryServiceImpl();
    }

    @Test
    public void test_That_Entry_Repository_Is_Empty() {
        EntryServiceImpl entryService = new EntryServiceImpl();
        assertEquals(0, entryService.count());
    }

    @Test
    public void test_That_One_Entry_Can_Be_Added_To_Repository() {
        DiaryService diaryService = new DiaryServiceImpl();
        diaryService.register("Tybravo", "passwordOne");
        assertEquals(1, diaryService.count());
        Diary fetchedUsername = diaryService.findById("Tybravo");
        assertEquals("tybravo", fetchedUsername.getUsername());
        entryService.saveEntryWithDiaryId("tybravo","Moment Enjoyed","Enjoyed a beautiful moment today");
        assertEquals(1, entryService.count());
    }

    @Test
    public void test_That_2_Different_Users_For_Entries_Can_Be_Added_To_Repository() {
        DiaryService diaryService = new DiaryServiceImpl();
        diaryService.register("Tybravo", "passwordOne");
        diaryService.register("Mikolo", "passwordTwo");
        assertEquals(2, diaryService.count());
        Diary fetchedUsername1 = diaryService.findById("Tybravo");
        Diary fetchedUsername2 = diaryService.findById("Mikolo");
        assertEquals("tybravo", fetchedUsername1.getUsername());
        assertEquals("mikolo", fetchedUsername2.getUsername());
        entryService.saveEntryWithDiaryId("Tybravo","Moment Enjoyed","Enjoyed a beautiful moment today");
        entryService.saveEntryWithDiaryId("Mikolo","Dream Reality","Enjoyed a beautiful moment today");
        assertEquals(2, entryService.count());
    }

    @Test
    public void test_That_2_Same_User_For_2_Or_More_Entries_Can_Be_Added_To_Repository() {
        DiaryService diaryService = new DiaryServiceImpl();
        diaryService.register("Tybravo", "passwordOne");
        assertEquals(1, diaryService.count());
        Diary fetchedUsername = diaryService.findById("Tybravo");
        assertEquals("tybravo", fetchedUsername.getUsername());
        entryService.saveEntryWithDiaryId("Tybravo","Moment Enjoyed","Enjoyed a beautiful moment today");
        entryService.saveEntryWithDiaryId("Tybravo","Dream Reality","Enjoyed a beautiful moment today");
        assertEquals(2, entryService.count());
    }


    @Test
    public void test_That_One_Entry_Can_Be_Removed_From_Multiple_Entries_In_A_Repository() {
        DiaryService diaryService = new DiaryServiceImpl();
        diaryService.register("Tybravo", "passwordOne");
        assertEquals(1, diaryService.count());
        Diary fetchedUsername = diaryService.findById("Tybravo");
        assertEquals("tybravo", fetchedUsername.getUsername());
        assertEquals(1, diaryService.count());
        Entry entry1 = new Entry("Tybravo","Read Books","Enjoyed a beautiful moment today");
        Entry entry2 = new Entry("Tybravo","Play Music","Enjoyed a beautiful moment today");
        Entry entry3 = new Entry("Tybravo","Window Shopping","Enjoyed a beautiful moment today");
        entryService.saveEntryWithDiaryId("Tybravo","Read Books","Enjoyed a beautiful moment today");
        entryService.saveEntryWithDiaryId("Tybravo","Play Music","Enjoyed a beautiful moment today");
        entryService.saveEntryWithDiaryId("Tybravo","Window Shopping","Enjoyed a beautiful moment today");

        entryService.delete(entry3);
        assertEquals(2, entryService.count());
    }

    @Test
    public void test_That_ALl_Entries_Of_A_User_Can_Be_Deleted_From_Repository() {
        DiaryService diaryService = new DiaryServiceImpl();
        diaryService.register("Tybravo", "passwordOne");
        Diary fetchedUsername = diaryService.findById("Tybravo");
        assertEquals("tybravo", fetchedUsername.getUsername());
        assertEquals(1, diaryService.count());
        Entry entry1 = new Entry("Tybravo","Read Books","Enjoyed a beautiful moment today");
        Entry entry2 = new Entry("Tybravo","Play Music","Enjoyed a beautiful moment today");
        Entry entry3 = new Entry("Tybravo","Window Shopping","Enjoyed a beautiful moment today");
        Entry entry4 = new Entry("Tybravo","Watching Movie","Enjoyed a beautiful moment today");
        entryService.saveEntryWithDiaryId("Tybravo","Read Books","Enjoyed a beautiful moment today");
        entryService.saveEntryWithDiaryId("Tybravo","Play Music","Enjoyed a beautiful moment today");
        entryService.saveEntryWithDiaryId("Tybravo","Window Shopping","Enjoyed a beautiful moment today");
        entryService.saveEntryWithDiaryId("Tybravo","Watching Movie","Enjoyed a beautiful moment today");

        entryService.delete(entry1);
        entryService.delete(entry2);
        entryService.delete(entry3);
        entryService.delete(entry4);
        assertEquals(0, entryService.count());
    }

    @Test
    public void test_That_An_Entry_Of_A_User_Can_Be_Updated_In_Repository() {
        DiaryService diaryService = new DiaryServiceImpl();
        diaryService.register("Tybravo", "passwordOne");
        Diary fetchedUsername = diaryService.findById("Tybravo");
        assertEquals("tybravo", fetchedUsername.getUsername());
        assertEquals(1, diaryService.count());
        Entry entry1 = new Entry("Tybravo","Read Books","Enjoyed a beautiful moment today");
        entryService.saveEntryWithDiaryId("Tybravo","Read Books","Enjoyed a beautiful moment today");

        entryService.delete(entry1);
        assertEquals(0, entryService.count());
        entryService.update("Tybravo","Write Articles","Enjoyed a beautiful moment today");
        assertEquals(1, entryService.count());

    }
}
