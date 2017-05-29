public class Camara{
	//atributos
	private ObjetoCamara[][] cenario;

	//construtor
	public Camara(int n){
		this.cenario = new ObjetoCamara[n][n];
	}

	//getter
	public ObjetoCamara[][] getCenario(){
		return this.cenario;
	}
}