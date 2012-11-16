package br.com.View;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

public class ListaV extends JInternalFrame implements ActionListener,
		InternalFrameListener {

	private static final long serialVersionUID = 1L;

	// Janela principal
	private Menu telaPrincipal;
	private Button bt;

	private static ListaV singleton;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	private ListaV(String titulo, Menu telaPrincipal) {
		super(titulo, true, true, true, true);

		this.telaPrincipal = telaPrincipal;

	

		setBounds(100, 100, 567, 315);
		getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblNewLabel = new JLabel("New label");
		getContentPane().add(lblNewLabel, "6, 4, right, default");
		
		textField = new JTextField();
		getContentPane().add(textField, "10, 4, left, default");
		textField.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		getContentPane().add(lblNewLabel_1, "6, 6, right, default");
		
		textField_1 = new JTextField();
		getContentPane().add(textField_1, "10, 6, left, default");
		textField_1.setColumns(20);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		getContentPane().add(lblNewLabel_2, "6, 8, right, default");
		
		textField_2 = new JTextField();
		getContentPane().add(textField_2, "10, 8, left, center");
		textField_2.setColumns(20);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		getContentPane().add(lblNewLabel_3, "6, 10, right, default");
		
		textField_3 = new JTextField();
		getContentPane().add(textField_3, "10, 10, left, default");
		textField_3.setColumns(20);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		getContentPane().add(lblNewLabel_4, "6, 12, right, default");
		
		textField_4 = new JTextField();
		getContentPane().add(textField_4, "10, 12, left, default");
		textField_4.setColumns(20);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		getContentPane().add(lblNewLabel_5, "6, 14, right, default");
		
		textField_5 = new JTextField();
		getContentPane().add(textField_5, "10, 14, left, default");
		textField_5.setColumns(20);

		addInternalFrameListener(this);

	
		telaPrincipal.jdPane.add(this);

		setBounds(100, 100, 403, 212);
		setVisible(true);
		

	}

	// Errado refazer
	public static ListaV getInstance(String titulo, Menu telaPrincipal) {
		if (singleton == null)
			return new ListaV(titulo, telaPrincipal);
		else
			return singleton;
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