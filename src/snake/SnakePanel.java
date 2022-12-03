
package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SnakePanel extends JPanel{
    
        Color colors= Color.YELLOW;
        Color colorc= Color.RED;
        int tamaño, tam, cant, res;
        List<int []> vibora= new ArrayList<>();
        int[] comida= new int[2];
        String direcc="de";
        String direccprox="de";
        Thread hilo;
       Caminante moves;
        public SnakePanel(int tamaño, int cant){
            this.tamaño=tamaño;
            this.cant=cant;
            this.tam=tamaño/cant;
            this.res=tamaño%cant;
            int[] a={cant/2-1, cant/2-1};
            int[] b={cant/2, cant/2-1};
            vibora.add(a);
            vibora.add(b);
            gcomida();
            moves= new Caminante(this);
            hilo= new Thread(moves);
            hilo.start();
        }
        @Override
        public void paint(Graphics pintor){
            super.paint(pintor);
            pintor.setColor(colors);
            for (int i=0; i < vibora.size();i++){
                pintor.fillRect(res/2+vibora.get(i)[0]*tam,res/2+vibora.get(i)[1]*tam , tam-1, tam-1);
            }
            for (int [] par:vibora){
                pintor.fillRect(res/2+par[0]*tam,res/2+par[1]*tam , tam-1, tam-1);
            }
            
            pintor.setColor(colorc);
            pintor.fillRect(res/2+comida[0]*tam,res/2+comida[1]*tam , tam-1, tam-1);
        }
        public void movimiento(){
            igualardir();
            int[] last=vibora.get(vibora.size()-1);
            int addx=0;
            int addy=0;
            switch(direcc){
                case "de":
                    addx=1;
                    break;
                    case "iz":
                    addx=-1;
                    break;
                    case "ar":
                    addy=-1;
                    break;
                    case "ab":
                    addy=1;
                    break;
            }
            int[] nuevo={Math.floorMod(last[0]+addx, cant),Math.floorMod(last[1]+addy,cant)};
            boolean ex=false;
            for(int i=0;i<vibora.size();i++){
                if(nuevo[0]==vibora.get(i)[0]&& nuevo[1]==vibora.get(i)[1]){
                    ex=true;
                    break;
                }
            }
            if(ex){
                JOptionPane.showMessageDialog(this, "PERDISTE");
                
            }else{
                if(nuevo[0]==comida[0]&&nuevo[1]==comida[1]){
                    vibora.add(nuevo);
                    gcomida();
                }else{
                    vibora.add(nuevo);
                    vibora.remove(0);
                }
            }
        }
        public void gcomida(){
            boolean ex=false;
            int a= (int)(Math.random()*cant);
            int b= (int)(Math.random()*cant);
            for(int[] par:vibora){
                if(par[0]==a&&par[1]==b){
                    ex=true;
                    gcomida();
                    break;
                }
            }
            if(!ex){
                this.comida[0]=a;
                this.comida[1]=b;
            }
        }
        public void cambiardir(String dir){
            if((this.direcc.equals("de")||this.direcc.equals("iz"))&&(dir.equals("ar")||dir.equals("ab"))){
                            this.direccprox=dir;
            }if((this.direcc.equals("ar")||this.direcc.equals("ab"))&&(dir.equals("iz")||dir.equals("de"))){
                            this.direccprox=dir;
            }

        }
        public void igualardir(){
            this.direcc=this.direccprox;
        }
}

    

