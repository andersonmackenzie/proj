package br.com.View;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import br.com.teste.MinhaTableModel;

public class Tela2 extends JInternalFrame implements ActionListener,
		InternalFrameListener {

	private JTextField jtfInicial;
	private JLabel flInicial;
	private JTextField jtfFinal;
	private JLabel jlFinal;
	private JButton jbGravar;
	private JButton jbLimpar;
	private Menu telaPrincipal;

	public Tela2(String titulo, Menu telaPrincipal) {
	
		this.telaPrincipal = telaPrincipal;

		getContentPane().setLayout(new GridLayout(3, 2, 0, 0));
		setSize(300, 140);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		centralizar();

		flInicial = new JLabel("número inicial: ");
		add(flInicial);

		jtfInicial = new JTextField();
		add(jtfInicial);

		jlFinal = new JLabel("número final: ");
		add(jlFinal);

		jtfFinal = new JTextField();
		add(jtfFinal);

		jbGravar = new JButton("Gravar");
		jbGravar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				gravar();

			}
		});

		add(jbGravar);

		jbLimpar = new JButton("Limpar");
		jbLimpar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		add(jbLimpar);
		
		
		setSize(300, 200);
		setVisible(true);
	}

	private void gravar() {

		int vInicial = 0;
		int vFinal = 0;

		try {

			String pegaValorInicial = jtfInicial.getText();
			vInicial = Integer.parseInt(pegaValorInicial);

			String pegaValorFinal = jtfFinal.getText();
			vFinal = Integer.parseInt(pegaValorFinal);

			if (vInicial > vFinal)
				JOptionPane.showMessageDialog(this, "Valores Invalidos", "",
						JOptionPane.ERROR_MESSAGE);

			double num = vInicial;
			String saida = "" + num + " ";

			for (double i = vInicial; i < vFinal; i += 0.5) {
				num += 0.5;
				saida += num + " ";

			}

			OutputStream os = new FileOutputStream(escolheDiretorio());
			OutputStreamWriter osr = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osr);
			bw.write(saida);
			JOptionPane.showMessageDialog(this, "Arquivo salvo com Sucesso",
					"Linguagen de Programação II", JOptionPane.PLAIN_MESSAGE);
			bw.close();

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this,
					"Digite apenas valores numericos",
					"Linguagem de Programação II" + "",
					JOptionPane.ERROR_MESSAGE);
		} catch (IOException ex) {
			System.out.println("Erro" + ex);
		} finally {
			limpar();
		}

	}

	public void limpar() {
		jtfInicial.setText(null);
		jtfFinal.setText(null);
	}

	private void centralizar() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension janela = getSize();
		if (janela.height > screen.height) {
			setSize(janela.width, screen.height);
		}
		if (janela.width > screen.width) {
			setSize(screen.width, janela.height);
		}
		setLocation((screen.width - janela.width) / 2,
				(screen.height - janela.height) / 2);
	}

	public String escolheDiretorio() {
		String diretorio = "E:\\sequencia.txt";
		JFileChooser arquivo = new JFileChooser();
		arquivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (arquivo.showOpenDialog(arquivo) == JFileChooser.APPROVE_OPTION) {
			diretorio = arquivo.getSelectedFile().getPath() + "\\sequencia.txt";
		}
		return diretorio;
	}

	// public static void main(String[] args) {
	// Gravar gr = new Gravar();
	// gr.setVisible(true);
	// }

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}