This folder contains the PCMBench Plugins.

--- Intro ---
The PCMBench is a nice Eclipse based GUI Editor for the Palladio Component Model. It is designed to easy the construction of 
PCM model instances by offering specialised GUI editors and property sheet, workflow support, wizards, etc.

This is still a development version, no stable release exists.

--- Getting started ---
To get started compile the source and run the plugins as an Eclipse application. Create a new Palladio Component Model
project using the New Project wizard. Note: The project name is no longer hardcoded in other parts so you can now use abitrary 
project names for the GMF integration to work. However, the whole thing is still a major construction site :-)

Switch the perspective to "PCMBench". You should see a specialised Navigator, a Resource view, a property sheet and an outline.

Right click in the resource view and select "Open repository..." Navigate to a PCM repository (e.g., the one which
is in SVN under the Palladio.EMFModel module called QoSA06). The repository should appear in the navigator and the resource
view.  If you select a component or interface in the Navigator the property sheet should show a tabbed property editing
possibility. Right click on repository elements in the Navigator to create new elements. Double click on any Service Effect
Specification to open a GMF editor for the SEFF. Note: In the current state open only _ONE_ SEFF editor at a given time.

NOTE: The code is still highly experimental and not usable in daily life...
