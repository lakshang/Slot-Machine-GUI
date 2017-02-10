/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author LakshanG <lakshan.g at your.org>
 */
public class StatisticsWindow {

    JLabel lblMatch, lblMatchVal, lblWon, lblWonMVal, lblWonC, lblWonCVal, lblLostM, lblLostMVal, lblLostC, lblLostCVal, lblAvg, lblAvgVal;

    public void window(int countWin, int countLost, int countMatch, int wonCredits, int lostCredits, float average) {
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(mainFrame.DISPOSE_ON_CLOSE);//close only one window
        mainFrame.setSize(300, 300);
        mainFrame.setResizable(true);
        mainFrame.setVisible(true);
        mainFrame.setLayout(new GridLayout(1, 2));
        mainFrame.setTitle("STATISTICS");

        JPanel amountPanel = new JPanel(new GridLayout(7, 1));
        JPanel resultPanel = new JPanel(new GridLayout(7, 1));
        // JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

        lblMatch = new JLabel(" Number of Matches : ");
        amountPanel.add(lblMatch);
        lblMatchVal = new JLabel(Integer.toString(countMatch));
        resultPanel.add(lblMatchVal);

        lblWon = new JLabel(" Matches Won : ");
        amountPanel.add(lblWon);
        lblWonMVal = new JLabel(Integer.toString(countWin));
        resultPanel.add(lblWonMVal);

        lblLostM = new JLabel(" Matches Lost : ");
        amountPanel.add(lblLostM);
        lblLostMVal = new JLabel(Integer.toString(countLost));
        resultPanel.add(lblLostMVal);

        lblWonC = new JLabel(" Credits Won : ");
        amountPanel.add(lblWonC);
        lblWonCVal = new JLabel(Integer.toString(wonCredits));
        resultPanel.add(lblWonCVal);

        lblLostC = new JLabel(" Credits Lost : ");
        amountPanel.add(lblLostC);
        lblLostCVal = new JLabel(Integer.toString(lostCredits));
        resultPanel.add(lblLostCVal);

        lblAvg = new JLabel(" Average : ");
        amountPanel.add(lblAvg);
        lblAvgVal = new JLabel(Float.toString(average));
        resultPanel.add(lblAvgVal);

        JButton btnSaveAs = new JButton(" Save ");
        resultPanel.add(btnSaveAs);
        btnSaveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                writeStatisticsWindow(countWin, countLost, countMatch, wonCredits, lostCredits, average);
            }
        });
        JButton btnChart = new JButton(" Chart ");
        amountPanel.add(btnChart);
        btnChart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                PieChartTest sc = new PieChartTest("Pie Chart", "Credit Comparison", wonCredits, lostCredits);
                sc.pack();
                sc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                sc.setVisible(true);
            }
        });

        // amountPanel.setBackground(Color.red);
        mainFrame.add(amountPanel);
        mainFrame.add(resultPanel);

    }

    public void writeStatisticsWindow(int countWin, int countLost, int countMatch, int wonCredits, int lostCredits, float average) {
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH-mm-ss");
        Date dObj = new Date();
        String date = df.format(dObj);
        String filename = date + ".txt";

        try {
           
            File f2 = new File(filename);//creates a text file on the src
            f2.createNewFile();//creates a new file
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f2))) {//uses buffered writer to write data line by line

                bw.write(date);
                bw.newLine();
                bw.write("\t Number of Matches  : " + countMatch);
                bw.newLine();
                bw.write("\t Matches Won        : " + countWin);
                bw.newLine();
                bw.write("\t Matches Lost       : " + countLost);
                bw.newLine();
                bw.write("\t Credits Won        : " + wonCredits);
                bw.newLine();
                bw.write("\t Credits Lost       : " + lostCredits);
                bw.newLine();
                bw.write("\t Average            : " + average);
                bw.flush();
                bw.close();
                File filedesktop = new File(filename);
                Desktop file = Desktop.getDesktop();
                file.open(filedesktop);//opens the file from the desktop
            }

        } catch (Exception e) {
            System.err.println("!! File Error ");
        }

    }

}
