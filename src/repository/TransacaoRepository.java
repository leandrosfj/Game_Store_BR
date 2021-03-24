package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.transacoes.Transacao;

public class TransacaoRepository {

  private final Map<String, Transacao> registros = new HashMap<>();

  public void add(final Transacao transacao) {
    this.registros.putIfAbsent(transacao.getCodigo(), transacao);
  }

  public Transacao get(final String cpf) {
    return this.registros.get(cpf);
  }

  public void delete(final String cpf) {
    this.registros.remove(cpf);
  }

  public List<Transacao> listAll() {
    return new ArrayList<>(this.registros.values());
  }
}
