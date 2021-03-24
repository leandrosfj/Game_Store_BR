package model.pessoa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import model.produtos.Produto;
import model.transacoes.Transacao;

public class Vendedor extends Pessoa {

  private final Map<Integer, Produto> catalogo = new HashMap();

  private final List<ContaPagarReceber> valoresAReceber = new ArrayList<>();

  private final Set<Transacao> vendas = new HashSet<>();

  public Vendedor() {
    super();
  }

  public List<ContaPagarReceber> getValoresAReceber() {
    return this.valoresAReceber;
  }

  public Map<Integer, Produto> getCatalogo() {
    return this.catalogo;
  }

  public Set<Transacao> getVendas() {
    return this.vendas;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    final Vendedor vendedor = (Vendedor) o;
    return this.getDocumento().equals(vendedor.getDocumento());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getDocumento());
  }

  @Override
  public String toString() {

    final StringBuilder vendas = new StringBuilder();

    this.vendas.forEach(
        transacao -> {
          vendas
              .append("    [" + transacao.getCodigo() + "] - ")
              .append("Comprador: ")
              .append(transacao.getComprador().getNome())
              .append(" - Total Bruto R$ ")
              .append(transacao.getValorTotal())
              .append(" - ")
              .append(transacao.getPagamento().toString())
              .append("\n");
        });

    final StringBuilder valoresReceber = new StringBuilder();

    this.valoresAReceber.forEach(conta -> valoresReceber.append(conta.toString()));

    final StringBuilder catalogoString = new StringBuilder();

    this.catalogo.values().forEach(item -> catalogoString.append(item.toString()));

    return "Nome: "
        + this.getNome()
        + "\nCNPJ: "
        + this.getDocumento()
        + "\nSaldo: R$ "
        + this.getSaldo()
        + "\nVendas:\n"
        + vendas.toString()
        + "\nValores a receber:\n"
        + valoresReceber.toString()
        + "\nCatálogo:\n"
        + catalogoString.toString();
  }
}
