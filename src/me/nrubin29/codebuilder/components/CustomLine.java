package me.nrubin29.codebuilder.components;

import me.nrubin29.codebuilder.utils.Language;

import javax.swing.*;

public class CustomLine extends StatementComponent {

    private final JTextField line;

    public CustomLine() {
        super("ln");

        line = new JTextField();

        add(line);

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    @Override
    public String toCode(Language lang) {
        return line.getText();
    }

    @Override
    public String toSimple() {
        return "Line " + line.getText();
    }
}