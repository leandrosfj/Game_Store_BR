package controller;

import java.io.IOException;
import java.util.Scanner;
import model.pessoa.Comprador;
import repository.CompradorRepository;

public class CompradorController extends AbstractController {

  CompradorRepository compradorRepository;

  public CompradorController(final CompradorRepository compradorRepository) {
    super();
    this.compradorRepository = compradorRepository;
  }

  public void consultarComprador() throws IOException, InterruptedException {

    super.imprimirCabecalho("Consultar Comprador");

    System.out.println("Informe o CPF do comprador desejado: ");
    final Scanner in = new Scanner(System.in);
    final String cpf = in.nextLine();

    final Comprador comprador = this.compradorRepository.get(cpf);

    if (comprador == null) {
      System.out.println("Comprador não encontrado para o CPF informado: " + cpf);

    } else {
      System.out.println("Comprador encontrado:\n\n" + comprador.toString());
    }

    super.esperarEnter();
  }

  public void listarCompradores() throws IOException, InterruptedException {

    super.imprimirCabecalho("Listar Compradores");

    super.limparConsole();

    this.compradorRepository
        .listAll()
        .forEach(
            item -> {
              System.out.println(
                  item.getNome()
                      + " - CPF: "
                      + item.getDocumento()
                      + " - Saldo: R$ "
                      + item.getSaldo());
            });

    super.esperarEnter();
  }

  public void cadastrarComprador() throws InterruptedException, IOException {

    super.imprimirCabecalho("Cadastrar Comprador");

    final Scanner in = new Scanner(System.in);
    final Comprador comprador = new Comprador();

    System.out.println("Informe o nome do Comprador: ");
    comprador.setNome(in.nextLine());

    System.out.println("Informe o CPF do Comprador: ");
    comprador.setDocumento(in.nextLine());

    System.out.println("Informe o saldo inicial do Comprador: ");
    comprador.setSaldo(Double.parseDouble(in.nextLine()));

    this.compradorRepository.add(comprador);

    super.esperarEnter();
  }
}
