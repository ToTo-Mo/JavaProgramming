package Task.RMI_IPC;

import java.rmi.RemoteException;
import java.util.Date;

// Remote interface
interface RemoteDate extends java.rmi.Remote {
    public Date getDate() throws RemoteException;
}