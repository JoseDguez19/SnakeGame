
package snake;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class panel extends JPanel{
    
        Color colorf= Color.green;
        int tamaño, tam, cant, res;
        
        public panel(int tamaño, int cant){
            this.tamaño=tamaño;
            this.cant=cant;
            this.tam=tamaño/cant;
            this.res=tamaño%cant;
        }
        @Override
        public void paint(Graphics pintor){
            super.paint(pintor);
            pintor.setColor(colorf);
            for(int i=0;i<cant;i++){
                for(int j=0;j<cant;j++){
                    pintor.fillRect(res/2+i*tam, res/2+j*tam, tam-1, tam-1);
                }
            }
        }
}
