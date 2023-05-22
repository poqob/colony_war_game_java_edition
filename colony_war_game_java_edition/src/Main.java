
import colony.Colony;
import log.Log;
import manufacture.Manufacture0;
import strategy.Strategy0;

public class Main {

	public static void main(String[] args) {

		Colony c = new Colony(30, new Strategy0(), new Manufacture0());
		Log log = new Log(c);
		System.out.println(log.toString());
	}

}
