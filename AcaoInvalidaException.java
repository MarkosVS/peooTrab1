package trabexceção;

public class AcaoInvalidaException extends Exception{
    //construtor
    public AcaoInvalidaException(String erro){
        super(erro);
    }
}