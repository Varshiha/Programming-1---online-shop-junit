

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    private Comment comment;
    
    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
    {
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        comment = new Comment("Adam", "Wow", 4);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        comment = null;
    }
    @Test
    public void testAuthorRatingStoredCorrectly(){
        assertEquals("Adam", comment.getAuthor(), "Author should be Adam");
        assertEquals(4, comment.getRating(), "Rating should be 4");
        
    }
    @Test
    public void testUpvote(){
        comment.upvote();
        assertEquals(1, comment.getVoteCount(), "Vote count = 1 after one upvote");
        comment.upvote();
        assertEquals(2, comment.getVoteCount(), "Vote count = 2 after two upvote");
    }
    @Test
    public void testDownvote(){
        comment.downvote();
        assertEquals(-1, comment.getVoteCount(), "Vote count = -1 after one dwonvote");
        comment.downvote();
        assertEquals(-2, comment.getVoteCount(), "Vote count = -2 after two downvote");
    }
}