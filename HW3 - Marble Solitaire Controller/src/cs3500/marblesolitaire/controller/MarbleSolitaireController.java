package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * This interface represents the controls offered by MarbleSolitaire. It runs the game
 * by taking in input and printing the game state.
 */
public interface MarbleSolitaireController {
  /**
   * This method plays a new game of the MarbleSolitaire using the provided model. It should
   * throw and IllegalArgumentException if the provided model is null. It should throw an
   * IllegalStateException ONLy if the controller is unable to to successfully receive input
   * or transmit output.
   *
   * @param model is the model provided to the new game.
   * @throws IllegalArgumentException if the provided model is null.
   * @throws IllegalStateException if the controller cannot receive input or transmit output.
   */
  void playGame(MarbleSolitaireModel model);
}
