This plugin contains classes related to displaying elements of the PCM in various JFace viewers 
and later on other GUI related stuff.

Package ui.provider:
This contains an ItemProvider and its Factory for default displaying of PCM model instances in
JFace viewers

Package ui.provider.categoryaware:
This contains an generic ItemProvider which is able to show content using user defined categories 
which get inserted into tree display. The generated ItemProviders render all children equally which is
not what you like to have. Hence, use the category item provider to distinguish the children of 
container objects into several classes/categories. The categories have to be disjunct.