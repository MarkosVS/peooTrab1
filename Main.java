import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		//menu inicial
		System.out.println("Digite o tamanho da câmara: (Mínimo: 5)");
		int tamanho = scan.nextInt();
                while(tamanho < 5){
                    System.out.println("Digite um valor maior ou igual a 5.");
                    tamanho = scan.nextInt();
                }
		Aventureiro mv = new Aventureiro("Marcos Vinicius");
		Caverna cav = new Caverna(mv, tamanho);
		cav.iniciar(TipoCamara.DIFICIL);
		cav.visualizarCenario();
	}
}