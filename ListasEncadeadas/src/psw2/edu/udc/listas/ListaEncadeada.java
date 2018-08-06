package psw2.edu.udc.listas;

//Descrição Lista 5 -  tem iterador//

public class ListaEncadeada {
	private class No {
		public No proximo;
		public No anterior;
		
		public Object dado;
	};

	private class ImplementaIterador implements Iterador {
		public No noAtual;
		
		public ImplementaIterador(No noAtual) {
			this.noAtual = noAtual;
		}
		
		@Override
		public Object getObjeto() {
			if(noAtual == null)
				return null;
			return noAtual.dado;
		}

		@Override
		public Object proximo() {
			if(noAtual == null)
				return null;
			Object dado = noAtual.dado;
			noAtual = noAtual.proximo;
			return dado;
		}

		@Override
		public Object anterior() {
			if(noAtual == null)
				return null;
			Object dado = noAtual.dado;
			noAtual = noAtual.anterior;
			return dado;
		}
	}

	private No inicio = null;
	private No fim = null;

	private int tamanho = 0;
	
	public int getTamanho() {
		return tamanho;
	}
	
	public boolean isVazia() {
		if(tamanho == 0)
			return true;
		return false;
	}

	public Iterador getInicio() {
		return new ImplementaIterador(inicio);
	}
	
	public Iterador getFim() {
		return new ImplementaIterador(fim);
	}

	public void inserirInicio(Object obj) {
		No novo = new No();
		novo.dado = obj;
		novo.proximo = inicio;
		novo.anterior = null;
		
		if(inicio == null) {
			inicio = novo;
			fim = novo;
		} else {
			inicio.anterior = novo;
			inicio = novo;
		}

		tamanho++;
	}

	public void inserirFim(Object obj) {
		No novo = new No();
		novo.dado = obj;
		novo.proximo = null;
		novo.anterior = fim;

		if (fim != null)
			fim.proximo = novo;

		fim = novo;
		if (inicio == null)
			inicio = novo;

		tamanho++;
	}

	public void inserir(Object obj, int pos) {		
		if(pos < 1 || pos > tamanho + 1)
			return;
		
		if(pos == 1) { // novo inicio
			inserirInicio(obj);
			return;
		}
		
		if(pos == tamanho + 1) { // novo fim
			inserirFim(obj);
			return;
		}
		
		No novo = new No();
		novo.dado = obj;
		novo.proximo = null;
		novo.anterior = null;

		// inserir no meio da lista
		No aux = inicio;
		int cont = 1;
		
		while(cont < pos ) {
			aux = aux.proximo;
			cont++;
		}
		
		novo.anterior = aux.anterior;
		novo.proximo = aux;
		aux.anterior.proximo = novo;
		aux.anterior = novo;
		
		tamanho++;
	}

	public Object removerInicio() {
		if (inicio == null)
			return null;

		Object dado = inicio.dado;

		if (inicio == fim) { // if(tamanho == 1)
			inicio = null;
			fim = null;
		} else {
			inicio.proximo.anterior = null;
			inicio = inicio.proximo;
		}

		tamanho--;

		return dado;
	}

	public Object removerFim() {
		if (fim == null) 
			return null;

		Object dado = fim.dado;

		if (inicio == fim) { //if(tamanho == 0)
			inicio = null;
			fim = null;
		} else {
			fim.anterior.proximo = null;
			fim = fim.anterior;
		}
		tamanho--;

		return dado;
	}

	public Object remover(int pos) {
		if(pos < 1 || pos > tamanho)
			return null;
		
		if(pos == 1) { // remover inicio
			return removerInicio();
		}
		
		if(pos == tamanho) { // remover o fim
			return removerFim();
		}
		
		No aux = inicio;
		int cont = 1;
		
		// remover no do meio da lista
		while(cont < pos ) {
			aux = aux.proximo;
			cont++;
		}
		
		Object dado = aux.dado;
		
		aux.anterior.proximo = aux.proximo;
		aux.proximo.anterior = aux.anterior;
		
		tamanho--;
		return dado;
	}

	public Object pesquisar(int pos) {
		No aux = inicio;
		int cont = 1;

		if (tamanho == 0)
			return null;

		if (pos > tamanho)
			return null;

		while (cont < pos) {
			aux = aux.proximo;
			cont++;
		}

		return aux.dado;
	}
}