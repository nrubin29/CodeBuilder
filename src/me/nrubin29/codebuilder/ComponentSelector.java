package me.nrubin29.codebuilder;

import me.nrubin29.codebuilder.components.Clazz;
import me.nrubin29.codebuilder.components.CustomLine;
import me.nrubin29.codebuilder.components.If;
import me.nrubin29.codebuilder.components.StatementComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ComponentSelector extends JFrame {

    private final Class[] components = new Class[]{Clazz.class, CustomLine.class, If.class};

    public ComponentSelector(final CodeBuilder code) {
        super("Component Selector");

        for (final Class c : components) {
            try {
                final StatementComponent sc = (StatementComponent) c.newInstance();
                JLabel label = new JLabel(c.getSimpleName(), sc.getIcon(), JLabel.CENTER);
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (JOptionPane.showConfirmDialog(ComponentSelector.this, sc) == JOptionPane.OK_OPTION) {
                            code.addItem(sc);
                            dispose();
                        }
                    }
                });
                add(label);
            } catch (Exception ignored) {
            }
        }

        setLayout(new GridLayout(2, 2));
        setSize(320, 240);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}