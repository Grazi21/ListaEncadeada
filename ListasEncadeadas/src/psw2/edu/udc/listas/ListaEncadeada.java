package psw2.edu.udc.listas;

//Descrição lista  2 - InserirInicio,InserirFim,inserir,pesquisar,removerinicio,removerFim, remover -Estruturada//
public class ListaEncadeada {
	private NoLista inicio;// primeira coisa na lista - Nó
	private NoLista fim;
	
	private int tamanho = 0;
	
	public int getTamanho() {
		return tamanho;
	}
	
	public boolean isVazia () {
		if (tamanho==1)
			return true;
		return false;
	}
	
	
public void inserirInicio(Object obj) {
	NoLista novo = new NoLista();
	novo.dado= obj;
	novo.proximo = inicio;
	novo.anterior = null;
	
	if(inicio == null) {
		inicio = novo;
		fim= novo;
	}else {
		inicio.anterior=novo;		
		inicio = novo;
}
	
	tamanho ++;
}
	
public void inserirFim(Object obj) {
NoLista novo = new NoLista();
novo.dado= obj;
novo.proximo = null;
novo.anterior = fim;

if(fim != null)
	fim.proximo= novo;

fim = novo;
if (inicio ==null)
	inicio = novo;
tamanho ++;
}

public void inserir (Object obj, int pos) {
if(pos<1|| pos> tamanho+1)
	return;

if(pos ==1) {
	inserirInicio(obj);
	return;
}

if (pos == tamanho +1) {
	inserirFim(obj);
	return;
}

NoLista novo = new NoLista();
novo.dado= obj;
novo.proximo = null;
novo.anterior = null;

NoLista aux = inicio;
int cont = 1;

while (cont< pos) {
	aux = aux.proximo;
	cont++;
}

novo.anterior = aux.anterior;
novo.proximo= aux;
aux.anterior.proximo= novo;
aux.anterior= novo;



tamanho ++;	
}

	
	
public Object removerInicio() {
	
	if (inicio == null) 
			return null;
		
	Object dado= inicio.dado;
	
	
	if(inicio == fim) {// removendo o unico elemento da lista
			inicio = null;
			fim = null;
		}else {
			inicio.proximo.anterior= null;
			inicio= inicio.proximo;
		}
	
	tamanho --;
	
	return dado;

}	

public Object removerFim() {
if (fim ==null)
	return null;

Object dado = fim.dado;

if (inicio== fim) {
	inicio = null;
	fim = null;
}else {
	fim.anterior.proximo= null;
	fim = fim.anterior;
}

tamanho --;
return dado;

}

public Object remover(int pos) {
if(pos<1|| pos> tamanho)
	return null;

if (pos ==1) {
	return removerInicio();
}

if (pos == tamanho) {
	return removerFim();
}

NoLista aux = inicio;
int cont = 1;

while (cont< pos) {
	aux = aux.proximo;
	cont++;
}

Object dado = aux.dado;

aux.anterior.proximo= aux.proximo;
aux.proximo.anterior= aux.anterior;

tamanho --;
return dado;

}

public Object pesquisar(int pos) {
	NoLista aux = inicio;
	int cont = 1;
	
	if (tamanho ==0) 
			return null;
		
	if (pos> tamanho)
			return null;
	
	
	while (cont< pos) {
			aux = aux.proximo;
			cont++;
		}
		
		Object dado = aux.dado;
		tamanho --;
		return dado;
}

}

