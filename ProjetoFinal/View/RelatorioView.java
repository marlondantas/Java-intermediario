package View;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import Controller.Conn;

public class RelatorioView {

    private static final String RELATORIO_CARGO = "select cargo.ds_carga, count(*) as quantidade from cursoJava.tbod_cargo cargo inner join cursoJava.tbod_funcionario funci on funci.id_cargo = cargo.id_cargo group by cargo.ds_carga order by cargo.ds_carga asc"; 

    private static final String RELATORIO_FUNCIOARIO = "select	count(case when vl_salario < 1000 then 1 end),     count(case when vl_salario >= 1000 and vl_salario < 2000 then 1 end),     count(case when vl_salario >= 2000 and vl_salario < 3000 then 1 end),     count(case when vl_salario >= 3000 and vl_salario < 4000 then 1 end),     count(case when vl_salario >= 4000 and vl_salario < 5000 then 1 end),     count(case when vl_salario >= 5000 then 1 end) from cursoJava.tbod_funcionario";

    public static JPanel getRelatorioCargo(){
        JPanel relatorioCargo = new JPanel();
        relatorioCargo.setLayout(null);

        JLabel jLabelTitulo = new JLabel("Relatórios",JLabel.CENTER);
        jLabelTitulo.setFont(new Font(jLabelTitulo.getFont().getName(),Font.PLAIN, 18));
        JLabel jLabelDescricao = new JLabel("Esse gráfico representa a quantidade de funcionario por cargo",JLabel.CENTER);

        DefaultPieDataset datasetGraficos = RelatorioView.getDefaultPieDataset(RelatorioView.RELATORIO_CARGO);

        JFreeChart freeChartSome = ChartFactory.createPieChart("", datasetGraficos,false,true,false);
        PiePlot plot = (PiePlot) freeChartSome.getPlot();
        
        plot.setLabelBackgroundPaint(Color.white);
        plot.setBackgroundPaint(null);
        plot.setOutlinePaint(null);

        freeChartSome.setBackgroundPaint(null);

        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator("{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        plot.setLabelGenerator(gen);

        ChartPanel chartPanel = new ChartPanel(freeChartSome){

            @Override
            public Dimension getPreferredSize(){
                return new Dimension(660,340);
            }

        };

        jLabelTitulo.setBounds(20, 20, 660, 40);
        jLabelDescricao.setBounds(20, 50, 660, 40);
        chartPanel.setBounds(20,100,660,340);
        
        relatorioCargo.add(jLabelTitulo);
        relatorioCargo.add(jLabelDescricao);
        relatorioCargo.add(chartPanel);
        
        relatorioCargo.setVisible(true);

        return relatorioCargo;
    }

    public static JPanel getRelatorioFuncionario(){
        JPanel relatorioCargo = new JPanel();
        relatorioCargo.setLayout(null);

        JLabel jLabelTitulo = new JLabel("Relatórios",JLabel.CENTER);
        jLabelTitulo.setFont(new Font(jLabelTitulo.getFont().getName(),Font.PLAIN, 18));
        JLabel jLabelDescricao = new JLabel("Esse gráfico representa a quantidade de funcionario por FUNCIONARIO",JLabel.CENTER);

        CategoryDataset datasetGraficos = RelatorioView.getCategoryDataset(RelatorioView.RELATORIO_FUNCIOARIO);

        JFreeChart freeChartSome = ChartFactory.createBarChart3D("",null,"Quantidade de funcionarios",datasetGraficos,PlotOrientation.VERTICAL,true,true,false);
        CategoryPlot plot = (CategoryPlot) freeChartSome.getCategoryPlot();

        plot.setBackgroundPaint(null);
        plot.setOutlinePaint(null);
        freeChartSome.setBackgroundPaint(null);

        plot.getRangeAxis().setLowerBound(0);
        plot.getRangeAxis().setRange(new Range(0, 5));
        plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        plot.getRangeAxis().setAutoRange(false);

        Font font3  = new Font(jLabelTitulo.getFont().getName(),Font.PLAIN, 10);
        plot.getRangeAxis().setLabelFont(font3);

        plot.getDomainAxis().setVisible(true);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setItemMargin(-2);

        ChartPanel chartPanel = new ChartPanel(freeChartSome){

            @Override
            public Dimension getPreferredSize(){
                return new Dimension(660,340);
            }

        };

        jLabelTitulo.setBounds(20, 20, 660, 40);
        jLabelDescricao.setBounds(20, 50, 660, 40);
        chartPanel.setBounds(20,100,660,340);
        
        relatorioCargo.add(jLabelTitulo);
        relatorioCargo.add(jLabelDescricao);
        relatorioCargo.add(chartPanel);
        
        relatorioCargo.setVisible(true);

        return relatorioCargo;
    }


    private static DefaultPieDataset getDefaultPieDataset(String query){
        DefaultPieDataset dados = new DefaultPieDataset();

        ResultSet resultadoRelatorio;
        

        try {
            resultadoRelatorio = Conn.selectQuery(query, Conn.getStatement());
            while(resultadoRelatorio.next()){
                dados.setValue(resultadoRelatorio.getString("ds_carga"), resultadoRelatorio.getInt("quantidade"));
            }

            return dados;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    private static CategoryDataset getCategoryDataset(String query){
        DefaultCategoryDataset dados = new DefaultCategoryDataset();

        ResultSet resultadoRelatorio;
        

        try {
            resultadoRelatorio = Conn.selectQuery(query, Conn.getStatement());
            while(resultadoRelatorio.next()){
                //dados.setValue(resultadoRelatorio.getString("ds_carga"), resultadoRelatorio.getInt("quantidade"));
                dados.addValue(resultadoRelatorio.getInt(1),"vl_salario < 1000"," < 1000");
                dados.addValue(resultadoRelatorio.getInt(2),"vl_salario >= 1000 and vl_salario < 2000"," 1000 - 2000 ");
                dados.addValue(resultadoRelatorio.getInt(3),"vl_salario >= 2000 and vl_salario < 3000"," 2000 - 3000 ");
                dados.addValue(resultadoRelatorio.getInt(4),"vl_salario >= 3000 and vl_salario < 4000"," 3000 - 4000 ");
                dados.addValue(resultadoRelatorio.getInt(5),"vl_salario >= 4000 and vl_salario < 5000"," 4000 - 5000 ");
                dados.addValue(resultadoRelatorio.getInt(6),"vl_salario >= 5000"," > 500");
            }

            return dados;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
