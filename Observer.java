// OBSERVER

import java.util.ArrayList;
import java.util.List;

// Subject Interface
// Defines the core methods that will be implemented by concrete subjects.
// Allows observers to be added, removed, and notified about updates.
interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String mode);
}

// Concrete Subject - HouseMode
// This class represents the "subject" in the Observer Pattern.
// It maintains a list of observers and notifies them when there's a change in state (house mode).
class HouseMode implements Subject {
    private List<Observer> observers;

    public HouseMode() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String mode) {
        for (Observer observer : observers) {
            observer.update(mode);
        }
    }
}

// Observer Interface
// Defines a method for receiving updates from the subject.
interface Observer {
    void update(String mode);
}

// Concrete Observer - Light
// This observer reacts to mode changes by adjusting the light accordingly.
class Light implements Observer {
    @Override
    public void update(String mode) {
        switch (mode) {
            case "Night":
                System.out.println("Lights dimmed");
                break;
            case "Away":
                System.out.println("Lights off");
                break;
            case "Home":
                System.out.println("Lights on");
                break;
        }
    }
}

// Concrete Observer - Thermostat
// This observer reacts to mode changes by adjusting the thermostat settings.
class Thermostat implements Observer {
    @Override
    public void update(String mode) {
        switch (mode) {
            case "Home":
                System.out.println("Thermostat set to comfortable temperature");
                break;
            case "Away":
                System.out.println("Thermostat set to energy-saving mode");
                break;
        }
    }
}

// This class demonstrates the working of the Observer Pattern.
// Different devices (light, thermostat) respond to changes in house mode (home, away, night).
public class Observer {
    public static void main(String[] args) {
        HouseMode houseMode = new HouseMode();
        Light light = new Light();
        Thermostat thermostat = new Thermostat();

        houseMode.addObserver(light);
        houseMode.addObserver(thermostat);

        System.out.println("Setting mode to 'Home':");
        houseMode.notifyObservers("Home");

        System.out.println("\nSetting mode to 'Away':");
        houseMode.notifyObservers("Away");

        System.out.println("\nSetting mode to 'Night':");
        houseMode.notifyObservers("Night");
    }
}
