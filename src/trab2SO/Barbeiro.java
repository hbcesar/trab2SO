public class Barbeiro extends Thread {
	private Fifo filaClientes;
	private int id;
	
	public Barbeiro(Fifo filaClientes, int id){
		this.filaClientes = filaClientes;
		this.id = id;
	}

	public void cortarCabelinho() {
		synchronized (filaClientes) {
			if (filaClientes.getFila().size() > 0){
				Cliente cliente = (Cliente) filaClientes.getFila().remove(0);
				cliente.cortarCabelinho(id);
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
	
	public void run(){
		while(true){
			this.cortarCabelinho();
			
			try {  
				Thread.sleep((int)(Math.random() * 5000));  
			}  
			catch (InterruptedException e) {  
				e.printStackTrace();  
			}
		}
	}

}
