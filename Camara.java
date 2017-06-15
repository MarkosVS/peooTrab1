package trabexceção;

import java.util.Random;

public class Camara{
	//atributos
	private ObjetoCamara[][] cenario;
        private final int tamanho;

	//construtor
	public Camara(int n){
		if(n < 5)
			n = 5;
		this.cenario = new ObjetoCamara[n][n];
                this.tamanho = n;
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
		//cria um ObjetoCamara tesouro
		ObjetoCamara tes = new ObjetoCamara(TipoElemento.TESOURO, "Tesouro");
		//cria um aventureiro igual ao passado como parametro e coloca na posição (0,0)
		this.cenario[0][0] = new ObjetoCamara(av.getTipo(), av.getNome());
		//switch-case com os tipos de camara
		switch(tipo){
			case FACIL:
				this.cenario[tamanho-1][tamanho-1] = tes;
				break;
			case DIFICIL:
				this.cenario[tamanho-1][tamanho-1] = tes;
				addJoaoDorminhoco();
				for(int i = 0; i < tamanho/2; i++)
					addObstaculo();                  
				break;
			case ERRADA:
				this.cenario[tamanho-1][tamanho-1] = new ObjetoCamara(TipoElemento.MENSAGEM, "Mensagem");
				addJoaoDorminhoco();
				for(int i = 0; i < tamanho/2; i++)
					addObstaculo();	
				break;
			default:
				break;
		}
	}

	public void visualizarCenario(){
		for(int i = 0; i < this.tamanho; i++){
			for(int j = 0; j < this.tamanho; j++){
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
		int i, j;
		//flag
		boolean flag = false, caminhoPreso;
		while(!flag){
			i = jv.nextInt(tamanho);
			j = jv.nextInt(tamanho);
			caminhoPreso = (i >= (tamanho-2) && j >= (tamanho-2)) || (i < 2 && j < 2);
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
		int i, j;
		//flag
		boolean flag = false;
		while(!flag){
			i = (jv.nextInt(this.tamanho - 4)) + 2;
			j = (jv.nextInt(this.tamanho - 4)) + 2;
			if(this.cenario[i][j].getTipo() == TipoElemento.EPACOVAZIO){
				this.cenario[i][j] = joao;
				flag = true;
			}
		}
	}
        
        public TipoCamara tipo(){
            if(this.cenario[tamanho-1][tamanho-1].getTipo() == TipoElemento.MENSAGEM)
                return TipoCamara.ERRADA;
            
            //percorre a matriz em busca de obstaculos
            for(int i = 0; i < tamanho; i++)
                for(int j = 0; j < 0; j++)
                    if(this.cenario[i][j].getTipo() == TipoElemento.OBSTACULO)
                        return TipoCamara.DIFICIL;
            return TipoCamara.FACIL;
        }
}
