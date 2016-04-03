public class Aufgabe4{

    public static void main(String[] args) {
        int dividend=1527193;
        int divisor=1229163;
        int r;

        while (dividend%divisor > 0) {
            r = dividend % divisor;
            System.out.println(r);
            dividend = divisor;
            divisor = r;
        }
        System.out.println(dividend);
    }
}
