To get transient (derived) attributes, you need to modify the generated .ecore model after you have reloaded the genmodel. This is how to do it

Export you model from RSA to uml
Reload the CostModel-4.genmodel. It will also generate or update the cost.ecore
Open the cost.ecore and make sure that all derived attributes have the EAttribute value transient=true
After you have checked (and changed) that, you can regenerate the model, edit and editor code. 


Use LabelProvider: 
edit <modelname>Editor.java in your editor code. Change one attribute and two methods as done in the designdecision editor. 
