package me.nrubin29.codebuilder;

import me.nrubin29.codebuilder.components.StatementComponent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class CodeBuilder extends JFrame {

    private final JTree tree;
    private final HashMap<String, StatementComponent> components;

    private CodeBuilder() {
        super("CodeBuilder");

        components = new HashMap<String, StatementComponent>();

        tree = new JTree();
        tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Project")));
        tree.setBorder(new EmptyBorder(5, 5, 5, 5));
        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!e.getComponent().equals(tree) || tree.getSelectionPath() == null) return;

                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (e.getClickCount() == 2) {
                        if (components.get(tree.getSelectionPath().toString()) == null) System.out.println("Null");
                        JOptionPane.showMessageDialog(CodeBuilder.this, components.get(tree.getSelectionPath().toString()));
                    }
                } else {
                    new ComponentSelector(CodeBuilder.this);
                }
            }
        });

        add(tree);

        setSize(640, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CodeBuilder();
    }

    public void addItem(StatementComponent sc) {
        components.put(tree.getSelectionPath().pathByAddingChild(sc.toSimple()).toString(), sc);
        ((DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent()).add(new DefaultMutableTreeNode(sc.toSimple()));
    }
}