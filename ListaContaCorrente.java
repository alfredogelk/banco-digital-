

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author UCS
 */
public class ListaContaCorrente {
    
    private ContaCorrente[] aContas ;
    private int quantasContas = 0 ;
    private int capacidade  ;
    private boolean estaOrdenado = false ;

    public ListaContaCorrente() 
    {
        this.aContas = new ContaCorrente[100];
        this.capacidade = 100;
    }

    public ListaContaCorrente(int capacidade) 
    {
        this.aContas = new ContaCorrente[capacidade];
        this.capacidade = capacidade;
    }
    
    public boolean incluir(int pos, ContaCorrente conta)
    {
        if (pos <= capacidade - 1 && pos >= 0)
        {
            if (this.aContas[pos] != null)
            {
                for (int i=this.capacidade-2; i > pos - 1; i --)
                    this.aContas[i+1] = this.aContas[i];
                this.aContas[pos] = conta;
                this.quantasContas ++;
            }
            else if ((pos >= 1 && this.aContas[pos - 1] != null) || (pos == 0)) // 
            {
                this.aContas[pos] = conta;
                this.quantasContas ++;
            }
            else 
            {
                this.incluirNoFim(conta);
            }
            return true;
        }
        return false;
    }

    public void incluirNoInicio(ContaCorrente conta)
    {
        for (int i=this.capacidade - 2; i > 0; i ++)
            this.aContas[i+1] = this.aContas[i];
        this.aContas[0] = conta;
        this.quantasContas ++;
    }
    
    public void incluirNoFim(ContaCorrente conta)
    {
        if(this.quantasContas >= this.capacidade)
            this.aContas[this.capacidade-1] = conta; 
        else
            this.aContas[this.quantasContas] = conta;
        this.quantasContas ++;
    }
    
    public boolean incluirEmOrdem(ContaCorrente conta)
    {
        if(!this.estaOrdenado)
            return false;        
        int kn = conta.getNumero();
        int j = this.quantasContas;
        while(j > 0 && this.aContas[j-1] != null && this.aContas[j-1].getNumero() > kn)
        {
            this.aContas[j] = this.aContas[j-1];
            j = j - 1;
        }
        this.aContas[j] = conta;
        this.quantasContas ++;
        return true;
    }
    
    public ContaCorrente pesquisar (int numero)
    {
        for(int i=0;i < this.capacidade; i++)
            if (this.aContas[i] != null && this.aContas[i].getNumero() == numero)
                return this.aContas[i];
        return null;
    }

    public ArrayList<ContaCorrente> pesquisarCliente (Cliente cliente)
    {
        ArrayList<ContaCorrente> x = new ArrayList<>();
        for(int i=0;i < this.capacidade; i++)
            if (this.aContas[i] != null && this.aContas[i].getDonoDaConta() == cliente)
                x.add(this.aContas[i]);
        return x;
    }
    
    public ContaCorrente get(int pos)
    {
        try {
            if (this.aContas[pos] != null)
                return this.aContas[pos];
            return null;
        } catch (Exception e) {
            return null;
        }
                
    }
    
    public int tamanho()
    {
        return this.quantasContas;
    }
    
    public ContaCorrente[] contasComSaldoArray(double valor)
    {
        ContaCorrente[] aC = new ContaCorrente[quantasContas];
        int x = 0;
        for(int i=0; i < this.quantasContas; i++)
        {
            if (this.aContas[i].getSaldo() > valor)
            {
                aC[x] = this.aContas[i];
                x ++;
            }
        }
        return aC;
    }

    public ListaContaCorrente contasComSaldoLista(double valor)
    {
        ListaContaCorrente l = new ListaContaCorrente(this.quantasContas);
        for(int i=0; i < this.quantasContas; i++)
        {
            if (this.aContas[i].getSaldo() > valor)
            {
                l.incluirNoFim(this.aContas[i]);
            }
        }
        return l;
    }
    
    public boolean ordenar()
    {
        for (int i=1; i<this.capacidade - 1; i++) 
        {
            if(this.aContas[i] != null)
            {
                ContaCorrente k = this.aContas[i];
                int kn = this.aContas[i].getNumero();
                int j = i;
                while(j > 0 && this.aContas[j] != null && this.aContas[j-1].getNumero() > kn)
                {
                    this.aContas[j] = this.aContas[j-1];
                    j = j - 1;
                }
                this.aContas[j] = k;
            }
        }
        this.estaOrdenado = true;
        return true;
    }
    
}
