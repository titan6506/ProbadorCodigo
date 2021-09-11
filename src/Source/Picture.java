package Source;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Picture extends JComponent implements MouseListener, FocusListener, Accessible { // JPanel hereda de JComponent
    private Image image;

    public Picture(Image image){
        this.image= image;
        setFocusable(true);
        addMouseListener(this);
        addFocusListener(this);
    }

    protected void painComponent(Graphics graphics){
        Graphics q = graphics.create();
        q.setColor(Color.WHITE);

        q.fillRect(0,0, image == null ? 125 : image.getWidth(this),
                image == null ? 125 : image.getHeight(this));

        if(image != null){
            q.drawImage(image,0,0,this);
        }

        if (isFocusOwner()){
            q.setColor(Color.red);
        }else{
            q.setColor(Color.BLACK);
        }
        q.drawRect(0,0, image == null ? 125 : image.getWidth(this),
                image == null ? 125 : image.getHeight(this));
        q.dispose();
    }


    @Override
    public void focusGained(FocusEvent e) {
this.repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        requestFocusInWindow();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) { // mouse hoovering
    requestFocusInWindow();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
