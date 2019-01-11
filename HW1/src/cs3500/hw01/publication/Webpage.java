package cs3500.hw01.publication;

//
public class Webpage implements Publication {
  String title;
  String url;
  String retrieved;

  /**
   * Constructs a Webpage.
   *
   * @param title     the title of the webpage
   * @param url       the url of the webpage
   * @param retrieved the date retrieved
   */

  public Webpage(String title, String url, String retrieved) {
    this.title = title;
    this.url = url;
    this.retrieved = retrieved;
  }

  /**
   * Formats a citation in APA style.
   *
   * @return the formatted citation
   */
  @Override
  public String citeApa() {
    return title + ". Retrieved " + retrieved + ", " + url + ".";
  }

  /**
   * Formats a citation in MLA style.
   *
   * @return the formatted citation
   */
  @Override
  public String citeMla() {
    return "\"" + title + ".\" Web. " + retrieved + " <" + url + ">.";
  }
}
