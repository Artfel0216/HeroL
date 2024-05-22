package main;

import entidades.Acao;
import repositorios.AcaoRepositoryImpl;
import servicos.AcaoService;
import servicos.AcaoServiceImpl;

import java.util.List;
import java.util.Scanner;

public class SistemaAcoes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AcaoService acaoService = new AcaoServiceImpl(new AcaoRepositoryImpl());

        int opcao;
        do {
            System.out.println("1. Cadastrar Ação");
            System.out.println("2. Visualizar Ações");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir o newline deixado por nextInt()

            switch (opcao) {
                case 1:
                    System.out.print("Nome da Ação: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço de Fechamento: ");
                    double precoFechamento = scanner.nextDouble();
                    scanner.nextLine();  // Consumir o newline deixado por nextDouble()
                    Acao acao = new Acao(nome, precoFechamento);
                    acaoService.cadastrarAcao(acao);
                    System.out.println("Ação cadastrada com sucesso!");
                    break;
                case 2:
                    List<Acao> acoes = acaoService.listarAcoes();
                    if (acoes.isEmpty()) {
                        System.out.println("Nenhuma ação cadastrada.");
                    } else {
                        System.out.println("Ações cadastradas:");
                        for (Acao a : acoes) {
                            System.out.println("Nome: " + a.getNome() + ", Preço de Fechamento: " + a.getPrecoFechamento());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        scanner.close();
    }
}
