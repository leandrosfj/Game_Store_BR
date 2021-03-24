package model.pagamentos;

import model.pessoa.Comprador;
import model.pessoa.Vendedor;

public class Debito extends Pagamento {

  public static final double TAXA_BANCO_PORCENTAGEM = 0.05;

  public Debito(final Comprador comprador, final Vendedor vendedor, final Double valorTotal) {
    super(comprador, vendedor, valorTotal);
  }

  @Override
  protected void debitarValoresComprador() {
    this.comprador.setSaldo(this.comprador.getSaldo() - this.valorTotal);
  }

  @Override
  protected void creditoValoresVendedor() {
    this.vendedor.setSaldo(this.vendedor.getSaldo() + this.valorTotal - this.getValorTaxa());
  }

  @Override
  protected boolean meioPagamentoPrecisaValidarSaldoComprador() {
    return true;
  }

  @Override
  protected Double getValorTaxa() {
    return this.getValorTotal() * TAXA_BANCO_PORCENTAGEM;
  }

  @Override
  public String toString() {

    return "Cartão de Débito";
  }
}
