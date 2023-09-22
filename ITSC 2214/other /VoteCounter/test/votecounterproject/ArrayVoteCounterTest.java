package votecounterproject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @version Spring 2019
 * @author clatulip
 */
public class ArrayVoteCounterTest {

    private ArrayVoteCounter voteCounter;

    /**
     * Initialization before any test methods are run.
     * @throws Exception 
     */
    @Before
    public void setUp() throws Exception {
        voteCounter = new ArrayVoteCounter();
        /*
        Data Legend:
            [0] = "Darth Sidius"
            [1] = "Darth Maul"
            [2] = "Darth Vader"
            [3] = "Darth Plagueis"
         */
    }

    /**
     * A simple test of the recordVote method.  (A better test would include
     * votes for multiple candidates and a few spoiled votes as well.)
     */
    @Test
    public void recordVote() {
        assertEquals(voteCounter.getVoteIndex(), 0);
        // Generate 20 votes for Darth Vader
        for (int i = 0; i < 10; i++) {
            voteCounter.recordVote("Darth Vader");
            assertEquals(i + 1, voteCounter.getVoteIndex());
            assertEquals(i + 1, voteCounter.getMemberVotes("Vader"));
        }
    }

}