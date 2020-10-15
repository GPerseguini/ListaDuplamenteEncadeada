

public class Aluno {
	private String nome;
	private int id;
	private String curso;
	private Aluno anterior;
	private Aluno proximo;
	
	Aluno(String nome, int id, String curso){
		this.nome = nome;
		this.id = id;
		this.curso = curso;
	}
	Aluno(){
	
	}
	public void setNome (String nome){
		this.nome = nome;
	}
	public void setID(int id){
		this.id = id;
	}
	public void setCurso (String curso){
		this.curso = curso;
	}
	public void setProximo(Aluno proximo){
		this.proximo = proximo;
	}
	public void setAnterior(Aluno anterior){
		this.anterior = anterior;
	}
	public String getNome(){
		return this.nome;
	}
	public int getID(){
		return this.id;
	}
	public String getCurso (){
		return this.curso;
	}
	public Aluno getProximo(){
		return this.proximo;
	}
	public Aluno getAnterior(){
		return this.anterior;
	}
	public Aluno addUltimo (Aluno aux,Aluno novoAluno){
		if (aux.getProximo() == null){
			aux.setProximo(novoAluno);
		}else{
			addUltimo(aux.getProximo(), novoAluno);
		}
		return aux.getProximo();
	}
	public Aluno removeUltimo(Aluno anterior, Aluno atual){
		if (atual.getProximo() == null){
			System.out.println("O aluno removido foi: "+atual.getNome());
			anterior.setProximo(null);
		}else{
			anterior = atual;
			removeUltimo(anterior,atual.getProximo());
		}
		return anterior.getProximo();
	}
}
