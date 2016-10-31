package br.com.improving.carrinho;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {

	private List<Item> listaItens;

    /**
     * Permite a adição de um novo item no carrinho de compras.
     *
     * Caso o item já exista no carrinho, ou seja, já exista um item no carrinho referenciando esse mesmo produto,
     * deverá seguir as seguintes duas regras:
     * - Deverá ser alterada apenas a quantidade, sendo que o novo valor deverá ser a soma da quantidade
     * atual e o valor da quantidade passada como parâmetro.
     * - Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor unitário do item deverá ser
     * o passado como parâmetro.
     *
     * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao carrinho de compras.
     *
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
    	int posicaoEncontrada = -1;
    	
    	for(int pos = 0; pos < getItens().size() & posicaoEncontrada < 0; pos++) {
    		Item itemTemporario = listaItens.get(pos);
    		
    		if(itemTemporario.getProduto().equals(produto)){
    			posicaoEncontrada = pos;
    		}    		
    	}
    	
    	try {	    	
    	    if(posicaoEncontrada < 0) {
    		   Item item = new Item(produto, valorUnitario, quantidade);
    		   item.setValor(item.getValorTotal());
    		   getItens().add(item);    		
    	    } else {
			  Item itemTemporario = listaItens.get(posicaoEncontrada);
			  quantidade = itemTemporario.getQuantidade() + quantidade;
			  valorUnitario = itemTemporario.getValorUnitario() == valorUnitario ? valorUnitario = itemTemporario.getValorUnitario() : valorUnitario;
			  Item item = new Item(produto, valorUnitario, quantidade);
			  item.setValor(item.getValorTotal());
			
			  listaItens.set(posicaoEncontrada, item);
		    }
    	}   catch(RuntimeException e) {
    		  e.getStackTrace();
    	    }  
    }

    /**
     * Permite a remoção do carrinho de compras do produto passado como parâmetro.
     *
     * @param produto
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(Produto produto) {
    	int posicaoEncontrada = -1;
    	
    	for(int pos = 0; pos < getItens().size() & posicaoEncontrada < 0; pos++) {
    		Item itemTemp = listaItens.get(pos);
    		
    		if(itemTemp.getProduto().equals(produto)) {
    			posicaoEncontrada = pos;
    		}
     	}
    	
    	if(posicaoEncontrada > -1) {
    		getItens().remove(posicaoEncontrada);
    	    return true;
    	} else {
    		return false;
    	}
    }

    /**
     * Permite a remoção do item de acordo com a posição.
     * Essa posição deve ser determinada pela ordem de inclusão do produto na coleção.
     *
     * @param posicaoItem
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(int posicaoItem) {
    	try {
    		listaItens.remove(posicaoItem);
    		return true;
    	    }
    	    catch(RuntimeException e) {
    		 return false;
    	}
    }

    /**
     * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais
     * de todos os itens que compõem o carrinho.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
    	getItens().stream()
    	              //.filter(s -> s.getValorUnitario()) 
    	              //.filter(s -> s.getValor().plus(s.getValor())
     			      //.forEach(s -> s.getValor().plus());
     			      .forEach(s -> s.getValorTotal().plus());
    	return (BigDecimal) getItens(); 
    }

    /**
     * Retorna a lista de itens do carrinho de compras.
     *
     * @return Collection<Itens>
     */
    public Collection<Item> getItens() {
    	if(listaItens == null) {
    		listaItens = new ArrayList<>();
    	}
    	return listaItens;
     }
}