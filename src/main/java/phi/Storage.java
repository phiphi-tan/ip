package phi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Storage {
    private File txtFile;
    private Path filePath;

    public Storage(String pathString) {
        this.txtFile = new File(pathString);
        this.filePath = Paths.get(pathString);

        if (!Files.exists(filePath)) {
            try {
                Files.createDirectories(filePath.getParent());
                Files.createFile(filePath);
                System.out.println("No file found, new .txt file created!");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public TaskList readFromFile() {
        TaskList tasks = new TaskList();
        try {
            Scanner txtScanner = new Scanner(txtFile);
            while (txtScanner.hasNextLine()) {
                tasks.addFromSc(txtScanner.nextLine());
            }
            txtScanner.close();
            System.out.println("Text file has been scanned!\n" + tasks.listSize() + " items in the list");
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong... There's still no file to be found");
            return new TaskList();
        }
        return tasks;
    }

    public void writeToFile(TaskList taskInput) {
        try {
            FileWriter output = new FileWriter(txtFile);
            output.write(taskInput.outputList());
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}
