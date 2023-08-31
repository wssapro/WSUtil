package cn.ws.tools;

import java.io.File;

public class BatchRenameFiles {

    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\Host-424\\Desktop\\image"; // Replace with the path to your directory
        File directory = new File(directoryPath);

        // List all files in the directory
        File[] files = directory.listFiles();

        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                if (file.isFile()) {
                    // Get the current file name
                    String oldFileName = file.getName();

                    // Construct the new file name (modify as needed)
                    String newFileName = (i+1) + ".jpg";

                    // Create a new File object with the new file name
                    File newFile = new File(directory, newFileName);

                    // Rename the file
                    if (file.renameTo(newFile)) {
                        System.out.println("File " + oldFileName + " renamed to " + newFileName);
                    } else {
                        System.out.println("Failed to rename file: " + oldFileName);
                    }
                }
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }
}
