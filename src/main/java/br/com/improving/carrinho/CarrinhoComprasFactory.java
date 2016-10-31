package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsável pela criação e recuperação dos carrinhos de compras.
 */
public class CarrinhoComprasFactory {

	Map<String, CarrinhoCompras> carrinhosCompras = new HashMap<String, CarrinhoCompras>();
	
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
    	
    	if(carrinhosCompras.containsKey(identificacaoCliente)) {
    		carrinhoCompras = null;
    	} else {
    		carrinhosCompras.put(identificacaoCliente, carrinhoCompras);
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
    	List<CarrinhoCompras> carrinhoComprasL = new ArrayList<>(carrinhosCompras.values());
    	
    	carrinhoComprasL.stream()
    	                    .forEach(s -> s.getValorTotal().plus().divide(new BigDecimal(carrinhoComprasL.size())));
        BigDecimal valorTicketMedio = (BigDecimal) carrinhoComprasL;
        return valorTicketMedio.setScale(2, RoundingMode.HALF_EVEN);
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
    	try {
    		carrinhosCompras.remove(identificacaoCliente);
    		return true;
    	    }
    	    catch(RuntimeException e) {
    		 return false;
    	}
    }
}
