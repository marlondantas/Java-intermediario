package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Model.Cargo;
import Model.Funcionario;
import View.Cargo.CargoViewAdicionar;
import View.Cargo.CargoViewConsultar;
import View.Cargo.CargoViewEditar;
import View.Funcionario.FuncionarioViewAdicionar;
import View.Funcionario.FuncionarioViewConsultar;
import View.Funcionario.FuncionarioViewEditar;

public class SistemaView {

    public static JFrame jFrameSistema;
    public static JPanel jPanelSistema;

    public static JFrame getFrame(){

        JFrame jFrame = new JFrame("Sistema");
        jFrame.setSize(750, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);

        return jFrame;
    }
    
    public static JMenuBar getMenuBar(){
        JMenuBar jMenuBar = new JMenuBar();

        JMenu jMenuArquivo = new JMenu("Arquivo");
        JMenu jMenuFuncionario = new JMenu("Funcionario");
        JMenu jMenuCargos = new JMenu("Cargos");
        JMenu jMenuRelatorios = new JMenu("Relatórios");

        JMenuItem jMenuItemSair = new JMenuItem("Sair"); 
        JMenuItem jMenuItemInicio = new JMenuItem("Inicio"); 
        JMenuItem jMenuItemFuncionarioConsultar = new JMenuItem("Consultar"); 
        JMenuItem jMenuItemFuncionarioCadastrar = new JMenuItem("Cadastrar"); 
        JMenuItem jMenuItemCangoConsultar = new JMenuItem("Consultar"); 
        JMenuItem jMenuItemCangoCadastrar = new JMenuItem("Cadastrar"); 
        JMenuItem jMenuItemRelatorioCargo = new JMenuItem("Funcionários por cargos"); 
        JMenuItem jMenuItemRelatorioSalarios = new JMenuItem("Salários dos funcionário"); 

        criarComponetes(jMenuBar, jMenuArquivo, jMenuFuncionario, jMenuCargos, jMenuRelatorios, jMenuItemSair, jMenuItemFuncionarioConsultar, jMenuItemFuncionarioCadastrar, jMenuItemCangoConsultar, jMenuItemCangoCadastrar, jMenuItemRelatorioCargo, jMenuItemRelatorioSalarios,jMenuItemInicio);
        criarEventos(jMenuBar, jMenuArquivo, jMenuFuncionario, jMenuCargos, jMenuRelatorios, jMenuItemSair, jMenuItemFuncionarioConsultar, jMenuItemFuncionarioCadastrar, jMenuItemCangoConsultar, jMenuItemCangoCadastrar, jMenuItemRelatorioCargo, jMenuItemRelatorioSalarios,jMenuItemInicio);

        return jMenuBar;
    }

    private static void criarComponetes(JMenuBar jMenuBar, JMenu jMenuArquivo, JMenu jMenuFuncionario, JMenu jMenuCargos, JMenu jMenuRelatorios,  JMenuItem jMenuItemSair,  JMenuItem jMenuItemFuncionarioConsultar, JMenuItem jMenuItemFuncionarioCadastrar, JMenuItem jMenuItemCangoConsultar,
    JMenuItem jMenuItemCangoCadastrar, JMenuItem jMenuItemRelatorioCargo, JMenuItem jMenuItemRelatorioSalarios, JMenuItem jMenuItemInicio){

        jMenuBar.add(jMenuArquivo);
        jMenuArquivo.add(jMenuItemInicio);
        jMenuArquivo.add(jMenuItemSair);

        jMenuBar.add(jMenuFuncionario);
        jMenuFuncionario.add(jMenuItemFuncionarioCadastrar);
        jMenuFuncionario.add(jMenuItemFuncionarioConsultar);

        jMenuBar.add(jMenuCargos);
        jMenuCargos.add(jMenuItemCangoCadastrar);
        jMenuCargos.add(jMenuItemCangoConsultar);

        jMenuBar.add(jMenuRelatorios);
        jMenuRelatorios.add(jMenuItemRelatorioCargo);
        jMenuRelatorios.add(jMenuItemRelatorioSalarios);
        
    }

