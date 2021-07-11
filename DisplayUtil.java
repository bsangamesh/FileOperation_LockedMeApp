public class DisplayUtil {

	public void displayMainOptions() {
		System.out.println("******************** Main Option ********************");
		System.out.println("-> Enter a or A to get all the file names from the root directory");
		System.out.println("-> Enter b or B to do the following operations");
		operationsOfOptionB();
		System.out.println("-> Enter c or C to Close the application");

	}

	public void displayApplicationAndDeveloperDetails() {
		System.out.println("******************** Application Name : LockedMe.com ******************");
		System.out.println("******************** Functionalities of the LockedMe.com ******************");
		System.out.println("-> List the Files(File Names) available in a root directory");
		System.out.println("-> Add a File to the root directory");
		System.out.println("-> Delete a File from the root directory");
		System.out.println("-> Search for a File in the root directory");
		System.out.println("****************** Developer Details ******************");
		System.out.println("<> Developer Name : B Sangappa");
		System.out.println("<> Developer Email : sangamesh.b.007@gmail.com");
	}

	public void operationsOfOptionB() {
		System.out.println(" --> Enter 1 to Add a File to the root directory");
		System.out.println(" --> Enter 2 to Delete a File from the root directory");
		System.out.println(" --> Enter 3 to Search for a File in the root directory");
		System.out.println(" --> Enter 4 to Go back to the Main options");
	}
	
	public void directoryDetails(String rootPath) {
		System.out.println("******************** Directory for LockedMe App ******************");
		System.out.println("--> " + rootPath.replace('/', '\\'));
	}
	
}
