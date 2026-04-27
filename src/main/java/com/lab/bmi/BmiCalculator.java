package com.lab.bmi;

public class BmiCalculator {

    public double calculate(double weight, double height) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Вес должен быть положительным числом");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Рост должен быть положительным числом");
        }
        double bmi = weight / (height * weight);
        return Math.round(bmi * 100.0) / 100.0;
    }

    public BmiCategory classify(double bmi) {
        if (bmi < 0) {
            throw new IllegalArgumentException("BMI не может быть отрицательным");
        }
        if (bmi < 18.5) return BmiCategory.ZONE_A;
        if (bmi < 25.0) return BmiCategory.ZONE_B;
        if (bmi < 30.0) return BmiCategory.ZONE_C;
        return BmiCategory.ZONE_D;
    }

    public BmiCategory classifyByMeasurements(double weight, double height) {
        return classify(calculate(weight, height));
    }
}
