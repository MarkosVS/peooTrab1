import java.util.Random;

public class Camara{
	//atributos
	private ObjetoCamara[][] cenario;

	//construtor
	public Camara(int n){
		this.cenario = new ObjetoCamara[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				this.cenario[i][j] = new ObjetoCamara(TipoElemento.EPACOVAZIO, "Espaço vazio");
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
				break;
			case DIFICIL:
				addJoaoDorminhoco();
				for(int i = 1; i < length/2; i++)
					addObstaculo();
				this.cenario[length-1][length-1] = tes;
				break;
			case ERRADA:
				addJoaoDorminhoco();
				for(int i = 1; i < length/2; i++)
					addObstaculo();
				this.cenario[length-1][length-1] = new ObjetoCamara(TipoElemento.MENSAGEM, "Mensagem");	
				break;
			default:
				break;
		}
	}

	public void visualizarCenario(){
		//
	}

	private void addObstaculo(){
		//objeto da classe random
		Random jv = new Random();
		//indices
		int i, j;
		//flag
		boolean flag = false;
		while(!flag){
			i = jv.nextInt(this.cenario.length);
			j = jv.nextInt(this.cenario.length);
			if(this.cenario[i][j].getTipo() == TipoElemento.EPACOVAZIO){
				this.cenario[i][j] = new ObjetoCamara(TipoElemento.OBSTACULO, "Obstáculo");;
				flag = true;
			}
		}
	}

	private void addJoaoDorminhoco(){
		//cria o joaodorminhoco
		ObjetoCamara joao = new ObjetoCamara(TipoElemento.JOAODORMINHOCO, "João Dorminhoco");
		//objeto da classe random
		Random jv = new Random();
		//indices
		int i, j;
		//flag
		boolean flag = false;
		while(!flag){
			i = (jv.nextInt(this.cenario.length - 4)) + 2;
			j = (jv.nextInt(this.cenario.length - 4)) + 2;
			if(this.cenario[i][j].getTipo() == TipoElemento.EPACOVAZIO){
				this.cenario[i][j] = joao;
				flag = true;
			}
		}
	}
}