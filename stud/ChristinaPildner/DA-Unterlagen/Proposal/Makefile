#################################################################
# Makefile (use GNU-Make)
# ---------------------------------------------------------------
# $Id: Makefile,v 1.2 2001/01/24 20:00:39 bless Exp bless $
# ---------------------------------------------------------------
# $* file name part of the current dependent with suffix deleted
#    (only for suffix rules)
# $@ full target name
# $< out-of-date module (only for suffix rules)
# $? list of components to be rebuilt
#
#################################################################

.DEFAULT:
	  @echo "This target needs remaking: default = [$<]"
	  @echo "Do you really use GNU-Make?"

MAINFILE       := diplarb
TITLEPAGE      := titelseite
TEXSOURCES     := $(wildcard *.tex)
BIBSRCFILES    := $(wildcard *.bib) 
BBLFILES       := $(subst bib,bbl,$(BIBSRCFILES))
AUXFILES       := $(subst tex,aux,$(TEXSOURCES))
SCRIPTDIR      := scripts

SOURCES = dipdoc.cls\
	  diplarb.tex\
	  diplarb.ist\
          macros.tex\
	  titelseite.tex\
	  erklaerung.tex\
	  einleitung.tex\
          analyse.tex\
          entwurf.tex\
          implemen.tex\
          zusammenf.tex\
	  Makefile

# FIGS = pics/fig*.fig

# PICS = pics/*.eps

# FOLIEN = folien/dafolien.tex

$(MAINFILE).dvi: $(MAINFILE).tex  \
		 wissdoc.cls $(TEXSOURCES) $(BBLFILES)
	   - makeindex -g -s diplarb.ist diplarb.idx
	   - latex $(MAINFILE)


it:
	@rm -f $(MAINFILE).dvi
	- latex $(MAINFILE)

#$(AUXFILES): %.aux: %.tex
#             latex $(MAINFILE)

$(BBLFILES): %.bbl: %.bib
	- latex $(MAINFILE)
	- bibtex $(MAINFILE)

final: it bbls double index ps

double: $(MAINFILE).tex
	 - latex $(MAINFILE)
	 - latex $(MAINFILE)

complete: $(MAINFILE).dvi
	 - latex $(MAINFILE)
	 - latex $(MAINFILE)

index: $(MAINFILE).ind

#makeindex kann keine 8-bit Umlaute richtig sortieren! :-(
#deswegen setzen wir sie für makeindex einfach nochmal um
$(MAINFILE).ind: $(MAINFILE).idx $(MAINFILE).ist
	- mv $(MAINFILE).idx $(MAINFILE).idx.orig
	- $(SCRIPTDIR)/recodetexumlaut <$(MAINFILE).idx.orig >$(MAINFILE).idx
	- makeindex -g -s $(MAINFILE).ist $(MAINFILE)
	- mv $(MAINFILE).idx.orig $(MAINFILE).idx

ps: $(MAINFILE).ps

$(MAINFILE).ps:	$(MAINFILE).dvi
	dvips -K -o $(MAINFILE).ps $(MAINFILE).dvi


#Für ein vernünftiges PDF wird benötigt:
# pdftex >=0.14e
# pdftex.def >=v0.02r
# hyperref.sty >= 6.69
# thumbpdf >=1.11
# ghostscript 6.50
finalpdf: pdf
	- thumbpdf $(MAINFILE)
	- pdflatex $(MAINFILE)

pdf:    $(MAINFILE).pdf  $(MAINFILE).ind

onepdf: 
	- pdflatex $(MAINFILE)

$(MAINFILE).pdf: $(MAINFILE).tex $(TEXSOURCES)
	- rm $(MAINFILE).aux $(MAINFILE).ind
	- pdflatex $(MAINFILE)
	- make bbls
	- pdflatex $(MAINFILE)
	- $(MAKE) index
	- pdflatex $(MAINFILE)


bbls: $(BBLFILES)


rmbbls:
	- rm $(BBLFILES)


view: $(MAINFILE).dvi
	xdvi $@ &

zipps: $(MAINFILE).ps
	       gzip -p $(MAINFILE).ps

folien: folien/dafolien.dvi
	(cd folien; dvips -K -t a4 -t landscape dafolien)

folien/dafolien.dvi: $(FOLIEN)
	    	     (cd folien; latex dafolien)

viewf: 
	(cd folien; xdvi -paper a4r dafolien) &

final: 
	dvips -K -t a4 diplarb

clean:
	- find . | egrep ".*((\.(aux|idx|ind|ilg|log|blg|bbl|toc|lof|lot|dvi|tlf|tlt))|~)$$" | xargs rm
	- rm $(MAINFILE).out thumb???.png thumbdta.tex thumbpdf.*

archive:
	 - @ echo "Making archive..."
	 - gtar -czvf $(MAINFILE).tar.gz $(SOURCES)  pics/*.ps pics/*.eps Makefile 
	 - @ echo "Archive ready."

save:
	- @ echo -n "Copying to DOS disk..."
	@ mcopy -no $(MAINFILE).tar.gz A:$(MAINFILE).tgz
	- @ echo "ready."


pics/%.eps: pics/fig/%.fig
	fig2dev -L ps $< $@
#end of Makefile


