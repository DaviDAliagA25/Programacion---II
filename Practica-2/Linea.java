package lineagrafico;
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

class Linea extends JPanel {
    public Punto p1, p2;

    public Linea(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
        setPreferredSize(new Dimension(450, 450)); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        
        float p1x = p1.x * 10;
        float p1y = p1.y * 10;
        float p2x = p2.x * 10;
        float p2y = p2.y * 10;
        g.drawLine((int)p1x, (int)p1y, (int)p2x, (int)p2y);
    }

    public void mostrar() {
        JFrame frame = new JFrame("Dibujar Línea");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this); 
        frame.pack(); 
        frame.setVisible(true);
    }
}

public class LineaGrafico {
    public static void main(String[] args) {
        Punto p1 = new Punto(25, 25);
        Punto p2 = new Punto(3, 3);
        Linea linea = new Linea(p1, p2);
        linea.mostrar();
    }
}
