import service.Monitor;
import service.memento.Originator;
import service.memento.CareTaker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Gui extends JFrame{

    private Monitor monitor;
    private Originator originator;
    private CareTaker careTaker;

    private JTextArea logi;
    private JButton startButton;
    private JButton stopButton;
    private boolean czy;
    private Thread test;


    public Gui(Monitor monitor, Originator originator, CareTaker careTaker){
        this.monitor = monitor;
        this.originator = originator;
        this.careTaker = careTaker;

        start();
    }
    public void start(){

        JFrame frame = new JFrame();
        frame.setTitle("BYT URL MONITOR");
        frame.setSize(500, 500);
        frame.setLayout(null);


        logi = new JTextArea("");
        logi.setBounds(10, 50, 400, 250);
        logi.setEditable(false);
        logi.setLineWrap(true);
        logi.setOpaque(false);

        startButton = new JButton("START");
        startButton.setBounds(0, 0, 100, 20);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                czy = true;
                run();
            }
        });

        stopButton = new JButton("STOP");
        stopButton.setBounds(120, 0, 100, 20);
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                czy = false;

            }
        });

        frame.add(logi);
        frame.add(startButton);
        frame.add(stopButton);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void run(){


         test = new Thread(() -> {
             int state = 0;
            while(czy){
                try{
                    monitor.checkForModification(logi);
                    if(state == 1){
                        originator.setState(monitor.getObserversMap());
                        careTaker.add(originator.saveStateToMemento());
                    }
                    state++;
                    Thread.sleep(5000);
                    if(state == 3){
                        monitor.setObserversMap(careTaker.get().getState());
                    }
                    logi.append("\n");
                }catch (InterruptedException e){
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        test.start();

    }


}
