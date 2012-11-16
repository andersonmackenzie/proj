package br.com.View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Tela3 extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public Tela3() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("New label");
		getContentPane().add(lblNewLabel, "4, 4, right, default");
		
		textField = new JTextField();
		getContentPane().add(textField, "6, 4, fill, default");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Teste");
		getContentPane().add(lblNewLabel_1, "4, 6, right, default");
		
		textField_1 = new JTextField();
		getContentPane().add(textField_1, "6, 6, fill, default");
		textField_1.setColumns(10);
		setVisible(true);
	}

}
