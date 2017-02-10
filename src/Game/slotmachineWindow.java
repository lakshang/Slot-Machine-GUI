/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;

/**
 *
 * @author LakshanG <lakshan.g at your.org>
 */
public class slotmachineWindow {

    private JButton btnAddCoin;
    private JButton btnSpin;
    private JButton btnReset;
    private JButton btnStatistics;
    private JButton btnBetMax;
    private JButton btnBetOne;
    private JFrame frame;
    private JPanel panelReel1, panelReel2, panelReel3;
    private JLabel lblReel1, lblReel2, lblReel3;
    private JLabel lblbetOne, lbladdCredit, lblinfo, lblinfo1;
    private static int iniCredit = 10;
    private static int iniBet = 0;
    public static int countWin, countLost, countMatch, wonCredits, lostCredits, winCredit;
    private static float average;
    Symbol sym = new Symbol();
    Reel reel1 = new Reel(lblReel1, panelReel1);
    Reel reel2 = new Reel(lblReel2, panelReel2);
    Reel reel3 = new Reel(lblReel3, panelReel3);
    Reel reel = new Reel();
    StatisticsWindow sw = new StatisticsWindow();
    private static int reelNum1, reelNum2, reelNum3;
    // private static int winCredit, creditValue, winCount,creditsWon,lostCount,creditsLost;

    public void layoutSlotMachine() {
        frame = new JFrame();
        frame.setResizable(true);
        frame.setLayout(new GridLayout(4, 1)); //4rows and 1column
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setTitle("SLOT MACHINE APPLICATION");
        //frame.se

        JPanel panelReel = new JPanel(new GridLayout(1, 3));
        //panelReel.setBackground(Color.red);
        frame.add(panelReel);

        panelReel1 = new JPanel();
        // panelReel1.setBackground(Color.black);
        panelReel.add(panelReel1);
        lblReel1 = new JLabel();
        lblReel1.setText(" ");

        panelReel.addMouseListener(new MouseAdapter() {//mouse click to stop the reels spinning

            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                try {

                    reel1.spinStop();
                    reel2.spinStop();
                    reel3.spinStop();
                    btnBetOne.setEnabled(true);
                    btnBetMax.setEnabled(true);
                    btnAddCoin.setEnabled(true);
                    btnSpin.setEnabled(true);
                    btnStatistics.setEnabled(true);
                    btnReset.setEnabled(true);
                    results();
                } catch (NullPointerException e) {
                    //JOptionPane.showMessageDialog(null, " Please Place a Bet ! ");
                }
            }
        });

        panelReel1.add(lblReel1);

        panelReel2 = new JPanel();

        //panelReel2.setBackground(Color.BLUE);
        panelReel.add(panelReel2);
        lblReel2 = new JLabel();
        lblReel2.setText("");
        panelReel2.add(lblReel2);

        panelReel3 = new JPanel();
        // panelReel3.setBackground(Color.red);
        panelReel.add(panelReel3);
        lblReel3 = new JLabel();
        lblReel3.setText("");

        panelReel3.add(lblReel3);

        JPanel panelSpinbtn = new JPanel(new GridLayout(1, 1));
        panelSpinbtn.setBackground(Color.yellow);
        frame.add(panelSpinbtn);

