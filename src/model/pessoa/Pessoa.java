package model.pessoa;

public abstract class Pessoa {

  private String nome;

  private double saldo;

  private String documento;

  public Pessoa() {
    super();
  }

  public String getDocumento() {
    return this.documento;
  }

  public void setDocumento(final String documento) {
    this.documento = documento;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(final String nome) {
    this.nome = nome;
  }

  public Double getSaldo() {
    return this.saldo;
  }

  public void setSaldo(final Double saldo) {
    this.saldo = saldo;
  }
}
