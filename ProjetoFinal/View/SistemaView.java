package View;

import javax.swing.*;

public class SistemaView {

    public static JFrame getFrame(){

        JFrame jFrame = new JFrame("Sistema");
        jFrame.setSize(750, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);

        return jFrame;
    }
    
}
