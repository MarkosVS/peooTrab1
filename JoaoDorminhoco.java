public class JoaoDorminhoco extends Personagem{
	//atributos
	private boolean acordado;

	//getter
	public boolean isAcordado(){
		return this.acordado;
	}

	//metodos
	public void changeAcordado(){
		this.acordado = !this.acordado;
	}
}