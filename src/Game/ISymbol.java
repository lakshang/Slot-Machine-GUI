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
public interface ISymbol{
    
    void setImage(ImageIcon image);
    ImageIcon getImage();
    void setVale(int v);
    int getValue();
    
    
}
