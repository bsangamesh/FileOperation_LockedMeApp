import java.io.File;
import java.io.IOException;

public class LockedMeApp{

	public static void main(String[] args) throws IOException {
		//String rootPath = "D:/SimpliLearn/Phase1_Project";
		String rootPath = System.getProperty("user.dir").concat("/Phase1Project/RootDirectory");
		DisplayUtil displayUtil = new DisplayUtil();
		File rootDirectory = new File(rootPath);
		if (!rootDirectory.exists()) {
			rootDirectory.mkdirs();
		}
		displayUtil.displayApplicationAndDeveloperDetails();
		displayUtil.directoryDetails(rootPath);
		MainOptions.showMainOptions(displayUtil, rootPath);

	}
}