package teste;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import br.com.Facade.AreaAtuacaoFacate;

import br.com.View.Menu;
import br.com.entidade.AreaAtuacao;

public class TesteTableModel extends JFrame {

	private JTextField jtf_nome;
	private JButton incluir;
	private JButton limpar;
	
	private JTable table;
	
	private JScrollPane jsp;
	private JPanel main;
	private JPanel dados;
	private JPanel tableDados;
	
	
	private AreaAtuacaoFacate area;
	private List<AreaAtuacao> lista;
	private Menu telaPrincipal;

	public TesteTableModel() {

		super("Exemplo de Mable Model");
		this.telaPrincipal = telaPrincipal;
		
		area = new AreaAtuacaoFacate();
	
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jtf_nome = new JTextField(15);
		incluir = new JButton("Incluir");
		limpar = new JButton("Limpar");
		
		main = new JPanel();
		dados = new JPanel(new GridLayout(4, 2));
		tableDados = new JPanel();
		jsp = new JScrollPane();
		table = new JTable();
		execute();

	}

	private void execute() {
		adicionarListeners();
		modelaTela();
	}

	private void adicionarListeners() {
		incluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jtf_nome != null && jtf_nome.getText().equals("") == true) {
					JOptionPane.showMessageDialog(null, "Digite o nome");
				}

				else {
					AreaAtuacao nova = new AreaAtuacao();
					nova.setNomeArea(jtf_nome.getText());
					area.adiciona(nova);

					limpar();
					listar();
				}
			}

		});
		limpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
	}

	private void limpar() {
		jtf_nome.setText("");

	}

	private void listar() {
		table.setModel(new MinhaTableModel(new String[] { "Codigo", "Nome" },
				getLista().size(), 2));
		List<AreaAtuacao> exibirLista = getLista();

		for (int i = 0; i < exibirLista.size(); i++) {
			table.setValueAt("" + exibirLista.get(i).getCodTipo(), i, 0);
			table.setValueAt("" + exibirLista.get(i).getNomeArea(), i, 1);

		}

		jsp.setViewportView(table);
		jsp.setAutoscrolls(true);
		table.setAutoCreateRowSorter(true);

	}

	private void modelaTela() {
		dados.add(new JLabel("Nome:"));
		dados.add(jtf_nome);

		dados.add(incluir);
		dados.add(limpar);
		lista = new AreaAtuacaoFacate().getLista();
		table.setModel(new MinhaTableModel(new String[] { "Codigo", "Nome" },
				getLista().size(), 2));
		for (int i = 0; i < lista.size(); i++) {
			table.setValueAt("" + lista.get(i).getCodTipo(), i, 0);
			table.setValueAt("" + lista.get(i).getNomeArea(), i, 1);

		}

		jsp.setViewportView(table);
		tableDados.add(jsp);

		main.add(dados);
		main.add(tableDados);

		this.setContentPane(main);
		this.setSize(600, 700);
		this.setVisible(true);
	}

	public List<AreaAtuacao> getLista() {

		lista = new AreaAtuacaoFacate().getLista();
		return lista;
	}

	public void setLista(ArrayList<AreaAtuacao> lista) {
		this.lista = lista;
	}

	public static void main(String[] args) {
		TesteTableModel t = new TesteTableModel();
		t.execute();
	}
}