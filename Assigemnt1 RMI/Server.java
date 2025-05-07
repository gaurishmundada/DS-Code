import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements Service {
    private ArrayList<String> messages = new ArrayList<>();

    public Server() throws RemoteException {
        super(); // this replaces UnicastRemoteObject.exportObject(this, 0);
    }

    public void receiveMessage(String message) throws RemoteException {
        System.out.println("Received message: " + message);
        messages.add(message);
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            LocateRegistry.createRegistry(1098); // Start the registry
            Naming.rebind("rmi://localhost/Service", server);
            System.out.println("Server ready");
        } catch (Exception e) {
            System.out.println("Server exception: " + e);
            e.printStackTrace();
        }
    }
}

