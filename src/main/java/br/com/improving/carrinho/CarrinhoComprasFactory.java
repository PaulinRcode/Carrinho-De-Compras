package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsável pela criação e recuperação dos carrinhos de compras.
 */
public class CarrinhoComprasFactory {

	Map<String, CarrinhoCompras> clientes = new HashMap<String, CarrinhoCompras>();
	
    /**
     * Cria um carrinho de compras para o cliente passado como parâmetro.
     *
     * Caso já existe um carrinho de compras para o cliente passado como parâmetro, esse carrinho deverá ser retornado.
     *
     * @param identificacaoCliente
     * @return CarrinhoCompras
     */
    public CarrinhoCompras criar(String identificacaoCliente) {
    	CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
    	
    	if(clientes.containsKey(identificacaoCliente)) {
    		carrinhoCompras = null;
    	} else {
    		clientes.put(identificacaoCliente, carrinhoCompras);
    	}
    	
    	return carrinhoCompras;
    }

    /**
     * Retorna o valor do ticket médio no momento da chamada ao método.
     * O valor do ticket médio é a soma do valor total de todos os carrinhos de compra dividido
     * pela quantidade de carrinhos de compra.
     * O valor retornado deverá ser arredondado com duas casas decimais, seguindo a regra:
     * 0-4 deve ser arredondado para baixo e 5-9 deve ser arredondado para cima.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTicketMedio() {

    }

    /**
     * Invalida um carrinho de compras quando o cliente faz um checkout ou sua sessão expirar.
     * Deve ser efetuada a remoção do carrinho do cliente passado como parâmetro da listagem de carrinhos de compras.
     *
     * @param identificacaoCliente
     * @return Retorna um boolean, tendo o valor true caso o cliente passado como parämetro tenha um carrinho de compras e
     * e false caso o cliente não possua um carrinho.
     */
    public boolean invalidar(String identificacaoCliente) {

    }
    
    protected String validaCliente(String identificacaoCliente) {
    	List<String> clientes = Arrays.asList("cliente1, cliente2, cliente3, cliente4");
    	
    	Comparator<String> c1 = (s1,s2) ->
    	Integer.compare(s1.compareTo(s2), s2.compareTo(s1));
    	
    	System.out.println(clientes);
    	
    }
}
