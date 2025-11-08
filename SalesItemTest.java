import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test name", 1000);
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
    }
    
    @Test
    public void testDuplicateAuthor(){
        SalesItem item = new SalesItem("Rubber Ducking", 12345);
        boolean first = item.addComment("Fallon", "Great book", 4);
        assertEquals(true, first);
        boolean second = item.addComment("Fallon", "Not bad, but not good", 2);
        assertEquals(false, second);
    }
    
    @Test
    public void testIllegalRatingBoundaries(){
        SalesItem item = new SalesItem("Ducking", 12345);
        assertEquals(false, item.addComment("Fallon", "Just bad", -1));
        assertEquals(false, item.addComment("Bod", "Not bad, but not good", 6));
    }
     
    @Test
    public void testFindMostHelpfulComment(){
        SalesItem item = new  SalesItem("Book", 111);
        item.addComment("Fallon", "Great", 4);
        item.addComment("Chris", "Bad", 1);
        item.addComment("Bob", "Okay", 3);
        
        item.upvoteComment(0);
        item.upvoteComment(1);
        item.upvoteComment(1);
        item.upvoteComment(2);
        
        Comment best = item.findMostHelpfulComment();
        
        assertNotNull(best);//Make sure that something is returned
        assertEquals("Chris", best.getAuthor());//check correct author
        assertEquals(2, best.getVoteCount());//Checks vote count
    }
    
    @Test
    public void testRemoveCommentValidIndex(){
        SalesItem item = new  SalesItem("Book", 111);
        item.addComment("Fallon", "Great", 4);
        item.addComment("Bob", "Okay", 3);
        
        item.removeComment(0);
        
        assertEquals(1, item.getNumberOfComments());
        assertEquals("Bob", item.findMostHelpfulComment().getAuthor());
    }
    
    @Test
    public void testRemoveCommentInvalidIndex(){
        SalesItem item = new  SalesItem("Book", 111);
        item.addComment("Fallon", "Great", 4);
        item.addComment("Bob", "Okay", 3);
        
        item.removeComment(3);//index 3 doesnt exists, so nothing should happen
        
        assertEquals(2, item.getNumberOfComments());//Still has two comments
        
    }
    @Test
    public void testPriceString(){
        SalesItem item = new  SalesItem("Book", 12345);
        
        assertEquals("$123.45", item.priceString(12345));
        assertEquals("$1.00", item.priceString(100));
        assertEquals("$1.09", item.priceString(109));
        assertEquals("$0.05", item.priceString(5));
    }
}
