package br.com.View;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.sun.codemodel.JOp;

import teste.MinhaTableModel;

import br.com.Facade.UniversidadeFacate;
import br.com.entidade.Universidade;

public class ListaUniver extends JInternalFrame implements ActionListener,
		InternalFrameListener {

	private static final long serialVersionUID = 1L;

	// Janela principal
	private Menu telaPrincipal;

	private JTextField jtf_nome;
	private JButton incluir;
	private JButton limpar;
	private JButton atualizar;

	private JTable table;

	private JScrollPane jsp;
	private JPanel main;
	private JPanel dados;

	private JPanel tableDados;

	private UniversidadeFacate area;
	private List<Universidade> lista;

	public ListaUniver(String titulo, Menu telaPrincipal) {
		super("Adição Área de atuação", true, true, true, true);

		this.telaPrincipal = telaPrincipal;

		setBounds(100, 100, 420, 212);
		getContentPane().setLayout(null);

		jtf_nome = new JTextField(15);
		incluir = new JButton("Incluir");
		limpar = new JButton("Limpar");
		atualizar = new JButton("Atualizar");

		area = new UniversidadeFacate();
		main = new JPanel();

		dados = new JPanel(new GridLayout(5, 2));

		tableDados = new JPanel();
		jsp = new JScrollPane();
		table = new JTable();

		addInternalFrameListener(this);

		telaPrincipal.jdPane.add(this);
		adicionarListeners();
		modelaTela();

		setResizable(false);
		setMaximizable(false);

	}

	private void modelaTela() {
		dados.add(new JLabel("Nome:"));
		dados.add(jtf_nome);

		dados.add(incluir);
		dados.add(limpar);
		dados.add(atualizar);

		lista = new UniversidadeFacate().getLista();
		table.setModel(new MinhaTableModel(new String[] { "Codigo", "Nome" },
				lista.size(), 2));
//		for (int i = 0; i < lista.size(); i++) {
//			table.setValueAt("" + lista.get(i).getId(), i, 0);
//			table.setValueAt("" + lista.get(i).getNome(), i, 1);
//
//		}

		jsp.setViewportView(table);

		tableDados.add(jsp);

		main.add(dados);
		main.add(tableDados);

		this.setContentPane(main);
		this.setSize(600, 700);
		this.setVisible(true);

	}

	private void adicionarListeners() {
		incluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jtf_nome != null && jtf_nome.getText().equals("") == true) {
					JOptionPane.showMessageDialog(null, "Digite o nome");
				}

				else {
					Universidade nova = new Universidade();
					nova.setNome(jtf_nome.getText());
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
		atualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listar();

			}
		});

		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						// JOptionPane.showMessageDialog(
						// null,
						// "ffsd"
						// +
						// table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION));

					}
				});
	}

	private void limpar() {
		jtf_nome.setText("");

	}

	private void listar() {
		List<Universidade> exibirLista = getLista();
		table.setModel(new MinhaTableModel(new String[] { "Codigo", "Nome" },
				exibirLista.size(), 2));

//		for (int i = 0; i < exibirLista.size(); i++) {
//			table.setValueAt(exibirLista.get(i).getId(), i, 0);
//			table.setValueAt(exibirLista.get(i).getNome(), i, 1);
//
//		}

		jsp.setViewportView(table);
		jsp.setAutoscrolls(true);
		table.setAutoCreateRowSorter(true);

	}

	public List<Universidade> getLista() {

		lista = new UniversidadeFacate().getLista();
		return lista;
	}

	public void setLista(List<Universidade> lista) {
		this.lista = lista;
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {

	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		System.out.println("fechado");

	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// panel.setBackground(Color.YELLOW);

	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// panel.setBackground(Color.YELLOW);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}