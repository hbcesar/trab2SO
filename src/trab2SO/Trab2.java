public class Trab2 {
	public static void main(String[] args) {
		Fifo filaClientes = new Fifo();
		int maximoFila = 5;

		Barbearia barbearia = new Barbearia(filaClientes, maximoFila);

		Barbeiro barbeiro1 = new Barbeiro(filaClientes, 1);
		Barbeiro barbeiro2 = new Barbeiro(filaClientes, 2);
		Barbeiro barbeiro3 = new Barbeiro(filaClientes, 3);

		barbearia.start();
		barbeiro1.start();
		barbeiro2.start();
		barbeiro3.start();
		
	}
}
