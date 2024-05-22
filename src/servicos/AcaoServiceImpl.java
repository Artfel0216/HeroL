package servicos;

import entidades.Acao;
import repositorios.AcaoRepository;
import java.util.List;

public class AcaoServiceImpl implements AcaoService {
    private AcaoRepository repository;

    public AcaoServiceImpl(AcaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void cadastrarAcao(Acao acao) {
        repository.salvarAcao(acao);
    }

    @Override
    public List<Acao> listarAcoes() {
        return repository.buscarAcoes();
    }
}
