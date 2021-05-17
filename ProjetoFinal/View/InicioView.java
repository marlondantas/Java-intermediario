package View;

import javax.swing.*;
import java.awt.*;

public class InicioView {
    
    public static JPanel getInicioView(){
        JPanel jPanelInicioView = new JPanel();
        jPanelInicioView.setLayout(null);

        JLabel lJLabelTitula = new JLabel("Escolha a opção no menu superior",JLabel.CENTER);
        
        criarComponetes(jPanelInicioView,lJLabelTitula);
        criarEventos(jPanelInicioView, lJLabelTitula);
        
        jPanelInicioView.setVisible(true);
        return jPanelInicioView;
    }

    private static void criarComponetes(JPanel jPanelInicioView, JLabel lJLabelTitula){
        lJLabelTitula.setBounds(20,100,660,40);
        jPanelInicioView.add(lJLabelTitula);
    }
    
    private static void criarEventos(JPanel jPanelInicioView, JLabel lJLabelTitula){

    }

}
