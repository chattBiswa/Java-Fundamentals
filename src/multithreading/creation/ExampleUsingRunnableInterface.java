package multithreading.creation;

public class ExampleUsingRunnableInterface {
    public static void main(String[] args) {
        // create thread using Runnable anonymous inner class
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside run method");
            }
        }, "myThread1");

        // create thread using Runnable lambda function
        Thread t2 = new Thread(() ->
                System.out.println("Inside run method"),
                "myThread2"
        );

        t1.start();
        t2.start();

        System.out.println("Thread name = " + t1.getName());
        System.out.println("Thread name = " + t2.getName());
    }
}
