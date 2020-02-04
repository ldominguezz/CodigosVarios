/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trileros;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Laura
 */
public class trileros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] cubilete=rellenarArray();
        int posicio=0;
        for (int i = 0; i < 30; i++) {
            cubilete=modificarArray(cubilete);
            
        }
        mostrarAsteriscos(cubilete);
        posicio=pedirInt("En quina posició creus que está la boleta?");
        if(comprovarPosicio(posicio, cubilete)){
            System.out.println("Has encertat on es el numero");
        }else{
            System.out.println("Mala Sort!");
        }
        mostrarArray(cubilete);
    }

    private static int[] rellenarArray() {
        int[] arr = {1,0,0,0};
        return arr;
    }
    
    static void mostrarArray(int[] arr) {
        System.out.print("{ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("}");
    }
    static int aleatorio(int max){
        int num;
        Random rdm=new Random();//se crea el objeto aleatorio
        num=rdm.nextInt(max);
        return num;
    }

    static int[] modificarArray(int[] cubilete) {
        int pos1=aleatorio(cubilete.length);
        int pos2=aleatorio(cubilete.length);
        while(pos1==pos2){
            pos2=aleatorio(cubilete.length);
        }
        System.out.print("Cubilete "+ (pos1+1)+" -> Cubilete " + (pos2+1));
        System.out.println("");
        int aux=cubilete[pos1];
        cubilete[pos1]=cubilete[pos2];
        cubilete[pos2]=aux;
        return cubilete;       
    }

    static void mostrarAsteriscos(int[] cubilete) {
        System.out.println("\nPosició Final:");
        for (int i = 0; i < cubilete.length; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    static int pedirInt(String texto) {
        Scanner sc = new Scanner(System.in);
        System.out.println(texto);
        int num=0;
        num=sc.nextInt();
         sc.nextLine();
        while(num<=0 || num>4){
            System.out.println("El numero no es correcte. Introdueix-lo de nou.");
            num=sc.nextInt();
            sc.nextLine();
        }
        return num;
    }

    private static boolean comprovarPosicio(int posicio, int[] cubilete) {
        return cubilete[posicio-1]==1;
    }
}
