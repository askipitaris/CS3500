General:
We have a lot of private helper methods that are not being tested. All public methods are being
tested. To get any private or protected fields, we use public get methods.

model.action:
We wanted to store an action as an object because that makes it easy to manipulate a deal with.
Actions have a start and endTime, shape, movement, colorChange and a multiple to grow by.

model.shape:
We have an IShape interface that has all the methods that all shapes will implement.
We used an AbstractShape class because there are a lot of shared fields and common implementations
of methods.
Special shapes are extend the more basic versions (square extends rectangle, circle extends ellipse)

model:
Our AnimatorModel interface is the actual model. It has all the common methods. It has a getState
method that returns all queued actions as text. It has a runAnimation that runs all the queued
actions and changes the objects.

We thought that the shapes should not be responsible for moving themselves so they are all
controlled by the model.

We decided to use java.awt.Color instead of making our own Color class because there real need to
just yet. It easier to use the existing implementation for now. If it becomes a problem in the
future, we are open to creating our Color class.

The user does not have to create a shape or action before they are added to the model. When the user
wants to create either, they give the relevant addAction/Shape method all the arguments and the
model creates the shape in the method body.

Throughout the process, we were unsure of the best way to keep track of the tick, which will run
the animations. For now, we think that the controller will be responsible for maintaining the tick
and have tried to build our model around that.

posn:
We wanted to hold the location of shapes as a Posn because it is easy to work with and we have used
them a lot in the past.