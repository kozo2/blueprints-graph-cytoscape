package org.cytoscape.blueprints;

import java.util.List;
import java.util.Map;

import org.cytoscape.model.CyRow;
import org.cytoscape.model.CyTable;

public class IndexRow implements CyRow {

	private final Object key;
	private final IndexCytoscape table;

	IndexRow(final Object key, final IndexCytoscape table) {
		this.key = key;
		this.table = table;
	}

	@Override
	public <T> T get(String columnName, Class<? extends T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> getList(String columnName, Class<T> listElementType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void set(String columnName, T value) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSet(String columnName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> getAllValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getRaw(String columnName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CyTable getTable() {
		// TODO Auto-generated method stub
		return null;
	}

}
