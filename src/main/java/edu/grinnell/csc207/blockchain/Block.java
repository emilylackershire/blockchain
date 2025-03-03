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
    public Block(int num, int amount, Hash prevHash) {
        this.number = num;
        this.amount = amount;
        this.prevHash = prevHash;
    }
    public Block(int num, int amount, Hash prevHash, long nonce) {
        this.number = num;
        this.amount = amount;
        this.prevHash = prevHash;
        this.nonce = nonce;

    }
    public int getNum() {
        return number;
    }
    public int getAmount() {
        return amount;
    }
    public long getNonce() {
        return nonce;
    }
    public Hash getPrevHash() {
        return prevHash;
    } 
    public Hash getHash() {
        return hash;
    }
    public String toString() {
        return "Block " + getNum() + " (Amount: " + getAmount() + ", Nonce: " + getNonce() + ", prevHash: " + getHash() + ", hash: " + getHash() +")";
    }

}

