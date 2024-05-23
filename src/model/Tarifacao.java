/*
 * Interface para dar taxa de compra e venda para cada moeda.
 */
package model;

/**
 *
 * @author eric song
 */
public interface Tarifacao {
    double getTaxaCompra();
    double getTaxaVenda();
}
