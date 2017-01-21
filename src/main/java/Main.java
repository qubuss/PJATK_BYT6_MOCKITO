import domain.GazetaPLObserver;
import domain.PJObserver;
import service.Monitor;
import service.memento.Originator;
import service.memento.CareTaker;

import java.net.MalformedURLException;
import java.net.URL;

public class Main{

	public static void main(String[] args) throws MalformedURLException {
				
		URL adress0 = new URL("http://www.pja.edu.pl/");
		URL adress1 = new URL("http://www.gazeta.pl/");
		
		Monitor monitor = new Monitor();

		PJObserver pjObserver = new PJObserver(monitor, adress0);
		GazetaPLObserver gazetaPLObserver = new GazetaPLObserver(monitor, adress1);

		monitor.addToObserversMap(pjObserver);
		monitor.addToObserversMap(gazetaPLObserver);

		CareTaker careTaker = new CareTaker();
		Originator originator = new Originator();

		new Gui(monitor, originator, careTaker);

	}

}
