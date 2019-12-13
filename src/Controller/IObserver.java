package Controller;

import View.VehicleGUI;

import java.util.ArrayList;

public interface IObserver {

    void actOnVehicleListChange(ArrayList<VehicleGUI> vehicleGUIList);
    void actOnVehicleSpeedChange(ArrayList<VehicleGUI> vehicleGUIList);
}
