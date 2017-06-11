package trabexceção;

public abstract class Elemento{
	//atributo
	private TipoElemento tipo;

	//construtor
	public Elemento(TipoElemento tipo){
		this.tipo = tipo;
	}

	//getter
	public TipoElemento getTipo(){
		return this.tipo;
	}

}