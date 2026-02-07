package com.dttyy.cropmod;

public enum CropType {
    CORN("corn", 4, 0.6F),
    TOMATO("tomato", null, null),
    CARROT("carrot", null, null);

    private final String name;
    private final Integer hunger;
    private final Float saturation;

    CropType(String name, Integer hunger, Float saturation) {
        this.name = name;
        this.hunger = hunger;
        this.saturation = saturation;
    }

    public String getName() {
        return name;
    }

    public Integer getHunger() {
        return hunger;
    }

    public Float getSaturation() {
        return saturation;
    }

    public boolean hasCustomFood() {
        return hunger != null && saturation != null;
    }
}
