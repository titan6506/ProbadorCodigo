package Source;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class trackFocusDemo extends JPanel {
    Picture pic1, pic2, pic3, pic4, pic5, pic6;
    JLabel info;
    static String mayaString = "Maya";
    static String anyaString = "Anya";
    static String laineString = "Laine";
    static String cosmoString = "Cosmo";
    static String adeleString = "Adele";
    static String alexiString = "Alexi";


    String[] comments = {" Ah! Que es esto?",
        "Esta es Maya",
            "Esta es Anya",
            "Esta es Laine",
            "Este es Cosmo",
            "Esta es Adele",
            "Este es Alexi",};

    public trackFocusDemo(){
        super(new BorderLayout());

        JPanel panelFotos = new JPanel(new GridLayout(2, 3));
        pic1 = new Picture(createImageIcon("/Images/" + mayaString + ".jpg",
                mayaString).getImage());
        pic1.setName("1");
        panelFotos.add(pic1);
        pic2 = new Picture(createImageIcon("/Images/" + anyaString + ".jpg",
                anyaString).getImage());
        pic2.setName("1");
        panelFotos.add(pic2);
        pic3 = new Picture(createImageIcon("/Images/" + laineString + ".jpg",
                laineString).getImage());
        pic3.setName("1");
        panelFotos.add(pic3);
        pic4 = new Picture(createImageIcon("/Images/" + cosmoString + ".jpg",
                cosmoString).getImage());
        pic4.setName("1");
        panelFotos.add(pic4);
        pic5 = new Picture(createImageIcon("/Images/" + adeleString + ".jpg",
                adeleString).getImage());
        pic5.setName("1");
        panelFotos.add(pic5);
        pic6= new Picture(createImageIcon("/Images/" + alexiString + ".jpg",
                alexiString).getImage());
        pic6.setName("1");
        panelFotos.add(pic6);

        info = new JLabel("Nada seleccionado");

        setPreferredSize(new Dimension(800,600));
        add(panelFotos,BorderLayout.CENTER);
        add(info,BorderLayout.SOUTH);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        KeyboardFocusManager focusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        focusManager.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                String prop = event.getPropertyName();
                if(("focusOwner".equals(prop)) && (event.getNewValue() instanceof Picture));
                Component comp = (Component) event.getNewValue();
                String name = comp.getName();
                int num = Integer.parseInt(name);
                if( num < 0 || num > comments.length){
                    num = 0;
                }
                info.setText(comments[num]);
            }
        });

    }

    protected static void crearMostrarGUI(){
        JFrame frame = new JFrame("Fotos y foco");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         JComponent newContentPane = new trackFocusDemo();
         newContentPane.setOpaque(true);
         frame.setContentPane(newContentPane);
         frame.pack();
         frame.setVisible(true);
    }

     public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                crearMostrarGUI();
            }
        });
    }

    protected static ImageIcon createImageIcon(String path, String description){
        java.net.URL imageURL = trackFocusDemo.class.getResource(path);
        if(imageURL == null){
            System.err.println("No se encuentra el archivo" + path);
            return null;
        }else{
            return new ImageIcon(imageURL, description);
        }
    }

}
