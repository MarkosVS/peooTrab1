public abstract class Personagem extends Elemento{
	//atributos
	private String nome;

	//construtores
	public Personagem(TipoElemento t){
		super(t);
	}

	public Personagem(TipoElemento t, String nome){
		super(t);
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