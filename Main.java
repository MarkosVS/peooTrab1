package trabexceção;

import java.util.Random;

public class Main{
    static void jogar(Caverna cav){
        Random jv = new Random();
        int rand;
        cav.iniciar();
        cav.visualizarCenario();
        TipoCamara tipo = cav.getCamara().tipo();
        if(tipo == TipoCamara.ERRADA){
            while(!(cav.getAventureiro().encontrouMensagem(cav.getCamara()))){
                rand = jv.nextInt(4) + 1;
                switch(rand){
                    case 1:
                        try{
                            cav.getAventureiro().mover(cav.getCamara(), Movimento.UP);
                        System.out.println("");
                        }catch(AcaoInvalidaException e){
                            System.out.println(e);
                            System.out.println("");
                        }
                        break;
                    case 2:
                        try{
                            cav.getAventureiro().mover(cav.getCamara(), Movimento.DOWN);
                            System.out.println("");
                        }catch(AcaoInvalidaException e){
                            System.out.println(e);
                            System.out.println("");
                        }
                        break;
                    case 3:
                        try{
                            cav.getAventureiro().mover(cav.getCamara(), Movimento.LEFT);
                            System.out.println("");
                        }catch(AcaoInvalidaException e){
                            System.out.println(e);
                            System.out.println("");
                        }
                        break;
                    case 4:
                        try{
                            cav.getAventureiro().mover(cav.getCamara(), Movimento.RIGHT);
                            System.out.println("");
                        }catch(AcaoInvalidaException e){
                            System.out.println(e);
                            System.out.println("");
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }    
    public static void main(String[] args) throws AcaoInvalidaException{
        Aventureiro mv = new Aventureiro("Marcos Vinicius");
        Caverna cav = new Caverna(mv, 7);
        jogar(cav);
    }
}
