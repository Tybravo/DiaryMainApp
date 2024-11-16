//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);






            /////////////////////////////////////////////////////////////////////////////////////////

/*

            import org.springframework.data.jpa.repository.JpaRepository;

            public interface TaskRepository extends JpaRepository<Task, Long> {
            }


            import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

            @Service
            public class TaskService {

                @Autowired
                private TaskRepository taskRepository;

                @Transactional
                public void deleteAllTasks() {
                    taskRepository.deleteAll();
                }
            }



          import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

            @RestController
            @RequestMapping("/tasks")
            public class TaskController {

                @Autowired
                private TaskService taskService;

                @DeleteMapping("/deleteAll")
                public void deleteAllTasks() {
                    taskService.deleteAllTasks();
                }
            }


*/







        }
    }
}