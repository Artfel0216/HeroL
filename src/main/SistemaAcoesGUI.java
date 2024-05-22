package main;

import entidades.Acao;
import servicos.AcaoService;
import servicos.AcaoServiceImpl;
import repositorios.AcaoRepositoryImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SistemaAcoesGUI {
    private JFrame frame;
    private JTextField nomeField;
    private JTextField precoField;
    private JTextArea textArea;
    private AcaoService acaoService;

    public SistemaAcoesGUI(AcaoService acaoService) {
        this.acaoService = acaoService;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Sistema de Ações");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        JLabel nomeLabel = new JLabel("Nome da Ação:");
        panel.add(nomeLabel);

        nomeField = new JTextField();
        panel.add(nomeField);
        nomeField.setColumns(10);

        JLabel precoLabel = new JLabel("Preço de Fechamento:");
        panel.add(precoLabel);

        precoField = new JTextField();
        panel.add(precoField);
        precoField.setColumns(10);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                double precoFechamento = Double.parseDouble(precoField.getText());
                Acao acao = new Acao(nome, precoFechamento);
                acaoService.cadastrarAcao(acao);
                nomeField.setText("");
                precoField.setText("");
                updateTextArea();
            }
        });
        panel.add(btnCadastrar);

        textArea = new JTextArea();
        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton btnVisualizar = new JButton("Visualizar Ações");
        btnVisualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTextArea();
            }
        });
        frame.getContentPane().add(btnVisualizar, BorderLayout.SOUTH);
    }

    private void updateTextArea() {
        List<Acao> acoes = acaoService.listarAcoes();
        StringBuilder sb = new StringBuilder();
        for (Acao acao : acoes) {
            sb.append("Nome: ").append(acao.getNome()).append(", Preço de Fechamento: ").append(acao.getPrecoFechamento()).append("\n");
        }
        textArea.setText(sb.toString());
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        AcaoService acaoService = new AcaoServiceImpl(new AcaoRepositoryImpl());
        SistemaAcoesGUI window = new SistemaAcoesGUI(acaoService);
        window.show();
    }
}
