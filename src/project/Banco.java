package project;

public class Banco {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BancoDeDados banco = new BancoDeDados();

		banco.conectar();
		banco.estaConectado();
		//banco.inserirPessoa("Bruno Fernandes",'M',21,"Português");
		//banco.updatePessoa("Bruno Penandes", 'M', 26, "Portuges", 4);
		banco.apagarPessoa(6);
		
		banco.listar();
		
	}

}
