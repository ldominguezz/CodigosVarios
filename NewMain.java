public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arr[] = new int[20];
        arr=rellenarArray();
        while(comprobarArray(arr)){
            arr=arrayNoRepetido(arr);
        }
        arr=ordenarArray(arr);
        mostrarArray(arr);
    }
    static int aleatorio(){
        int num;
        Random rdm=new Random();//se crea el objeto aleatorio
        num=rdm.nextInt(21)+1;// numero entre 25 y 75, si solo fuese del 1 al 10 num=rdm.nextInt(10)+1;
        return num;
    }
    static int[] rellenarArray(){
        int i;
        int[] aux=new int[10];  
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
            System.out.println("["+i+"]="+arr[i]);
        }
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
}
