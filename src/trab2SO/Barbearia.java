public class Barbearia {
	final int numeroBarbeiros;
	final int numeroCadeirasFila;
	int totalBarbeiros = 0;
	int totalFila = 0;
	Fifo barbeiros;
	Fifo clientes;
	
	public Barbearia (int nmrBarbeiros, int nmrCadeiras){
		this.numeroBarbeiros = nmrBarbeiros;
		this.numeroCadeirasFila = nmrCadeiras;
		this.barbeiros = new Fifo(this.numeroBarbeiros);
		this.clientes = new Fifo(this.numeroCadeirasFila);
		
		for(int i=0; i< this.numeroBarbeiros; i++){
			this.barbeiros.put(new Barbeiro(this.clientes));
		}

	}


	public void cortarCabelinho(Cliente c) throws Exception {    
		if (!filaCheia()) {
			clientes.put(c);

			synchronized(this){
				this.totalFila++;
			}

			if(barbeiroLivre()){
				Barbeiro b = (Barbeiro) barbeiros.get();
				b.notify();


				synchronized(this){
					if(this.totalFila > 0)
						this.totalFila--;
				}

				barbeiros.put(b);

			}
		} else {
			throw new Exception("Fila Cheia");
		}

	} 

	synchronized boolean filaCheia() {
		if(totalFila < numeroCadeirasFila){
			return false;
		} else {
			return true;
		}
	}

	synchronized boolean barbeiroLivre() {
		if(totalBarbeiros < numeroBarbeiros){
			return true;
		} else {
			return false;
		}

	}

}
