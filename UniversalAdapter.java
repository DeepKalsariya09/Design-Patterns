// ADAPTER

// Target Interface - PowerSocket (the common interface)
// The common interface that will be used by all devices, regardless of the plug type.
// Decision: Defining an interface ensures that all devices can be controlled in a standardized way.
interface PowerSocket {
    void providePower();
}

// Adaptee - USDevice (Incompatible class with the target interface)
// This class represents a US-specific device that does not comply with the PowerSocket interface.
// Decision: The USDevice has its own method for providing power, which is incompatible with PowerSocket.
class USDevice {
    public void plugInUS() {
        System.out.println("Powering US device with US plug.");
    }
}

// Adaptee - EuropeanDevice (Incompatible class with the target interface)
// This class represents a European-specific device, also incompatible with PowerSocket.
// Decision: Like USDevice, this device has its own method for receiving power.
class EuropeanDevice {
    public void plugInEU() {
        System.out.println("Powering European device with EU plug.");
    }
}

// Adapter for USDevice
// The adapter class bridges the gap between the incompatible USDevice and PowerSocket.
// Decision: Implements the PowerSocket interface to allow a USDevice to be used in a PowerSocket context.
class USAdapter implements PowerSocket {
    private USDevice usDevice;

    public USAdapter(USDevice usDevice) {
        this.usDevice = usDevice;
    }

    @Override
    public void providePower() {
        usDevice.plugInUS();
    }
}

// Adapter for EuropeanDevice
// This adapter class allows EuropeanDevice to work with PowerSocket.
// Decision: Like USAdapter, it implements PowerSocket to make EuropeanDevice compatible.
class EuropeanAdapter implements PowerSocket {
    private EuropeanDevice europeanDevice;

    public EuropeanAdapter(EuropeanDevice europeanDevice) {
        this.europeanDevice = europeanDevice;
    }

    @Override
    public void providePower() {
        europeanDevice.plugInEU();
    }
}

// This is the client code that demonstrates how the Adapter Pattern is used to solve the incompatibility issue.
public class UniversalAdapter {
    public static void main(String[] args) {
        // Create US and European devices
        USDevice usDevice = new USDevice();
        EuropeanDevice euDevice = new EuropeanDevice();

        // Create adapters for each device
        PowerSocket usAdapter = new USAdapter(usDevice);
        PowerSocket euAdapter = new EuropeanAdapter(euDevice);

        // Use the adapters to power devices
        System.out.println("Using US Adapter:");
        usAdapter.providePower();

        System.out.println("\nUsing European Adapter:");
        euAdapter.providePower();
    }
}
