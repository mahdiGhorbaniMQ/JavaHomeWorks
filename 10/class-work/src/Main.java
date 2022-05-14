public class Main {
    public static void main(String[] args) throws InterruptedException {
        FileIO fileIO = new FileIO();
        Thread thread1 = new Thread(){
            @Override
            public void run(){
                fileIO.read("src/input.txt");
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run(){
                fileIO.write("src/output.txt");
            }
        };

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("completed");
    }
}