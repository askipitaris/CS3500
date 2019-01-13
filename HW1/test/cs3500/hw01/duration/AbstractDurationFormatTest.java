package cs3500.hw01.duration;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** Tests for the format method of {@link Duration}s. 
    Add your tests to this class to assure that your format 
    method works properly
*/
public abstract class AbstractDurationFormatTest {
  @Test
  public void formatExample1() {
    assertEquals("4 hours, 0 minutes, and 9 seconds",
                  hms(4, 0, 9)
                    .format("%h hours, %m minutes, and %s seconds"));
  }

  @Test
  public void formatExample2() {
    assertEquals("4:05:17",
                  hms(4, 5, 17).format("%h:%M:%S"));
  }

  // ADD MORE TESTS HERE
  // Your tests must only use hms(...) and sec(...) to construct new Durations
  // and must *not* directly say "new CompactDuration(...)" or
  // "new HmsDuration(...)"

  @Test
  public void formatExample3() {
    assertEquals("04:07:22",
        hms(4, 7, 22).format("%H:%M:%S"));
    assertEquals("04 hours, 07 minutes and 22 seconds",
        hms(4, 7, 22).format("%H hours, %M minutes and %S seconds"));
  }

  @Test
  public void formatExamples4() {
    assertEquals("1 hour is 50% of the movie",
        hms(1, 0, 0).format("%h hour is 50%% of the movie"));
    assertEquals("3600 seconds is 50% of the movie",
        hms(1, 0, 0).format("%t seconds is 50%% of the movie"));
  }

  @Test
  public void testDoubleSpecificers() {
    assertEquals("240",
        hms(0, 4, 0).format("%t"));
    assertEquals("%t",
        hms(0, 4, 0).format("%%t"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMalformed() {
    hms(0, 5, 1).format("%y");
  }

  /*
    Leave this section alone: It contains two abstract methods to
    create Durations, and concrete implementations of this testing class
    will supply particular implementations of Duration to be used within 
    your tests.
   */
  /**
   * Constructs an instance of the class under test representing the duration
   * given in hours, minutes, and seconds.
   *
   * @param hours the hours in the duration
   * @param minutes the minutes in the duration
   * @param seconds the seconds in the duration
   * @return an instance of the class under test
   */
  protected abstract Duration hms(int hours, int minutes, int seconds);

  /**
   * Constructs an instance of the class under test representing the duration
   * given in seconds.
   *
   * @param inSeconds the total seconds in the duration
   * @return an instance of the class under test
   */
  protected abstract Duration sec(long inSeconds);

  public static final class HmsDurationTest extends AbstractDurationFormatTest {
    @Override
    protected Duration hms(int hours, int minutes, int seconds) {
      return new HmsDuration(hours, minutes, seconds);
    }

    @Override
    protected Duration sec(long inSeconds) {
      return new HmsDuration(inSeconds);
    }
  }

  public static final class CompactDurationTest extends AbstractDurationFormatTest {
    @Override
    protected Duration hms(int hours, int minutes, int seconds) {
      return new CompactDuration(hours, minutes, seconds);
    }

    @Override
    protected Duration sec(long inSeconds) {
      return new CompactDuration(inSeconds);
    }
  }
}
