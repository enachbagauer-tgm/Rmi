package engine;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import compute.Compute;

public class LoadBalancer {
	
	
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        createRegistry(1099, "NachbagauerTest");
    }
	
	private static void createRegistry (int port, String name ) {
    	Compute engine = new ComputeEngine();
        Compute stub;
		try {
			stub = (Compute) UnicastRemoteObject.exportObject(engine, 0); //Request handler, Parameter handler,  Object calling, 
	        Registry registry = LocateRegistry.createRegistry(port);//bindRegistry
	        registry.rebind(name, stub);//Map
	        
		} catch (RemoteException e) {
			e.getMessage();
		}

    }
}
