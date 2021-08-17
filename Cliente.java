import java.util.ArrayList;

public class Cliente
{
    private String nome;
    private String endereco ;
    //private ArrayList<ContaCorrente> aContas = new ArrayList<>();
    private ListaContaCorrente aContas = new ListaContaCorrente();
    
    public Cliente(String nome, String endereco)
    {
        this.nome = nome ;
        this.endereco = endereco ;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public void addContaCorrente(ContaCorrente conta)
    {
        //this.aContas.incluir(conta);
        this.aContas.incluirNoFim(conta);
    }
}
