package jgame23;

import java.io.File;
import java.util.Calendar;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Ranking {

    public void test(){
    try {
        File file = new File("ranking.csv");
        PrintWriter printWriter = new PrintWriter(file);
        write(printWriter);
        printWriter.close();
    }catch (IOException e) {
        e.printStackTrace();
        }
    }
    public void write(PrintWriter printWriter) {
        ArrayList<String> playerData = new ArrayList<>();
        playerData.add(Jugador.getNombre());
        playerData.add(String.valueOf(Jugador.getPuntuacion()));
        playerData.add(String.valueOf(Calendar.getInstance()));

        for (String string : playerData) {
            printWriter.write(string);
        }
    }
}
