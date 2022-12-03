
package snake;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Caminante implements Runnable {
    SnakePanel panel;
    boolean estado=true;

public Caminante(SnakePanel panel){
    this.panel=panel;
    }
    @Override
    public void run() {
        while(estado){
//        panel.movimiento();
//        panel.repaint();
        try {
            Thread.sleep(250);
            panel.movimiento();
        panel.repaint();
        } catch (InterruptedException ex) {
            Logger.getLogger(Caminante.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}

    public void parar(){
        this.estado=false;
        
    }
    
}
