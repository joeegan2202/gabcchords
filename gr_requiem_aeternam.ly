\version "2.22.0"
\include "gregorian.ly"
\include "noh2.ily"

global = {
  \cadenzaOn
  \override Glissando #'thickness = #2.0
}

%\header {
%  title = \markup \center-column {"Agnus Dei I." \vspace #1 }
%  tagline = ""
%  composer = ""
%}

%\paper {
%  #(include-special-characters)
%  oddHeaderMarkup = \markup \fill-line {
%    \line {}
%    \center-column {
%      \on-the-fly #first-page     " "
%      \on-the-fly #not-first-page ""
%    }
%    \line { \on-the-fly #print-page-number-check-first \fromproperty #'page:page-number-string }
%  }
%  evenHeaderMarkup = \markup \fill-line {
%    \line { \on-the-fly #print-page-number-check-first \fromproperty #'page:page-number-string }
%    \center-column { "" }
%    \line {}
%  }
%}

chantText = \lyricmode {
	RE -- QUI -- EM \set stanza = "*"
 ae -- tér -- _ _ _ nam do -- _ na e -- is _ Dó -- _ mi -- ne: _ _ _ _ _ et lux per -- pé _ _ _ _ _ tu -- a _ _ _ lú -- _ \set stanza = "_"
 ce -- at e -- _ is. _ _ _ _ _ _ _ _ _ \set stanza = "℣."
 In me -- mó -- ri -- a ae -- tér _ _ _ _ _ _ _ _ \set stanza = "_"
 _ _ \set stanza = "_"
 na e -- _ _ _ rit ju _ _ _ _ _ _ _ _ _ stus: ab au -- di -- ti -- ó -- ne ma _ _ _ _ la _ _ _ \set stanza = "*"
 non _ \set stanza = "_"
 ti -- mé -- _ bit. _ _ _ 
}

chantMusic = {
  \tieDown
	\key a \major
e'4( gis'4 fis'4) fis'4 fis'4 

fis'4 a'4( fis'4 gis'4) a'4( fis'4 e'4) gis'4( e'4) fis'4( gis'4) fis'4 
\divisioMaior
a'4( fis'4) a'4( b'4 cis''4) a'4( gis'4 fis'4) 
\bar "" \break

fis'4 fis'4( e'4) g'4( fis'4 e'4) 
\divisioMinima
e'4( d'4) fis'4( e'4 fis'4) fis'4( e'4 fis'4) fis'4( d'4) e'4( fis'4) a'4( a'4 fis'4 e'4.) fis'4( \quil gis'4 a'4) b'4( a'4 a'4) fis'4( gis'4 fis'4) 
\bar "" \break

\divisioMaxima
a'4( a'4) 
a'4 
a'4 a'4( gis'4) a'4( b'4) cis''4( a'4 gis'4) a'4( a'4 gis'4) 
\divisioMinima
b'4( a'4) b'4( a'4 fis'4) fis'4 fis'4( a'4 fis'4 e'4) fis'4( a'4 a'4 fis'4.) a'4( a'4 gis'4 fis'4) a'4( e'4 e'4 d'4) 
\bar "" \break

\divisioMaxima
d'4( e'4 fis'4) a'4( gis'4 fis'4 gis'4) e'4 fis'4 
a'4( fis'4) a'4( b'4) b'4( a'4) b'4( cis''4 b'4 a'4) 
\divisioMinima
cis''4( a'4) cis''4( d''4 b'4 gis'4) a'4( fis'4 e'4.) fis'4( \quil gis'4 a'4) b'4. a'4( b'4 cis''4) 
\bar "" \break

