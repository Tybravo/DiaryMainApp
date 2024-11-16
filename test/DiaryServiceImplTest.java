
import ofofo.data.models.Diary;
import ofofo.data.repositories.DiaryRepository;
import ofofo.data.repositories.DiaryRepositoryImpl;
import ofofo.data.services.DiaryService;
import ofofo.data.services.DiaryServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryServiceImplTest {
    DiaryService diaryService;
    @BeforeEach
    public void setUp() {
        diaryService = new DiaryServiceImpl();
    }

    @Test
    public void test_That_No_Member_Is_Registered_And_User_Count_Is_Zero(){
        DiaryService diaryService = new DiaryServiceImpl();
        assertEquals(0, diaryService.count());
    }

    @Test
    public void test_To_Register_New_Member_User_Count_Is_One(){
        diaryService.register("Tybravo", "bravoPassword");
        assertEquals(1, diaryService.count());
    }

    @Test
    public void test_To_Register_New_User_Twice_User_Disallowed_And_Count_Is_Still_One() {
        diaryService.register("Tybravo", "bravoPassword");
        assertEquals(1, diaryService.count());
        assertThrows(IllegalArgumentException.class, () -> diaryService.register("Tybravo", "bravoPassword"));
        assertEquals(1, diaryService.count());
    }

    @Test
    public void test_That_User_Login_With_Wrong_Username_And_Disallow_User_To_Enter_Password() {
        diaryService.register("Tybravo", "bravoPassword");
        assertEquals(1, diaryService.count());
        assertThrows(IllegalArgumentException.class, () -> diaryService.loginUsername("Michael"));
        assertEquals(1, diaryService.count());
    }

    @Test
    public void  test_That_User_Login_With_Right_Username_And_Allow_User_To_Enter_Password() {
        diaryService.register("Tybravo", "bravoPassword");
        assertEquals(1, diaryService.count());
        diaryService.loginUsername("Tybravo");
        assertEquals(1, diaryService.count());
        Diary fetchedUsername = diaryService.findById("Tybravo");
        assertEquals("tybravo", fetchedUsername.getUsername());
    }

    @Test
    public void  test_That_When_User_Login_With_Right_Username_Diary_Still_Locked() {
        diaryService.register("Tybravo", "bravoPassword");
        assertEquals(1, diaryService.count());
        diaryService.loginUsername("Tybravo");
        assertEquals(1, diaryService.count());
        Diary fetchedUsername = diaryService.findById("Tybravo");
        assertEquals("tybravo", fetchedUsername.getUsername());
        diaryService.lock();
        assertTrue((diaryService.isLocked()));
    }

    @Test
    public void test_That_User_Login_With_Wrong_Password_And_Diary_Still_Locked() {
        diaryService.register("Tybravo", "bravoPassword");
        assertEquals(1, diaryService.count());
        assertThrows(IllegalArgumentException.class, () -> diaryService.loginPassword("wrongPassword"));
        assertEquals(1, diaryService.count());
        diaryService.lock();
        assertTrue((diaryService.isLocked()));
    }

    @Test
    public void  test_That_User_Login_With_Right_Password_Diary_Is_Eventually_Unlocked() {
        diaryService.register("Tybravo", "bravoPassword");
        assertEquals(1, diaryService.count());
        diaryService.loginPassword("bravoPassword");
        assertEquals(1, diaryService.count());
        Diary fetchedPassword = diaryService.findByPass("bravoPassword");
        assertEquals("bravopassword", fetchedPassword.getPassword());
        diaryService.unLock();
        assertFalse((diaryService.isLocked()));
    }

    @Test
    public void  test_That_User_Login_With_Right_Username_Right_Password_Diary_Is_Always_Unlocked() {
        diaryService.register("Tybravo", "bravoPassword");
        assertEquals(1, diaryService.count());
        diaryService.loginUsername("Tybravo");
        assertEquals(1, diaryService.count());
        Diary fetchedUsername = diaryService.findById("Tybravo");
        assertEquals("tybravo", fetchedUsername.getUsername());
        diaryService.lock();
        assertTrue((diaryService.isLocked()));
        diaryService.loginPassword("bravoPassword");
        assertEquals(1, diaryService.count());
        Diary fetchedPassword = diaryService.findByPass("bravoPassword");
        assertEquals("bravopassword", fetchedPassword.getPassword());
        diaryService.unLock();
        assertFalse((diaryService.isLocked()));
    }

}