    private static void criarEventos(JMenuBar jMenuBar, JMenu jMenuArquivo, JMenu jMenuFuncionario, JMenu jMenuCargos, JMenu jMenuRelatorios,  JMenuItem jMenuItemSair,  JMenuItem jMenuItemFuncionarioConsultar, JMenuItem jMenuItemFuncionarioCadastrar, JMenuItem jMenuItemCangoConsultar,
        JMenuItem jMenuItemCangoCadastrar, JMenuItem jMenuItemRelatorioCargo, JMenuItem jMenuItemRelatorioSalarios, JMenuItem jMenuItemInicio){
            jMenuItemSair.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    System.exit(0);
                }
            });

            jMenuItemInicio.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    SistemaView.inicio(true);
                }
            });

            jMenuItemFuncionarioConsultar.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                   SistemaView.funcionarioConsulta();
                }
            });

            jMenuItemFuncionarioCadastrar.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    SistemaView.funcionarioCadastro();
                }
            });

            jMenuItemCangoConsultar.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    SistemaView.cargoConsulta();
                }
            });

            jMenuItemCangoCadastrar.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    SistemaView.cargoCadastro();
                }
            });
            
            jMenuItemRelatorioCargo.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    SistemaView.relatorioCargo();
                }
            });

            jMenuItemRelatorioSalarios.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    SistemaView.relatorioSalarios();
                }
            });

    }

    // -> Mudancas de frame:
    public static void login(){
        SistemaView.jFrameSistema.getContentPane().removeAll();
        
        SistemaView.jFrameSistema.add(LoginView.getLoginView());
        SistemaView.jFrameSistema.setTitle("Funcionarios Company SA");
    }

    public static void inicio(boolean loginValido){

        if(SistemaView.jFrameSistema.getMenuBar() == null){
            
            SistemaView.jFrameSistema.getContentPane().removeAll();
            
            SistemaView.jFrameSistema.setJMenuBar(getMenuBar());

            SistemaView.jFrameSistema.add(InicioView.getInicioView());
            
            SistemaView.jFrameSistema.setTitle("Funcionarios Company SA");
            SistemaView.jFrameSistema.setVisible(true);
            
        }else{
            SistemaView.jFrameSistema.getContentPane().removeAll();
            SistemaView.jFrameSistema.add(InicioView.getInicioView());
            
            SistemaView.jFrameSistema.setTitle("Funcionarios Company SA");
            SistemaView.jFrameSistema.setVisible(true);
        }
    }

    private static void funcionarioConsulta(){
        SistemaView.jFrameSistema.getContentPane().removeAll();
        SistemaView.jFrameSistema.add(FuncionarioViewConsultar.getCargoViewConsultar());
        SistemaView.jFrameSistema.setTitle("Funcionarios consultar Company SA");
        SistemaView.jFrameSistema.setVisible(true);
    }
    private static void funcionarioCadastro(){
        SistemaView.jFrameSistema.getContentPane().removeAll();
        SistemaView.jFrameSistema.add(FuncionarioViewAdicionar.getFuncionarioView());
        SistemaView.jFrameSistema.setTitle("Funcionarios Adicionar Company SA");   
        SistemaView.jFrameSistema.setVisible(true);
    }

    public static void funcionarioEditar(Funcionario funcionarioAtual){
        SistemaView.jFrameSistema.getContentPane().removeAll();
        SistemaView.jFrameSistema.add(FuncionarioViewEditar.getFuncionarioViewEditar(funcionarioAtual));
        SistemaView.jFrameSistema.setTitle("Funcionarios EDITAR Company SA");   
        SistemaView.jFrameSistema.setVisible(true);
    }



    private static void cargoConsulta(){
        SistemaView.jFrameSistema.getContentPane().removeAll();
        SistemaView.jFrameSistema.add(CargoViewConsultar.getCargoViewConsultar());
        SistemaView.jFrameSistema.setTitle("Cargo consultar Company SA");
        SistemaView.jFrameSistema.setVisible(true);
    }
    private static void cargoCadastro(){
        SistemaView.jFrameSistema.getContentPane().removeAll();
        SistemaView.jFrameSistema.add(CargoViewAdicionar.getCargoViewAdicionar());
        SistemaView.jFrameSistema.setTitle("Cargo Adicionar Company SA");
        SistemaView.jFrameSistema.setVisible(true);
    }

    public static void cargoEditar(Cargo cargoAtual){
        SistemaView.jFrameSistema.getContentPane().removeAll();

        SistemaView.jFrameSistema.add(CargoViewEditar.getCargoViewEditar(cargoAtual));

        SistemaView.jFrameSistema.setTitle("Cargo EDITAR Company SA");   
        SistemaView.jFrameSistema.setVisible(true);
    }


    private static void relatorioCargo(){
        SistemaView.jFrameSistema.getContentPane().removeAll();

        SistemaView.jFrameSistema.add(RelatorioView.getRelatorioCargo());

        SistemaView.jFrameSistema.setTitle("Relatorio CARGOS Company SA");   
        SistemaView.jFrameSistema.setVisible(true);
    }
    
    private static void relatorioSalarios(){
        SistemaView.jFrameSistema.getContentPane().removeAll();

        SistemaView.jFrameSistema.add(RelatorioView.getRelatorioFuncionario());

        SistemaView.jFrameSistema.setTitle("Relatorio Funcionario Company SA");   
        SistemaView.jFrameSistema.setVisible(true);
    }

}
