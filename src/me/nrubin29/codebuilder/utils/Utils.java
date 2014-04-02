package me.nrubin29.codebuilder.utils;

import javax.swing.*;

public class Utils {

    public static <T extends Enum<T>> JComboBox createComboBox(Enum<T>[] e) {
        JComboBox box = new JComboBox();

        for (Enum<T> v : e) box.addItem(v);

        return box;
    }
}