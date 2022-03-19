package matlab.example;

import com.mathworks.toolbox.javabuilder.remoting.BasicRemoteFactory;
import signalprocessor.SignalProcessor;
import signalprocessor.SignalProcessorRemote;


import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SignalProcessorServer {
    public static void main(String[] args)throws Exception {
        BasicRemoteFactory factory = new BasicRemoteFactory(SignalProcessor.class, SignalProcessorRemote.class,false);
        Remote stub = factory.getStub();
        Registry reg  = LocateRegistry.createRegistry(10990);
        reg.rebind("FactoryInstance",factory);
        System.out.println("Server registered and running successfully!!\n");
    }
}
