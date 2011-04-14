package org.cytoscape.blueprints;

import java.util.List;

import org.cytoscape.model.CyColumn;
import org.cytoscape.model.CyTable;

import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Index;

public class IndexColumn<E extends Element> implements CyColumn {

    private final Index<E> index;

    // Column data type: String, Number, or Boolean
    private final Class<?> columnType;

    private final boolean isPrimaryKey;
    private final boolean isImmutable;
    private final IndexCytoscape<E> table;

    IndexColumn(final Index<E> index, final Class<?> columnType,
	    final IndexCytoscape<E> table, final boolean isPrimaryKey, final boolean isImmutable) {
	this.columnType = columnType;
	this.index = index;
	this.isImmutable = isImmutable;
	this.isPrimaryKey = isPrimaryKey;
	this.table = table;
    }

    @Override
    public String getName() {
	return index.getIndexName();
    }

    @Override
    public void setName(final String newName) {
	// TODO: copy existing index and create new one.
	throw new UnsupportedOperationException("Index name is immutable.");
    }

    @Override
    public Class<?> getType() {
	return this.columnType;
    }

    @Override
    public Class<?> getListElementType() {
	return null;
    }

    @Override
    public boolean isVirtual() {
	// Always false.
	return false;
    }

    @Override
    public boolean isPrimaryKey() {
	return this.isPrimaryKey;
    }

    @Override
    public boolean isImmutable() {
	return this.isImmutable;
    }

    @Override
    public CyTable getTable() {
	return this.table;
    }

    @Override
    public CyTable getVirtualTable() {
	// Always null since this is not virtual.
	return null;
    }

    @Override
    public <T> List<T> getValues(Class<? extends T> type) {
	if (type == null)
	    throw new NullPointerException("type argument must not be null!");
	
	if (type != index.getIndexClass())
	    throw new IllegalArgumentException("expected "
		    + this.columnType.getName() + " got "
		    + type.getName() + "!");

	return table.getColumnValues(index.getIndexName(), type);
    }

}
