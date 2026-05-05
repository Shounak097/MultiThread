import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutionThread {

    public static void main(String[] args){
        System.out.println("Current Thread : "+Thread.currentThread().getName());

        ExecutorService service = Executors.newFixedThreadPool(4);

        for(int i=0;i<10;i++){
            RunableThread task = new RunableThread(i);
            service.execute(task);
        }
        service.shutdown();

    }
}
