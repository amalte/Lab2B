package Controller;

import Model.MotorizedVehicleFactory;
import View.VehicleView;
import Model.Saab95;
import Model.Scania;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class VehicleController extends Observable {

    // The frame that represents this instance View of the MVC pattern
    private VehicleView frame;

    // Constructor
    public VehicleController(VehicleView frame) {
        this.frame = frame;
        initActionListeners();
    }

    // Initialize all ActionListeners
    private void initActionListeners() {
        frame.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startCars();
                notifySpeedChange(frame.getVehicleGUIList());
            }
        });

        frame.getStopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopCars();
                notifySpeedChange(frame.getVehicleGUIList());
            }
        });

        frame.getAddVehicleButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addVehicle();
                notifyListChange(frame.getVehicleGUIList());
            }
        });

        frame.getRemoveVehicleButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeVehicle();
                notifyListChange(frame.getVehicleGUIList());
            }
        });

        frame.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(frame.getGasAmount());
                notifySpeedChange(frame.getVehicleGUIList());
            }
        });

        frame.getBrakeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(frame.getGasAmount());
                notifySpeedChange(frame.getVehicleGUIList());
            }
        });

        frame.getTurboOnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOn();
                notifySpeedChange(frame.getVehicleGUIList());
            }
        });

        frame.getTurboOffButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOff();
                notifySpeedChange(frame.getVehicleGUIList());
            }
        });

        frame.getLiftBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                raiseBed();
            }
        });

        frame.getLowerBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerBed();
            }
        });
    }

    // Calls the startEngine method for each car once
    void startCars() {
        for(int i = 0; i < frame.getVehicleGUIList().size(); i++) {
            frame.getVehicleGUI(i).getVehicle().startEngine();
        }

    }

    // Calls the stopEngine method for each car once
    void stopCars() {
        for(int i = 0; i < frame.getVehicleGUIList().size(); i++) {
            frame.getVehicleGUI(i).getVehicle().stopEngine();
        }
    }

    // Adds a new random vehicle
    void addVehicle() {
        if(frame.getVehicleGUIList().size() < 10) {
            Random rand = new Random();
            int randomX = rand.nextInt(600) + 100;
            int randomY = rand.nextInt(500);
            frame.addVehicle(MotorizedVehicleFactory.createRandomVehicle(), randomX, randomY);
        }
    }

    // Removes the latest added vehicle to vehicleGUI List
    void removeVehicle() {
        if(frame.getVehicleGUIList().size() > 0) {
            frame.getVehicleGUIList().remove(frame.getVehicleGUIList().size() - 1);
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for(int i = 0; i < frame.getVehicleGUIList().size(); i++) {
            frame.getVehicleGUI(i).getVehicle().gas(gas);
        }
    }

    // Calls the brake method for each car once
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for(int i = 0; i < frame.getVehicleGUIList().size(); i++) {
            frame.getVehicleGUI(i).getVehicle().brake(brake);
        }
    }

    // Calls the setTurboOn method if vehicle is a Saab95
    void turboOn() {
        for(int i = 0; i < frame.getVehicleGUIList().size(); i++) {
            if(frame.getVehicleGUI(i).getVehicle().getModelName() == "Saab95") {
                ((Saab95) frame.getVehicleGUI(i).getVehicle()).setTurboOn();
            }
        }
    }

    // Calls the setTurboOn method if vehicle is a Saab95
    void turboOff() {
        for(int i = 0; i < frame.getVehicleGUIList().size(); i++) {
            if(frame.getVehicleGUI(i).getVehicle().getModelName() == "Saab95") {
                ((Saab95) frame.getVehicleGUI(i).getVehicle()).setTurboOff();
            }
        }
    }

    // Calls the raiseFlatbed method if vehicle is a Scania
    void raiseBed() {
        for(int i = 0; i < frame.getVehicleGUIList().size(); i++) {
            if(frame.getVehicleGUI(i).getVehicle().getModelName() == "Scania") {
                ((Scania) frame.getVehicleGUI(i).getVehicle()).raiseFlatbed();
            }
        }


    }
    // Calls the lowerFlatbed method if vehicle is a Scania
    void lowerBed() {
        for(int i = 0; i < frame.getVehicleGUIList().size(); i++) {
            if(frame.getVehicleGUI(i).getVehicle().getModelName() == "Scania") {
                ((Scania) frame.getVehicleGUI(i).getVehicle()).lowerFlatbed();
            }
        }
    }
}
