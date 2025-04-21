package edu.grinnell.csc207.blockchain;

/**
 * A single block of a blockchain.
 */
public class Block {
    int number = 0;
    int amount;
    Hash prevHash;
    long nonce;
    Hash hash;

    /**
     * initializes everything
     * @param num - number 
     * @param amount - amount we are adding/taking
     * @param prevHash - previous hash
    
    public Block(int num, int amount, Hash prevHash) {
        this.number = num;
        this.amount = amount;
        this.prevHash = prevHash;
        this.nonce = 999;
    }
    */

    /**
     * initializes everything
     * @param num - number 
     * @param amount - amount we are adding/taking
     * @param prevHash - previous hash
     * @param nonce - nonce
     */
    public Block(int num, int amount, Hash prevHash, long nonce) {
        this.number = num;
        this.amount = amount;
        this.prevHash = prevHash;
        this.nonce = nonce;
    }

    /**
     * @return returns number
     */
    public int getNum() {
        return number;
    }

    /**
     * @return retruns the amount 
     */
    public int getAmount() {
        return amount;
    }

    /** 
     * returns the nonce
     * @return returns nonce
     */
    public long getNonce() {
        return this.nonce;
    }

    /**
     * @return returns the previous hash
     */
    public Hash getPrevHash() {
        return prevHash;
    }

    /**
     * returns the hash
     * @return returns hash
     */
    public Hash getHash() {
        return hash;
    }

    /**
     * a string representation of everything
     * @return returns string
     */
    @Override
    public String toString() {
        return "Block " + getNum() + " (Amount: " + getAmount() 
                + ", Nonce: " + getNonce() + ", prevHash: " + getHash()
                + ", hash: " + getHash() + ")";
    }
}
