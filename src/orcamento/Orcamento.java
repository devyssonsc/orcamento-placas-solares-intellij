package orcamento;

public class Orcamento {
    String descricao;
    String marca;
    String modelo;
    double valorTotal;
    double tempoTotalInstalacao;

    public String getDescricao() {
        return descricao;

    }
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getTempoTotalInstalacao() {
        return tempoTotalInstalacao;
    }

    @Override
    public String toString() {
        return "Descrição do orçamento: " + descricao + ", Marca escolhida: " + marca + ", Modelo escolhido: " + modelo + ", Valor Total: "
                + valorTotal + "€, Tempo Total da Instalação: " + tempoTotalInstalacao + ".";
    }

}