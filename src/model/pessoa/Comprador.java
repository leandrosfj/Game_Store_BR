package model.pessoa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import model.transacoes.Transacao;

public class Comprador extends Pessoa {

  private final List<ContaPagarReceber> valoresAPagar = new ArrayList<>();

  private final Set<Transacao> compras = new HashSet<>();

  public Comprador() {

    super();
  }

  public List<ContaPagarReceber> getValoresAPagar() {
    return this.valoresAPagar;
  }

  public Set<Transacao> getCompras() {
    return this.compras;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    final Comprador comprador = (Comprador) o;
    return this.getDocumento().equals(comprador.getDocumento());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getDocumento());
  }

  @Override
  public String toString() {

    final StringBuilder valoresAPagar = new StringBuilder();

    this.valoresAPagar.forEach(conta -> valoresAPagar.append(conta.toString()));

    final StringBuilder compras = new StringBuilder();

    this.compras.forEach(
        transacao -> {
          compras
              .append("    [" + transacao.getCodigo() + "] - ")
              .append("Vendedor: ")
              .append(transacao.getVendedor().getNome())
              .append(" - Total R$ ")
              .append(transacao.getValorTotal())
              .append(" - ")
              .append(transacao.getPagamento().toString())
              .append("\n");
        });

    return "Nome: "
        + this.getNome()
        + "\nCPF: "
        + this.getDocumento()
        + "\nSaldo: R$ "
        + this.getSaldo()
        + "\nCompras:\n"
        + compras.toString()
        + "\nValores a pagar:\n"
        + valoresAPagar.toString();
  }
}
