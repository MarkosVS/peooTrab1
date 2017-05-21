public abstract class Elemento{
	//atributo
	private TipoElemento tipo;

	//construtor
	public Elemento(){
		this.tipo = TipoElemento.ESPACOVAZIO;
	}

	//getter
	public TipoElemento getTipo(){
		return this.tipo;
	}

}