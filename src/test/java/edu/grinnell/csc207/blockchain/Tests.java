package edu.grinnell.csc207.blockchain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Tests {
    int initialAmount = 300;
    
    @Test
    public void annaStartTest() {
        BlockChain block = new BlockChain(initialAmount);
        assertEquals(300, block.annaBalance);
    }
    @Test
    public void bobStartTest() {
        BlockChain block = new BlockChain(initialAmount);
        assertEquals(0, block.bobBalance);
    }
    @Test
    public void annaStratTest() {
        BlockChain block = new BlockChain(initialAmount);
        assertEquals(300, block.annaBalance);
    }
}
