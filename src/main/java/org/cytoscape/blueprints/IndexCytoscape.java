package org.cytoscape.blueprints;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.cytoscape.model.CyColumn;
import org.cytoscape.model.CyRow;
import org.cytoscape.model.CyTable;
import org.cytoscape.model.SUIDFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tinkerpop.blueprints.pgm.AutomaticIndex;
import com.tinkerpop.blueprints.pgm.Element;
import com.tinkerpop.blueprints.pgm.Index;
import com.tinkerpop.blueprints.pgm.IndexableGraph;

/**
 * CyTable implementation using Bleuprint's Index.
 * 
 * In this implementation, table is a collection of indices.
 * 
 */
public class IndexCytoscape<E extends Element> implements CyTable {

    private static final Logger logger = LoggerFactory.getLogger(IndexCytoscape.class);

    // Node, edge, or network.
    private final Map<String, CyColumn> indexMap;

    private final long suid;

    private String title;

    private final String primaryKey;
    private final boolean isPublic;
    private final boolean mutable;

    public IndexCytoscape(final IndexableGraph graph, final Class<E> graphObjectType, final String title,
	    final String primaryKey, final Class<?> primaryKeyType, final boolean isPublic, final boolean mutable) {

	if (graph == null)
	    throw new NullPointerException("Graph is null.");
	if (graphObjectType == null)
	    throw new NullPointerException("Element type is null.");
	if (primaryKey == null)
	    throw new NullPointerException("Primary key is null.");

	this.suid = SUIDFactory.getNextSUID();
	this.title = title;
	this.isPublic = isPublic;
	this.mutable = mutable;
	this.primaryKey = primaryKey;

	this.indexMap = new HashMap<String, CyColumn>();

	final Iterable<Index<? extends Element>> indices = graph.getIndices();
	Index<E> keyIndex = graph.getIndex(primaryKey, graphObjectType);

	// Check primary key index
	if (keyIndex == null) {
	    final Set<String> pKeySet = new HashSet<String>();
	    pKeySet.add(primaryKey);
	    keyIndex = graph.createAutomaticIndex(primaryKey, graphObjectType, pKeySet);
	}

	final IndexColumn<E> pKeyIndexColumn = new IndexColumn<E>(keyIndex, primaryKeyType, this, true, true);
	this.indexMap.put(primaryKey, pKeyIndexColumn);
	//FIXME
//	for (final Index<? extends Element> idx : indices) {
//	    if (idx.getIndexName().equals(primaryKey) == false)
//		indexMap.put(idx.getIndexName(), new IndexColumn<E>(idx, , this, true, true));
//	}
    }

    public long getSUID() {
	return suid;
    }

    public boolean isPublic() {
	return isPublic;
    }

    public Mutability getMutability() {
	return null;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public CyColumn getPrimaryKey() {
	return this.indexMap.get(primaryKey);
    }

    public CyColumn getColumn(String columnName) {
	// TODO Auto-generated method stub
	return null;
    }

    public Collection<CyColumn> getColumns() {
	// TODO Auto-generated method stub
	return null;
    }

    public void deleteColumn(String columnName) {
	// TODO Auto-generated method stub

    }

    public <T> void createColumn(String columnName, Class<? extends T> type, boolean isImmutable) {
	// TODO Auto-generated method stub

    }

    public <T> void createListColumn(String columnName, Class<T> listElementType, boolean isImmutable) {
	// TODO Auto-generated method stub

    }

    public CyRow getRow(Object primaryKey) {
	// TODO Auto-generated method stub
	return null;
    }

    public List<CyRow> getAllRows() {
	// TODO Auto-generated method stub
	return null;
    }

    public String getLastInternalError() {
	// TODO Auto-generated method stub
	return null;
    }

    public Set<CyRow> getMatchingRows(String columnName, Object value) {
	// TODO Auto-generated method stub
	return null;
    }

    public int getRowCount() {
	// TODO Auto-generated method stub
	return 0;
    }

    public String addVirtualColumn(String virtualColumn, String sourceColumn, CyTable sourceTable,
	    String sourceJoinKey, String targetJoinKey, boolean isImmutable) {
	throw new UnsupportedOperationException("Virtual Column is not supported.");
    }

    public void addVirtualColumns(CyTable sourceTable, String sourceJoinKey, String targetJoinKey, boolean isImmutable) {
	throw new UnsupportedOperationException("Virtual Column is not supported.");
    }

    synchronized <T> List<T> getColumnValues(final String columnName, final Class<? extends T> type) {
	// FIXME
	return null;
    }

}
