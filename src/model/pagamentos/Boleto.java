package model.pagamentos;

import java.time.LocalDate;
import model.pessoa.Comprador;
import model.pessoa.ContaPagarReceber;
import model.pessoa.Vendedor;

public class Boleto extends Pagamento {

  public static final double VALOR_EMISSAO_BOLETO = 3.5;

  public Boleto(final Comprador comprador, final Vendedor vendedor, final Double valorTotal) {
    super(comprador, vendedor, valorTotal);
  }

  @Override
  protected void debitarValoresComprador() {
    this.comprador.setSaldo(this.comprador.getSaldo() - this.valorTotal);
  }

  @Override
  protected void creditoValoresVendedor() {

    this.vendedor
        .getValoresAReceber()
        .add(
            new ContaPagarReceber(
                (this.valorTotal - this.getValorTaxa()), LocalDate.now().plusDays(5), "Boleto"));
  }

  @Override
  protected boolean meioPagamentoPrecisaValidarSaldoComprador() {
    return true;
  }

  @Override
  protected Double getValorTaxa() {
    return VALOR_EMISSAO_BOLETO;
  }

  @Override
  public String toString() {

    return "Boleto";
  }
}
