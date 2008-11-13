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
  - zusätzlicher Branch innerhalb des Loop
  - zusätzliche Faktor 0.95 für die Anzahl der Schleifendurchläufe
- alle primitiven Operationen der Datenbank haben eine Fehlerwahrscheinlichkeit von: 0.00001
- ändere Data.Store.queryStockItem():
  - enthält nur noch eine Database-Query-Anfrage (Vereinfachung)