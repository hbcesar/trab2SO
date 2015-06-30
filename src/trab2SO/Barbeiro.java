public class Barbeiro extends Thread {
	private Fifo filaClientes;
	private int id;
	
	//recebe referencia para lista
	//e tambem uma id unica, para que seja possivel 
	//identificar que barbeiro ta cortando cabelo ou dormindo
	//na hora dos prints.
	public Barbeiro(Fifo filaClientes, int id){
		this.filaClientes = filaClientes;
		this.id = id;
	}

	//"chama" o primeiro da fila
	//e corta o seu cabelinho
	public void cortarCabelinho() {
		synchronized (filaClientes) {
			if (filaClientes.getFila().size() > 0){
				Cliente cliente = (Cliente) filaClientes.getFila().remove(0);
				cliente.cortarCabelinho(this.id);
				
			} else {
				try{
					System.out.println("Barbeiro " + Integer.toString(id) + " foi dormir.");
					filaClientes.wait();
				} catch (InterruptedException e) {  
					e.printStackTrace();  
				}
			}
		}
	}
	
	//barbeiro vai demorar 10 segundos entre um corte de cabelo 
	//e outro
	public void run(){
		while(true){
			this.cortarCabelinho();
			
			try {  
				Thread.sleep((int)(Math.random() * 10000));  
			}  
			catch (InterruptedException e) {  
				e.printStackTrace();  
			}
		}
	}

}
