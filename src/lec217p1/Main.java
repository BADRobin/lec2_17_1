package lec217p1;

public class Main {

    double result;
    int count;

    public static void main(String[] args) {
//	    IntegralCalculator calculator = new IntegralCalculator(new MyFunctionExample(), 0, Math.PI, 1_000_000);
////        IntegralCalculator calculator = new IntegralCalculator(x -> Math.sin(x), 0, Math.PI, 1_000_000);
//        double v = calculator.calculate();
//        System.out.println("v = " + v);
        Main main = new Main();
        main.runNow();
    }

    private void runNow() {
        double a = 0;
        double b = Math.PI;
        int n = 100_000_000;
        result = 0;
        count = 0;
        int nThreads = 100;
        double delta = (b - a) / nThreads;
        int n1 = n / nThreads;
        long finish = System.currentTimeMillis();
        for (int i = 0; i < nThreads; i++) {
            ThreadedCalculator threadedCalculator = new ThreadedCalculator(new MyFunctionExample(), a + i * delta, a + (i + 1) * delta, n1, this);
            new Thread(threadedCalculator).start();
        }
        try {
            synchronized (this) {
                while (count < nThreads) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("result = " + result);
        System.out.println("finish = " + finish);
    }

        public synchronized void sendResult(double v) {
        result += v;
        count ++;
        notify();
    }
}

