public abstract class Personagem extends Elemento{
	//atributos
	private String nome;

	//construtor
	public Personagem(TipoElemento t, String nome){
		super(t);
		this.nome = nome;
	}

	//getter / setter
	public String getNome(){
		return this.nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
        
        //métodos
        public void mover(Camara cam, Movimento mov) throws AcaoInvalidaException{
            //posição do personagem
            int x = 0, y = 0;
            //tamanho da camara
            int length = cam.getCenario().length;
            boolean flag = false; //flag para quebrar o duplo for
            //duplo for para encontrar a posição do personagem
            for(int i = 0; i < length && !flag; i++)
                for(int j = 0; j < length && !flag; j++){
                    if(cam.getCenario()[i][j].getTipo() == this.getTipo()){
                        x = i;
                        y = j;
                        flag = true;
                    }
                }
            
            //switch-case pra realizar o movimento
            switch(mov){
                case UP:
                    //não deixar o personagem sair da camara
                    if(x == 0){
                        cam.visualizarCenario();
                        throw new AcaoInvalidaException("Não é possível sair da câmara");
                    }
                    
                    //não deixar o personagem atravessar um obstáculo
                    if(cam.getCenario()[x-1][y].getTipo() == TipoElemento.OBSTACULO){
                        cam.visualizarCenario();
                        throw new AcaoInvalidaException("Não é possível se atravessar um obstáculo");
                    }
                    
                    //checa se acima do personagem é um espaço vazio, se sim, já realiza o movimento
                    if(cam.getCenario()[x-1][y].getTipo() == TipoElemento.EPACOVAZIO){
                       cam.getCenario()[x-1][y] = cam.getCenario()[x][y];
                       cam.getCenario()[x][y] = new ObjetoCamara(TipoElemento.EPACOVAZIO, "Espaço vazio");
                       cam.visualizarCenario();
                       return;
                    }
                    
                    //checa o tipo do personagem
                    if(cam.getCenario()[x][y].getTipo() == TipoElemento.AVENTUREIRO){
                        //
                    }else if(cam.getCenario()[x][y].getTipo() == TipoElemento.JOAODORMINHOCO){
                        //
                    }
                    break;
                case DOWN:
                    break;
                case LEFT:
                    break;
                case RIGHT:
                    break;
                default:
                    break;
            }
        }
}