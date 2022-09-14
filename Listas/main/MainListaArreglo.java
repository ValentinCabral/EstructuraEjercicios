package main;
import arraylist.ListaArreglo;


public class MainListaArreglo{

  public static void main(String[] args){
     ListaArreglo <Integer> arr1 = new ListaArreglo<Integer>();
     arr1.agregar(1);
     arr1.agregar(2);
     arr1.agregar(3);
     ListaArreglo <Integer> arr2 = new ListaArreglo<Integer>();
     arr2.agregar(1);
     arr2.agregar(2);
     arr2.agregar(3);
     arr2.agregar(4);
     
     System.out.println(arr1.equals(arr2));
  }
}
