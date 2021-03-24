package controller;

import java.io.IOException;
import java.util.Scanner;
import model.pessoa.Vendedor;
import model.produtos.Produto;
import repository.VendedorRepository;

public class VendedorController extends AbstractController {

  VendedorRepository vendedorRepository;

  public VendedorController(final VendedorRepository vendedorRepository) {
    super();
    this.vendedorRepository = vendedorRepository;
  }

  public void consultarVendedor() throws IOException, InterruptedException {

    super.imprimirCabecalho("Consultar Vendedor");

    System.out.println("Informe o CNPJ do vendedor desejado: ");
    final Scanner in = new Scanner(System.in);
    final String cnpj = in.nextLine();

    final Vendedor vendedor = this.vendedorRepository.get(cnpj);

    if (vendedor == null) {
      System.out.println("Vendedor não encontrado para o CNPJ informado: " + cnpj);

    } else {
      System.out.println("Vendedor encontrado:\n\n" + vendedor.toString());
    }

    super.esperarEnter();
  }

  public void listarVendedores() throws IOException, InterruptedException {

    super.imprimirCabecalho("Listar Vendedores");

    super.limparConsole();

    this.vendedorRepository
        .listAll()
        .forEach(
            item -> {
              System.out.println(
                  item.getNome()
                      + " - CNPJ: "
                      + item.getDocumento()
                      + " - Saldo: R$"
                      + item.getSaldo());
            });

    super.esperarEnter();
  }

  public void cadastrarVendedor() throws IOException, InterruptedException {

    super.imprimirCabecalho("Cadastrar Vendedor");

    final Scanner in = new Scanner(System.in);
    final Vendedor vendedor = new Vendedor();

    System.out.println("Informe o nome do Vendedor: ");
    vendedor.setNome(in.nextLine());

    System.out.println("Informe o CNPJ do Vendedor: ");
    vendedor.setDocumento(in.nextLine());

    vendedor.setSaldo(0.);

    this.vendedorRepository.add(vendedor);

    super.esperarEnter();
  }

  public void cadastrarProduto() throws IOException, InterruptedException {

    super.imprimirCabecalho("Cadastrar Produto");

    final Scanner in = new Scanner(System.in);

    System.out.println("Informe o CNPJ do Vendedor: ");
    final String documento = in.nextLine();

    final Vendedor vendedor = this.vendedorRepository.get(documento);

    if (vendedor == null) {

      System.out.println("Vendedor não encontrado!");

      super.esperarEnter();
      return;

    } else {

      System.out.println("\nCadastrando produto para vendedor " + vendedor.getNome() + "\n\n");
    }

    System.out.println("Informe o nome do produto: ");
    final String nome = in.nextLine();

    System.out.println("Informe o preço do produto: ");
    final Double preco = Double.parseDouble(in.nextLine());

    final Produto produto = new Produto();
    produto.setNome(nome);
    produto.setPrecoUnitario(preco);

    this.vendedorRepository.addProduto(documento, produto);

    super.esperarEnter();
  }
}
