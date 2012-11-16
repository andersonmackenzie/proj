package br.com.teste;

import java.util.Vector;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class MinhaTableModel extends AbstractTableModel {
	private String[] lista;
	protected Vector<Pessoa> dataVector;

	public static final int NOME = 0;
	public static final int CIDADE = 1;
	public static final int ESTADO = 2;
	public static final int INDEX = 3;

	public MinhaTableModel(String[] lista, int size, int i) {
		this.setLista(lista);
		dataVector = new Vector<Pessoa>();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		return lista.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return lista[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case NOME:
		case CIDADE:
		case ESTADO:
			return String.class;
		default:
			return Object.class;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == INDEX)
			return false;
		else
			return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return columnIndex;

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
		Pessoa record = (Pessoa) dataVector.get(rowIndex);
		
		switch (columnIndex) {
		case NOME:
			record.setNome((String) aValue);
			break;
		case CIDADE:
			record.setCidade((String) aValue);
			break;
		case ESTADO:
			record.setEstado((String) aValue);
			break;
		default:
			System.out.println("invalid index");
		}
		fireTableCellUpdated(rowIndex, columnIndex);

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	public String[] getLista() {
		return lista;
	}

	public void setLista(String[] lista) {
		this.lista = lista;
	}

	public void addEmptyRow() {
		dataVector.add(new Pessoa());
		fireTableRowsInserted(dataVector.size() - 1, dataVector.size() - 1);
	}

}
