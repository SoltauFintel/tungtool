package de.mwvb.tung.actions;

import java.io.IOException;

import de.mwvb.maja.web.ActionBase;

/**
 * param: app (has value "artifact" or "metadata")
 * param: name
 * query param: source
 */
public class Mirror extends ActionBase {
	
	@Override
	public String run() {
		System.out.println();
		System.out.println("MIRROR");

		String app;
		if ("artifact".equals(req.params("app"))) {
			app = "org.eclipse.equinox.p2.artifact.repository.mirrorApplication";
		} else {
			app = "org.eclipse.equinox.p2.metadata.repository.mirrorApplication";
		}
		System.out.println("    application: " + app);

		String name = req.params("name"); // z.B. "GRECLIPSE"
		if (name == null || name.trim().isEmpty()) {
			return "Error: name missing";
		}
		name = "/mirror/" + name;
		System.out.println("    destination: " + name);

		String source = req.queryParams("source"); // z.B. "http://dist.springsource.org/release/GRECLIPSE/e4.7"
		if (source == null || source.trim().isEmpty()) {
			return "Error: source missing";
		}
		System.out.println("    source     : " + source);
		
		
		try {
			ProcessBuilder pb = new ProcessBuilder("/eclipse/eclipse",
					"-application", app,
					"-source", source,
					"-destination", name,
					"-verbose",
					"-ignoreErrors");

			System.out.println("    start...");
			Process p = pb.start();
			
			System.out.println("    wait for...");
			p.waitFor();
			
			System.out.println("    done.");
			return "done";
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return "Error: " + e.getClass().getName() + ": " + e.getMessage();
		}
	}
}
