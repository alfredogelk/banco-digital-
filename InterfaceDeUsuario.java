import java.util.ArrayList;

public class InterfaceDeUsuario
{
    //private ContaCorrente[] asContasDoBanco = new ContaCorrente[100] ;
    private ListaContaCorrente aContas = new ListaContaCorrente();
    private Cliente[] aClientes = new Cliente[100] ;
    //private int tamanho = 0 ;
    private int tamanhoC = 0 ;
    private Leitor entrada = new Leitor();
    private boolean ContaCorrente;

    public int buscarConta()
    {
        System.out.print("entre com o numero da conta: ");
        return entrada.leiaInt();
    }
    
    public String buscarAgencia()
    {
        System.out.print("entre com a agencia: ");
        return entrada.leiaString();
    }
    
    public Cliente buscarCliente()
    {
        System.out.print("entre com o nome do cliente: ");
        String nome = entrada.leiaString();
        for(int i=0 ; i< this.tamanhoC ; i++)
        {
            if( nome.equals(this.aClientes[i].getNome()))
                return this.aClientes[i];
        }
        return null;
    }
    
    public void msgMenu()
    {
        System.out.println("0.Sair");
        System.out.println("1. Criar uma nova conta");
        System.out.println("2. Depositar na conta");
        System.out.println("3. Sacar da conta");
        System.out.println("4. Consultar o saldo");
        System.out.println("5. Cadastrar cliente");
        System.out.println("6. Listar clientes");
        System.out.println("7. Ordenar contas por numero");
        System.out.println("8. mostrar contas correntes com saldo acima de um determinado valor");
    }
    
    public void menu()
    {
        this.msgMenu();
        int opcao = entrada.leiaInt();
        double valor = 0;
        int numero = 0;
        ContaCorrente c;

        while(opcao != 0)
        {
            switch (opcao){
                case 1:
                    numero = this.buscarConta();
                    String agencia = this.buscarAgencia();
                    Cliente cliente = this.buscarCliente();
                    if (cliente == null)
                        System.out.println("Cliente não encontrado!");
                    else
                    {
                        c = new ContaCorrente(numero,agencia,cliente);
                        //aContas.incluir(c);
                        aContas.incluirNoFim(c);
                        cliente.addContaCorrente(c);
                    }
                    break;
                case 2:
                    numero = this.buscarConta();
                    System.out.print("entre com o valor: ");
                    valor = entrada.leiaDouble();
                    c = this.aContas.pesquisar(numero);
                    if(c != null)
                        c.depositar(valor);
                    else 
                        System.out.println("conta não existe");
                    break;
                case 3:
                    numero = this.buscarConta();
                    System.out.print("entre com o valor: ");
                    valor = entrada.leiaDouble();
                    c = this.aContas.pesquisar(numero);
                    if(c != null)
                        c.sacar(valor);
                    else 
                        System.out.println("conta não existe");
                    break;
                case 4:
                    numero = this.buscarConta();
                    c = this.aContas.pesquisar(numero);
                    if(c != null)
                        System.out.println("Saldo atual: " + c.getSaldo());
                    else 
                        System.out.println("conta não existe");
                    break;
                case 5:
                    // cadastrar cliente
                    System.out.println("Digite o nome do cliente: ");
                    String nome = entrada.leiaString();
                    boolean encontrou = false;
                    for(int i=0 ; i< this.tamanhoC ; i++)
                    {
                        if( nome.equals(this.aClientes[i].getNome()))
                        {
                            encontrou = true;
                            break;
                        }   
                    }
                    if(encontrou)
                    {
                        System.out.println("cliente já existe");
                    } 
                    else 
                    {
                        System.out.println("Digite o endereco do cliente: ");
                        String endereco = entrada.leiaString();
                        this.aClientes[this.tamanhoC] = new Cliente(nome, endereco) ;
                        this.tamanhoC++ ;
                    }
                    break;
                case 6:
                    for(int i=0; i < this.tamanhoC; i++)
                    {
                        System.out.println("Cliente: " + this.aClientes[i].getNome());
                        System.out.println("Contas:");
                        ArrayList<ContaCorrente> cc = this.aContas.pesquisarCliente(this.aClientes[i]);
                        if (cc != null) {
                            for (ContaCorrente ccc : cc)
                            {
                                System.out.print("Numero: " + ccc.getNumero() + " ");
                                System.out.println("Saldo: " + ccc.getSaldo());
                            }
                        }
                    }
                    break;
                case 7:
                    this.aContas.ordenar();
                    break;
                case 8:
                    System.out.print("digite o valor: ");
                    double v = entrada.leiaDouble();
                    System.out.println("nenhuma conta com saldo maior que o valor");
                    ListaContaCorrente contasComSaldo = this.aContas.contasComSaldoLista(v);
                    int ix = 0;
                    while (contasComSaldo.get(ix) != null)
                    {
                        System.out.println("Numero: " + contasComSaldo.get(ix).getNumero());
                        System.out.println("Saldo: " + contasComSaldo.get(ix).getSaldo());
                        ix ++;
                    }
                    break;
                case 9:
                    numero = this.buscarConta();
                    String agencia2 = this.buscarAgencia();
                    Cliente cliente2 = this.buscarCliente();
                    if (cliente2 == null)
                        System.out.println("Cliente não encontrado!");
                    else
                    {
                        c = new ContaCorrente(numero,agencia2,cliente2);
                        //aContas.incluir(c);
                        aContas.incluirEmOrdem(c);
                        cliente2.addContaCorrente(c);
                    }
                    break;
                default:
                    break;
            }
                   
            this.msgMenu();
            opcao = entrada.leiaInt();
        }

    }
}
