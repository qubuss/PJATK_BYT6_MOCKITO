package domain;

import domain.Observer;
import service.Monitor;

import java.net.URL;

public class GazetaPLObserver extends Observer {

    public GazetaPLObserver(Monitor monitor, URL url) {
        this.name = "GAZETA";
        this.url = url;
        this.monitor = monitor;
    }

    @Override
    public String update() {
        String s = "page " + url + " was updated";
        System.out.println(s);
        return s;
    }
}
