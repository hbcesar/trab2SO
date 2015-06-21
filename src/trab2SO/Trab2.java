public class Trab2 {
	public static void main(String[] args) {
		Barbearia barbearia = new Barbearia(3, 5);
		
		for(int i=0; i< Math.random() * 10; i++){
			try{
				barbearia.cortarCabelinho(new Cliente(i));
			} catch (Exception e){
				System.out.println(e);
			}
		}
		
	}
}
