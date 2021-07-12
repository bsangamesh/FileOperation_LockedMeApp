import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class Services {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public void listFileNamesOfTheRootDirectory(String rootPath) {
		File rootFile = new File(rootPath);
		File[] filesInRootDirectory = rootFile.listFiles();
		if (filesInRootDirectory.length == 0) {
			System.out.println("Root Directory is Empty");
		} else {
			Arrays.sort(filesInRootDirectory);
			System.out.println("Files available in Root Directory are ");
			for (File file : filesInRootDirectory) {
				System.out.println(file.getName());
			}
		}
	}

	public void userInteractionsToAddOrDeleteOrSearchForFile(DisplayUtil displayUtil, String rootPath) throws IOException {
		displayUtil.operationsOfOptionB();
		String temp = bufferedReader.readLine();
		if (temp.length() > 1) {
			System.out.println("Enter Valid Options like 1 or 2 or 3 or 4");
			userInteractionsToAddOrDeleteOrSearchForFile(displayUtil, rootPath);
		} else {
			char operation = temp.charAt(0);
			if (operation == '1') {
				addAFileToRootDirectory(rootPath);
				userInteractionsToAddOrDeleteOrSearchForFile(displayUtil, rootPath);
			} else if (operation == '2') {
				deleteAFileFromRootDirectory(rootPath);
				userInteractionsToAddOrDeleteOrSearchForFile(displayUtil, rootPath);
			} else if (operation == '3') {
				searchForAFileInTheRootDirectory(rootPath);
				userInteractionsToAddOrDeleteOrSearchForFile(displayUtil, rootPath);
			} else if (operation == '4') {
				MainOptions.showMainOptions(displayUtil, rootPath);
			} else {
				System.out.println("Enter Valid Options like 1 or 2 or 3 or 4");
				userInteractionsToAddOrDeleteOrSearchForFile(displayUtil, rootPath);
			}
		}
	}

	public void addAFileToRootDirectory(String rootPath) throws IOException {
		System.out.println("Enter the file name of your choice");
		String fileName = bufferedReader.readLine();
		File fileNameDirectory = new File(rootPath + "/" + fileName);
		if (fileNameDirectory.createNewFile()) {
			System.out.println("File " + fileNameDirectory.getName() + " is created in the Root Directory");
		} else {
			System.out.println("File already exists.");
		}

	}


	public static void deleteAFileFromRootDirectory(String rootPath) throws IOException {
		System.out.println("Enter the Name of the File which you wish to delete from the Root Directory");
		String fileName = bufferedReader.readLine();
		File fileNameDirectory = new File(rootPath + "/" + fileName);
		if (fileNameDirectory.exists()) {
			boolean fileDeleted = fileNameDirectory.delete();
			if (fileDeleted) {
				System.out.println(fileName + " File is deleted from the Root Directory");
			} else {
				System.out.println("Some issue while deleting the file " + fileName + " from the Root Directory");
			}
		} else {
			System.out.println("File Not Found(FNF)");
		}

	}
	
	public static void searchForAFileInTheRootDirectory(String rootPath) throws IOException {
		System.out.println("Enter the Name of the File which you wish to search and see from the Root Directory");
		String fileName = bufferedReader.readLine();
		File fileNameDirectory = new File(rootPath + "/" + fileName);
		if (fileNameDirectory.exists()) {
			System.out.println(fileName + " File is found in the Root Directory and the Content of the file is");
			// Files.lines(fileNameDirectory.toPath()).filter(line -> !line.isEmpty())
			// .forEach(System.out::println);
			FileInputStream input = new FileInputStream(fileNameDirectory);
			FileChannel channel = input.getChannel();
			byte[] buffer = new byte[256 * 1024];
			ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);

			try {
				for (int length = 0; (length = channel.read(byteBuffer)) != -1;) {
					System.out.write(buffer, 0, length);
					byteBuffer.clear();
				}
			} finally {
				input.close();
			}
			System.out.println();
		} else {
			System.out.println(fileName + " File is not found in the Root Directory");
		}

	}


}
