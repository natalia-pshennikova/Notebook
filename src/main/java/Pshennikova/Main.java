package Pshennikova;

import asg.cliche.Shell;
import asg.cliche.ShellFactory;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Notebook commands = new Notebook();
        Shell shell = ShellFactory.createConsoleShell("cmd", "Notebook", commands);
        shell.commandLoop();
    }
}
