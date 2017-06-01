public class Main{
	public static void main(String[] args){
		Aventureiro mv = new Aventureiro("Marcos Vinicius");
		Caverna cav = new Caverna(mv, 10);
		cav.iniciar(TipoCamara.FACIL);
	}
}