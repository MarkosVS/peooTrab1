package trabexceção;

public class ObjetoCamara extends Elemento{
	//atributo
	private String nome;

	//construtor
	public ObjetoCamara(TipoElemento t, String nome){
		super(t);
		this.nome = nome;
	}

	//getter
	public String getNome(){
		return this.nome;
	}

	//setter
	public void setNome(String nome){
		this.nome = nome;
	}
}