\divisioMinima
b'4( cis''4 b'4 cis''4 a'4 fis'4) \quil gis'4( a'4 fis'4) 
\finalis
fis'4 
a'4 a'4( b'4) b'4 b'4 
b'4( cis''4) cis''4( b'4 a'4 gis'4) a'4( fis'4 e'4) 
\divisioMinima
gis'4( e'4) fis'4( a'4 a'4) b'4( cis''4 b'4 cis''4) 
\bar "" \break

\divisioMinima
a'4( cis''4) d''4( b'4 gis'4) a'4( fis'4 e'4.) fis'4( gis'4 fis'4 e'4 fis'4) 
\divisioMinima
b'4( \quil cis''4 d''4 cis''4) d''4( cis''4 b'4 cis''4) cis''4( b'4) 
\divisioMaxima
b'4( \quil cis''4) d''4( cis''4 b'4) \quil cis''4 d''4( cis''4 b'4) b'4( cis''4) 
\bar "" \break

cis''4( a'4) cis''4( b'4 a'4) a'4( fis'4.) a'4( a'4 fis'4) a'4. a'4( a'4 a'4 fis'4) 
\divisioMinima
a'4( b'4) cis''4( b'4 a'4) cis''4( b'4 a'4) b'4( fis'4) fis'4 
\bar "" \break

\divisioMaxima
a'4( a'4) 
a'4 a'4 a'4 a'4 a'4( b'4) 
b'4( a'4 gis'4 e'4.) fis'4( a'4 gis'4 e'4) fis'4( a'4) 
\divisioMinima
gis'4( b'4) cis''4( a'4 fis'4) fis'4( a'4 fis'4 e'4) fis'4( a'4 a'4 fis'4.) a'4( a'4 gis'4 fis'4) a'4( e'4 e'4 d'4) 
\bar "" \break

\divisioMaxima
d'4( e'4 fis'4) a'4( gis'4 fis'4 gis'4) 
e'4( fis'4) a'4( fis'4) a'4( b'4) b'4( cis''4 a'4 gis'4) a'4( b'4) 
\divisioMinima
e'4( fis'4 a'4 a'4 cis''4 b'4 a'4 gis'4 fis'4) \quil gis'4( a'4 fis'4) 
\bar "" \break

\finalis
}

altoMusic = {
	b2*6/4 
cis'2*6/4~ 
cis'2*12/4~ 
cis'2*8/4~ 
cis'4 
fis'2*4/4~ 
fis'2*6/4 
cis'2*6/4~ 
cis'4 
b2*10/4 
s2*4/4 
d'2*6/4~ 
d'2*6/4~ 
d'2*8/4 
e'2*8/4 
d'2*6/4 
cis'2*6/4~ 
cis'2*4/4~ 
cis'4 
fis'2*4/4 
}

tenorMusic = {
	\key a \major
gis2*6/4 
a2*6/4~ 
a2*12/4 
b2*8/4 
a4 
\divisioMaior
d'2*4/4 
cis'2*6/4 
b2*6/4 
a4 
g2*10/4 
\divisioMinima
a2*10/4~ 
a2*6/4~ 
a2*8/4~ 
a2*8/4~ 
a2*6/4~ 
a2*6/4 
b2*4/4 
a4~ 
a2*4/4 
\divisioMaxima
}

bassMusic = {
	s2*12/4 
fis2*12/4~ 
fis2*8/4~ 
fis4~ 
fis2*4/4~ 
fis2*6/4~ 
fis2*6/4~ 
fis4 
g2*10/4 
fis2*10/4 
e2*4/4 
d2*8/4 
cis2*8/4 
b,2*6/4 
fis2*6/4~ 
fis2*4/4~ 
fis4 
d2*4/4 
}

voiceLines = {
  \voiceLineStyle

  % Manually add line break
  %s2
  %\allowVoiceLineBreak
  %\voiceLine "down" "down" a2*3/2 a2*1/2
}

\score{
  <<
    \new Lyrics
    \new GrandStaff <<
      \set GrandStaff.autoBeaming = ##f
      \set GrandStaff.instrumentName = \markup \center-column {
        ""
      }
      \new Staff = up <<
        \new Voice = "chant" {
          \voiceOne \global \chantMusic
        }
        \new Voice {
          \voiceTwo \global \altoMusic
        }
      >>

      \new Staff = down <<
        \clef bass
        \new Voice {
          \voiceOne \global \tenorMusic
        }
        \new Voice {
          \voiceTwo \global \bassMusic
        }
        \new Voice {
          \voiceThree \global \voiceLines
        }
      >>
    >>
    \context Lyrics {
      \lyricsto chant {
        \chantText
      }
    }
  >>
}
