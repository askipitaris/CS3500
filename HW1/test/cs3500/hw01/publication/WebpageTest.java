package cs3500.hw01.publication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

// Tests for citing a Webpage
public class WebpageTest {

  Webpage courseSite = new Webpage("CS 3500: Object-Oriented Design",
      "https://course.ccs.neu.edu/cs3500/", "Jan 10, 2019");

  /**
   * Tests APA formatting for webpage citations
   */
  @Test
  public void testCiteApa() {
    assertEquals("CS 3500: Object-Oriented Design. Retrieved Jan 10, 2019, "
        + "https://course.ccs.neu.edu/cs3500/.", this.courseSite.citeApa());
  }

  /**
   * Tests incorrect APA formatting for webpage citations
   */
  @Test
  public void testCiteApaWrong() {
    assertNotEquals("This is formatted incorrectly!",
        "Retrieved Jan 10, 2019, CS 3500: Object-Oriented Design. "
        + "https://course.ccs.neu.edu/cs3500/.", this.courseSite.citeApa());
  }

  /**
   * Tests MLA formatting for webpage citations
   */
  @Test
  public void testCiteMla() {
    assertEquals("\\CS 3500: Object-Oriented Design.\\ Web. Jan 10, 2019 "
        + "<https://course.ccs.neu.edu/cs3500/>", this.courseSite.citeMla());
  }

  /**
   * Tests incorrect MLA formatting for webpage citations
   */
  @Test
  public void testCiteMlaWrong() {
    assertNotEquals("This is formatted incorrectly!",
        "Retrieved Jan 10, 2019, https://course.ccs.neu.edu/cs3500/. "
            + "CS 3500: Object-Oriented Design.", this.courseSite.citeMla());
  }
}