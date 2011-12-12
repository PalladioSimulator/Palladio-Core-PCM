This folder should contain, among others, the files "up.gif" and "down.gif". As of now (November 27th, 2011), those files
are not in use. Initially, they were meant as symbols indicating whether certain (HTML) tables are sorted ascendingly (up arrow),
or descendingly (down arrow).

Since images cannot be embedded directly (binarily) in HTML code (one may only include a link to an image in the code)
and since we--currently--do not want to output/write the two image files in addition to the HTML page, we have decided
to remove any code occurences that included the up and down arrow images. Instead, we now use normal text that indicates
whether a table is sorted ascendingly or descendingly.

This may be a temporary state and you can always modify the code to include the images again, instead of the textual solution.
To do so, modifications of the "jsComponents.css" and "jsComponents.js" files are needed. Or, you can simply browse to [1]
and download the code in its original state, which makes use of the up and down arrow images.


	Daniel Patejdl

-----
[1]: http://www.dgroth.de/jsComponents/