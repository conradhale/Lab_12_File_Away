import javax.swing.JFileChooser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.File;

public class Main {
  public static void main(String[] args) {
    JFileChooser chooser = new JFileChooser();
    Scanner inFile;
    String line;
    String[] words;
    Path target = new File(System.getProperty("user.dir")).toPath();
    chooser.setCurrentDirectory(target.toFile());
    try {
      if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        target = chooser.getSelectedFile().toPath();
      }
      inFile = new Scanner(target);
      int lineCount = 0;
      int wordCount = 0;
      int charCount = 0;
      while(inFile.hasNextLine()) {
        lineCount++;
        line = inFile.nextLine();
        charCount += line.length();
        words = line.split(" ");
        wordCount += words.length;
      }
      System.out.println(target);
      System.out.println("Lines: " + lineCount);
      System.out.println("Words: " + wordCount);
      System.out.println("Characters: " + charCount);
    } catch (FileNotFoundException e) {
      System.out.println("File Not Found");
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("IOException");
      e.printStackTrace();
    }
  }
}