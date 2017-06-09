import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		//menu inicial
		System.out.println("Digite o tamanho da câmara: ");
		int tamanho = scan.nextInt();
		Aventureiro mv = new Aventureiro("Marcos Vinicius");
		Caverna cav = new Caverna(mv, tamanho);
		cav.iniciar(TipoCamara.FACIL);
		cav.visualizarCenario();
		/*
		System.out.println("");
		System.out.println(cav.getCamara().getCenario()[tamanho-2][tamanho-1].getTipo());
		*/
	}
}