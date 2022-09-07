#include <stdlib.h>
#include <stdio.h>
#include "pilas.h"

//Enumeracion de los distintos tipos de datos para saber como mostrar
enum{ENTERO,CARACTER};

/*
	Implementación de pilas "polimorficas"
	usando nodos (listas enlazadas)
*/
typedef struct lista* nodo;

struct lista{
	void *valor;
	int tipoValor;
	struct lista *siguiente;
};

// Implementación del tipo_lista declarado en pilas.h
struct estructura_pila{
	nodo tope;
	int elementos;
};

// Crea un nodo con elemento como valor y apuntando a nada
nodo crear_nodo(void *elemento, int tipo){
	nodo linkable = (nodo) malloc (sizeof (struct lista));
	
	linkable->valor = elemento;
	linkable->tipoValor = tipo;
	linkable->siguiente = NULL;

	return linkable;
}

tipo_pila crear(void){
	tipo_pila pila = (tipo_pila) malloc (sizeof (struct estructura_pila));

	pila->tope = NULL;
	pila->elementos = 0;
	
	printf("\tCreada con éxito\n");

	return pila;
};

void tope(tipo_pila pila){
	if(pila->tope == NULL){
		printf("\tLa pila está vacía\n");
	}else{
		if(pila->tope->tipoValor == ENTERO){
			printf("\tEl tope de la pila es: %d\n", *(int *)pila->tope->valor);
		}else{
			printf("\tEl tope de la pila es: %c\n", *(char *)pila->tope->valor);
		}
	}
};

int apilar(tipo_pila pila, void *elemento, int tipo){
	nodo linkable = crear_nodo(elemento, tipo);

	linkable->siguiente = pila->tope;
	pila->tope = linkable;
	pila->elementos++;

	return 0;
};

int vaciar(tipo_pila pila){
	nodo cursor;

	while(pila->tope != NULL){
		cursor = pila->tope;
		pila->tope = pila->tope->siguiente;
		pila->elementos--;
		free(cursor);
	}
	
	printf("\tVaciada con éxito\n");
	
	return 0;
};

void elementos(tipo_pila pila){
	printf("\tEn la pila hay %d elementos\n", pila->elementos);
};

int desapilar(tipo_pila pila){
	if(pila->tope == NULL){
		printf("\tLa pila está vacía\n");
	}else{
		nodo cursor;
		cursor = pila->tope;
		pila->tope = pila->tope->siguiente;
		pila->elementos--;
		if(cursor->tipoValor == ENTERO){
			printf("\tSe desapilo con éxito\n");
			printf("\tSu valor es: %d\n", *(int *)cursor->valor);
		}else{
			printf("\tSe desapilo con éxito\n");
			printf("\tSu valor es: %c\n", *(char *)cursor->valor);
		}
		free(cursor);
	}

	return 0;
};