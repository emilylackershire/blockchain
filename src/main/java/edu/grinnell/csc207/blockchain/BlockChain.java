package edu.grinnell.csc207.blockchain;

import java.security.NoSuchAlgorithmException;

/**
 * A linked list of hash-consistent blocks representing a ledger of
 * monetary transactions.
 */

public class BlockChain {
    Node first;
    Node last;
    public int annaBalance = 0;
    public int bobBalance = 0;

    /**
     * class contains block and next
     */
    public class Node {
        Block block;
        Node next;

        /**
         * initializes node
         * 
         * @param block
         * @param next
         */
        public Node(Block block, Node next) {
            this.block = block;
            this.next = next;
        }
    }

    /**
     * creates the block chain
     * 
     * @param initial initial balance we want to add
     */
    public BlockChain(int initial) {
        Block block = new Block(1, initial, null);
        Node n = new Node(block, null);
        first = n;
        last = n;
        annaBalance = initial;
    }

    /**
     * mines the amount
     * 
     * @param amount
     * @return mined number
     * @throws NoSuchAlgorithmException
     */
    public Block mine(int amount) throws NoSuchAlgorithmException {
        long nonce = 0;
        Hash hash = new Hash(Hash.calculateHash(this.getSize()
                + 1, amount, last.block.getPrevHash(), nonce));
        int maxIterations = 10000;
        int iterations = 0;
        while (hash.isNotValid() && iterations > maxIterations) {
            nonce++;
            hash = new Hash(Hash.calculateHash(this.getSize()
                    + 1, amount, last.block.getPrevHash(), nonce));
            iterations++;
        }
        // System.out.println("nonce " + nonce);
        // System.out.println("iterations " + iterations);
        // System.out.println("hash " + hash);
        Block newBlock = new Block(this.getSize() + 1, amount, hash, nonce);
        return newBlock;
    }

    /**
     * gets the size
     * 
     * @return returns size
     */
    public int getSize() {
        return last.block.getNum();
    }

    /**
     * appends a new block to the block chain
     * 
     * @param blk block we are adding
     */
    public void append(Block blk) {
        if (blk.getHash().isValid() && blk.getHash() != blk.getPrevHash()) {
            Node newNode = new Node(blk, null);
            last.next = newNode;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * removes the last element of the blockchain
     * 
     * @return returns a boolean if it can remove
     */
    public boolean removeLast() {
        if (last.block.getNum() == 1) {
            return false;
        } else {
            Node cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            last = cur;
            return true;
        }
    }

    /**
     * gets and returns the hash
     * 
     * @return returns hash
     */
    public Hash getHash() {
        return last.block.getHash();
    }

    /**
     * gets and returns the nonce
     * 
     * @return returns nonce
     */
    public long getNonce() {
        return last.block.getNonce();
    }

    /**
     * checks if the block chain is valid
     * 
     * @return returns a boolean representation
     */
    public boolean isValidBlockChain() {
        Node prev = first;
        Node cur = first;
        while (cur.next != null) {
            if (!cur.block.getHash().isValid() || prev.block.getHash() != cur.block.getPrevHash()) {
                return false;
            }
            prev = cur;
            cur = cur.next;
        }
        return true;
    }

    /**
     * bobs balance
     * 
     * @return returns bobs balance
     */
    public int getBobBalance() {
        return bobBalance;
    }

    /**
     * annas balance
     * 
     * @return returns annas balance
     */
    public int getAnnaBalance() {
        return annaBalance;
    }

    /**
     * prints bobs and annas balances
     */
    public void printBalances() {
        Node cur = first;
        while (cur.next != null) {
            if (cur.block.getAmount() > 0) {
                annaBalance += cur.block.getAmount();
            } else {
                bobBalance += cur.block.getAmount();
            }
            cur = cur.next;
        }
    }

    /**
     * string representation of the block
     * 
     * @returns
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        Node cur = first;
        while (cur.next != null) {
            string.append(cur.block.toString());
            cur = cur.next;
        }
        return string.toString();
    }

}
