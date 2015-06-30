import java.util.LinkedList;

public class Fifo {
	private LinkedList<Object> fifo = new LinkedList<Object>();
	private int tamanho = 0;
	
	//recebe o tamanho maximo de clientes que podem entrar na fila
	public Fifo(int tamanho){
		this.tamanho = tamanho;
	}

	//retorna referencia para fila
	public LinkedList<Object> getFila(){
		return fifo;
	}
	
	//confere (atomicamente) se a fila esta cheia or not
	public synchronized boolean estaCheia(){
		return fifo.size() > tamanho;
	}
} 
