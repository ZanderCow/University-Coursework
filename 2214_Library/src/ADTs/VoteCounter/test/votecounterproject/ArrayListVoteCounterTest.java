package votecounterproject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @version Spring 2019
 * @author clatulip
 * Slightly modified for Fall 2022 by Bruce Long
 * @since 08-29-2022
*/
public class ArrayListVoteCounterTest {

    private ArrayListVoteCounter voteCounter;

    /**
     * Initialization before any test methods are run.
     * @throws Exception 
     */
    @Before
    public void setUp() throws Exception {
        this.voteCounter = new ArrayListVoteCounter();
        /*
        Data Legend:
            [0] = "Darth Sidius"
            [1] = "Darth Maul"
            [2] = "Darth Vader"
            [3] = "Darth Plagueis"
         */
    }

    /**
     * Tests the recordVote method.
     */
    @Test
    public void recordVote() {
        
       // are both the votes and spoiled votes ArrayLists are empty.
        assertTrue(voteCounter.getVotes().isEmpty());
        assertTrue(voteCounter.getSpoiledVotes().isEmpty());
        
        // Record some votes for one or more of the candidates. Use the legend 
        // above for clarification.
        for (int i = 0; i < 5; i++) {
            voteCounter.recordVote("Darth Vader");
        }
        
        //do the candidates actually receive the appropriate votes.
        assertEquals(voteCounter.getSithSenateMemberVotes("Darth Vader"), 5);
      
        
        // did the vote list has increase
        assertTrue(voteCounter.getVotes().size() > 0);

        
    }

}