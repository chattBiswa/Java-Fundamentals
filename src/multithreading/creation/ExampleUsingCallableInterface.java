package multithreading.creation;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


// To create the thread, a Runnable is required. To obtain the result, a Future is required.
// The Java library has the concrete type FutureTask, which implements Runnable and Future.
//
public class ExampleUsingCallableInterface {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // FutureTask is the concrete class of Future interface
        FutureTask[] randomNoTasks = new FutureTask[10];

        for (int i = 0; i < 10; i++) {
            // lambda defining call() of Callable interface instance pass in FutureTask Obj
            // Note: indirectly, the thread is created with a Callable.
            // there is no way to create the thread directly with a Callable

            randomNoTasks[i] = new FutureTask(() -> {
                Random randObj = new Random();
                // generating a random number between 0 to 9
                Integer randNo = randObj.nextInt(10);
                // the thread is delayed for some random time
                Thread.sleep(randNo * 1000);
                return randNo;
            });

            // FutureTask impl Runnable, thus it can be used to create thread
            Thread t = new Thread(randomNoTasks[i]);
            t.start();
        }

        // loop for receiving the random numbers
        for (int j = 0; j < 10; j++)
        {
            // invoking the get() method
            Object o = randomNoTasks[j].get();

            // The get method holds the control until the result is received
            // The get method may throw the checked exceptions
            // like when the method is interrupted. Because of this reason
            // we have to add the throws clause to the main method

            // printing the generated random number
            System.out.println("The random number is: " + o);

        }

    }
}
