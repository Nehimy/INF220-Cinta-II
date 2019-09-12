/*
  Enlaces de referencia:
    - https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
    - https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
    - https://javatutorial.net/java-swing-jframe-layouts
    - https://howtodoinjava.com/java-regular-expression-tutorials/
    - https://es.wikipedia.org/wiki/Unicode
    - http://www.fileformat.info/info/unicode/char/00a0/index.htm
*/

import clases.Cinta;
import javax.swing.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.JOptionPane;

public class ventanaJframe {
    // Atributos
    private Cinta objCinta = new Cinta(255);
    private JFrame ventanaM;
    private JButton botonGrabar;
    private JButton botonPlay;
    private JButton botonAnterior;
    private JButton botonSiguiente;
    private JButton botonDetener;
    private JButton botonReiniciar;
    private JTextField texto1;
    private JTextField texto2;
    private JLabel labelCinta;
    private JLabel labelCabezal;
    
    //Método principal
    public static void main(String []args){
      //Variable de tipo ventanaJframe
      new ventanaJframe(); //Pone el nombre a la ventana si JFrame no tiene nombre
    } 
    public ventanaJframe (){
    
      //Variablede tipo JFrame    
      ventanaM = new JFrame("ventanita");
      ventanaM.setSize(550,550);
      ventanaM.getContentPane().setBackground(Color.white);
      ventanaM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*Finaliza el programa*/
      ventanaM.setLayout(new GridBagLayout());  
        
      //Declaramos el botón grabar Rec
      botonGrabar = new JButton("rec");
      botonGrabar.setBackground(Color.pink);
        
      //Declaramos el botón sacar caracter o play
      JButton botonPlay = new JButton("play");
      botonPlay.setBackground(Color.pink);
      
      //Declaramos el botón anterior «
      JButton botonAnterior = new JButton(" « ");
      botonAnterior.setBackground(Color.pink);
      
      //Declaramos el botón siguiente »
      JButton botonSiguiente = new JButton(" » ");
      botonSiguiente.setBackground(Color.pink);
      
      //Declaramos el botón detener ||
      JButton botonDetener = new JButton(" || ");
      botonDetener.setBackground(Color.pink); 
      
      //Declaramos el botón reiniciar ▀
      JButton botonReiniciar = new JButton(" ▀ ");
      botonReiniciar.setBackground(Color.pink);
      
      /*     
      //Declarando caja de texto1
      texto1 = new JTextField("uno");
      //texto.setBackground(new Color(204, 255, 153));
      //texto1.setBackground(Color.green);
        
      //Declarando caja de texto2
      texto2 = new JTextField("dos");
      //texto.setBackground(new Color(204, 255, 153));
      //texto2.setBackground(Color.green);*/
      
      //Crea el objeto JLabel
      labelCinta = new JLabel(" ");
      labelCinta.setFont(new Font("Arial", 0, 18));
      Border borde = BorderFactory.createLineBorder(Color.pink, 2);
      labelCinta.setBorder(borde);
      
      labelCabezal = new JLabel(" ");
      labelCabezal.setFont(new Font("Arial", 0, 18));
      
      //Objeto de configuración del grid
      GridBagConstraints gridConf = new GridBagConstraints();
      gridConf.fill = GridBagConstraints.HORIZONTAL;
      
      /*-------------------------------*/
      /* Adherir elementos a la ventana*/
      /*-------------------------------*/
      
      //Añadir labels a la ventana
      gridConf.gridx = 2;
      gridConf.gridy = 0;
      gridConf.ipady = 20;
      gridConf.ipadx = 15;
      gridConf.insets = new Insets(0,0,0,0); //padding
      gridConf.gridwidth = 2;
      ventanaM.add(labelCinta, gridConf);
      
      gridConf.gridx = 2;
      gridConf.gridy = 1;
      gridConf.insets = new Insets(0,0,0,0);
      ventanaM.add(labelCabezal, gridConf);
      
      //Confi de los botones
      gridConf.ipady = 20;
      gridConf.ipadx = 20;
      gridConf.gridwidth = 1;
      gridConf.insets = new Insets(10,10,10,10);
      
      
      //Ayadir botones a la ventana
      gridConf.gridx = 0;
      gridConf.gridy = 2;
      ventanaM.add(botonGrabar, gridConf);
      gridConf.gridx = 1;
      gridConf.gridy = 2;
      ventanaM.add(botonPlay, gridConf);
      gridConf.gridx = 2;
      ventanaM.add(botonAnterior, gridConf);
      gridConf.gridx = 3;
      ventanaM.add(botonSiguiente, gridConf);
      gridConf.gridx = 4;
      ventanaM.add(botonDetener, gridConf);
      gridConf.gridx = 5;
      ventanaM.add(botonReiniciar, gridConf);
      
      
        
      //onclick Rec
      botonGrabar.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            grabarClick();
          }
      });  
      
      // onclick Play
      botonPlay.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            playClick();
          }
      });    
      
      //onclick  Anterior «
      botonAnterior.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            anteriorClick();
          }
      });
      
      //onclick  Siguiente »
      botonSiguiente.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            siguienteClick();
          }
      });
      
      //onclick Detener ||
      botonDetener.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          detenerClick();
        }
      });
      
      //onclick Reiniciar  ▀
      botonReiniciar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          reiniciarClick();
        }
      });
      
      /*------------------------*/
      //ventanaM.pack();
      ventanaM.setVisible(true);//Configurando visualización de la ventana
      /*------------------------*/
    }
    
    public void grabarClick(){
      System.out.println("the button is pressed");
      char caracter = JOptionPane.showInputDialog(ventanaM, "Ingresa un caracter: ").charAt(0);
      objCinta.Grabar(caracter);
      
      dibujarCabezalyCinta();
    }
    
    public void playClick(){
      System.out.println("the button is pressed");
      //show mensaje
      char auxChar = objCinta.SacarCaracter();
      JOptionPane.showMessageDialog(ventanaM, auxChar);
    }
    
    public void anteriorClick(){
      objCinta.Anterior();
      System.out.println("retrocedio un poquito");
      dibujarCabezalyCinta();
    }
    
    public void siguienteClick(){
      objCinta.Siguiente();   
      System.out.println("Avanzo un poquito"); 
      dibujarCabezalyCinta();
    }
    
    public void detenerClick(){
      objCinta.Detener();
    }
    
    public void reiniciarClick(){
      objCinta.Reiniciar();
      System.out.println("cabezal en -1"); 
      dibujarCabezalyCinta();
    }
    
    public void dibujarCabezalyCinta(){
      if (objCinta.cabezal > -1){
        String cintaText = objCinta.SacarTodo();
        
        if (cintaText != ""){
          int lastIndex = objCinta.cabezal * 2;
          //Declaramos la variable cabezalText
          //cabezalText recive un char de la cadena cintaText
          String cabezalText = cintaText.substring(0,lastIndex);
          //\u2b06 Carácter Unicode 'FLECHA NEGRA HACIA ARRIBA' (U + 2B06)
          //\ufe0f es una marca de no espacio y hereda su propiedad de script del carácter anterior.
          /* cabezalText tiene el mismo caracter que ingreza en el primer label para avanzar la misma cantidad de espacio y es pintado de blanco para no mostrarce en el label del puntero*/
       
          cabezalText = "<html><font color='white'>"+cabezalText+"</font>\u2b06</html>";
          labelCabezal.setText(cabezalText);
        }
        
        labelCinta.setText(cintaText);
      } else {
        labelCabezal.setText("");
      }
    }
}
