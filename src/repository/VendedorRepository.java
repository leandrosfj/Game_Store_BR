package repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.pessoa.Vendedor;
import model.produtos.Produto;

public class VendedorRepository {

  private final Map<String, Vendedor> registros = new HashMap<>();

  public void add(final Vendedor vendedor) {

    if (this.registros.get(vendedor.getDocumento()) != null) {

      System.out.println("\nERRO: Vendedor já cadastrado para CNPJ informado...");

      return;
    }

    this.registros.putIfAbsent(vendedor.getDocumento(), vendedor);

    System.out.println("\nVendedor cadastrado com sucesso!");
  }

  public Vendedor get(final String documento) {
    return this.registros.get(documento);
  }

  public void delete(final String documento) {
    this.registros.remove(documento);
  }

  public List<Vendedor> listAll() {
    return new ArrayList<>(this.registros.values());
  }

  public void addProduto(final String documento, final Produto produto) {

    final Vendedor vendedor = this.get(documento);

    if (vendedor == null) {

      System.out.println("\nVendedor não encontrado!");
      return;
    }

    final Map<Integer, Produto> catalogo = vendedor.getCatalogo();

    final boolean produtoExisteNoCatalogo =
        catalogo.values().stream().anyMatch(item -> item.equals(produto));

    if (produtoExisteNoCatalogo) {
      System.out.println("\nERRO: Produto já existe no catálogo: " + produto.getNome());
      return;
    }

    final int codigo =
        (catalogo.values().stream().map(Produto::getCodigo).collect(Collectors.toList()).stream()
                .max(Comparator.comparing(Integer::valueOf))
                .orElse(0))
            + 1;

    produto.setCodigo(codigo);
    catalogo.putIfAbsent(produto.getCodigo(), produto);

    System.out.println("\nProduto cadastrado com sucesso!");
  }
}
