package com.lab.bmi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BMI Calculator — модульные тесты")
class BmiCalculatorTest {

    private final BmiCalculator calculator = new BmiCalculator();

    @Test
    @DisplayName("1. BMI для лёгкой зоны (50 кг / 1.75 м < 18.5)")
    void calculate_lightZone() {
        double bmi = calculator.calculate(50, 1.75);
        assertTrue(bmi < 18.5, "Ожидался BMI < 18.5, получено: " + bmi);
    }

    @Test
    @DisplayName("2. Нулевой вес выбрасывает IllegalArgumentException")
    void calculate_zeroWeight_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(0, 1.75));
    }

    @Test
    @DisplayName("3. Отрицательный рост выбрасывает IllegalArgumentException")
    void calculate_negativeHeight_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate(70, -1.75));
    }

    @Test
    @DisplayName("4. Классификация: BMI 17 → Зона A")
    void classify_zoneA() {
        assertEquals(BmiCategory.ZONE_A, calculator.classify(17.0));
    }

    @Test
    @DisplayName("5. Классификация: BMI 22 → Зона B")
    void classify_zoneB() {
        assertEquals(BmiCategory.ZONE_B, calculator.classify(22.0));
    }

    @Test
    @DisplayName("6. Классификация: BMI 27 → Зона C")
    void classify_zoneC() {
        assertEquals(BmiCategory.ZONE_C, calculator.classify(27.0));
    }

    @Test
    @DisplayName("7. Классификация: BMI 32 → Зона D")
    void classify_zoneD() {
        assertEquals(BmiCategory.ZONE_D, calculator.classify(32.0));
    }

    @Test
    @DisplayName("8. Отрицательный BMI выбрасывает IllegalArgumentException")
    void classify_negativeBmi_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.classify(-1));
    }
}
