public class Barbearia extends Thread {
	private Fifo filaClientes;
	private int cliente = 0;
	
	public Barbearia(Fifo filaClientes){
		this.filaClientes = filaClientes;
	}
	
	public void novoCliente(int clienteId){
		Cliente cliente = new Cliente(filaClientes, clienteId);
		cliente.start();
		
	}

	public void run(){
		while(true){
			this.novoCliente(cliente++);

			try {  
				Thread.sleep(1000);  
			}  
			catch (InterruptedException e) {  
				e.printStackTrace();  
			}
		}
	}
}
