package model.transacoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import model.pagamentos.Pagamento;
import model.pessoa.Comprador;
import model.pessoa.Vendedor;
import model.produtos.Produto;

public class Transacao {

  private final String codigo;
  private Comprador comprador;
  private Vendedor vendedor;
  private Pagamento pagamento;
  private List<Produto> produtos = new ArrayList<>();

  public Transacao() {
    super();
    this.codigo = UUID.randomUUID().toString();
  }

  public Double getValorTotal() {
    //    return this.produtosSet.stream().mapToDouble(Produto::getPrecoUnitario).sum();

    final AtomicReference<Double> valorTotal = new AtomicReference<>(0d);

    this.produtos.forEach(produto -> valorTotal.updateAndGet(v -> v + produto.getPrecoUnitario()));

    return valorTotal.get();
  }

  public Comprador getComprador() {
    return this.comprador;
  }

  public void setComprador(final Comprador comprador) {
    this.comprador = comprador;
  }

  public Vendedor getVendedor() {
    return this.vendedor;
  }

  public void setVendedor(final Vendedor vendedor) {
    this.vendedor = vendedor;
  }

  public Pagamento getPagamento() {
    return this.pagamento;
  }

  public void setPagamento(final Pagamento pagamento) {
    this.pagamento = pagamento;
  }

  public List<Produto> getProdutos() {
    return this.produtos;
  }

  public void setProdutos(final List<Produto> produtos) {
    this.produtos = produtos;
  }

  public String getCodigo() {
    return this.codigo;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    final Transacao transacao = (Transacao) o;
    return this.comprador.equals(transacao.comprador)
        && this.vendedor.equals(transacao.vendedor)
        && this.pagamento.equals(transacao.pagamento)
        && this.produtos.equals(transacao.produtos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.comprador, this.vendedor, this.pagamento, this.produtos);
  }

  @Override
  public String toString() {
    return "Transacao{"
        + "codigo='"
        + this.codigo
        + '\''
        + ", comprador="
        + this.comprador
        + ", vendedor="
        + this.vendedor
        + ", pagamento="
        + this.pagamento
        + ", produtosSet="
        + this.produtos
        + '}';
  }
}
