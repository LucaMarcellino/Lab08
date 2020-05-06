package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {

	
	private Graph<Airport,DefaultWeightedEdge> grafo;
	private ExtFlightDelaysDAO dao;
	private Map<Integer,Airport> aereoporti;
	
	
	public Model() {
		this.dao=new ExtFlightDelaysDAO();
		
	}
	
	public void creaGrafo(int mediaU) {
		this.aereoporti=new HashMap<>();
		dao.loadAllAirports(aereoporti);
		
		this.grafo= new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(this.grafo, aereoporti.values());
		
		for(Arco a : dao.getArchi(aereoporti)) {
			if(a.getMedia()>mediaU) {
				Graphs.addEdge(this.grafo, a.getoA(),a.getdA() , a.getMedia());
			}
		}

		
	}
	
	public Graph<Airport,DefaultWeightedEdge> getGrafo(int mediaU){
		this.creaGrafo(mediaU);
		return grafo;
		
	}
	
	public int getVertici(int mediaU) {
		int numeroVertici= this.getGrafo(mediaU).vertexSet().size();
		return numeroVertici;
		
	}
	
	public int getArchi(int mediaU) {
		int numeroArchi= this.getGrafo(mediaU).edgeSet().size();
		return numeroArchi;
		
	}
	
	
}
