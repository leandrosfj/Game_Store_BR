package model.pessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContaPagarReceber {

  private final Double valor;
  private final LocalDate dataVencimento;
  private final String tipo;

  public ContaPagarReceber(final Double valor, final LocalDate dataVencimento, final String tipo) {
    this.valor = valor;
    this.dataVencimento = dataVencimento;
    this.tipo = tipo;
  }

  public Double getValor() {
    return this.valor;
  }

  public LocalDate getDataVencimento() {
    return this.dataVencimento;
  }

  @Override
  public String toString() {
    return "   Vencimento "
        + this.dataVencimento.format(DateTimeFormatter.ISO_LOCAL_DATE)
        + " - R$ "
        + this.valor
        + " - "
        + this.tipo
        + "\n";
  }
}
