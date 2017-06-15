package trabexceção;

import java.util.Random;

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
        
        public void iniciar(){
                Random jv = new Random();
                int n = jv.nextInt(3);
                if(n == 0)
                    this.camara.iniciar(TipoCamara.FACIL ,this.aventureiro);
                else if(n == 1)
                    this.camara.iniciar(TipoCamara.DIFICIL ,this.aventureiro);
                else
                    this.camara.iniciar(TipoCamara.ERRADA ,this.aventureiro);
	}

	public void visualizarCenario(){
		this.camara.visualizarCenario();
	}
}