package psw2.edu.udc.listas;

//Descrição primeira Lista - Possui inserir, remover e retirar - Versão Estruturada, não possui nenhuma caracterista de orientação a objeto//

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
		
		
public void inserir(Object obj, int pos) {
		NoLista novo = new NoLista();
		novo.dado= obj;
		novo.proximo = null;
		novo.anterior = null;
		
		if (pos< 1 || pos > tamanho + 1)
			return;
		
		if(tamanho==0) {// lista vazia
			tamanho  ++;
			inicio = novo;
			fim = novo;
			return;
		}
		
		if(pos ==1) {// novo inicio
			novo.proximo= inicio;
			inicio.anterior= novo;
			inicio = novo;
			tamanho ++;
			return;
		}
		
		if(pos == tamanho + 1) {// novo final
			novo.anterior= fim;
			fim.proximo= novo;
			fim = novo;
			tamanho ++;
			return;
		}
		// inserir no meio da lista 
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

		
public Object remover(int pos) {//
	NoLista aux = inicio;
	int cont = 1;
			
		if (tamanho ==0) 
				return null;
			
		if (pos> tamanho)
				return null;
			
		if(tamanho ==1) {// removendo o unico elemento da lista
				Object dado = inicio.dado;
				
				inicio= null;
				fim = null;
				tamanho --;
				return dado;
			}
		
		if (pos==1) { // remover o inicio
			Object dado = inicio.dado;
			
			inicio.proximo.anterior= null;
			inicio= inicio.proximo;
			
			tamanho --;
			
			return dado;
			
		}
		
		if(pos == tamanho) {// remover fim
			Object dado = inicio.dado;
			
			fim.anterior.proximo= null;
			fim= fim.proximo;
			
			tamanho --;
			
			return dado;
					
		}
			// remover no meio da lista // 
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
