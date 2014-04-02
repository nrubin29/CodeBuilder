package me.nrubin29.codebuilder.components;

import me.nrubin29.codebuilder.CodeBuilder;
import me.nrubin29.codebuilder.utils.Language;

import javax.imageio.ImageIO;
import javax.swing.*;

public abstract class StatementComponent extends JPanel {

    private ImageIcon icon;

    StatementComponent(String iconName) {
        try {
            icon = new ImageIcon(ImageIO.read(CodeBuilder.class.getResource("/res/" + iconName + ".png")));
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public abstract String toCode(Language lang);

    public abstract String toSimple();
}