package com.mycompany.restaurante.Model;

public class Saves {
    private static Save saveA;

    public static Save getSave() {
        return saveA;
    }

    public static void setSave(Save save) {
        saveA = save;
    }
}