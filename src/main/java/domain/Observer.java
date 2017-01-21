package domain;

import service.Monitor;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

public abstract class Observer implements Serializable {

	protected URL url;
	protected String name;
	protected Monitor monitor;

	public URL getUrl() {
		return url;
	}

	public String getName() {
		return name;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public abstract String update() throws IOException;

}
