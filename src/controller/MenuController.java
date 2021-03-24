package controller;

import java.io.IOException;
import java.util.Scanner;
import repository.CompradorRepository;
import repository.TransacaoRepository;
import repository.VendedorRepository;

public class MenuController extends AbstractController{

  CompradorRepository compradorRepository = new CompradorRepository();
  VendedorRepository vendedorRepository = new VendedorRepository();
  TransacaoRepository transacaoRepository = new TransacaoRepository();

  CompradorController compradorController = new CompradorController(this.compradorRepository);
  VendedorController vendedorController = new VendedorController(this.vendedorRepository);
  TransacaoController transacaoController = new TransacaoController(this.compradorRepository, this.vendedorRepository,
      this.transacaoRepository);

  public static void main(final String[] args)  {

    final MenuController menu = new MenuController();

    try {
      menu.exibirMenu();

    } catch (final Exception e) {

      System.out.println("Erro ao executar operação: " + e.getMessage());
    }
  }

  public void exibirMenu() throws InterruptedException, IOException {

    int op;

    final Scanner in = new Scanner(System.in);

    do {

      super.limparConsole();

      super.imprimirCabecalho("Game Store BR");

      final String menu =
          """
              1 - Cadastrar Comprador
              2 - Listar Compradores
              3 - Consultar Comprador
              4 - Cadastrar Vendedor
              5 - Listar Vendedores
              6 - Consultar Vendedor
              7 - Cadastrar Produto
              8 - Registrar Transação Comercial
              0 - Sair do sistema
  
              Escolha uma opção:
              """;

      System.out.println(menu);

      op = Integer.parseInt(in.nextLine());

      switch (op) {

        case 1 -> this.compradorController.cadastrarComprador();
        case 2 -> this.compradorController.listarCompradores();
        case 3 -> this.compradorController.consultarComprador();
        case 4 -> this.vendedorController.cadastrarVendedor();
        case 5 -> this.vendedorController.listarVendedores();
        case 6 -> this.vendedorController.consultarVendedor();
        case 7 -> this.vendedorController.cadastrarProduto();
        case 8 -> this.transacaoController.registrarTransacao();
        case 0 -> {
          System.out.println("Fechando sistema...");
          Thread.sleep(3000);
        }
        default -> {
          System.out.println("Opção inválida...");
          Thread.sleep(3000);
        }
      }

    } while (op!=0);

    in.close();
  }
}