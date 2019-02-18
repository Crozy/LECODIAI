package lecodiai.engine;

import javafx.animation.AnimationTimer;
import lecodiai.specification.DataService;
import lecodiai.specification.RequireDataService;

public class CustomTimer extends AnimationTimer implements RequireDataService {
	private DataService dataService;

	@Override
	public void handle(long now) {
		
	}

	@Override
	public void bindDataService(DataService service) {
		dataService = service;
	}

}
