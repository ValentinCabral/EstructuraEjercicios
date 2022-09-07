package rac;
import java.util.*;

/**
 * La clase {@code Racional} permite representar un número racional
 * Con un denominador SIEMPRE positivo
 * Permite utilizar metodos para sumar, restar y comparar racionales.
 * */
public class Racional{
	/**
	 * Atributos numerador y denominador usados internamente
	 * para la representación de los racionales
	 * */
	private long numerador;
	private long denominador;

	/**
	 * {@code Racional()} es el constructor por defecto para los racionales
	 * Le asigna 0 al númerador y 1 al denominador (0/1 = 0)
	 * */
	public Racional(){
		this.numerador = 0;
		this.denominador = 1;
	}

	/**
	 * {@code Racional(numerador, denominador)} es el constructor para racionales con valores
	 * tanto en el numerador como el denominador
	 * @param numerador: Numerador del racional
	 * @param denominador: Denominador del racional
	 * */
	public Racional(long numerador, long denominador){
		this.numerador = numerador;
		this.denominador = denominador;
	}

	/**
	 * {@code Racional(numerador)} es el constructor para racionales-enteros
	 * le asigna automaticamente 1 al denominador
	 * @param numerador: Numerador del racional (Valor final del entero)
	 * */
	public Racional(long numerador){
		this.numerador = numerador;
		this.denominador = 1;
	}

	/**
	 * Retorna el numerador de este racional
	 * @return el numerador
	 * */
	public long numerador(){
		return this.numerador;
	}

	/**
	 * Define el numerador de este racional
	 * @param numerador: El nuevo numerador
	 * */
	public void numerador(long numerador){
		this.numerador = numerador;
	}

	/**
	 * Retorna el denominador de este racional
	 * @return el denominador
	 * */
	public long denominador(){
		return this.denominador;
	}

	/**
	 * Define el denominador de este racional
	 * @param denominador: El nuevo denominador
	 * */
	 public void denominador(long denominador){
	 	this.denominador = denominador;
	 }

	 /**
	  * El método {@code sumar} permite sumarle a nuestro objeto otro racional
	  * y retornar el resultado
	  * @param racSuma: Racional a sumarle al objeto actual
	  * @return Nuevo racional con la suma de ambos.
	  * */
	 public Racional sumar(Racional racSuma){
	 	Racional res = new Racional(); // Para guardar la suma
	 	//Si los denominadores son iguales se suman los numeradores directamente
	 	if( this.denominador == racSuma.denominador() ){
	 		res.denominador(this.denominador);
	 		res.numerador( this.numerador + racSuma.numerador() );
	 		return res;
	 	}else{
	 		// Comun denominador
	 		res.denominador( this.denominador * racSuma.denominador() );
	 		// Multiplicacion cruzada entre numeradores y denominadores
	 		res.numerador( (this.numerador * racSuma.denominador()) + (this.denominador * racSuma.numerador()) );
	 		return res;
	 	}
	 }

	 /**
	  * El método {@code restar} permite restarle a nuestro objeto otro racional
	  * y retornar el resultado
	  * @param racResta: Racional a restarle al objeto actual
	  * @return Nuevo racional con la resta de ambos.
	  * */
	 public Racional restar(Racional racResta){
	 	Racional res = new Racional(); // Para guardar la resta
	 	// Si los denominadores son iguales se restan los numeradores directamente
	 	if( this.denominador == racResta.denominador() ){
	 		res.denominador(this.denominador);
	 		res.numerador( this.numerador - racResta.numerador() );
	 		return res;
	 	}else{
	 		// Comun denominador
	 		res.denominador( this.denominador * racResta.denominador() );
	 		// Multiplicacion cruzada
	 		res.numerador( (this.numerador * racResta.denominador()) - (racResta.numerador() * this.denominador) );
	 		return res;
	 	}
	 }

	 /**
	  * El método {@code equals} permite comparar nuestro objeto actual
	  * con otro objeto del mismo tipo
	  * @param rac: Objeto a comparar con el nuestro
	  * @return true o false dependiendo de si los objetos son iguales
	  * */
	 @Override
	 public boolean equals(Object r){
	 	// Si el objeto pasado es null o no coinciden las clases con el actual, no puedo comparar
	 	if( r == null || getClass() != r.getClass()){return false;}
	 	// Si r no es un objeto Racional no puedo compararlos
	 	if( !(r instanceof Racional) ){return false;} 
	 	// Variable auxiliar donde guardo un casteo a Racional del objeto pasado para poder hacer comparaciones
	 	Racional rac = (Racional) r;
	 	// Caso en el que tanto el numerador y el denominador sean iguales
	 	if( (this.numerador == rac.numerador()) && (this.denominador == rac.denominador()) ){
	 		return true;
	 	}
	 	return false;
	 }

	 /**
	  * El metodo {@code toString} permite una representacion en la consola
	  * de un racional
	  * @return cadena de texto representando un racional
	  * */
	 @Override
	 public String toString(){
	 	return this.numerador + "/" + this.denominador + "\n";
	 }
}