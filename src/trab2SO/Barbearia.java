package trab2SO;

public class Barbearia extends Exception {
	final int numeroBarbeiros = 3;
	final int numeroCadeirasFila = 5;
	int totalBarbeiros = 0;
	int totalFila = 0;
	
	public void cortarCabelinho(Cliente c) throws Exception {  
        synchronized(this) {  
            if (this.totalBarbeiros == this.numeroBarbeiros){
            	if (this.totalFila == this.numeroCadeirasFila){ 
            		throw new Exception("Fila cheia! Vou embora!");
            	} else {
            		this.totalFila++;
            		wait();
            	}
            } else {
            	this.totalBarbeiros++;
            	c.start();
            } 
        }  
	} 

}
