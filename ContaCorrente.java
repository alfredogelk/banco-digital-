public class ContaCorrente
{
    private int numero ;
    private double saldo = 0 ;
    private String agencia ;
    private Cliente donoDaConta ;
    
    public ContaCorrente(int numero, String agencia, Cliente cliente)
    {
        this.numero = numero ;
        this.agencia = agencia ;
        this.donoDaConta = cliente ;
    }
    
    public void depositar(double valor)
    {
        this.saldo += valor ;
    }
    
    public void sacar(double valor)
    {
        this.saldo -= valor;
    }
    
    public double getSaldo()
    {
        return this.saldo;
    }
    
    public Cliente getDonoDaConta()
    {
        return this.donoDaConta;
    }
    
    public void setNumero(int num)
    {
        this.numero = num ;
    }
    
    public int getNumero()
    {
        return this.numero ;
    }
    
    public void setAgencia(String ag)
    {
        this.agencia = ag ;
    }
    
    public String getAgencia()
    {
        return this.agencia ;
    }
    
    
}
