package controller;

import java.io.IOException;
import java.util.Scanner;
import model.pagamentos.Pagamento;
import model.pagamentos.PagamentoFactory;
import model.pessoa.Comprador;
import model.pessoa.Vendedor;
import model.produtos.Produto;
import model.transacoes.Transacao;
import repository.CompradorRepository;
import repository.TransacaoRepository;
import repository.VendedorRepository;

public class TransacaoController extends AbstractController {

  CompradorRepository compradorRepository;
  VendedorRepository vendedorRepository;
  TransacaoRepository transacaoRepository;

  public TransacaoController(
      final CompradorRepository compradorRepository,
      final VendedorRepository vendedorRepository,
      final TransacaoRepository transacaoRepository) {
    this.compradorRepository = compradorRepository;
    this.vendedorRepository = vendedorRepository;
    this.transacaoRepository = transacaoRepository;
  }

  public void registrarTransacao() throws IOException, InterruptedException {

    super.imprimirCabecalho("Registrar Transação");

    final Transacao transacao = new Transacao();

    final Scanner in = new Scanner(System.in);

    System.out.println("Informe CPF do comprador");
    final String cpfComprador = in.nextLine();

    final Comprador comprador = this.compradorRepository.get(cpfComprador);

    if (comprador == null) {

      System.out.println("\nComprador não encontrado!");
      return;
    }

    transacao.setComprador(comprador);

    System.out.println("Informe CNPJ do vendedor");
    final String cnpjVendedor = in.nextLine();

    final Vendedor vendedor = this.vendedorRepository.get(cnpjVendedor);

    if (vendedor == null) {
      System.out.println("\nVendedor não encontrado!");
      return;
    }

    transacao.setVendedor(vendedor);

    int codigoProduto;

    do {

      System.out.println("Informe o código do produto desejado ou 0(zero) para finalizar: \n");
      vendedor.getCatalogo().values().forEach(produto -> System.out.println(produto.toString()));

      codigoProduto = Integer.parseInt(in.nextLine());

      if(codigoProduto!=0) {

        final Produto produto = vendedor.getCatalogo().get(codigoProduto);

        if(produto==null){

          System.out.println("Produto não encontrado");

        } else {
          transacao.getProdutos().add(produto);
        }

      }

    } while (codigoProduto != 0);


    final String menu =
        """
            Informa o método de pagamento
            
            1 - Boleto
            2 - Crédito
            3 - Débito
            4 - Pix
            0 - Sair do sistema

            Escolha uma opção:
            """;

    System.out.println(menu);

    final int formaPagamento = Integer.parseInt(in.nextLine());

    final Pagamento meioDePagamento = PagamentoFactory
        .newPagamento(comprador, vendedor, transacao.getValorTotal(), formaPagamento);

    if(meioDePagamento ==null){
      System.out.println("Meio de Pagamento inválido");
      return;
    }

    transacao.setPagamento(meioDePagamento);

    if( meioDePagamento.realizarTransacaoFinanceira()) {

      comprador.getCompras().add(transacao);

      vendedor.getVendas().add(transacao);

      this.transacaoRepository.add(transacao);

      System.out.println("Transação Comercial realizada com sucesso!");

    }

    super.esperarEnter();
  }
}
