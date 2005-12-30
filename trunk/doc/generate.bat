::!/bin/bash

set PREFIX=feinentwurf
set LATEX=pdflatex
:: Alternative:
:: LATEX=latex

:: LaTeX
::@ %LATEX% %PREFIX%

:: Bibtex
@bibtex %PREFIX%

:: Index erzeugen
@makeindex %PREFIX%.idx index.tex

:: Glossar erzeugen
@makeindex %PREFIX%.glo -s ../shared/nomencl.ist -o %PREFIX%.gls

pause