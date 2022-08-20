package ThreadMethods;

/*
	Thread Join Example
*/

public class ThreadJoin extends Thread{
    @Override
    public void run()
    {
        for (int i = 0; i < 2; i++){
            try{
                Thread.sleep(500);
                System.out.println("Current Thread: " + Thread.currentThread().getName());
            }catch(Exception ex){
                System.out.println("Exception has" + " been caught" + ex);
            }
            System.out.println(i);
        }
    }
}

class Test{

    public static void main (String[] args)
    {
        // creating two threads
        ThreadJoin t1 = new ThreadJoin();
        ThreadJoin t2 = new ThreadJoin();
        ThreadJoin t3 = new ThreadJoin();

        // thread t1 starts
        t1.start();
        // starts second thread after when first thread t1 has died.
        try
        {
            System.out.println("Current Thread: " + Thread.currentThread().getName());
            t1.join();
        }catch(Exception ex){
            System.out.println("Exception has " + "been caught" + ex);
        }

        // t2 starts
        t2.start();

        // starts t3 after when thread t2 has died.
        try{
            System.out.println("Current Thread: " + Thread.currentThread().getName());
            t2.join();
        }catch(Exception ex){
            System.out.println("Exception has been" + " caught" + ex);
        }

        t3.start();
    }
}
