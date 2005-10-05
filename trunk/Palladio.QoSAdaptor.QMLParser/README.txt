Most of the classes in QMLParser have been copied unchanged from the QmlPad
project of Lars Karg. Small changes have been made due to adjustments regarding 
antlr.runtime version 2.7.5 since 2.7.2 has been used before. QMLLexer.cs, 
QMLParser.cs, QMLTokenTypes.cs and QMLTokenTypes.txt have been newly generated 
with Antlr 2.7.5 using the grammar in qml.q by Lars Karg.
For future work with a QML parser the parser by Lars Karg is recommended, 
because it will be better administered and tested and is planned to be updated 
to antlr 3.x when it will be available and should also work with antlr 2.75 by 
now. I decided to build a new parser from the grammar by Lars Karg myself for 
this project, because it was the fastest way to get a working version for the 
currently avaiable antlr version. As mentioned before some minor changes were
made and so it can not be guaranteed that the parser will work as good as the 
original version of Lars Karg and it has to be mentioned that it was only 
tested with the examples used to test the whole Palladio.QoSAdaptor 
application, where it seems to work without any problems.