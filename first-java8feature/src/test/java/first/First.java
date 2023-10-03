package first;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class First {
    // lambda - GO to marker interface copy method paranthies() and use it.
    @Test
    public void first_lambdaExamples() throws InterruptedException {
        //Anonymous
        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("This is anonymous runnable class run() method");
            }
        };
        Thread thread = new Thread(anonymousRunnable);
        thread.start();
        thread.join();

        //Lambda
        Runnable runnableLambda = () -> {
            System.out.println("This is runnable class run() lambda method");
        };

        Thread thread1 = new Thread(runnableLambda);
        thread1.start();
        thread1.join();

        //Anonymous
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o, Object t1) {
                return 0;
            }
        };

        //Lambda
        Comparator<String> comparatorLambda = (o1, o2) -> 0;

        Comparator comparatorLambdaCompact = (o1, o2) -> {
            return 0;
        };

    }
}
