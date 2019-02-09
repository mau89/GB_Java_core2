import java.util.Arrays;
public class Task {
    static final int SIZE = 10_000_000;
    static final int H = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {
        Version1();
        Version2();
    }

    public static void Version1() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.printf("Вариант выполнения прямого обхода %s секунд %n", (float) (System.currentTimeMillis() - a) / 1000);
    }

    public static void Version2() throws InterruptedException {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        float[] a1 = new float[H];
        float[] a2 = new float[H];
        System.arraycopy(arr, 0, a1, 0, H);
        System.arraycopy(arr, H, a2, 0, H);

        class MyRunnable implements Runnable {
            float[] arr1;

            public MyRunnable(float[] arr1) {
                this.arr1 = arr1;
            }

            @Override
            public void run() {
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        }

        Thread thread1 = new Thread(new MyRunnable(a1));
        Thread thread2 = new Thread(new MyRunnable(a2));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.arraycopy(a1, 0, arr, 0, H);
        System.arraycopy(a2, 0, arr, H, H);

        System.out.printf("Вариант выполнения двух потоков %s секунд %n", (float) (System.currentTimeMillis() - a) / 1000);
    }
}