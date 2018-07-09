package lec217p1;

public class IntegralCalculator  {
    private MyFunction f;
    private double a;
    private double b;
    private int n;

    public IntegralCalculator(MyFunction f, double a, double b, int n) {
        this.f = f;
        this.a = a;
        this.b = b;
        this.n = n;
    }
    public double calculate () {
        double h = (b-a)/n;
        double s =0;
        for (int i = 0; i < n; i++) {
            double x = a + i * h;
            double y = f.f(x);
            s += y*h;
        }return s;
    }

}
