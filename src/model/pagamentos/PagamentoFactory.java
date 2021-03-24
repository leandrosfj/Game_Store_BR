package model.pagamentos;

import model.pessoa.Comprador;
import model.pessoa.Vendedor;

public class PagamentoFactory {

  public static Pagamento newPagamento(
      final Comprador comprador,
      final Vendedor vendedor,
      final Double valorTotal,
      final Integer tipoPagamento) {

    return switch (tipoPagamento) {

      case 1 -> new Boleto(comprador, vendedor, valorTotal);
      case 2 -> new Credito(comprador, vendedor, valorTotal);
      case 3 -> new Debito(comprador, vendedor, valorTotal);
      case 4 -> new Pix(comprador, vendedor, valorTotal);
      default -> null;
    };
  }
}
