package de.mwvb.tung;

import static spark.Spark.externalStaticFileLocation;
import static spark.Spark.port;

import de.mwvb.maja.web.AbstractWebApp;
import de.mwvb.tung.actions.Mirror;
import spark.Spark;

/**
 * Tung, the Eclipse provisioning tool
 * 
 * <p>The name comes from: Equinox = (in German:) Tag-und-Nacht-Gleiche = T.u.N.G. = Tung</p>
 */
public class TungApp extends AbstractWebApp {
	public static final String VERSION = "0.1.0";

	@Override
	protected void routes() {
		Spark.get("/", (req, res) -> "Tung tool");
		_get("/mirror/:app/:name", Mirror.class);
		System.out.println("App loaded");
	}

	public static void main(String[] args) {
		new TungApp().start(VERSION);
	}
	
	@Override
	public void start(String version) {
		initLogging();
		initConfig();
		
		int port = Integer.parseInt(config.get("port"));
		port(port);
		banner(port, version);
		
   		externalStaticFileLocation("/mirror");
    	
    	initDatabase();
    	init();
    	
    	defaultRoutes();
    	routes();
	}
}
