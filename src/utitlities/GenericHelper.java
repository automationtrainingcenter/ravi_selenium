package utitlities;

import java.io.File;

public class GenericHelper {

	public static String getFilePath(String folderName, String fileName) {
		/*
		 * This method returns the path of the any file which are inside your project
		 * folder or inside another folder of project folder.
		 */
		return System.getProperty("user.dir") + File.separator + folderName + File.separator + fileName;
	}

}
