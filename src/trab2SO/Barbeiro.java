public class Barbeiro extends Thread {
	Fifo clientes;
	Cliente cliente;

	public Barbeiro (Fifo clientes){
		this.clientes = clientes;
	}

	public void run(){
		synchronized(this){
			this.cliente = (Cliente) clientes.get();
		}

		cliente.notify();

		try {
			wait();
		} catch (InterruptedException e) {
			System.out.println("Erro ao dormir barbeiro");
		}
	}

}
