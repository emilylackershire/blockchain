package edu.grinnell.csc207.blockchain;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Tests {
    int initialAmount = 300;
    
    @Test
    public void annaStartTest() throws NoSuchAlgorithmException {
        BlockChain block = new BlockChain(initialAmount);
        assertEquals(300, block.annaBalance);
    }
    @Test
    public void bobStartTest() throws NoSuchAlgorithmException {
        BlockChain block = new BlockChain(initialAmount);
        assertEquals(0, block.bobBalance);
    }
    @Test
    public void testAppendBlock() throws NoSuchAlgorithmException {
        BlockChain block = new BlockChain(initialAmount);
        Block newAnnaBlock = new Block(block.getSize()
        + 1, 400, block.getHash(), 0);
        block.append(newAnnaBlock, 0);
        Block newBobBlock = new Block(block.getSize()
        + 1, 0, block.getHash(), 0);
        block.append(newBobBlock, -100);
        assertEquals(400, block.annaBalance);
        assertEquals(100, block.bobBalance);
    }
}
