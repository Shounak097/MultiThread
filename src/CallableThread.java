import javax.swing.plaf.FontUIResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableThread {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random r = new Random();
        GreetingGenerator gg = new GreetingGenerator(r);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //Future<String> promiseOfGreeting = executorService.submit(gg);
        List<Future<String>> listOfGreeting = new ArrayList<>();
        // any code here not depending on greeting
        for (int i=0;i<4;i++){
            Future<String> promiseOfGreeting = executorService.submit(gg);
            listOfGreeting.add(promiseOfGreeting);
        }
        for(Future<String> promises : listOfGreeting){
            String greeting = promises.get(); // blocking call
            System.out.println(greeting);
        }


        // any code depending on greeting

        executorService.shutdown();
    }
}
