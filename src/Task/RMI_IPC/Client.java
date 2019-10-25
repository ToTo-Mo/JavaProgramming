package Task.RMI_IPC;

import java.rmi.*;
import java.rmi.registry.*;

public class Client {
    public static void main(String[] args) {
        try {
            String remoteServer = "Server";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            // Java RMI registry lookup to get a proxy for the remote object
            RemoteDate ds = (RemoteDate) registry.lookup("DateServer");
            System.out.println("server conneted");
            System.out.println( ds.getDate() ); // remote object invocation
        }
        catch (Exception e){
            System.out.println("server connection failed");
        }
    }
}