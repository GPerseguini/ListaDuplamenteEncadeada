
public class Principal {

	public static void main(String[] args) {
		Lista lista = new Lista();
		lista.addFinal("Lucas",7,"ADS");
		lista.addInicio("Marcelo",6,"Log");
		lista.addInicio("Vinicius",5,"UX");
		lista.addInicio("Victor",4,"Jornalismo");
		lista.addInicio("Jamille",3,"ADS");
		lista.addInicio("Gabriel",2,"ADS");		
		lista.addInicio("Kauan",1,"ADS");
		lista.addInicio("Pino Costa",10,"Comex");
		lista.addInicio("Zézinho Pedroso",1,"ADS");	
		//lista.visualiza();
		System.out.println("Elemento removido: "+lista.removeInicio());
		lista.removeFinal();
		lista.visualiza();
		lista.buscaAluno("Marcelo");
		lista.OrdenaLista();
		lista.visualiza();
	}

}
