import java.util.Random;

public class Camara{
	//atributos
	private ObjetoCamara[][] cenario;

	//construtor
	public Camara(int n){
		if(n < 5)
			n = 5;
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
				this.cenario[length-1][length-1] = tes;
				addJoaoDorminhoco();
				for(int i = 0; i < length/2; i++)
					addObstaculo();                  
				break;
			case ERRADA:
				this.cenario[length-1][length-1] = new ObjetoCamara(TipoElemento.MENSAGEM, "Mensagem");
				addJoaoDorminhoco();
				for(int i = 0; i < length/2; i++)
					addObstaculo();	
				break;
			default:
				break;
		}
	}

	public void visualizarCenario(){
		for(int i = 0; i < this.cenario.length; i++){
			for(int j = 0; j < this.cenario.length; j++){
				if(this.cenario[i][j].getTipo() == TipoElemento.EPACOVAZIO)
					System.out.print("-    -");
				else if(this.cenario[i][j].getTipo() == TipoElemento.AVENTUREIRO)
					System.out.print("-Aven-");
				else if(this.cenario[i][j].getTipo() == TipoElemento.JOAODORMINHOCO)
					System.out.print("-João-");
				else if(this.cenario[i][j].getTipo() == TipoElemento.OBSTACULO)
					System.out.print("-Obst-");
				else if(this.cenario[i][j].getTipo() == TipoElemento.MENSAGEM)
					System.out.print("-Mens-");
				else
					System.out.print("-Teso-");
			}
			System.out.println("");
		}
	}

	private void addObstaculo(){
		//objeto da classe random
		Random jv = new Random();
		//indices
		int i, j, len = this.cenario.length;
		//flag
		boolean flag = false, caminhoPreso;
		while(!flag){
			i = jv.nextInt(len);
			j = jv.nextInt(len);
			caminhoPreso = (i >= (len-2) && j >= (len-2)) || (i < 2 && j < 2);
			if(this.cenario[i][j].getTipo() == TipoElemento.EPACOVAZIO && !caminhoPreso){
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
		int i, j, len = this.cenario.length;
		//flag
		boolean flag = false, posicaoInvalida;
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