package com.dttyy.cropmod.data;

public enum CropType {

    ASPARAGUS("asparagus", 3, 0.6f, false),
    OAT("oat", 3, 0.6f, false),
    RYE("rye", 3, 0.6f, false),
    CORN("corn", 3, 0.6f, false),
    BARLEY("barley", 3, 0.6f, false);

    private final String name;
    private final int hunger;
    private final float saturation;
    private final boolean regrowable; // 新增

    CropType(String name, int hunger, float saturation, boolean regrowable) {
        this.name = name;
        this.hunger = hunger;
        this.saturation = saturation;
        this.regrowable = regrowable;
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

    public boolean isRegrowable() {
        return regrowable;
    }
}
