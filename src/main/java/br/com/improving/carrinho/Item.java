package br.com.improving.carrinho;

import java.math.BigDecimal;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;

    /**
     * Construtor da classe Item.
     * \
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
    }

    /**
     * Retorna o produto.
     *
     * @return Produto
     */
    public Produto getProduto() {
    }

    /**
     * Seta o produto.
     *
     * @param produto
     */
    public void setProduto(Produto produto) {
    }

    /**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorUnitario() {
    }

    /**
     * Seta o valor unitário do item.
     *
     * @param valorUnitario
     */
    public void setValorUnitario(BigDecimal valorUnitario) {
    }

    /**
     * Retorna a quantidade dos item.
     *
     * @return int
     */
    public int getQuantidade() {
    }

    /**
     * Seta a quantidade do item.
     *
     * @param quantidade
     */
    public void setQuantidade(int quantidade) {
    }

    /**
     * Retorna o valor total do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {

    }
}
