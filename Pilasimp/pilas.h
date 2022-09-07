typedef struct estructura_pila* tipo_pila;
typedef struct lista* nodo;

// Crea un nodo con elemento como valor y apuntando a nada
nodo crear_nodo(void *elemento, int tipo);

// Crea una pila vacia y la retorna
tipo_pila crear(void);

// Accede al tope de la pila y lo muestra por pantalla
void tope(tipo_pila pila);

// Apila un nuevo elemento en la pila (cabeza) y retorna 0 si fue correcto
int apilar(tipo_pila pila, void *elemento, int tipo);

// Desapila y retorna el elemento en el tope de una pila no vacia
int desapilar(tipo_pila pila);

// Elimina todos los elementos de la pila dejandola vacia
int vaciar(tipo_pila pila);

// Retorna la cantidad de elementos presentes en la pila
void elementos(tipo_pila pila);