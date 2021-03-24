package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.pessoa.Comprador;

public class CompradorRepository {

  private final Map<String, Comprador> registros = new HashMap<>();

  public void add(final Comprador comprador) {

    if (this.registros.get(comprador.getDocumento()) != null) {

      System.out.println("\nERRO: Comprador já cadastrado para CPF informado...");

      return;
    }

    this.registros.putIfAbsent(comprador.getDocumento(), comprador);

    System.out.println("\nComprador cadastrado com sucesso!");
  }

  public Comprador get(final String cpf) {
    return this.registros.get(cpf);
  }

  public void delete(final String cpf) {
    this.registros.remove(cpf);
  }

  public List<Comprador> listAll() {
    return new ArrayList<>(this.registros.values());
  }
}
