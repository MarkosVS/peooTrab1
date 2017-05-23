public abstract class Personagem extends Elemento{
	//atributos
	private String nome;

	//construtores
	public Personagem(){
		super();
	}

	public Personagem(Sting nome){
		super();
		this.nome = nome;
	}

	//getter / setter
	public String getNome(){
		return this.nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
}