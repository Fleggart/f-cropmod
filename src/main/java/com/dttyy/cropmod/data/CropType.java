package com.dttyy.cropmod.data;

public enum CropType {

    ASPARAGUS("asparagus", 3, 0.6f, false),
    OAT("oat", 3, 0.6f, false),
    RYE("rye", 3, 0.6f, false),
    CORN("corn", 3, 0.6f, false),
    BARLEY("barley", 3, 0.6f, false);

    private final String name;

    CropType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
