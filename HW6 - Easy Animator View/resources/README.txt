Design choices for views

There is a view interface (IView) which all the views implement. IView has the most basic functionality
for a view. AbstractViewClass abstracts two fields, a model and int speed.

Use of BuilderPattern



SVG View
Simply outputs the animation as an SVG file. Depending on the shape, the SVG is outputted differently, since
each shape has different SVG tags.

Textual View
Simply outputs the animation as text in either a .txt file or in the console. Very similar to the svg view.
If the file that the user specifies does not exist, then it is created. If the file does exist, then it is
overwritten.


Visual View
This view runs the animation in its own window. It reads from a file, and creates KeyFrames that it then interpolates
each Keyframe. the interpolate function calculates the state of that Keyframe at a particluar moment in time.
The VisualView class creates the JFrame that the VisualPanel will be displayed in.
All of the animation is created in the VisualPanel, most of the functionality occurs here.

In the VisualPanel class, the paintComponent, draws each Keyframe, which displays the image on the panel.
The tick is incremented in the ActionPerformedMethod.
