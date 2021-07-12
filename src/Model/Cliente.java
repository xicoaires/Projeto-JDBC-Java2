package Model;

public class Cliente {

	private Long id;
	private String nome;
	private String cpf;
	private String genero;
	private String anoNasc;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getAnoNasc() {
		return anoNasc;
	}
	public void setAnoNasc(String anoNasc) {
		this.anoNasc = anoNasc;
	}
	@Override
	public String toString() {
		return "Cliente ID: " + id
			 + "\nNome: " + nome
			 + "\nCPF nº: " + cpf
			 + "\nGênero: " + genero
			 + "\nAno Nascimento: " + anoNasc+"\n";
	}
	
	
}
