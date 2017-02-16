package fr.uha.ensisa.mo;

import java.io.*;

/**
 * Created by othman on 13/01/2017.
 */
public class RunServer {

    public static void main(String[] args) throws IOException {

        String OS = System.getProperty("os.name").toLowerCase();

        if(OS.indexOf("win") >= 0) {
            ProcessBuilder runServer = new ProcessBuilder("powershell.exe");
            runServer.redirectErrorStream(true);
            Process p = runServer.start();
            BufferedWriter p_stdin = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            p_stdin.write("cd 'C:\\Program Files\\swipl\\bin'");
            p_stdin.newLine();
            p_stdin.flush();

            File file = new File("server/prolog/server.pl");
            p_stdin.write(".\\swipl.exe -s "+file.getAbsolutePath());
            p_stdin.newLine();
            p_stdin.flush();

            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null)
                    break;
                System.out.println(line);
            }
        }
        else if(OS.indexOf("mac") >= 0) {
            ProcessBuilder runServer = new ProcessBuilder("/bin/bash");
            runServer.redirectErrorStream(true);
            Process p = runServer.start();

            BufferedWriter p_stdin = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            p_stdin.write("cd /Applications");
            p_stdin.newLine();
            p_stdin.flush();

            File file = new File("server/prolog/server.pl");
            p_stdin.write("./SWI-Prolog.app -s "+file.getAbsolutePath());
            p_stdin.newLine();
            p_stdin.flush();

            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null)
                    break;
            }
        }
    }
}
