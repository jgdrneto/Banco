package banco;

/*
 * Classe conta 
 */
public class Conta{
    
	private String codigo;         
	private double saldo = 0;
	
	/*
	 * Construtor da classe
	 * 
	 * @params String String representando unicamente a conta
	 * @params double Saldo da conta a ser criada 
	 */
	public Conta (String p_id, double p_saldo) { 
		this.saldo = p_saldo;
	    this.codigo = p_id;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	/*
	 * Retirada de certa quantia da conta
	 * 
	 * @params double Valor a ser retirado da conta
	 * 
	 * @return double Saldo atual da conta
	 */
	public double debitar (double valor) throws OperacaoIlegalException {
			
		if(valor > 0 && saldo >= valor){
	         saldo = saldo-valor; 
	    }else{
			throw new OperacaoIlegalException();
		}
		
	   return saldo;

	}

	/*
     * Acréscimo de certa quantia da conta
     * 
     * @params double Valor a ser acrescentado da conta
     * 
     * @return double Saldo atual da conta
     */
	public double creditar (double valor) throws OperacaoIlegalException {
		
		
		if(valor > 0 ){
		    saldo = saldo+valor; 
	    }else{
			throw new OperacaoIlegalException();
		}
		
		return saldo;

	}
	
	/*
     * Transferência de valor entre contas
     * 
     * @params Conta Conta na qual se deseja transferir o valor
     * @params double Valor a ser acrescentado da conta destino
     * 
     * @return double Saldo atual da conta
     */
	public double transferir (Conta conta, double valor) throws OperacaoIlegalException {
       
	   if(conta!=null){ 
	       this.debitar(valor); 
	       conta.creditar(valor);
	   }else{
	       throw new OperacaoIlegalException();
	   }
       return saldo;
       
    }
	
}

	

