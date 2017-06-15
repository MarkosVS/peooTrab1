package trabexceção;

import java.util.Random;

public class Main{
    static void jogar(Caverna cav){
        Random jv = new Random();
        int rand;
        cav.iniciar();
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
            System.out.println("");
            System.out.println("O tesouro está em outra câmara.");
            System.out.println("Gerando nova câmara...");
            System.out.println("");
            jogar(cav);
        }else if(tipo == TipoCamara.FACIL){
            while(!(cav.getAventureiro().encontrouTesouro(cav.getCamara()))){
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
            System.out.println("Você ganhou");
        }else{
            while(!(cav.getAventureiro().encontrouTesouro(cav.getCamara()))){
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
            System.out.println("Você ganhou");
        }
    }    
    public static void main(String[] args) throws AcaoInvalidaException{
        Aventureiro mv = new Aventureiro("Marcos Vinicius");
        Caverna cav = new Caverna(mv, 7);
        jogar(cav);
        cav.visualizarCenario();
    }
}
