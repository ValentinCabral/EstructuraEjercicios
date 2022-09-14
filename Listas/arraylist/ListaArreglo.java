package arraylist;
import lista.Lista;

public class ListaArreglo <T> implements Lista<T>{
	
	//Cantidad actual de elementos 
	private int nroElementos;
	//Arreglo interno de la lista
	private T[] lista;
	public static final int CAPACIDAD_POR_DEFECTO = 50;
	
	
	public ListaArreglo(){
		this.nroElementos = 0;
		this.lista = (T[]) new Object[CAPACIDAD_POR_DEFECTO];
	}
	
	
	public ListaArreglo(int capacidad){
		this.lista = (T[]) new Object[capacidad];
		this.nroElementos = 0;
	}
	
	
	
	
	public boolean agregar(T elem){
		if( this.elementos() == this.lista.length ){
		  return false;
		}else{
		  this.lista[this.elementos()] = elem;
		  this.nroElementos++;
		  return true;
		}
	}
	
	
	public boolean agregarTodos(Lista<T> otraLista){
	  // Si el arreglo ya esta lleno, o si se va a superar el limite al agregar los elementos
		if( (this.nroElementos == this.lista.length) || ( (this.nroElementos + otraLista.elementos()) >= this.lista.length) ){
		  return false;
		}else{
		  for(int i = 0; i < otraLista.elementos(); i++){
		  	this.lista[this.elementos()] = otraLista.obtener(i);
		  	this.nroElementos++; 
		  }
		  return true;
		}
	}

	
	public boolean insertar(T elem, int indice){
	  if( (indice < 0) || indice > this.lista.length ){
	    throw new IndexOutOfBoundsException("Fuera de rango\n");
	  }else{
	    // SUBLISTA CON LOS ELEMENTOS POSTERIORES AL INDICE
	    ListaArreglo posR = new ListaArreglo<T>();
	    posR = (ListaArreglo) this.subLista(indice, this.elementos() );
	    // SUBLISTA CON LOS ELEMENTOS ANTERIORES AL INDICE
	    ListaArreglo posL = new ListaArreglo<T>();
	    posL = (ListaArreglo) this.subLista(0, indice);
	    posL.agregar(elem);
	    this.vaciar();
	    this.agregarTodos(posL);
	    this.agregarTodos(posR);
	    return true;
	  }
	}


	
	public T eliminar(int indice){
		if( (indice < 0 ) || (indice > this.lista.length) ){
			throw new IndexOutOfBoundsException("Fuera de rango\n");
		}else{
		  	// Auxiliar para guardar el elemento a eliminar
		 	T aux = this.lista[indice];	
		  	// SUBLISTA CON LOS ELEMENTOS ANTERIORES AL INDICE
		  	ListaArreglo posL = new ListaArreglo<T>();
		  	posL = (ListaArreglo) this.subLista(0, indice);

		  	// SUBLISTA CON LOS ELEMENTOS POSTERIORES AL INDICE
		  	ListaArreglo posR = new ListaArreglo<T>();
		  	posR = (ListaArreglo) this.subLista(indice+1, this.elementos());

		  	this.vaciar();
		  	this.agregarTodos(posL);
		  	this.agregarTodos(posR);
		  	return aux;

		}
	}

	
	public T obtener(int indice){
	  if( (indice < 0) || (indice > this.lista.length) ){
	    throw new IndexOutOfBoundsException("Fuera de rango\n");
	  }else{
	    return this.lista[indice];
	  }
	}
	

	public Lista<T> subLista(int desdeInd, int hastaInd){
	  if( (desdeInd < 0) || (desdeInd > this.lista.length) || (hastaInd > this.lista.length) || (hastaInd < 0)){
	    throw new IndexOutOfBoundsException("Fuera de rango\n");
	  }else{
	    ListaArreglo subL = new ListaArreglo<T>( (hastaInd - desdeInd) + 1);
	    if( desdeInd == hastaInd){
	    	return subL;
	    }else{
	    	for( int i = desdeInd; i < hastaInd; i++){
	      		subL.agregar(this.lista[i]);
	    	}
	    	return subL;
	    }
	  }
	}

	
	public boolean contiene(T elem){
	  for( int i = 0; i < this.elementos(); i++ ){
	    T e = this.lista[i];
	    if( ((e == null) && (elem == null)) || e.equals(elem) ){
	      return true;
	    }
	  }
	  return false;
	}

	
	public void vaciar(){
	  for (int i = 0; i < this.lista.length; i++){
	    this.lista[i] = null;
	  }
	  this.nroElementos = 0;
	}
	
	
	public int elementos(){
	  return this.nroElementos;
	}

	
	public boolean esVacia(){
	  return this.elementos() == 0;
	}

	
	public boolean repOK(){return false;}

	@Override
	public String toString(){
	  String aux = "\n[";
	  for(int i = 0; i < this.elementos(); i++){
	    //Los elementos que no son el ultimo van con coma, el ultimo no
	    if( (i + 1) < this.elementos()) {
	      aux+= this.lista[i].toString() + ", ";
	    }else{
	       aux+= this.lista[i].toString();
	    }
	  }
	  aux+= "]";
	  return aux;
	}
	

	@Override
	public boolean equals(Object otro){
	 // Distintas clases
	 if( otro == null || ( getClass() != otro.getClass() ) ){return false;}
	 
	 // No es una instancia de ListaArreglo
	 if( !(otro instanceof ListaArreglo) ){return false;}
	 
	 // Hago un casteo en un auxiliar para poder acceder a los elementos
	 ListaArreglo aux = (ListaArreglo) otro;
	 
	 // DIstinta cantidad de elementos
	 if( aux.elementos() != this.elementos() ){return false;}
	 
	 // Comparo elemento a elemento
	 boolean sonIguales = true;
	 for( int i = 0; i < this.elementos(); i++ ){
	 	sonIguales &= aux.obtener(i) == this.obtener(i);
	 }
	 
	 return sonIguales;
	}

}
