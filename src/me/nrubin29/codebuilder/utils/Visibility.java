package me.nrubin29.codebuilder.utils;

public enum Visibility {

    PUBLIC, PRIVATE, PROTECTED, NONE;

    @Override
    public String toString() {
        return this == NONE ? "" : name().toLowerCase();
    }
}