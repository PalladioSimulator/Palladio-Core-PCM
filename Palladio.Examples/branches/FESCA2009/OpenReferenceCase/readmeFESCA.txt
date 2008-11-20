--------------------------------------------------------------------
PCM Model Instance of CoCoME
--------------------------------------------------------------------
see:
- http://cocome.org/
- http://sdqweb.ipd.uka.de/wiki/CoCoME-PCM
--------------------------------------------------------------------


--------------------------------------------------------------------
Adaptation of ORC for FESCA 2009 Paper
--------------------------------------------------------------------

- mehr Komplexität für Application.Store.bookSale():
  - zusätzlicher Branch innerhalb des Loop mit zwei Verzweigungen
  - zusätzliche Faktor für die Anzahl der Schleifendurchläufe 
- begin / commit transaction hat eine Fehlerwahrscheinlichkeit von: 0.000001
- ändere Data.Store.queryStockItem():
  - enthält nur noch eine Database-Query-Anfrage (Vereinfachung)
  
  
--------------------------------------------------------------------
Lessons learned
--------------------------------------------------------------------

- Ein Integer kann in einer StochasticExpression nicht mit einem Double multpliziert werden!
- Der DependencySolver kann nur mit ganzzahligen LoopIteration-Counts arbeiten!  