import ofofo.data.models.Diary;
import ofofo.data.repositories.DiaryRepositoryImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryRepositoryImplTest {
    DiaryRepositoryImpl diaryRepo;

    @BeforeEach
    public void setUp() {
        diaryRepo = new DiaryRepositoryImpl();
        diaryRepo.deleteAll();
    }

    @Test
    public void test_That_New_Repository_Is_empty() {
        diaryRepo = new DiaryRepositoryImpl();
        assertEquals(0, diaryRepo.count());
    }

    @Test
    public void test_That_One_New_Diary_Is_Added_To_Repo() {
        assertEquals(0, diaryRepo.count());
        Diary diary = new Diary("Bravo", "PasswordOne");
        diaryRepo.save(diary);
        assertEquals(1, diaryRepo.count());
        assertEquals(1, diaryRepo.getSize());
    }

    @Test
    public void test_That_Two_Or_More_New_Diary_Is_Added_To_Repo() {
        assertEquals(0, diaryRepo.count());
        Diary diary01 = new Diary("TY", "PasswordOne");
        diaryRepo.save(diary01);
        assertEquals(1, diaryRepo.count());
        Diary diary02 = new Diary("Bravo", "PasswordTwo");
        diaryRepo.save(diary02);
        assertEquals(2, diaryRepo.count());
        assertEquals(2, diaryRepo.getSize());
    }

    @Test
    public void test_That_One_Diary_Can_Be_Removed_From_Repo() {
        Diary diary = new Diary("TY", "PasswordOne");
        diaryRepo.save(diary);
        assertEquals(1, diaryRepo.count());
        diaryRepo.delete(diary);
        Assertions.assertEquals(0, diaryRepo.count());
    }

    @Test
    public void test_That_Two_Diaries_Added_Delete_One_And_Diary_Is_Not_Empty() {
        assertEquals(0, diaryRepo.count());
        Diary diary01 = new Diary("TY", "PasswordOne");
        diaryRepo.save(diary01);
        assertEquals(1, diaryRepo.count());
        Diary diary02 = new Diary("Bravo", "PasswordTwo");
        diaryRepo.save(diary02);
        assertEquals(2, diaryRepo.count());
        diaryRepo.delete(diary02);
        assertEquals(1, diaryRepo.count());
        assertEquals(1, diaryRepo.getSize());
    }

    @Test
    public void test_That_Diary_Can_Be_Retrieved_From_Repo() {
        Diary diary = new Diary("TY", "PasswordOne");
        diaryRepo.save(diary);
        assertEquals(1, diaryRepo.count());
        assertEquals(1, diaryRepo.getSize());
        assertEquals("TY", diary.getUsername());
    }

    @Test
    public void test_To_Search_Entry_By_Id() {
        assertEquals(0, diaryRepo.count());
        Diary diary = new Diary("Bravo", "PasswordOne");
        diaryRepo.save(diary);
        assertEquals(1, diaryRepo.count());
        Diary diary2 = new Diary("Adetayo", "PasswordTwo");
        diaryRepo.save(diary2);
        assertEquals(2, diaryRepo.count());
        Diary fetchedUsername = diaryRepo.findById("Bravo");
        assertEquals("Bravo", fetchedUsername.getUsername());
    }

    @Test
    public void test_To_Delete_One_Diary_Record_In_Repository(){
        assertEquals(0, diaryRepo.count());
        Diary diary01 = new Diary("Bravo", "PasswordOne");
        diaryRepo.save(diary01);
        Diary diary02 = new Diary("Bravo", "PasswordOne");
        diaryRepo.save(diary02);
        assertEquals(2, diaryRepo.getSize());
        diaryRepo.delete(diary02);
        assertEquals(1, diaryRepo.count());
        assertEquals(1, diaryRepo.getSize());
    }

    @Test
    public void test_To_Delete_All_Diary_Records_In_Repository(){
        assertEquals(0, diaryRepo.count());
        Diary diary01 = new Diary("Bravo", "PasswordOne");
        diaryRepo.save(diary01);
        Diary diary02 = new Diary("Mikolo", "PasswordTwo");
        diaryRepo.save(diary02);
        Diary diary03 = new Diary("Bravo", "PasswordThree");
        diaryRepo.save(diary03);
        assertEquals(3, diaryRepo.getSize());
        diaryRepo.deleteAllById("Bravo");
        assertEquals(0, diaryRepo.count());
    }

}