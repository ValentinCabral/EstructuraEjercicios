package main;
import arraylist.ListaArreglo;


public class MainListaArreglo{

  public static void main(String[] args){
     ListaArreglo <Integer> arr1 = new ListaArreglo<Integer>();
     arr1.agregar(1);
     arr1.agregar(2);
     arr1.agregar(3);
     ListaArreglo <Integer> arr2 = new ListaArreglo<Integer>();
     arr2.agregar(0);

     arr1.insertar(4,3);
     arr1.insertar(5,4);
     arr1.insertar(0,0);
     arr1.eliminar(0);
     System.out.println(arr1.contiene(0)); // False
     System.out.println(arr1.contiene(5)); // True
     System.out.println(arr1);
  }
}
