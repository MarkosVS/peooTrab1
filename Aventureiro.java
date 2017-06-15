package trabexceção;

public class Aventureiro extends Personagem{
	//construtor
	public Aventureiro(String nome){
		super(TipoElemento.AVENTUREIRO, nome);
	}
        
        //métodos
        public boolean encontrouTesouro(Camara cam){
            int len = cam.getCenario().length;
            return cam.getCenario()[len-1][len-1].getTipo() == TipoElemento.AVENTUREIRO;
        }
}

