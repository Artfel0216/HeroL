package repositorios;

import entidades.Acao;
import java.util.ArrayList;
import java.util.List;

public class AcaoRepositoryImpl implements AcaoRepository {
    private List<Acao> acoes = new ArrayList<>();

    @Override
    public void salvarAcao(Acao acao) {
        acoes.add(acao);
    }

    @Override
    public List<Acao> buscarAcoes() {
        return acoes;
    }
}
