import java.util.LinkedList;

public class Fifo {
	LinkedList<Object> fifo = new LinkedList<Object>();
	private int tamanho;
	private int ocupados = 0;

	public Fifo (int tamanho) {
		this.tamanho = tamanho;
	}

	synchronized boolean put(Object c){
		if(this.ocupados == this.tamanho){
			return false;
		} else {
			fifo.add (c);
			this.ocupados++;
			return true;
		}
	}

	synchronized Object get(){
		return fifo.removeFirst();
	}
} 
