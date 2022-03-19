package matlab.example;


import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWNumericArray;
import signalprocessor.SignalProcessor;

import java.util.Arrays;

/**
 * https://ww2.mathworks.cn/help/compiler_sdk/gs/create-a-java-application-with-matlab-code.html
 */
public class SignalProcessorExample {
    public static void main(String[] args) throws Exception {
        SignalProcessor processor = new SignalProcessor();

        double[] x = new double[]{1.0, 2.0, 3.0, 1.0};
        Object[] res = processor.mrecps(1, x);
        MWArray a = (MWNumericArray) res[0];
        System.out.println(Arrays.toString((double[]) a.getData()));


    }
}
