package ru.geekbrains.lesson5;

public class Application {
    static final int size = 10000000;
    public static void main(String[] args){
        oneThreadMethod();
        try {
            multiThreadMethod(2);
        }catch (SuperPlusException ex){
            System.out.println(ex.toString());
        }
    }
    private static void oneThreadMethod(){
        long timeBegin = System.currentTimeMillis();
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        System.out.println("Время заполеннеия: " + (System.currentTimeMillis()-timeBegin));
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i/5)*Math.cos(0.2f + i/5)*Math.cos(0.4f + i/2));
        }
        System.out.println("Время выполнения:  " + (System.currentTimeMillis()-timeBegin));
    }

    private static void multiThreadMethod(int countThread) throws SuperPlusException{
        if(countThread>size) throw new SuperPlusException("Потоков больше чем размер массиваа");
        long timeBegin = System.currentTimeMillis();
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        System.out.println("Время заполеннеия: " + (System.currentTimeMillis()-timeBegin));
        int h = size/countThread;
        int extraH = size%countThread;
        float[][] dArr = new float[countThread][h];
        float[] extraArr = new float[extraH];
        for (int i = 0; i < countThread; i++) {
            System.arraycopy(arr, i*h, dArr[i], 0, h);
        }
        if(extraH!=0) {
            System.arraycopy(arr, countThread * h, extraArr, 0, extraH);
        }
        Thread[] thArr = new Thread[countThread];
        Thread extraThread = null;
        for (int i = 0; i < countThread; i++) {
            int finalI = i;
            thArr[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < h; j++) {
                        dArr[finalI][j] = (float) (dArr[finalI][j] * Math.sin(0.2f + finalI/5)*
                                Math.cos(0.2f + finalI/5)*Math.cos(0.4f + finalI/2));
                    }
                }
            });
        }
        // запуск
        for (int i = 0; i < countThread; i++) {
            thArr[i].start();
        }
        if (extraH!=0){
            extraThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < extraH; i++) {
                        extraArr[i] = (float) (extraArr[i] * Math.sin(0.2f + i/5)*
                                Math.cos(0.2f + i/5)*Math.cos(0.4f + i/2));
                    }
                }
            });
            extraThread.start();
        }
        // ожидание
        try {
            for (int i = 0; i < countThread; i++) {
                thArr[i].join();
            }
            if(extraThread!=null){
                extraThread.join();
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        // склейка
        for (int i = 0; i < countThread; i++) {
            System.arraycopy(dArr[i], 0, arr, h*i, h);
        }
        System.arraycopy(extraArr, 0, arr, h*countThread, extraH);
        System.out.println("Время выполнения:  " + (System.currentTimeMillis()-timeBegin));
    }

    private static class SuperPlusException extends Exception{
        public SuperPlusException(String message) {
            super(message);
        }

        @Override
        public String toString() {
            return this.getMessage();
        }
    }
}

