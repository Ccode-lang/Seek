package command;


import comp.compiler;
import runner.runner;
import fileread.filereader;
import syntax.checker;



public class main {
    static String[] lines;
    public static void main(String[] args) {
        if ( args.length == 0 ) {
            System.out.println("Invalid arguments");
            System.exit(1);
        }
        if ( args[0].equals("comp") ) {
            lines = filereader.read(args[1]);
            if ( checker.check(lines) ) {
                compiler.compile(lines, args[2]);
            } else {
                System.out.println("\n\nSyntax errors, check above.");
            }
        } else if ( args[0].equals("run") ) {
            lines = filereader.read(args[1]);
            runner.run(lines);
        } else {
            System.out.println("Invalid arguments");
            System.exit(1);
        }
    }
}
