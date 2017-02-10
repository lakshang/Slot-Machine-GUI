/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author LakshanG <lakshan.g at your.org>
 */
public class Reel extends Thread {

    static Symbol[] imageArray = new Symbol[6];

    private int randomNum;
    private JLabel lblimage;
    private JPanel reelPanel;

    public Reel(JLabel lblimage, JPanel reelPanel) {
        this.lblimage = lblimage;
        this.reelPanel = reelPanel;

    }

    public Reel() {
    }//default constructor

    /**
     * @return the randomNum
     */
    public int getRandomNum() {
        return randomNum;
    }

    /**
     * @param randomNum the randomNum to set
     */
    public void setRandomNum(int randomNum) {
        this.randomNum = getRanNum();
    }

    public void setimageArray() {
        imageArray[0] = new Symbol(new ImageIcon("src/images/bell.png", "Bell"), 6);
        imageArray[1] = new Symbol(new ImageIcon("src/images/cherry.png", "Cherry"), 2);
        imageArray[2] = new Symbol(new ImageIcon("src/images/lemon.png", "Lemon"), 3);
        imageArray[3] = new Symbol(new ImageIcon("src/images/plum.png", "Plum"), 4);
        imageArray[4] = new Symbol(new ImageIcon("src/images/redseven.png", "Redseven"), 7);
        imageArray[5] = new Symbol(new ImageIcon("src/images/watermelon.png", "Watermelon"), 5);
    }//sets the images along with the required amounts

    public void spin(JLabel lblimage) {

        randomNum = getRanNum();
        lblimage.setIcon(new ImageIcon((imageArray[randomNum].getImage().getImage().getScaledInstance(reelPanel.getWidth() - 10, reelPanel.getHeight() - 10, Image.SCALE_DEFAULT))));
        //pass the random number and gets the required image
    }

    Timer timer;//calls the timer class

    public void run() {
        setimageArray();//sets the image array
        timer = new Timer(25, new ActionListener() {//delay of 25 milliseconds
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of generated methods, choose Tools | Templates.
                spin(lblimage);//perfom spin action
            }
        });

        timer.start();//starts the timer
    }

    public void spinStop() {
       
            timer.stop();//stops the timer       
        
    }

    public int getRanNum() {
        int x = (int) (Math.random() * imageArray.length);

        return x;//generates a random num and returns
    }

    public int calculate(int x, int y, int winCredit) {
        winCredit = imageArray[x].getValue() * y;
        return winCredit;
        //calculates the credits as needed
    }
}
