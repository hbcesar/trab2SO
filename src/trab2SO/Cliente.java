public class Cliente {
	private int id;

	public Cliente(int id){
		this.id = id;
	}

	public void cortarCabelinho(int id){
		System.out.println("Sou o cliente " + Integer.toString(this.id) + " estou cortando meu cabelinho"
				+ " com o Barbeiro " + Integer.toString(id) + ".");
	}
}
