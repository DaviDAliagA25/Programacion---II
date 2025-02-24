package circulografico;
/**
 *
 * @author DAVID
 */
import javax.swing.*;
import java.awt.*;

class Punto {
    public float x, y;

    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }
}

class Circulo extends JPanel {
    public Punto centro;
    public float radio;

    public Circulo(Punto centro, float radio) {
        this.centro = centro;
        this.radio = radio;
        setPreferredSize(new Dimension(450, 450));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        
        float centroX = centro.x * 10;
        float centroY = centro.y * 10;
        float diametro = 2 * radio * 10;
        g.drawOval((int)centroX, (int)centroY, (int)diametro, (int)diametro);
    }

    public void mostrar() {
        JFrame frame = new JFrame("Dibujar Círculo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
    }
}

public class CirculoGrafico {
    public static void main(String[] args) {
        Punto centro = new Punto(3, 3);
        float radio = 10;
        Circulo circulo = new Circulo(centro, radio);
        circulo.mostrar(); 
    }
}
