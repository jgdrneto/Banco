package banco;

import junit.framework.TestCase;

public class ContaTest extends TestCase {
    
    Conta c1,c2,c3;    
    
    /*
     * Iniciando valores das contas que serão utilizadas nos testes
     */
    public void setUp(){
        
        c1 = new Conta("001", 10.0);
        c2 = new Conta("002", 500.0);
    }
    
    /*
     * Testa condição de sucesso do método debitar
     */
	public void testDebitarSucesso() throws OperacaoIlegalException{
		c1.debitar(10);
		assertEquals(0,c1.getSaldo(),0.0);
	}
	
	/*
	 * Testa condição de erro do método debitar, lançando excessão
	 */
	public void testDebitarValorMaiorQueSaldo(){
        	    
	    try{
	        c1.debitar(20);
	        
	        fail("Não deve ser possivel sacar além do saldo!");
	        
	    }catch(OperacaoIlegalException ex){
	        
	        //EXCEÇÃO ESPERADA
	        
	        System.out.println("Excessão lançada no método testDebitarValorMaiorQueSaldo");
	        
	    }
	    
    }
	
	/*
     * Testa condição de erro do método debitar, lançando excessão
     */
    public void testDebitarErroValorNegativo(){
                
        try{
            c1.debitar(-10);
            
            fail("Não deve ser possivel sacar além do saldo!");
            
        }catch(OperacaoIlegalException ex){
            
            //EXCEÇÃO ESPERADA
            
            System.out.println("Excessão lançada no método testDebitarErroValorNegativo");
            
        }
        
    }
	
	/*
     * Testa condição de sucesso do método creditar
     */
    public void testCreditarSucesso() throws OperacaoIlegalException{
        c1.creditar(10);
        assertEquals(20,c1.getSaldo(),0.0);
    }
    
    /*
     * Testa condição de erro do método creditar, lançando excessão
     */
    public void testCreditarErro(){
                
        try{
            c1.creditar(-10);
            
            fail("Não deve ser possivel creditar valores negativos!");
            
        }catch(OperacaoIlegalException ex){
            
            //EXCEÇÃO ESPERADA
            
            System.out.println("Excessão lançada no método testCreditarErro");
            
        }
        
    }
	
   /*
    * Testa condição de erro do método transferir, lançando excessão
    */
   public void testTranferirErroReferenciaContaNula(){
               
       try{
           
           c2.transferir(c3, 10);
           
           fail("Não deve ser possivel trnasferir valores para conta de referência nula!");
           
       }catch(OperacaoIlegalException ex){
           
           //EXCEÇÃO ESPERADA
       
           System.out.println("Excessão lançada no método testTranferirErroReferenciaContaNula");
       }
       
   }
    
   /*
    * Testa condição de erro do método transferir, lançando excessão
    */
   public void testTranferirErroValorMaiorSaldo(){
               
       try{
           
           c1.transferir(c2, 20);
           
           fail("Não deve ser possivel transferir valores acima do saldo!");
           
       }catch(OperacaoIlegalException ex){
           
           //EXCEÇÃO ESPERADA
           
           System.out.println("Excessão lançada no método testTranferirErroValorMaiorSaldo");
           
       }
       
   }
   
   /*
    * Testa condição de erro do método transferir, lançando excessão
    */
   public void testTranferirErroValorNegativo(){
               
       try{
           
           c1.transferir(c2, -5);
           
           fail("Não deve ser possivel transferir valores negativos!");
           
       }catch(OperacaoIlegalException ex){
           
           //EXCEÇÃO ESPERADA
           
           System.out.println("Excessão lançada no método testTranferirErroValorNegativo");
           
       }
       
   }
   
   /*
    * Testa condição de sucesso do método transferir, lançando excessão
    */
   public void testTranferirSucesso() throws OperacaoIlegalException{

       c2.transferir(c1, 50);
       
       assertEquals(60,c1.getSaldo(),0.0);
       assertEquals(450,c2.getSaldo(),0.0);
       
   }
   
}
