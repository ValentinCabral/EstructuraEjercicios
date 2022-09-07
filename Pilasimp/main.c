#include <stdio.h>
#include <stdlib.h>
#include "pilas.h"

enum{ENTERO,CARACTER};

int main(){

	tipo_pila pila = NULL;
	int salir = 1;
	// Menú a mostrar
	char* menu = "\n1. Crear una nueva pila (Vacia)\n2. Apilar un nuevo elemento\n3. Acceder al tope de la pila\n4. Desapilar tope de la pila\n5. Vaciar pila\n6. Ver cantidad de elementos\n7. Salir";
	
	system("clear");
	// Se muestra el menú siempre que salir != 0
	while(salir){

		printf("%s\n", menu);
		scanf("%d", &salir);

		switch(salir){
			case 1:
				system("clear");
				pila = crear();
				break;
			case 2:
				system("clear");
				if(pila == NULL){
					printf("\tNo se creo una pila\n");
					break;
				}
				printf("\tInsertar un:\n \t1. ENTERO\n \t2. CARACTER\n");
				int tipoAIns;
				scanf("%d", &tipoAIns);
				system("clear");
				if(tipoAIns == 1){
					printf("\tIngresa el entero\n");
					int* x = malloc(sizeof(int));
					scanf("%d", x);
					apilar(pila, x, ENTERO);
				}else{
					printf("\tIngresa el caracter\n");
					char* y = malloc(sizeof(char));
					scanf(" %c", y);
					apilar(pila, y, CARACTER);
				}
				system("clear");
				printf("\tSe apilo con éxito\n");
				break;
			case 3:
				system("clear");
				if(pila == NULL){
					printf("\tNo se creo una pila\n");
					break;
				}
				tope(pila);
				break;
			case 4:
				system("clear");
				if(pila == NULL){
					printf("\tNo se creo una pila\n");
					break;
				}
				desapilar(pila);
				break;
			case 5:
				system("clear");
				if(pila == NULL){
					printf("\tNo se creo una pila\n");
					break;
				}
				vaciar(pila);
				break;
			case 6:
				system("clear");
				if(pila == NULL){
					printf("\tNo se creo una pila\n");
					break;
				}
				elementos(pila);
				break;
			case 7:
				system("clear");
				salir = !salir;
				break;
		}
	}
}