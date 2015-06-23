public class Barbearia extends Thread {
	private Fifo filaClientes;
	private int maximoFila;
	
	public Barbearia(Fifo filaClientes, int maximoFila){
		this.filaClientes = filaClientes;
		this.maximoFila = maximoFila;
	}
	
	public void novoCliente(){
		synchronized (filaClientes){
			if(filaClientes.getFila().size() >= maximoFila){
				System.out.println("Sou o cliente " + Integer.toString((int)(Math.random() * 100))
						+ " vou embora pois nao tem espaco na fila!");
			} else{
				Cliente cliente = new Cliente((int)(Math.random() * 100));
				filaClientes.getFila().add(cliente);

				filaClientes.notifyAll();
			}
		}
	}

	public void run(){
		while(true){
			this.novoCliente();

			try {  
				Thread.sleep((int)(Math.random() * 5000));  
			}  
			catch (InterruptedException e) {  
				e.printStackTrace();  
			}
		}
	}
}
