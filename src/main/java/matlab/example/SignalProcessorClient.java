package matlab.example;


import com.mathworks.toolbox.javabuilder.remoting.RemoteFactory;

import signalprocessor.SignalProcessorRemote;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;

public class
SignalProcessorClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("192.168.66.212", 10990);
        RemoteFactory factory = (RemoteFactory) registry.lookup("FactoryInstance");
        SignalProcessorRemote remote = (SignalProcessorRemote) factory.newInstance();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            double[] x = new double[]{1.0, 2.0, i, 1.0};
            Object[] res = remote.mfft(1, x, 4.);
            System.out.println(Arrays.toString(((double[][]) res[0])[0]));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("平均用时: " + (endTime - startTime)/1000 + "ms");
    }
}
