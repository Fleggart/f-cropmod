package com.dttyy.cropmod.data;

public enum CropType {

    ASPARAGUS("asparagus"),
    OAT("oat"),
    RYE("rye"),
    CORN("corn"),
    BARLEY("barley");

    private final String name;

    CropType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
