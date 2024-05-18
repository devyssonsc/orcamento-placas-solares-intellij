package orcamento;

public class Painel {
    String marca;
    String modelo;
    double preco; // por unidade
    double tempoInstalacao; // por unidade
    double producao; // kWh

    public Painel(String marca, String modelo, double preco, double tempoInstalacao, double producao) {
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.tempoInstalacao = tempoInstalacao;
        this.producao = producao;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPreco() {
        return preco;
    }

    public double getTempoInstalacao() {
        return tempoInstalacao;
    }

    public double getProducao() {
        return producao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Preço Unitário: " + preco + ", Tempo de Instalação Unitário: "
                + tempoInstalacao + ", Produção: " + producao + "kWh.";
    }

}