package model.pagamentos;

import model.pessoa.Comprador;
import model.pessoa.Vendedor;

public class Pix extends Pagamento {

  public Pix(final Comprador comprador, final Vendedor vendedor, final Double valorTotal) {
    super(comprador, vendedor, valorTotal);
  }

  @Override
  protected void debitarValoresComprador() {
    this.comprador.setSaldo(this.comprador.getSaldo() - this.valorTotal);
  }

  @Override
  protected void creditoValoresVendedor() {
    this.vendedor.setSaldo(this.vendedor.getSaldo() + this.valorTotal);
  }

  @Override
  protected boolean meioPagamentoPrecisaValidarSaldoComprador() {
    return true;
  }

  @Override
  protected Double getValorTaxa() {
    return 0d;
  }

  @Override
  public String toString() {

    return "PIX";
  }
}
