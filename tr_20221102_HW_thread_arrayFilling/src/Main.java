import java.util.Arrays;

/*
ДЗ
First level: Реализовать многопоточное заполнение массива на N элементов (например, на 1000000 элементов) случайными числами.
При том каждый поток заполняет свой участок массива (например, если два потока то один заполняет с 0 по 499999 элементы, а второй оставшиеся).
Заполнить массив в 1 поток, в 3 потока, в 5 потоков. Засечь время заполнения. Сравнить результаты и выяснить самый эффективный способ.
 */

public class Main {

    public static final int SIZE = 10_000_000;

    public static void main(String[] args) throws InterruptedException {
       /*
       ЧЕМ БОЛЬШЕ ПОТОКОВ, ТЕМ ДОЛЬШЕ ПО ВРЕМЕНИ?!
       без join() быстро:)
        */
        System.out.println("=====================arrayFilling();===========================");
        arrayFilling();
        System.out.println("=====================arrayFillingIn3Threads();===========================");
        arrayFillingIn3Threads();
        System.out.println("=====================arrayFillingIn3Threads_var2();===========================");
        arrayFillingIn3Threads_var2();
        System.out.println("=====================arrayFillingIn5Threads();===========================");
        arrayFillingIn5Threads();

    }

    // Через один поток
    public static void arrayFilling() {
        int[] arr = new int[SIZE];
        long before = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (int) ((Math.random() * 20_000) - 10_000);
        }
        long after = System.currentTimeMillis();
        System.out.println("время одного потока - " + (after - before) + " !!!!!!!!");
    }

    // Через три потока
    public static void arrayFillingIn3Threads() {
        int[] arrResult = new int[SIZE];
        long before = System.currentTimeMillis();

        My3Thread t1 = new My3Thread();
        My3Thread t2 = new My3Thread();
        My3Thread t3 = new My3Thread();

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int[] arr1 = t1.arrInThread;
        int[] arr2 = t2.arrInThread;
        int[] arr3 = t3.arrInThread;

        System.arraycopy(arr1, 0, arrResult, 0, SIZE / 3);
        System.arraycopy(arr2, 0, arrResult, SIZE / 3, SIZE / 3);
        System.arraycopy(arr3, 0, arrResult, SIZE / 3 * 2, SIZE / 3);

        long after = System.currentTimeMillis();
        System.out.println("время трех потоков - " + (after - before) + " !!!!!!!!");

        //  Проверка
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arrResult, 0, 20)));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arrResult, SIZE / 3, SIZE / 3 + 20)));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arrResult, SIZE / 3 * 2, SIZE / 3 * 2 + 20)));
    }

    // Через три потока (вариант 2)
    public static void arrayFillingIn3Threads_var2() {
        int[] arrResult = new int[SIZE];
        long before = System.currentTimeMillis();
        int[] arr1 = new int[SIZE / 3];
        int[] arr2 = new int[SIZE / 3];
        int[] arr3 = new int[SIZE / 3];

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < SIZE / 3; i++) {
                    arr1[i] = (int) ((Math.random() * 20_000) - 10_000);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < SIZE / 3; i++) {
                    arr2[i] = (int) ((Math.random() * 20_000) - 10_000);
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < SIZE / 3; i++) {
                    arr3[i] = (int) ((Math.random() * 20_000) - 10_000);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.arraycopy(arr1, 0, arrResult, 0, SIZE / 3);
        System.arraycopy(arr2, 0, arrResult, SIZE / 3, SIZE / 3);
        System.arraycopy(arr3, 0, arrResult, SIZE / 3 * 2, SIZE / 3);

        long after = System.currentTimeMillis();
        System.out.println("время трех потоков_вариант2- " + (after - before) + " !!!!!!!!");
    }

    // Через пять потоков
    public static void arrayFillingIn5Threads() {
        int[] arrResult = new int[SIZE];
        long before = System.currentTimeMillis();

        My5Thread t1 = new My5Thread();
        My5Thread t2 = new My5Thread();
        My5Thread t3 = new My5Thread();
        My5Thread t4 = new My5Thread();
        My5Thread t5 = new My5Thread();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int[] arr1 = t1.arrInThread;
        int[] arr2 = t2.arrInThread;
        int[] arr3 = t3.arrInThread;
        int[] arr4 = t4.arrInThread;
        int[] arr5 = t5.arrInThread;

        System.arraycopy(arr1, 0, arrResult, 0, SIZE / 5);
        System.arraycopy(arr2, 0, arrResult, SIZE / 5, SIZE / 5);
        System.arraycopy(arr3, 0, arrResult, SIZE / 5 * 2, SIZE / 5);
        System.arraycopy(arr4, 0, arrResult, SIZE / 5 * 3, SIZE / 5);
        System.arraycopy(arr5, 0, arrResult, SIZE / 5 * 4, SIZE / 5);

        long after = System.currentTimeMillis();
        System.out.println("время пяти потоков - " + (after - before) + " !!!!!!!!");

        //  Проверка
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arrResult, 0, 20)));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arrResult, SIZE / 5, SIZE / 5 + 20)));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arrResult, SIZE / 5 * 2, SIZE / 5 * 2 + 20)));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arrResult, SIZE / 5 * 3, SIZE / 5 * 3 + 20)));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arrResult, SIZE / 5 * 4, SIZE / 5 * 4 + 20)));
    }


}

class My3Thread extends Thread {
    public int[] arrInThread = new int[10_000_000 / 3];

    @Override
    public void run() {
        for (int i = 0; i < 10_000_000 / 3; i++) {
            arrInThread[i] = (int) ((Math.random() * 20_000) - 10_000);
        }
        //  Проверка
//        System.out.println("Поток - " + this.getName());
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arrInThread, 0, 20)));
    }
}

class My5Thread extends Thread {
    public int[] arrInThread = new int[10_000_000 / 5];

    @Override
    public void run() {
        for (int i = 0; i < 10_000_000 / 5; i++) {
            arrInThread[i] = (int) ((Math.random() * 20_000) - 10_000);
        }
        //  Проверка
//        System.out.println("Поток - " + this.getName());
//        System.out.println(Arrays.toString(Arrays.copyOfRange(arrInThread, 0, 20)));
    }
}


