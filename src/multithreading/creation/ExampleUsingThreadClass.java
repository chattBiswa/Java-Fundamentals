package multithreading.creation;

public class ExampleUsingThreadClass {
    public static void main(String[] args) {
        // create the thread instance
        Thread t1 = new Thread("thread1");

        // start the thread
        t1.start();

        // print the name of running thread
        System.out.println("thread name = " + t1.getName());
    }
}
