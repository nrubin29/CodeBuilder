package me.nrubin29.codebuilder.components;

import me.nrubin29.codebuilder.utils.Language;
import me.nrubin29.codebuilder.utils.Operation;
import me.nrubin29.codebuilder.utils.Utils;

import javax.swing.*;

public class If extends StatementComponent {

    private final JTextField a, b;
    private final JComboBox operator;

    public If() {
        super("if");

        a = new JTextField();
        b = new JTextField();
        operator = Utils.createComboBox(Operation.values());

        add(a);
        add(operator);
        add(b);

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    @Override
    public String toCode(Language lang) {
        if (lang == Language.JAVA)
            return "if (" + a.getText() + " " + operator.getSelectedItem() + " " + b.getText() + ") {";
        return "Not supported.";
    }

    @Override
    public String toSimple() {
        return "If " + a.getText() + " " + ((Operation) operator.getSelectedItem()).name().toLowerCase() + " " + b.getText();
    }
}