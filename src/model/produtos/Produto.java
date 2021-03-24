package model.produtos;

import java.util.Objects;

public class Produto {

  private int codigo;
  private String nome;
  private Double precoUnitario;

  @Override
  public String toString() {

    return "    [" + this.codigo + "] - " + this.nome + " - Preço: R$ " + this.precoUnitario + "\n";
  }

  public int getCodigo() {
    return this.codigo;
  }

  public void setCodigo(final Integer codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(final String nome) {
    this.nome = nome;
  }

  public Double getPrecoUnitario() {
    return this.precoUnitario;
  }

  public void setPrecoUnitario(final Double precoUnitario) {
    this.precoUnitario = precoUnitario;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    final Produto produto = (Produto) o;
    return this.nome.equals(produto.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.nome);
  }
}
