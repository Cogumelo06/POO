import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SemaforosGUI extends JFrame {
    private Cruzamento cruzamento;
    private JPanel painelSemaforos;

    public SemaforosGUI() {
        setTitle("Sincronização de Semáforos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        cruzamento = new Cruzamento();

        painelSemaforos = new JPanel();
        painelSemaforos.setLayout(new GridLayout(1, 2));
        add(painelSemaforos, BorderLayout.CENTER);

        // Adiciona dois semáforos no cruzamento e na interface gráfica
        Semaforo semaforo1 = new Semaforo(Semaforo.EstadoSemaforo.VERDE);
        Semaforo semaforo2 = new Semaforo(Semaforo.EstadoSemaforo.VERMELHO);
        cruzamento.adicionaSemaforo(semaforo1);
        cruzamento.adicionaSemaforo(semaforo2);
        painelSemaforos.add(semaforo1);
        painelSemaforos.add(semaforo2);

        JPanel painelControles = new JPanel();
        painelControles.setLayout(new GridLayout(1, 2));
        add(painelControles, BorderLayout.SOUTH);

        JButton iniciarButton = new JButton("Iniciar");
        painelControles.add(iniciarButton);
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cruzamento.sincroniza();
            }
        });

        JButton pararButton = new JButton("Parar");
        painelControles.add(pararButton);
        pararButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cruzamento.pararSincronizacao();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SemaforosGUI().setVisible(true);
            }
        });
    }
}
