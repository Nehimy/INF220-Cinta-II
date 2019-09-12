package clases;

import java.util.Scanner;
import java.util.regex.*;

//Declaramos la clase
public class Cinta{

  //Atributos de la clase
  char caractercito[];
  public int cabezal;
  int EOC;
  boolean pausa;
  
  //Constructor crea un objeto de la cinta
  public Cinta(int dimension){
    caractercito = new char [dimension];
    cabezal = -1;
    EOC = dimension;
    pausa = true;
  }
  
  /////////////////////////////
  /*Metodos de la clase cinta*/
  /////////////////////////////
  public boolean Pertenece(char caracter){
    String auxCadena = Character.toString(caracter);
    return auxCadena.matches("[A-Za-z ]");
  }
  
  //Inserta un caracter en la cinta
  public void Grabar(char caracter){
    if(pausa){
      if ((Pertenece(caracter))){
        Avanzar();
        caractercito[cabezal] = caracter;
        System.out.println(caractercito[cabezal]);
      }else{
        System.out.println("Error: Caracter invalido");
      }
    }
  }
  
  //Devuelve el caracter donde esta el cabezal
  //Nombre alternativo Play
  public char SacarCaracter(){
    if (cabezal < 0){
      return 0;
    }else{
      return caractercito[cabezal];
    }
    
  }
  
  //Avanzar el cabezal a la siguiente position 
  public void Avanzar(){
    if (pausa){
      if(cabezal >= EOC-1){
        System.out.println("Error: cabezal en el final de cinta");
        System.exit(1);
      } else {
        cabezal++;
      }
    }

  } 
  
  //Devuelve todo el contenido
  public String SacarTodo(){
    String cadena = "";
    int contador = 0;
    while(contador<caractercito.length && caractercito[contador] != 0){
     if (caractercito[contador] == ' '){
    /*---------------------------------------------------------------------------*/
    /*Nota:Para c/c++/java Unicode Character 'NO-BREAK SPACE' (U+00A0) quiere decir espacio no rompible.
     
      En el momento en el que el interprete lee el proyecto, si encontramos dos espacios 
      seguidos o más,  el interprete solo toma uno y los demas son descartados una ves
      interpretado el codigo en java pasa a leguaje de maquida ocea compilado. Por ese
      motivo usamos un espacio unicode especial que nos permita reprecentar si o si todos los espacios.*/
    /*---------------------------------------------------------------------------*/
        cadena = cadena + "\u00A0"+" ";
     } else {
        cadena = cadena + caractercito[contador]+" ";
     }
     contador++;
    }
    return cadena;
  }
  
  //Detiene el avance y mueve el cabezal a la position inicial
  public void Reiniciar(){
    cabezal= -1;
  }
  
  //Detener el avance del cabezal
  public void Detener(){
    pausa=!pausa;
  }
  
  //Mueve el cabezal hasta la siguiente position en blanco
  public void Siguiente(){
    if(pausa && cabezal < (SacarTodo().length()/2)-1){
      cabezal++;
    }
    System.out.println(Integer.toString(SacarTodo().length()/2));
    System.out.println(Integer.toString(cabezal));
  }
  
  //Mueve el cabezal a la position anterior en blanco
  public void Anterior(){
    if(pausa && cabezal > -1){
      cabezal--;
    }  
  }
  
 }
