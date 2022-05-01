package coins.state;

import org.junit.jupiter.api.Test;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

class CoinsTest {

    private Coins state1 = new Coins(7, 3); // the original initial state

    private Coins state2; // the goal state
    {
        BitSet bs = new BitSet(7);
        bs.set(0, 7);
        state2 = new Coins(7, 3, bs);
    }


    @Test
    void testCanFlip(){

        assertEquals(false,state1.getCoins().length() <= state1.getN() && state1.getCoins().cardinality() == state1.getM());
        assertEquals(false,state2.getCoins().length() <= state2.getN() && state2.getCoins().cardinality() == state2.getM());
    }

    @Test
    void testToString(){
        assertEquals("O|O|O|O|O|O|O",state1.toString());
        assertEquals(true,"O|O|O|O|O|O|O".equals(state1.toString()));
        assertEquals(false,"O|O|O|O|O|O|0|".equals(state1.toString()));
    }

    @Test
    void testIsGoal(){
        assertEquals(true,state2.isGoal());
        assertEquals(false, state1.isGoal());
    }

    @Test
    void testHashCode(){
        Coins coin = new Coins(state1.getN(), state1.getM(),state1.getCoins());
        assertTrue(state1.hashCode() == state1.hashCode());
        assertTrue(state1.hashCode() == coin.hashCode());
    }

    @Test
    void testClone() {
        var clone = state1.clone();
        assertTrue(clone.equals(state1));
        assertNotSame(state1, clone);

    }

}