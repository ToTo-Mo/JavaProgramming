package Task.RMI_IPC;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class Server extends UnicastRemoteObject implements RemoteDate{

    protected Server() throws RemoteException {
        super();
    }

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        try {
            RemoteDate ds = new Server(); 
            
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("DateServer", ds);
        } 
        catch (Exception e) { }
        }

    public Date getDate() throws RemoteException {
        return new Date();
    }
}

