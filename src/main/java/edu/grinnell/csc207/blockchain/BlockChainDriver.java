package edu.grinnell.csc207.blockchain;

import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;

/**
 * The main driver for the block chain program.
 */
public class BlockChainDriver {
   
    /**
     * The main entry point for the program.
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        if (args.length != 1 ) {
            System.err.println("Usage: java BlockChain: missing an initial amount");
            System.exit(1);
        }
        int initialAmount = Integer.valueOf(args[0]);
        if (initialAmount < 0) {
            System.err.println("Error: cannot be negative");
        }
        BlockChain block = new BlockChain(initialAmount);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println("Command?");
        switch(input) {
            case "mine":
                break;
            case "append":
                break;
            case "remove":
                break;
            case "check":
                break;
            case "report":
                break;
            case "help":
                break;
            case "quit":
                break;
            default:
                System.out.println("Command?");
        }










        scan.close();
    }  
}
