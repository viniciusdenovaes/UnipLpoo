package entidade;

public class Pato {
	
	private String nome;
	private int idade;
	public Pato(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}
	public int getIdade() {
		return idade;
	}
	@Override
	public String toString() {
		return "Pato [nome=" + nome + ", idade=" + idade + "]";
	}
	
}
