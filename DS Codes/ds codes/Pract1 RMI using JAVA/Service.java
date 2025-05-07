import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Service extends Remote {
    void receiveMessage(String message) throws RemoteException;
}

