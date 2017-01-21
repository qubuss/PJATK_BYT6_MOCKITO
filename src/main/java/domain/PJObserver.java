package domain;

import service.Monitor;

import java.net.URL;

public class PJObserver extends Observer {

    public PJObserver(Monitor monitor, URL url) {
        this.name = "PJATK";
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
