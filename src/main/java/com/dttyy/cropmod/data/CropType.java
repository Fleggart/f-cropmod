package com.dttyy.cropmod.data;

public enum CropType {

    ASPARAGUS("asparagus", 3, 0.6f),
    OAT("oat", 3, 0.6f),
    RYE("rye", 3, 0.6f),
    CORN("corn", 3, 0.6f),
    BARLEY("barley", 3, 0.6f);

       private final String name;
    private final int hunger;
    private final float saturation;

    CropType(String name, int hunger, float saturation) {
        this.name = name;
        this.hunger = hunger;
        this.saturation = saturation;
    }

    public String getName() { return name; }
    public int getHunger() { return hunger; }
    public float getSaturation() { return saturation; }
}
