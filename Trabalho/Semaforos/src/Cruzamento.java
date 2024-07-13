import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cruzamento {
    private List<Semaforo> semaforos;
    private Timer timer;
    private int estado;

    public Cruzamento() {
        this.semaforos = new ArrayList<>();
        this.estado = 0;
    }

    public void adicionaSemaforo(Semaforo semaforo) {
        semaforos.add(semaforo);
    }

    public void sincroniza() {
        timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estado == 0) {
                    semaforos.get(0).mudarEstado(); // Verde para Amarelo
                    estado = 1;
                } else if (estado == 1) {
                    semaforos.get(0).mudarEstado(); // Amarelo para Vermelho
                    semaforos.get(1).mudarEstado(); // Vermelho para Verde
                    estado = 2;
                } else if (estado == 2) {
                    semaforos.get(1).mudarEstado(); // Verde para Amarelo
                    estado = 3;
                } else if (estado == 3) {
                    semaforos.get(1).mudarEstado(); // Amarelo para Vermelho
                    semaforos.get(0).mudarEstado(); // Vermelho para Verde
                    estado = 0;
                }
            }
        });
        timer.start();
    }

    public void pararSincronizacao() {
        if (timer != null) {
            timer.stop();
            timer = null;
        }
    }

    public int totalDeSemaforos() {
        return semaforos.size();
    }

    public List<Semaforo> getSemaforos() {
        return semaforos;
    }
}
