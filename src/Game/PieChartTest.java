/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author LakshanG <lakshan.g at your.org>
 */
public class PieChartTest extends JFrame{

    public PieChartTest(String appTitle, String chartTitle,int wonCredits, int lostCredits){
    PieDataset dataset= createDataset(wonCredits, lostCredits);  
    JFreeChart chart = createChart(dataset, chartTitle);
    ChartPanel  chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(500,300));
        this.setContentPane(chartPanel);
        
    
    }
    
    
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
////        PieChartTest sc = new PieChartTest("Pie Chart Test", "OS Comparision");
////        sc.pack();
////        sc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        sc.setVisible(true);
//    }

    private PieDataset createDataset(int wonCredits, int lostCredits) {
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("Won Credits", wonCredits);
        result.setValue("Lost Credits", lostCredits);

        return result;
    }
    
    private JFreeChart createChart (PieDataset dataset, String title){
    JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);
    
    PiePlot3D plot = (PiePlot3D) chart.getPlot();
    plot.setStartAngle(0);
    plot.setDirection(Rotation.CLOCKWISE);
    plot.setForegroundAlpha(0.5f);
    return chart;
    
    }
    
    
}
