import javax.swing.*;
import java.awt.*;

public class Semaforo extends JPanel {
    private static final int DIAMETRO = 50;
    private static final int ESPACAMENTO = 20;

    public enum EstadoSemaforo {
        VERDE, AMARELO, VERMELHO
    }

    private EstadoSemaforo estado;

    public Semaforo(EstadoSemaforo estadoInicial) {
        this.estado = estadoInicial;
        setPreferredSize(new Dimension(100, 300));
    }

    public void mudarEstado() {
        switch (estado) {
            case VERDE:
                estado = EstadoSemaforo.AMARELO;
                break;
            case AMARELO:
                estado = EstadoSemaforo.VERMELHO;
                break;
            case VERMELHO:
                estado = EstadoSemaforo.VERDE;
                break;
        }
        repaint();
    }

    public EstadoSemaforo getEstado() {
        return estado;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Desenhar luz vermelha
        g2d.setColor(estado == EstadoSemaforo.VERMELHO ? Color.RED : Color.GRAY);
        g2d.fillOval((getWidth() - DIAMETRO) / 2, ESPACAMENTO, DIAMETRO, DIAMETRO);

        // Desenhar luz amarela
        g2d.setColor(estado == EstadoSemaforo.AMARELO ? Color.YELLOW : Color.GRAY);
        g2d.fillOval((getWidth() - DIAMETRO) / 2, 2 * ESPACAMENTO + DIAMETRO, DIAMETRO, DIAMETRO);

        // Desenhar luz verde
        g2d.setColor(estado == EstadoSemaforo.VERDE ? Color.GREEN : Color.GRAY);
        g2d.fillOval((getWidth() - DIAMETRO) / 2, 3 * ESPACAMENTO + 2 * DIAMETRO, DIAMETRO, DIAMETRO);
    }
}
