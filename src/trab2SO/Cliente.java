public class Cliente extends Thread{
	private int id;
	private Fifo filaClientes;

	public Cliente(Fifo clientes, int id){
		this.filaClientes = clientes;
		this.id = id;
	}

	public void cortarCabelinho(int id){
		System.out.println("Sou o cliente " + Integer.toString(this.id) + " estou cortando meu cabelinho"
				+ " com o Barbeiro " + id + ".");
	}

	public void run () {
		synchronized(filaClientes){
			if(filaClientes.estaCheia()){
				System.out.println("Sou o cliente " + Integer.toString(this.id)
						+ " vou embora pois nao tem espaco na fila!");
			} else {
				filaClientes.getFila().add(this);
				filaClientes.notifyAll();
			}
		}
	}
}
