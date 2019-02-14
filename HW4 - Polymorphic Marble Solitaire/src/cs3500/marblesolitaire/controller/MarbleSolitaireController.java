package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This interface represents the controls offered by MarbleSolitaire. It runs the game by taking in
 * input and printing the game state.
 */
public interface MarbleSolitaireController {

  /**
   * This method plays a new game of the MarbleSolitaire using the provided model. It should
   * throw and IllegalArgumentException if the provided model is null. It should throw an
   * IllegalStateException only if the controller is unable to to successfully receive input or
   * transmit output.
   *
   * <p>This method will transmit the game state from the given model to the Appendable object
   * exactly like the model provides. It transmits the score from the model.
   *
   * <p>If the game is ongoing, it obtains the next user input from the Readable object. The user
   * input is made up of four integers. The first is the row number to move from, the second is the
   * column number to move from, the third is the row to move to and the fourth is the column to
   * move to. To make the game more user friendly, all inputs start from 1.
   *
   * <p>If the game is over, the message "Game over!" is added to the transmission.
   *
   * <p>At any point, if the next value is 'q' or 'Q', it will transmit the message "Game quit!"
   * with the final game state after it.
   *
   * <p>If there are any unexpected inputs, it will ask the user to re-enter that value again. Once
   * all four values are read, if the model signals the move as invalid, the Appendable object will
   * transmit the message "Invalid move. Play again. X", where X describes why the input was
   * invalid.
   *
   * @param model is the model provided to this controller.
   * @throws IllegalArgumentException if the provided model is null.
   * @throws IllegalStateException if the controller cannot receive input or transmit output.
   */
  void playGame(MarbleSolitaireModel model);
}
