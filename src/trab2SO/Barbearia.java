public class Barbearia extends Thread {
	private Fifo filaClientes;
	private int cliente = 0;
	
	//barbearia recebe referencia a lista de clientes
	public Barbearia(Fifo filaClientes){
		this.filaClientes = filaClientes;
	}
	
	//funcao que cria um novo cliente a "entrar" na barbearia
	public void novoCliente(int clienteId){
		Cliente cliente = new Cliente(filaClientes, clienteId);
		cliente.start();
		
	}

	//a cada 1 segundo, um novo cliente vai "chegar" para
	//cortar seu cabelinho
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
