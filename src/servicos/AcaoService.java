package servicos;

import entidades.Acao;
import java.util.List;

public interface AcaoService {
    void cadastrarAcao(Acao acao);
    List<Acao> listarAcoes();
}
