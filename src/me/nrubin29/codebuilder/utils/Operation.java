package me.nrubin29.codebuilder.utils;

public enum Operation {

    EQUALS("=="), NOTEQUALS("!="), LESSTHAN("<"), GREATERTHAN(">"), LESSTHANEQUALS(">="), GREATERTHANEQUALS("<=");

    private final String op;

    Operation(String op) {
        this.op = op;
    }

    @Override
    public String toString() {
        return op;
    }
}