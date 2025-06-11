package projetoJunto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compra {
    private LocalDate data;
    private Agricultor agricultor;
    private double valorTotal;
    private List<ProdutoComprado> produtosComprados;

    public Compra(LocalDate data, Agricultor agricultor, double valorTotal) {
        this.data = data;
        this.agricultor = agricultor;
        this.valorTotal = valorTotal;
        produtosComprados = new ArrayList<ProdutoComprado>();
    }

    public LocalDate getData() {
        return data;
    }

    public Agricultor getAgricultor() {
        return agricultor;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public List<ProdutoComprado> getProdutosComprados() {
        return produtosComprados;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "data=" + data +
                ", agricultor=" + agricultor.getNomeU() +
                ", valorTotal=" + valorTotal +
                ", produtosComprados=" + produtosComprados +
                '}';
    }
}