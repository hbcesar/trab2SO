import java.lang.Thread;

public class Cliente extends Thread {
	private int id;

	public Cliente(int id){
		this.id = id;
	}

	public void run(Barbearia barbearia){
		System.out.println("Sou o cliente " + Integer.toString(id) + " vou cortar meu cabelinho.");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			System.out.println("Erro ao cortar cabelinho: " + e);
		}
	}
}
