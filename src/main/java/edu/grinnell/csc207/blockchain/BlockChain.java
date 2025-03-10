package edu.grinnell.csc207.blockchain;

import java.security.NoSuchAlgorithmException;

/**
 * A linked list of hash-consistent blocks representing a ledger of
 * monetary transactions.
 */

public class BlockChain {
    Node first;
    Node last; 
    int annaBalance = 0;
    int bobBalance = 0;
    public class Node {
        Block block;
        Node next;
        public Node(Block block, Node next) {
            this.block = block;
            this.next = next;
        }
    }
    public BlockChain (int initial) {
        Block block = new Block(1, initial, null);
        Node n = new Node(block, null);
        first = n;
        last = n;
    }
    public Block mine(int amount) throws NoSuchAlgorithmException { 
        long nonce = 0;
        Hash hash = new Hash(Hash.calculateHash(this.getSize() + 1, amount, last.block.getPrevHash(), nonce));
        while(!hash.isValid()) {
            nonce++; 
            hash = new Hash(Hash.calculateHash(this.getSize() + 1, amount, last.block.getPrevHash(), nonce));
        }
        Block newBlock = new Block(this.getSize() + 1, amount, hash, nonce);
        return newBlock;
    }
    public int getSize() {
        return last.block.getNum();
    }
    public void append(Block blk) {
        if(blk.getHash().isValid() && blk.getHash() != blk.getPrevHash()) {
            Node newNode = new Node(blk, null);
            last.next = newNode;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public boolean removeLast() {
        if(last.block.getNum() == 1) {
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
    public Hash getHash() {
        return last.block.getHash();
    }
    public long getNonce() {
        return last.block.getNonce();
    }
    public boolean isValidBlockChain() {
        Node prev = first;
        Node cur = first;
            while (cur.next != null) {
                if(!cur.block.getHash().isValid() || prev.block.getHash() != cur.block.getPrevHash()){
                    return false;
                }
                prev = cur;
                cur = cur.next;
            }
            return true;
    }
    public void printBalances() {
        Node cur = first;
        while (cur.next != null) {
            if(cur.block.getAmount() > 0){
                annaBalance += cur.block.getAmount();
            } else {
                bobBalance += cur.block.getAmount();
            }
            cur = cur.next;
        }
    }
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
