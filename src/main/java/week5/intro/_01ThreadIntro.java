package week5.intro;

public class _01ThreadIntro {

    public static void main(String[] args) {

        Thread main = Thread.currentThread();

        System.out.println(main.getName());

        MyThread myThread = new MyThread("info thread");
        myThread.setDaemon(true);
        myThread.start();

        for (int i = 0; i < 10; i++) {
            System.out.printf("main work %d\n", i+1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}

class MyThread extends Thread {

    private String threadDescr;

    public MyThread(String threadDescr) {
        this.threadDescr = threadDescr;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.printf("My work %s, %s, %s\n", getId(), getName(), getState());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                interrupt();
            }
        }

    }
}