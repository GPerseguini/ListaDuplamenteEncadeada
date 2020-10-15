

public class Lista {
	private Aluno inicio;
	private Aluno anterior;
	private Aluno fim;
	
	Lista(){
		this.inicio = null;
		this.anterior = null;
		this.fim = null;
	}
	public boolean isEmpty(){
		if (this.inicio == null){
			System.out.println("A lista está vazia");
			return true;
		}else{
			System.out.println("Existem alunos na lista");
			return false;
		}
	}
	public void addInicio(String nome, int id, String curso){
		Aluno novoAluno = new Aluno(nome,id,curso);
		if (inicio == null){
			inicio = novoAluno;
		}else{
			novoAluno.setProximo(inicio);
			inicio.setAnterior(novoAluno);
			inicio = novoAluno;
		}
	}
	public void addFinal(String nome, int id, String curso){
		Aluno novoAluno = new Aluno(nome,id,curso);
		if (inicio == null){
			inicio = novoAluno;
			novoAluno.setProximo(null);
			novoAluno.setAnterior(null);
		}else{
			Aluno aux = new Aluno();
			aux = inicio;
			aux.setProximo(aux.addUltimo(aux,novoAluno));
			aux.setProximo(novoAluno);
		}
	}
	public String removeInicio (){
		Aluno aux = new Aluno();
		if (isEmpty() == false){
			aux = inicio;
			inicio = inicio.getProximo();
			inicio.setAnterior(null);
		}else{
			System.out.println("Lista Vazia");
		}
		return aux.getNome();
	}
	public void removeFinal (){
		if (inicio == null){
			System.out.println("A lista está vazia");
		}else{
			if (inicio.getProximo() == null){
				inicio = null;
			}else{
				Aluno atual = inicio;
				Aluno anterior = inicio;
				anterior.setProximo(anterior.removeUltimo(anterior, atual));
			}
		}
	}
	public void visualiza(){
		if (isEmpty() == true){
		}else{
			Aluno aux = inicio;
			String lista = " ";
			ver(aux,lista);
		}
	}
	public void ver(Aluno aux, String lista){
		if (aux.getProximo() == null){
			lista = "\nAluno: " + aux.getNome()+" RA: "+aux.getID()+" Curso: "+aux.getCurso()+ " Anterior: "+aux.getAnterior().getNome();
			System.out.println(lista);
		}else{
			lista = "\nAluno: " + aux.getNome()+" RA: "+aux.getID()+" Curso: "+aux.getCurso()+" Proximo: "+aux.getProximo().getNome();
			if (aux.getAnterior() != null){
				lista = lista + " Anterior: " + aux.getAnterior().getNome();
			}
			System.out.println(lista);
			ver(aux.getProximo(),lista);
		}
	}
	public void buscaAluno(String nome){
		String n = "x";
		if (isEmpty() == false){
			Aluno aux = inicio;
			n = buscador(aux,nome, n);
			if (n.contains(nome)){
				System.out.println("Elemento encontrado: "+n);
			}else{
				System.out.println("Elemento não encontrado");
			}
		}
	}
	public String buscador(Aluno aux,String nome, String s){
		if (aux != null && !aux.getNome().contains(nome)){
				return buscador(aux.getProximo(),nome, s);	
		}else{
				if (aux.getNome().contains(nome)){
					s = aux.getNome();
					return s;
			}

		}
		return s;
	}
	
	public void OrdenaLista (){
		Aluno aux = inicio;
		int tamanho=0,j=0,k=0;
		
		tamanho = tamanho(aux,tamanho);
		Aluno vetorAux[] = new Aluno[tamanho];
		vetorAux = converteVetor(vetorAux,tamanho-1,aux);
		vetorAux = bubbleSort(vetorAux,tamanho-1,j,k);
		/* Exibir o vetor em ordem alfabética
		for (int i=0 ; i < tamanho; i++){
			System.out.println("Aluno: " + vetorAux[i].getNome()+" RA: "+vetorAux[i].getID()+" Curso: "+vetorAux[i].getCurso());
		}*/
	}
	
	public int tamanho(Aluno aux, int tamanho){
		if (aux != null){
			tamanho++;
			return tamanho(aux.getProximo(),tamanho);
		}else{
			return tamanho;
		}
	}
	public Aluno[] converteVetor (Aluno[] vetorAux,int tamanho, Aluno aux){
		if (tamanho >= 0){
			vetorAux[tamanho] = aux;
			return converteVetor(vetorAux,tamanho-1,aux.getProximo());
		}else{
			return vetorAux;
		}
	}
	
	public Aluno[] bubbleSort (Aluno[] vetorAux, int tamanho,int j, int k){
		if (k < tamanho){
			if (j < tamanho){
				Aluno auxs = new Aluno();
				if (vetorAux[j].getNome().compareToIgnoreCase(vetorAux[j+1].getNome()) < 0){
					auxs.setNome(vetorAux[j].getNome());
					vetorAux[j].setNome(vetorAux[j+1].getNome());
					vetorAux[j+1].setNome(auxs.getNome());
					
					auxs.setID(vetorAux[j].getID());
					vetorAux[j].setID(vetorAux[j+1].getID());
					vetorAux[j+1].setID(auxs.getID());
					
					auxs.setCurso(vetorAux[j].getCurso());
					vetorAux[j].setCurso(vetorAux[j+1].getCurso());
					vetorAux[j+1].setCurso(auxs.getCurso());
				}
				return bubbleSort(vetorAux, tamanho,j+1,k);
			}
			return bubbleSort(vetorAux, tamanho,0,k+1);
		}else{
			return vetorAux;
		}
	}
	
}




