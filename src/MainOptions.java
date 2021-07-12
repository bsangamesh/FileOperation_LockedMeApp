import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainOptions {
	static Services services = new Services();
	public static void showMainOptions(DisplayUtil displayUtil, String rootPath) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		displayUtil.displayMainOptions();
		String temp = bufferedReader.readLine();
		if (temp.length() > 1) {
			System.out.println("Enter Valid Options like a/A, b/B or c/C");
			showMainOptions(displayUtil, rootPath);
		} else {
			char mainOptions = temp.charAt(0);

			switch (mainOptions) {
			case 'a':
			case 'A':
				services.listFileNamesOfTheRootDirectory(rootPath);
				showMainOptions(displayUtil, rootPath);
			case 'b':
			case 'B':
				services.userInteractionsToAddOrDeleteOrSearchForFile(displayUtil, rootPath);
				showMainOptions(displayUtil, rootPath);
			case 'c':
			case 'C':
				System.out.println("Thank you for using LockedMe.com. Bye!");
				System.exit(0);
			default:
				System.out.println("Enter Valid Options like a/A, b/B or c/C");
				showMainOptions(displayUtil, rootPath);
			}
		}
	}

}
