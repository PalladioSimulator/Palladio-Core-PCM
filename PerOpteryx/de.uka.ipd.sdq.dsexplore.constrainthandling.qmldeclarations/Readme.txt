README

Quickstart to get qml declaration that simply optimizes:
1) Rename [default]PCMObjectives.qmldeclarations to PCMObjectives.qmldeclarations
2) Rename [Example]PCMProfile.qmldeclarations (optional). Load the absolute path 
   of the UsageModel you want to optimize and choose the Model in the 
   SimpleQMLProfile and choose the UsageScenario you want to optimize in the 
   UsageScenarioRequirement.
   !!!: The qml editor is still buggy, therefore the changes need to be done 
      manually in XML (Change absolute path of UsageModel and id of UsageScenario).
3) Chose the above QML profile in launch config

Note: Until the QML support matured, don't use refinements and use 1 file per qml definition.