import domain.Observer;
import org.junit.Test;
import service.ObserverMapKey;
import service.memento.Originator;
import service.memento.Memento;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;


public class OriginatorTest {

    @Test
    public void saveStateToMementoTest() {
        Originator or = new Originator();
        Map<ObserverMapKey, Observer> state = new HashMap<ObserverMapKey, Observer>();
        or.setState(state);
        Memento mem = or.saveStateToMemento();
        assertNotNull(mem);
        assertSame(state,mem.getState());
    }

    @Test
    public void getStateFromMementoTest() {
        Originator or = new Originator();
        Map<ObserverMapKey, Observer> state = new HashMap<ObserverMapKey, Observer>();
        Memento memento = new Memento(state);
        or.getStateFromMemento(memento);
        assertSame(state, or.getState());

    }
}
