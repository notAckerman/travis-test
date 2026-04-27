package com.lab.bmi;

public enum BmiCategory {
    ZONE_A("Зона A — лёгкая"),
    ZONE_B("Зона B — оптимальная"),
    ZONE_C("Зона C — повышенная"),
    ZONE_D("Зона D — высокая");

    private final String label;

    BmiCategory(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
