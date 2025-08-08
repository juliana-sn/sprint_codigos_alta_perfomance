package listas;

import modelos.Colaborador;

public class ListaCrescenteColaborador {

	private class NO {
		Colaborador dado;
		NO prox;
	}

	NO lista = null;

	public boolean isEmpty() {
		return (lista == null);
	}

	public void add(Colaborador elem) {
		NO novo = new NO();
		novo.dado = elem;
		if (isEmpty()) {
			lista = novo;
			novo.prox = null;
		} else if (novo.dado.getNota() < lista.dado.getNota()) {
			novo.prox = lista;
			lista = novo;
		} else {
			NO aux = lista;
			boolean achou = false;
			while (aux.prox != null && !achou) {
				if (aux.prox.dado.getNota() < novo.dado.getNota()){
					aux = aux.prox;
				} else if (aux.prox.dado.getNota() == novo.dado.getNota()) {
					if (aux.prox.dado.getId() < aux.prox.dado.getId()){
						aux = aux.prox;
					}else{
						achou = true;
					}
				} else
					achou = true;
			}
			novo.prox = aux.prox;
			aux.prox = novo;
		}
	}
	public void show(int qtd) {
		NO aux = lista;
		int cont = 0;
		System.out.println("============ Lista de Colaboradores ============");
		while (aux!=null && cont <= qtd) {
			System.out.print(aux.dado + "\n");
			aux = aux.prox;
			cont++;
		}
	}
	public Colaborador remove(int valor) {
		Colaborador colaborador = null;
		boolean achou = false;
		if (!isEmpty()) {
			if (valor==lista.dado.getId()) {
				achou = true;
				colaborador = lista.dado;
				lista = lista.prox;
			}
			else
			{
				NO aux = lista;
				while (aux.prox!=null && !achou) {
					if (valor == aux.prox.dado.getId()) {
						colaborador = aux.prox.dado;
						achou = true;
					}else
						aux = aux.prox;
				}
				if (achou)
					aux.prox = aux.prox.prox;
			}
		}
		return colaborador;
	}
	
	
	
}
