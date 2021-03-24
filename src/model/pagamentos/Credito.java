package model.pagamentos;

import java.time.LocalDate;
import model.pessoa.Comprador;
import model.pessoa.ContaPagarReceber;
import model.pessoa.Vendedor;

public class Credito extends Pagamento {

  public static final int DIA_VENCIMENTO_CARTAO = 15;
  public static final double TAXA_BANCO_PORCENTAGEM = 0.05;

  public Credito(final Comprador comprador, final Vendedor vendedor, final Double valorTotal) {
    super(comprador, vendedor, valorTotal);
  }

  @Override
  protected void debitarValoresComprador() {

    final LocalDate dataVencimentoCartao =
        LocalDate.now().getDayOfMonth() >= DIA_VENCIMENTO_CARTAO
            ? LocalDate.now().plusMonths(1).withDayOfMonth(DIA_VENCIMENTO_CARTAO)
            : LocalDate.now().withDayOfMonth(DIA_VENCIMENTO_CARTAO);

    this.comprador
        .getValoresAPagar()
        .add(new ContaPagarReceber(this.valorTotal, dataVencimentoCartao, "Cartão de Crédito"));
  }

  @Override
  protected void creditoValoresVendedor() {
    this.vendedor
        .getValoresAReceber()
        .add(
            new ContaPagarReceber(
                (this.valorTotal - this.getValorTaxa()),
                LocalDate.now().plusMonths(1),
                "Cartão de Crédito"));
  }

  @Override
  protected boolean meioPagamentoPrecisaValidarSaldoComprador() {
    return false;
  }

  @Override
  protected Double getValorTaxa() {
    return this.getValorTotal() * TAXA_BANCO_PORCENTAGEM;
  }

  @Override
  public String toString() {

    return "Cartão de Crédito";
  }
}
