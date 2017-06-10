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
                    if(x == 0)
                        throw new AcaoInvalidaException();
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