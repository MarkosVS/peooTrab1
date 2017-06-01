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

	//métodos
	public void iniciar(TipoCamara tipo, Aventureiro av){
		//variavel pra armazenar o tamanho da matriz
		int length = this.cenario.length;
		//cria um ObjetoCamara tesouro
		ObjetoCamara tes = new ObjetoCamara(TipoElemento.TESOURO, "Tesouro");
		//cria um aventureiro igual ao passado como parametro e coloca na posição (0,0)
		this.cenario[0][0] = new ObjetoCamara(av.getTipo(), av.getNome());
		//switch-case com os tipos de camara
		switch(tipo){
			case FACIL:
				this.cenario[length-1][length-1] = tes;
		}
	}
}