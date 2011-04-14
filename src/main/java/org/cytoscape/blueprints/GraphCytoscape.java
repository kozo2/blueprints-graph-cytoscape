package org.cytoscape.blueprints;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cytoscape.model.CyEdge;
import org.cytoscape.model.CyEdge.Type;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.CyRow;
import org.cytoscape.model.CyTable;
import org.cytoscape.model.CyTableEntry;
import org.cytoscape.model.SUIDFactory;

import com.tinkerpop.blueprints.pgm.Graph;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.oupls.GraphSource;

public class GraphCytoscape implements GraphSource, CyNetwork {

    private final Graph graph;
    private final long suid;

    private int nodeCount;

    private final Map<String, CyTable> netTableManager;
    private final Map<String, CyTable> nodeTableManager;
    private final Map<String, CyTable> edgeTableManager;

    public GraphCytoscape(final Graph graph) {
	this.graph = graph;

	this.suid = SUIDFactory.getNextSUID();
	this.nodeCount = 0;

	netTableManager = new HashMap<String, CyTable>();
	nodeTableManager = new HashMap<String, CyTable>();
	edgeTableManager = new HashMap<String, CyTable>();

	initDefaultTables();
    }

    private void initDefaultTables() {

    }

    public Graph getGraph() {
	return graph;
    }

    public CyRow getCyRow(String tableName) {
	return null;
    }

    public CyRow getCyRow() {
	// TODO Auto-generated method stub
	return null;
    }

    public long getSUID() {
	return this.suid;
    }

    public CyNode addNode() {
	final Vertex vertex = graph.addVertex(SUIDFactory.getNextSUID());
	return new VertexCytoscape(vertex, ++nodeCount);
    }

    public boolean removeNode(CyNode node) {
	// TODO Auto-generated method stub
	return false;
    }

    public CyEdge addEdge(CyNode source, CyNode target, boolean isDirected) {
	// TODO Auto-generated method stub
	return null;
    }

    public boolean removeEdge(CyEdge edge) {
	// TODO Auto-generated method stub
	return false;
    }

    public int getNodeCount() {
	final Iterable<Vertex> itr = this.graph.getVertices();
	if (itr instanceof Collection)
	    return ((Collection<?>) itr).size();
	else {
	    int count = 0;
	    for (final Vertex vertex : itr)
		count++;

	    return count;
	}
    }

    public int getEdgeCount() {
	// TODO Auto-generated method stub
	return 0;
    }

    public List<CyNode> getNodeList() {
	// TODO Auto-generated method stub
	return null;
    }

    public List<CyEdge> getEdgeList() {
	// TODO Auto-generated method stub
	return null;
    }

    public boolean containsNode(CyNode node) {
	// TODO Auto-generated method stub
	return false;
    }

    public boolean containsEdge(CyEdge edge) {
	// TODO Auto-generated method stub
	return false;
    }

    public boolean containsEdge(CyNode from, CyNode to) {
	// TODO Auto-generated method stub
	return false;
    }

    public CyNode getNode(int index) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override public CyEdge getEdge(int index) {
	return null;
    }

    public List<CyNode> getNeighborList(CyNode node, Type edgeType) {
	// TODO Auto-generated method stub
	return null;
    }

    public List<CyEdge> getAdjacentEdgeList(CyNode node, Type edgeType) {
	// TODO Auto-generated method stub
	return null;
    }

    public List<CyEdge> getConnectingEdgeList(CyNode source, CyNode target, Type edgeType) {

	return null;
    }

    @Override
    public CyTable getDefaultNetworkTable() {
	return this.netTableManager.get(CyNetwork.DEFAULT_ATTRS);
    }

    @Override
    public CyTable getDefaultNodeTable() {
	return this.nodeTableManager.get(CyNetwork.DEFAULT_ATTRS);
    }

    @Override
    public CyTable getDefaultEdgeTable() {
	return this.edgeTableManager.get(CyNetwork.DEFAULT_ATTRS);
    }
}
