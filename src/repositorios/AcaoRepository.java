package repositorios;

import entidades.Acao;
import java.util.List;

public interface AcaoRepository {
    void salvarAcao(Acao acao);
    List<Acao> buscarAcoes();
}
