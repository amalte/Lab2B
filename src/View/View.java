package View;

import javax.swing.*;

public abstract class View extends JPanel {

    protected int width;
    protected int height;

    public View(int width, int height) {
        this.width = width;
        this.height = height;
    }

    protected abstract void initComponents();
    public abstract void updateView();
}
