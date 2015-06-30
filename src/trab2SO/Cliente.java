public class Cliente extends Thread{
	private int id;
	private Fifo filaClientes;

	//recebe referencia para lista
	//e tambem uma id unica, para que seja possivel 
	//identificar que barbeiro ta cortando cabelo ou dormindo
	//na hora dos prints.
	public Cliente(Fifo clientes, int id){
		this.filaClientes = clientes;
		this.id = id;
	}

	//imprime na tela que esta cortando cabelinho
	public void cortarCabelinho(int id){
		System.out.println("Sou o cliente " + Integer.toString(this.id) + " estou cortando meu cabelinho"
				+ " com o Barbeiro " + id + ".");
	}

	//assim que a thread inicia sua execucao, ela checa se ha 
	//espaco na fila, caso houver, entra nela e espera (envia um notify
	//para acordar os meninos barbeiros),
	//caso contrario, fica chateado e vai embora.
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
