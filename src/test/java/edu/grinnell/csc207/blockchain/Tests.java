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
    public void annaStratTest() throws NoSuchAlgorithmException {
        BlockChain block = new BlockChain(initialAmount);
        assertEquals(300, block.annaBalance);
    }
}
