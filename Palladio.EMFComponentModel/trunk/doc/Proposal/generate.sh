#!/bin/bash

PREFIX="feinentwurf"
LATEX=pdflatex
# Alternative:
#LATEX=latex

# LaTeX
${LATEX} ${PREFIX}

# Bibtex
bibtex ${PREFIX}

# Index erzeugen
makeindex <${PREFIX}.idx> index.tex

# Glossar erzeugen
makeindex ${PREFIX}.glo -s nomencl.ist -o ${PREFIX}.gls

# Abkürzungen ?!?
# TODO

# LaTeX
${LATEX} ${PREFIX}
