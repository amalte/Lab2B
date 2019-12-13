package Controller;

import View.VehicleGUI;

import java.util.ArrayList;

public abstract class Observable {

    private ArrayList<IObserver> observers = new ArrayList<>();

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyListChange(ArrayList<VehicleGUI> vehicleGUIList) {
        for(IObserver observer : observers) {
            observer.actOnVehicleListChange(vehicleGUIList);
        }
    }

    public void notifySpeedChange(ArrayList<VehicleGUI> vehicleGUIList) {
        for(IObserver observer : observers) {
            observer.actOnVehicleSpeedChange(vehicleGUIList);
        }
    }
}
