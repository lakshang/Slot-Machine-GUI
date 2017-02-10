/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import javax.swing.ImageIcon;

/**
 *
 * @author LakshanG <lakshan.g at your.org>
 */
public class Symbol implements ISymbol {

    private ImageIcon image;
    private int value;
//    private JLabel lblimage;
//    private JPanel reelPanel;
//    slotmachineWindow sw = new slotmachineWindow();

    public Symbol(ImageIcon image, int value) {

        this.setImage(image);//sets the image
        this.setVale(value);//sets the random value

    }
    public Symbol(){}

    @Override
    public void setImage(ImageIcon image) {
        this.image = image;
    }//sets the image to the image icon

    @Override
    public ImageIcon getImage() {
        return image;
    }

    @Override
    public void setVale(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    public int compareImages(Reel reel1, Reel reel2, Reel reel3) {
        if (reel1.getRandomNum() == reel2.getRandomNum() && reel1.getRandomNum() == reel3.getRandomNum()) {
            return 0;
        } else if (reel1.getRandomNum() == reel2.getRandomNum() || reel1.getRandomNum() == reel3.getRandomNum() || reel2.getRandomNum() == reel3.getRandomNum()) {
            return 1;
        } else {
            return 2;
        }

    }

}
