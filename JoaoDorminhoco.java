package trabexceção;

public class JoaoDorminhoco extends Personagem{
	//atributos
	private boolean acordado;

	//construtor
	public JoaoDorminhoco(){
		super(TipoElemento.AVENTUREIRO, "João Dorminhoco");
	}
	
	//getter
	public boolean isAcordado(){
		return this.acordado;
	}

	//metodos
	public void changeAcordado(){
		this.acordado = !this.acordado;
	}
}