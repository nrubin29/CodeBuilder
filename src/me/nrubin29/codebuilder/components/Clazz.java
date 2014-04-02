package me.nrubin29.codebuilder.components;

import me.nrubin29.codebuilder.utils.Language;
import me.nrubin29.codebuilder.utils.Utils;
import me.nrubin29.codebuilder.utils.Visibility;

import javax.swing.*;

public class Clazz extends StatementComponent {

    private final JTextField name;
    private final JComboBox visibility;

    public Clazz() {
        super("cl");

        name = new JTextField();
        visibility = Utils.createComboBox(Visibility.values());

        add(visibility);
        add(name);

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    @Override
    public String toCode(Language lang) {
        if (lang == Language.JAVA) return visibility.getSelectedItem() + " class " + name.getText() + " {";
        return "Not supported.";
    }

    @Override
    public String toSimple() {
        return "Class " + name.getText();
    }
}