package model.pagamentos;

import model.pessoa.Comprador;
import model.pessoa.Vendedor;

public abstract class Pagamento {

  Comprador comprador;

  Vendedor vendedor;

  Double valorTotal;

  public Pagamento(final Comprador comprador, final Vendedor vendedor, final Double valorTotal) {
    this.comprador = comprador;
    this.vendedor = vendedor;
    this.valorTotal = valorTotal;
  }

  protected Double getValorTotal() {
    return this.valorTotal;
  }

  protected boolean compradorPossuiSaldoNecessarioParaTransacao() {

    if (this.meioPagamentoPrecisaValidarSaldoComprador()) {

      return (this.comprador.getSaldo() > (this.valorTotal + this.getValorTaxa()));

    } else {

      return true;
    }
  }

  public boolean realizarTransacaoFinanceira() {

    if (!this.compradorPossuiSaldoNecessarioParaTransacao()) {

      System.out.println("Comprador não possui saldo necessário para concluir a operação.");

      return false;
    }

    this.debitarValoresComprador();

    this.creditoValoresVendedor();

    return true;
  }

  protected abstract Double getValorTaxa();

  protected abstract void debitarValoresComprador();

  protected abstract void creditoValoresVendedor();

  protected abstract boolean meioPagamentoPrecisaValidarSaldoComprador();
}
