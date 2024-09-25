// BRIDGE

// Implementor Interface - DeviceControl
// Interface to define the core method for controlling a device.
interface DeviceControl {
    void controlDevice();
}

// Concrete Implementor - MobileAppControl
// Specific implementation of the DeviceControl interface for controlling the device via a mobile app.
class MobileAppControl implements DeviceControl {
    @Override
    public void controlDevice() {
        System.out.println("Controlling device through Mobile App.");
    }
}

// Concrete Implementor - WebAppControl
// Specific implementation of DeviceControl for controlling the device via a web application.
class WebAppControl implements DeviceControl {
    @Override
    public void controlDevice() {
        System.out.println("Controlling device through Web App.");
    }
}

// Abstraction - SmartDevice
// Abstract class to represents a smart device. It uses a reference to the DeviceControl interface,
// making it independent of how the device is actually controlled (mobile or web).
abstract class SmartDevice {
    protected DeviceControl deviceControl;

    public SmartDevice(DeviceControl deviceControl) {
        this.deviceControl = deviceControl;
    }

    public abstract void operate();
}

// Abstraction - SmartLight
class SmartLight extends SmartDevice {
    public SmartLight(DeviceControl deviceControl) {
        super(deviceControl);
    }

    @Override
    public void operate() {
        System.out.println("Operating Smart Light...");
        deviceControl.controlDevice();
    }
}

// Refined Abstraction - SmartFan
class SmartFan extends SmartDevice {
    public SmartFan(DeviceControl deviceControl) {
        super(deviceControl);
    }

    @Override
    public void operate() {
        System.out.println("Operating Smart Fan...");
        deviceControl.controlDevice();
    }
}

// This class demonstrates the Bridge Pattern by showing how different smart devices (light and fan)
// can be controlled via different control mechanisms (mobile app and web app) without changing the smart devices themselves.
public class SmartHomeBridge {
    public static void main(String[] args) {
        // Control Smart Light with Mobile App
        SmartDevice light = new SmartLight(new MobileAppControl());
        light.operate();

        // Control Smart Fan with Web App
        SmartDevice fan = new SmartFan(new WebAppControl());
        fan.operate();
    }
}
