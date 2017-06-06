import java.util.Random;

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
			case TipoCamara.FACIL:
				this.cenario[length-1][length-1] = tes;
				break;
			case TipoCamara.DIFICIL:
				addJoaoDorminhoco();
				this.cenario[length-1][length-1] = tes;
				break;
			case TipoCamara.ERRADA:
				break;
			default:
				break;
		}
	}

	private void addElementos(ObjetoCamara obj, int span){
		//objeto da classe random
		Random jv = new Random();
		//indices
		int i, j;
		//flag
		boolean flag = false;
		while(!flag){
			i = jv.nextInt(span);
			j = jv.nextInt(span);
			if(this.cenario[i][j].getTipo() == TipoElemento.EPACOVAZIO){
				this.cenario[i][j] = obj;
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