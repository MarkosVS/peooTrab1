public class Caverna{
	//atributos
	private Camara camara;
	private Aventureiro aventureiro;

	//construtor
	public Caverna(Aventureiro av, int n){
		this.camara = new Camara(n);
		this.aventureiro = av;
	}

	//getters
	public Camara getCamara(){
		return this.camara;
	}

	public Aventureiro getAventureiro(){
		return this.aventureiro;
	}

	//setters
	public void setCamara(Camara c){
		this.camara = c;
	}

	public void setAventureiro(Aventureiro av){
		this.aventureiro = av;
	}

	//métodos
	public void iniciar(TipoCamara tipo){
		this.camara.iniciar(tipo, this.aventureiro);
	}

	public void visualizarCenario(){
		this.camara.visualizarCenario();
	}
}