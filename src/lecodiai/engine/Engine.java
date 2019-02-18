package lecodiai.engine;

import java.util.ArrayList;
import java.util.Random;

import lecodiai.model.Entity;
import lecodiai.model.Position;
import lecodiai.specification.DataService;
import lecodiai.specification.EngineService;
import lecodiai.specification.RequireDataService;

public class Engine implements EngineService, RequireDataService {
	
	private CustomTimer timer;
	private DataService data;
	
	@Override
	public void bindDataService(DataService service) {
		data = service;
	}
	
	@Override
	public void init() {
		timer = new CustomTimer();
		timer.bindDataService(data);
		start();
		generateEntities(6); //TODO HARDCODED VALUE
		
	}

	@Override
	public void start() {
		timer.start();
	}

	@Override
	public void stop() {
		timer.stop();
	}
	
	private void generateEntities(int nbEntities) {
		Random rand = new Random();
		int xMax	= data.getMapXMax();
		int xMin	= data.getMapXMin();
		int yMax 	= data.getMapYMax();
		int yMin 	= data.getMapYMin();
		data.setEntities(new ArrayList<Entity>());
		
		while (data.getEntities().size() < nbEntities) {
			int x = rand.nextInt(xMax-data.getEntitySize()-xMin)+xMin;
			int y = rand.nextInt(yMax-data.getEntitySize()-yMin)+yMin;
			
			Entity e = new Entity(new Position(x, y));
			e.setHeight(data.getEntitySize());
			e.setWidth(data.getEntitySize());
			data.addEntity(e);
		}
//		addWalls();
		
	}
	
	public void removeEntities() {
		data.setEntities(new ArrayList<Entity>());
	}
	
	
}
