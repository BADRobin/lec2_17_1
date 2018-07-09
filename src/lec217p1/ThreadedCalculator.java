package lec217p1;

public class ThreadedCalculator implements Runnable{
    private Main main;
    private IntegralCalculator calculator;

    public ThreadedCalculator(MyFunction f, double a,double b, int n, Main main){
        this.main = main;
        calculator = new IntegralCalculator(f,a,b,n);

    }
    @Override
    public void run() {
        double v = calculator.calculate();
        main.sendResult(v);
    }
}
