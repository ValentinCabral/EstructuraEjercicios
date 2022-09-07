package main;
import rac.Racional;

public class MainRacional{

	public static void main(String[] args){
		Racional rac1 = new Racional(1,2);
		Racional rac2 = new Racional(3,2);
		Racional rac3 = new Racional(2);

		System.out.println(rac1.toString() + rac2.toString() + rac3.toString());

		// 4/2
		System.out.println(rac1.sumar(rac2));
		// 5/2 
		System.out.println(rac1.sumar(rac3));
		// 7/2 
		System.out.println(rac2.sumar(rac3));
		// 3/2
		System.out.println(rac3.restar(rac1));
		// 2/2
		System.out.println(rac2.restar(rac1));

		// 2 == 2/2 false
		System.out.println(rac3.equals(rac2.restar(rac1)));

		Racional rac4 = new Racional(3,2);
		// 3/2 == 3/2 true
		System.out.println(rac2.equals(rac4));


	}

}