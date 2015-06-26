import java.util.LinkedList;

public class Fifo {
	private LinkedList<Object> fifo = new LinkedList<Object>();
	private int tamanho = 0;
	
	public Fifo(int tamanho){
		this.tamanho = tamanho;
	}

	public LinkedList<Object> getFila(){
		return fifo;
	}
	
	public synchronized boolean estaCheia(){
		return fifo.size() > tamanho;
	}
} 
