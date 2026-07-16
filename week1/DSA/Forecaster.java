package DSA;

import java.util.LinkedList;

public class Forecaster {

    private final LinkedList<Double> window = new LinkedList<>();
    private final int size;
    private double sum = 0;

    public Forecaster(int windowSize) {
        this.size = windowSize;
    }

    public double addAndForecast(double newValue) {
        window.addLast(newValue);
        sum += newValue;
        if (window.size() > size) {
            sum -= window.removeFirst();
        }
        return sum / window.size();
    }

    public static void main(String[] args) {
        Forecaster forecaster = new Forecaster(3);
        double[] prices = {100, 102, 101, 105, 107, 110, 108};

        for (double price : prices) {
            double forecast = forecaster.addAndForecast(price);
            System.out.println("New price: " + price + " -> Forecast: " + forecast);
        }
    }
}