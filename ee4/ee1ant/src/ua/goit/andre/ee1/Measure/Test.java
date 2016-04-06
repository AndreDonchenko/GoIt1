package ua.goit.andre.ee1.Measure;

public class Test {

    public static  volatile boolean flag =  true;

    public static void main(String[] args) throws  InterruptedException {
        new Thread(new Runnable(){
            public void run() {
                int i = 0;
                while (flag) {
                    i++;
                }
                System.out.println(i);
            }
        }).start();
        Thread.sleep(100);
        flag = false;
    }
}
