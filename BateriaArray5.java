
import java.util.Random;


public class NewMain {

   public static void main(String[] args) {
        int arr[] = new int[10];
        int arrParell[];
        arr=rellenarArray(arr.length);
        while(comprobarArray(arr)){
            arr=arrayNoRepetido(arr);
        }
        arrParell=introduirParells(arr);
        arr=ordenarArray(arr);
        arrParell=ordenarArray(arrParell);
        System.out.println("Array global: ");
        mostrarArray(arr);
        System.out.println("Array de parells : ");
        mostrarArray(arrParell);
    }
    static int aleatorio(){
        int num;
        Random rdm=new Random();//se crea el objeto aleatorio
        num=rdm.nextInt(20)+1;// numero entre 25 y 75, si solo fuese del 1 al 10 num=rdm.nextInt(10)+1;
        return num;
    }
    static int[] rellenarArray(int mida){
        int i;
        int[] aux=new int[mida];  
        for (i=0; i<aux.length; i++){
            aux[i]=aleatorio();
        }
        return aux;
    }
        static int[] arrayNoRepetido(int[] arr){
        int i, j;
        for (i = 0; i < arr.length-1; i++) {
            for(j=1; j<arr.length;j++){
                if(arr[i]==arr[j] && i!=j){
                    arr[j]=aleatorio(); // si trobem dos elements iguals, a la posició del segon, tornem a cridar a la funció aleatori.
                }
            }
        }
        return arr;
    }

    static boolean comprobarArray(int[] array) {
        boolean iguals=false;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 1; j < array.length; j++) {
                if(array[i]==array[j] && i!=j){
                    iguals= true; // retorna true si hi ha dos elements iguals
                }
            }
        }
        return iguals;// retorna false si hi ha dos elements iguals
    }
    static void mostrarArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("["+i+"]="+arr[i] + " ");
        }
        System.out.println("");
    }
    static int[] ordenarArray(int[] arr) {
        int canvi=0;
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    canvi = arr[i];
                    arr[i] = arr[j];
                    arr[j] = canvi;
                }
            }
        }
        return arr;
    }

    private static int[] introduirParells(int[] arr) {
        int j=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>10 && arr[i]%2==0){
                j++;
            }
        }
        int[] aux=new int[j];  
        j=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>10 && arr[i]%2==0){
                aux[j]=arr[i];
                j++;
            }
        }
        return aux;
    }
}
