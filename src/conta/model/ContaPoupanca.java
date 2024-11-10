package conta.model;

public class ContaPoupanca extends Conta  {
	
	private int aniversaio;
	
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversaio = aniversario;
		
	}
	
	public int getAniversaio() {
		return aniversaio;
		
	}
	
	public void setAniversaio(int aniversaio) {
		this.aniversaio = aniversaio;
		
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Aniversário da conta: " + aniversaio);

	}

}