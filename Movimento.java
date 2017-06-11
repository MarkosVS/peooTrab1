package trabexceção;

public enum Movimento{
	UP(1), DOWN(2), LEFT(3), RIGHT(4);
	
    private int value;
    
    Movimento(int n){
        this.value = n;
    }
}
