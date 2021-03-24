package controller;

import java.io.IOException;
import java.util.Scanner;

public abstract class AbstractController {

  protected void limparConsole() throws IOException, InterruptedException {

    if (System.getProperty("os.name").contains("Windows")) {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } else {
      Runtime.getRuntime().exec("clear");
    }
  }

  protected void esperarEnter() throws IOException, InterruptedException {

    final Scanner scan = new Scanner(System.in);

    System.out.print("\n\nPressione ENTER para continuar...");
    final String enter = scan.nextLine();

    this.limparConsole();
  }

  protected void imprimirCabecalho(final String titulo) {

    System.out.println("========================================");
    System.out.println(this.centerString(40, titulo));
    System.out.println("========================================\n");
  }

  private String centerString(final int width, final String s) {

    return String.format(
        "%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
  }
}
