=================================================
 How to customize the PCM Eclipse Distribution 
=================================================

*** Please note the following order settings! ***

---------------------------------------------------------------------------------------------------
 Table Of Contents 
---------------------------------------------------------------------------------------------------

  (1) Preparation
  (2) Configuration File: "config.ini"
  (3) Run-Configuration
  (4) Configuration tab of the Product
  (5) Configuration File: "plugin_customization.ini"
  (6) Troubleshooting

  
---------------------------------------------------------------------------------------------------
(1) Preparation 
---------------------------------------------------------------------------------------------------

  * Install Eclipse 3.3.2 + Palladio Component Model
    (http://sdqweb.ipd.uka.de/wiki/Palladio_Component_Model)
  * Import org.eclipse.sdk from Plug-ins as source in your workspace.
  * Create a product with the wizard.
  * Don't create a product with the button "New...", because it impedes the Universal Welcome Page 
    of the Eclipse IDE.


---------------------------------------------------------------------------------------------------
(2) Configuration File: "config.ini"
---------------------------------------------------------------------------------------------------

  * File location: root path of the Plug-in.
  * Set the path for the PCM-Splash in the config.ini (root path of the Plug-in) with the entry: 
    "osgi.splashPath = platform:/base/plugins/org.eclipse.sdk" (without quotation mark)


---------------------------------------------------------------------------------------------------
(3) Run-Configuration
---------------------------------------------------------------------------------------------------

  * Menu: Run > Open Run Dialog...
  * Tab Main: Choose the Eclipse own product in the Run-Config: org.eclipse.sdk.ide.
  * Tab Plug-ins: Select ALL plug-ins for the target.
  * Be sure that there are no conflicts by clicking on Validate Plug-ins. After that the message 
    should say "No problems were detected.".
    -> Please look at (6) Troubleshooting > Plug-in conflicts if you have any conflicts.


---------------------------------------------------------------------------------------------------
(4) Configuration tab of the Product
---------------------------------------------------------------------------------------------------

  * Add all plug-ins to the configuration and additionally click on "Add required Plug-ins"
  * The count of the Plug-ins should display the same count as in the Run-Config less 1 (the 
    Product itself).
  * Substitute the Eclipse icons with the PCM ones in an arbitrary directory, but by conventions 
    use the directory "icons"
  * Set the paths for the PCM icons for the launcher an the use of an existing config.ini and the 
    other settings for the PCM Eclipse.


---------------------------------------------------------------------------------------------------
(5) Configuration File: "plugin_customization.ini"
---------------------------------------------------------------------------------------------------

  * File location: root path of the Plug-in.
  
  * Default perspective on the Perspective Bar: [Insert the following entry without quotation mark]
      "org.eclipse.ui/defaultPerspectiveId = org.eclipse.jdt.ui.JavaPerspective"
      (for the Java perspective; for other perspectives you must research the correct id)
  
  * Add perspectives to the Perspective Bar: [Insert the following entry without quotation mark]
      "org.eclipse.ui/PERSPECTIVE_BAR_EXTRAS = de.uka.ipd.sdq.codegen.simudatavisualization
        .SimuBenchPerspective"
      (for the SumuBench perspective)
      
      
---------------------------------------------------------------------------------------------------
(6) Troubleshooting
---------------------------------------------------------------------------------------------------
  
  * If your Editor - which you use for the configuration files - has Unix standard settings (i.e. 
    word wrap coding, format, etc.), it can produce some errors which are hardly understandable.
  * Plug-in conflicts: The using of an Eclipse distribution (e.g. Yoxos) can implicate a lot of
    troubles with Plug-in- conflicts (e.g. wrong versions) so it is recommended to use the original 
    Eclipse RCP Package from eclipse.org as the development environment.
    -> At the moment the project is not compatible with Eclipse Ganymede 3.4.x.
  * Renaming the Plug-in project: This is forbidden because of reference problems.
  
===================================================================================================  