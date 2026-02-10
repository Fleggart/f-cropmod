package com.dttyy.cropmod;

public enum CropType {

    TOMATO("tomato", 5, 0.8f, false),
    asparagus("asparagus", 3, 0.6f, false);
    
    private final String name;
    private final int hunger;
    private final float saturation;
    private final boolean hasMaterial;

    CropType(String name, int hunger, float saturation, boolean hasMaterial) {
        this.name = name;
        this.hunger = hunger;
        this.saturation = saturation;
        this.hasMaterial = hasMaterial;
    }

    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public float getSaturation() {
        return saturation;
    }

    public boolean hasMaterial() {
        return hasMaterial;
    }
}
