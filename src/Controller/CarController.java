package Controller;

import View.CarView;
import Model.Saab95;
import Model.Scania;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;

    // Constructor
    public CarController(CarView frame) {
        this.frame = frame;
        initActionListeners();
    }

    // Initialize all ActionListeners
    private void initActionListeners() {
        frame.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startCars();
            }
        });

        frame.getStopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopCars();
            }
        });

        frame.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(frame.getGasAmount());
            }
        });

        frame.getBrakeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(frame.getGasAmount());
            }
        });

        frame.getTurboOnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOn();
            }
        });

        frame.getTurboOffButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOff();
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
