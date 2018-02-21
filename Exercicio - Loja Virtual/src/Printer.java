import java.io.OutputStream;
import java.io.PrintStream;

public class Printer {

    // tomar como exemplo subwayprinter de headfirst

    private PrintStream out;

    public Printer(OutputStream outputStream) {
        out = new PrintStream(outputStream);
    }

}
