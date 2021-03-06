package cs3500.hw01.duration;

/**
 * Durations represented as hours, minutes, and seconds.
 */
public final class HmsDuration extends AbstractDuration {

  /**
   * Constructs a duration in terms of its length in hours, minutes, and seconds.
   *
   * @param hours the number of hours
   * @param minutes the number of minutes
   * @param seconds the number of seconds
   * @throws IllegalArgumentException if any argument is negative
   */
  public HmsDuration(int hours, int minutes, int seconds) {
    this(inSeconds(hours, minutes, seconds));
    ensureHms(hours, minutes, seconds);
  }

  /**
   * Constructs a duration in terms of its length in seconds.
   *
   * @param inSeconds the number of seconds (non-negative)
   * @throws IllegalArgumentException {@code inSeconds} is negative
   */
  public HmsDuration(long inSeconds) {
    if (inSeconds < 0) {
      throw new IllegalArgumentException("must be non-negative");
    }

    seconds = secondsOf(inSeconds);
    minutes = minutesOf(inSeconds);
    hours = hoursOf(inSeconds);
  }

  private final int hours;
  private final int minutes;
  private final int seconds;

  @Override
  protected AbstractDuration fromSeconds(long seconds) {
    return new HmsDuration(seconds);
  }

  @Override
  public String format(String template) {
    String output = "";

    for (int i = 0; i < template.length(); i++) {
      if (template.charAt(i) == '%') {
        i++;
        if (i >= template.length()) {
          throw new IllegalArgumentException("Malformed template");
        } else if (template.charAt(i) == 'H') {
          output += String.format("%02d", hours);
        } else if (template.charAt(i) == 'h') {
          output += String.format("%d", hours);
        } else if (template.charAt(i) == 'M') {
          output += String.format("%02d", minutes);
        } else if (template.charAt(i) == 'm') {
          output += String.format("%d", minutes);
        } else if (template.charAt(i) == 'S') {
          output += String.format("%02d", seconds);
        } else if (template.charAt(i) == 's') {
          output += String.format("%d", seconds);
        } else if (template.charAt(i) == '%') {
          output += "%";
        } else if (template.charAt(i) == 't') {
          output += inSeconds();
        } else {
          throw new IllegalArgumentException("Malformed template");
        }
      } else if (template.equals("")) {
        return "";
      } else {
        output += template.charAt(i);
      }
    }
    return output;
  }

  @Override
  public long inSeconds() {
    return inSeconds(hours, minutes, seconds);
  }

  @Override
  public String asHms() {
    return asHms(hours, minutes, seconds);
  }
}