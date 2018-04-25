
import cljotdr.parse;
import cljotdr.dump;
import clojure.lang.PersistentHashMap;
public class A_Test {

	public static void main(String[] args) {
		clojure.lang.PersistentHashMap results;

		Boolean verbose = true; // display results on screen
		results = cljotdr.parse.sorparse("data\\test.sor", "data\\trace.dat", verbose);
		
		// save result in JSON format
		cljotdr.dump.save_file(results,"data\\testout.json", 1);
		
		// save result in SMILE format
		//cljotdr.dump.save_file(results,"testout.sml", 2);

		double version = (double) results.valAt("version");
		System.out.format("\n* Version = %.1f\n", version);

		clojure.lang.PersistentHashMap GenParams = (clojure.lang.PersistentHashMap) results.valAt("GenParams");

		System.out.format("\n* GenParams listing : %s\n", GenParams);
		System.out.format("\n* wavelength = %s\n", GenParams.valAt("wavelength"));


		// Changing an SOR file: generate the JSON file from parsing the original SOR file
		// then edit the JSON to make changes and run the change_sor() function.
		// Only a few fields (such as fiber ID) can be changed; most are ignored.
		//String original = "demo_ab.sor";
		//String jsonfile = "demo_ab-replacement.json";
		//String newsor   = "testout.sor";
		//cljotdr.alter.change_sor(original, jsonfile, newsor);

		//System.out.println("Bye!");
	}

}
