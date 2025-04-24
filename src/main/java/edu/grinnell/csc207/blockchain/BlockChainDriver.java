package edu.grinnell.csc207.blockchain;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * The main driver for the block chain program.
 */
public class BlockChainDriver {
    private static void printer() {
        System.out.println("Valid commands: ");
        System.out.println(" mine: discovers the nonce for a given transaction ");
        System.out.println(" append: appends a new block onto the end of the chain ");
        System.out.println(" remove: removes the last block from the end of the chain ");
        System.out.println(" check: checks that the block chain is valid ");
        System.out.println(" report: reports the balances of Alice and Bob ");
        System.out.println(" help: prints this list of commands ");
        System.out.println(" quit: quits the program");
        System.out.println("\nCommand?");
    }

    /**
     * The main entry point for the program.
     * 
     * @param args the command-line arguments
     * @throws NoSuchAlgorithmException
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // if (args.length != 1) {
        // System.err.println("Usage: java BlockChain: missing an initial amount");
        // System.exit(1);
        // }
        int initialAmount = 300;
        // Integer.valueOf(args[0]);
        if (initialAmount < 0) {
            System.err.println("Error: cannot be negative");
        }
        BlockChain block = new BlockChain(initialAmount);
        block.initialBlock(initialAmount);
        printer();
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        boolean quit = false;
        while (quit == false) {
            switch (input) {
                case "mine":
                    System.out.println("Amount Transfered? ");
                    int amount = Integer.valueOf(scan.nextLine());
                    block.mine(amount);
                    long nonce = block.getNonce();
                    break;
                case "append":
                    System.out.println("Amount Transfered? ");
                    int amountAppend = Integer.valueOf(scan.nextLine());
                    Block newBlock = new Block(block.getSize()
                            + 1, amountAppend, block.getHash(), 0); // I calculate nonce in append
                    block.append(newBlock, amountAppend);
                    break;
                case "remove":
                    block.removeLast();
                    break;
                case "check":
                    if (block.isValidBlockChain() == true) {
                        System.out.println("The block chain is vaid!");
                    } else {
                        System.out.println("The block chain is not valid!");
                    }
                    break;
                case "report":
                    System.out.println("\nBob's Balance: " + block.getBobBalance()
                            + ", Anna's Balace: "
                            + block.getAnnaBalance() + "\n");
                    break;
                case "help":
                    printer();
                    break;
                case "quit":
                    quit = true;
                    break;
                default:
                    printer();
                }
            System.out.println("\nCommand?\n");
            input = scan.nextLine();
        }
        scan.close();
    }
}
