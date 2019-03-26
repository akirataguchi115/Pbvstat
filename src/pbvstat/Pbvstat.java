package pbvstat;

import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Pbvstat {

    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        Component frame = null;
        chooser.showOpenDialog(frame);
        File[] files = chooser.getSelectedFiles();

//        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
//        dialog.setMode(FileDialog.LOAD);
//        dialog.setVisible(true);
//        String tiedosto = dialog.getFile();
        int play_kertoja = 0;
        for (File tiedosto : files) {
            try {
                Scanner tiedostonlukija = new Scanner(tiedosto);
                while (tiedostonlukija.hasNextLine()) {
                    String rivi = tiedostonlukija.nextLine();
                    String[] palat = rivi.split(";");
                    for (int i = 0; i < palat.length; i++) {
                        if (palat[i].contains("play")) {
                            play_kertoja++;
                            System.out.println(rivi);
                        }
                    }
                }
            } catch (IOException ex) {
                System.out.println("Virhe tiedoston käsittelyssä.");
            }
        }
        System.out.println("Yhteensä " + play_kertoja + " kertaa play-käskyä");
        System.exit(0);
    }
}
