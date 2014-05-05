package controllers;

import java.util.Map;

import model.Area;
import model.Indicator;
import model.Observation;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class API extends Controller{
	
	public static Result getDataToGraph(String area1, String  area2, String indicator){

		Area _area1 = Area.findByID(Long.parseLong(area1));
		System.out.println(_area1);
		Area _area2 = Area.findByID(Long.parseLong(area2));
		System.out.println(_area2);
		Indicator ind = Indicator.getByID(Long.parseLong(indicator));
		System.out.println(ind);
		return ok(Json.toJson(Observation.getObservationsToCompare(_area1, _area2, ind)));
	}

}