        btnSpin = new JButton("Spin");//Spin Button
        btnSpin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (iniBet == 0) {
                    JOptionPane.showMessageDialog(null, "Place a bet !");

                } else {

                    reel1 = new Reel(lblReel1, panelReel1);
                    reel2 = new Reel(lblReel2, panelReel2);
                    reel3 = new Reel(lblReel3, panelReel3);
                    reel1.start();
                    reel2.start();
                    reel3.start();
                    btnBetOne.setEnabled(false);
                    btnBetMax.setEnabled(false);
                    btnAddCoin.setEnabled(false);
                    btnSpin.setEnabled(false);
                    btnStatistics.setEnabled(false);
                    btnReset.setEnabled(false);
                    countMatch++;
                }
            }
        });
        panelSpinbtn.add(btnSpin);

        JPanel panelInfo = new JPanel();
        frame.add(panelInfo);
        panelInfo.setLayout(new GridLayout(1, 3));

        JPanel panelCreditArea = new JPanel(new GridLayout(3, 1));
        panelCreditArea.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        panelCreditArea.add(new JLabel("Credit Area"));

        lbladdCredit = new JLabel("Credits : 10 ");

        panelCreditArea.add(lbladdCredit);

        btnAddCoin = new JButton("Add Coin");//Add Coin Button
        panelCreditArea.add(btnAddCoin);
        btnAddCoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniCredit += 1;
                lbladdCredit.setText("Credits : " + iniCredit);

            }
        });

        panelInfo.add(panelCreditArea);

        JPanel panelGameInfo = new JPanel(new GridLayout(3, 1));
        panelGameInfo.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        panelGameInfo.add(new JLabel("Game Info"));
        lblinfo = new JLabel("                        Welcome ");
        lblinfo1 = new JLabel("                     Slot Machine");
        panelGameInfo.add(lblinfo);
        panelGameInfo.add(lblinfo1);
        panelInfo.add(panelGameInfo);

        JPanel panelBetArea = new JPanel(new GridLayout(3, 1));
        panelBetArea.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
        panelBetArea.add(new JLabel("Bet Area"));
        panelBetArea.add(new JLabel(""));

        lblbetOne = new JLabel("Bet Amount: 0");
        panelBetArea.add(lblbetOne);
        panelBetArea.add(new JLabel(""));

        btnBetOne = new JButton("Bet One");//Bet One Button
        panelBetArea.add(btnBetOne);
        btnBetOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (iniCredit > 0) {
                    if (iniBet == 3) {
                        JOptionPane.showMessageDialog(null, "Maximum Bet is 3");
                    } else {
                        iniBet += 1;
                        lblbetOne.setText("Bet Amount: " + iniBet);
                        iniCredit -= 1;
                        lbladdCredit.setText("Credits : " + iniCredit);
                    }
                } else {

                    JOptionPane.showMessageDialog(null, " Insufficient Credits");
                }

            }
        });

        btnBetMax = new JButton("Bet Max");//Bet Max Button
        panelBetArea.add(btnBetMax);
        panelInfo.add(panelBetArea);
        btnBetMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (iniCredit >= 3) {
                    if (iniBet == 3) {
                        JOptionPane.showMessageDialog(null, "Maximum Bet is 3");
                    } else {
                        iniCredit += iniBet;
                        iniBet = 3;
                        lblbetOne.setText("Bet Amount: " + iniBet);
                        iniCredit -= 3;
                        lbladdCredit.setText("Credits : " + iniCredit);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, " Insufficient Credits ");
                }

            }
        });

        JPanel panelResetStats = new JPanel();
        frame.add(panelResetStats);

        btnReset = new JButton("Reset");// Reset Button
        panelResetStats.add(btnReset);
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniCredit += iniBet;
                iniBet = 0;
                lblbetOne.setText("Bet Amount: " + iniBet);
                lbladdCredit.setText("Credits : " + iniCredit);

            }
        });

        btnStatistics = new JButton("Statistics");
        panelResetStats.add(btnStatistics);
        btnStatistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                average();
                if (countMatch > 0) {
                    sw = new StatisticsWindow();
                    sw.window(countWin, countLost, countMatch, wonCredits, lostCredits, average);
                }
            }
        });

        frame.setVisible(true);
    }

    private void average() {
        if (countMatch > 0) {
            average = (wonCredits - lostCredits) / countMatch;
        } else {
            JOptionPane.showMessageDialog(null, "Zero Matches Played !");
        }

    }

    private void results() {
        reel.setimageArray();
        reelNum1 = reel1.getRandomNum();
        reelNum2 = reel2.getRandomNum();
        reelNum3 = reel3.getRandomNum();

        int x = sym.compareImages(reel1, reel2, reel3);
        switch (x) {
            case 0:
                winCredit = reel.calculate(reelNum1, 3, winCredit);
                iniCredit += winCredit;
                lblinfo.setText(" You Won ! ");
                lblinfo1.setText(" Credits Won : " + winCredit);
                winCredit++;
                wonCredits += winCredit;
                break;
            case 1:
                if (reelNum1 == reelNum2 || reelNum1 == reelNum3) {
                    winCredit = reel.calculate(reelNum1, 2, winCredit);
                    iniCredit += winCredit;

                } else if (reelNum2 == reelNum3) {
                    winCredit = reel.calculate(reelNum2, 2, winCredit);
                    iniCredit += winCredit;
                }
                lblinfo.setText(" You Won ! ");
                lblinfo1.setText(" Credits Won : " + winCredit);
                countWin++;
                wonCredits += winCredit;
                break;
            default:
                lblinfo.setText(" You Lost ! ");
                lblinfo1.setText(" Credits Won : 0 ");
                countLost++;
                lostCredits += iniBet;
                break;
        }
        lbladdCredit.setText("Credits : " + iniCredit);
        iniBet = 0;
        lblbetOne.setText("Bet Amount: " + iniBet);
    }

    public static void main(String[] args) {
        slotmachineWindow sw = new slotmachineWindow();
        sw.layoutSlotMachine();

    }

}
