public class Trab2 {
	public static void main(String[] args) {
		//inicia a fila
		Fifo filaClientes = new Fifo(5);

		//"abre" a barbearia
		Barbearia barbearia = new Barbearia(filaClientes);

		//tres barbeiros chegam para um dia maneiro de trabalho
		Barbeiro barbeiro1 = new Barbeiro(filaClientes, 1);
		Barbeiro barbeiro2 = new Barbeiro(filaClientes, 2);
		Barbeiro barbeiro3 = new Barbeiro(filaClientes, 3);

		//bota a galera pra ralar
		barbearia.start();
		barbeiro1.start();
		barbeiro2.start();
		barbeiro3.start();
		
	}
}
