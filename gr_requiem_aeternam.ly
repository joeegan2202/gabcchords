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
fis'4 fis'4( e'4) g'4( fis'4 e'4) 
\divisioMinima
e'4( d'4) fis'4( e'4 fis'4) fis'4( e'4 fis'4) fis'4( d'4) e'4( fis'4) a'4( a'4 fis'4 e'4.) fis'4( \quil gis'4 a'4) b'4( a'4 a'4) fis'4( gis'4 fis'4) 
\divisioMaxima
a'4( a'4) 
a'4 
a'4 a'4( gis'4) a'4( b'4) cis''4( a'4 gis'4) a'4( a'4 gis'4) 
\divisioMinima
b'4( a'4) b'4( a'4 fis'4) fis'4 fis'4( a'4 fis'4 e'4) fis'4( a'4 a'4 fis'4.) a'4( a'4 gis'4 fis'4) a'4( e'4 e'4 d'4) 
\divisioMaxima
d'4( e'4 fis'4) a'4( gis'4 fis'4 gis'4) e'4 fis'4 
a'4( fis'4) a'4( b'4) b'4( a'4) b'4( cis''4 b'4 a'4) 
\divisioMinima
cis''4( a'4) cis''4( d''4 b'4 gis'4) a'4( fis'4 e'4.) fis'4( \quil gis'4 a'4) b'4. a'4( b'4 cis''4) 
\divisioMinima
b'4( cis''4 b'4 cis''4 a'4 fis'4) \quil gis'4( a'4 fis'4) 
\finalis
fis'4 
a'4 a'4( b'4) b'4 b'4 
b'4( cis''4) cis''4( b'4 a'4 gis'4) a'4( fis'4 e'4) 
\divisioMinima
gis'4( e'4) fis'4( a'4 a'4) b'4( cis''4 b'4 cis''4) 
\divisioMinima
a'4( cis''4) d''4( b'4 gis'4) a'4( fis'4 e'4.) fis'4( gis'4 fis'4 e'4 fis'4) 
\divisioMinima
b'4( \quil cis''4 d''4 cis''4) d''4( cis''4 b'4 cis''4) cis''4( b'4) 
\divisioMaxima
b'4( \quil cis''4) d''4( cis''4 b'4) \quil cis''4 d''4( cis''4 b'4) b'4( cis''4) 
cis''4( a'4) cis''4( b'4 a'4) a'4( fis'4.) a'4( a'4 fis'4) a'4. a'4( a'4 a'4 fis'4) 
\divisioMinima
a'4( b'4) cis''4( b'4 a'4) cis''4( b'4 a'4) b'4( fis'4) fis'4 
\divisioMaxima
a'4( a'4) 
a'4 a'4 a'4 a'4 a'4( b'4) 
b'4( a'4 gis'4 e'4.) fis'4( a'4 gis'4 e'4) fis'4( a'4) 
\divisioMinima
gis'4( b'4) cis''4( a'4 fis'4) fis'4( a'4 fis'4 e'4) fis'4( a'4 a'4 fis'4.) a'4( a'4 gis'4 fis'4) a'4( e'4 e'4 d'4) 
\divisioMaxima
d'4( e'4 fis'4) a'4( gis'4 fis'4 gis'4) 
e'4( fis'4) a'4( fis'4) a'4( b'4) b'4( cis''4 a'4 gis'4) a'4( b'4) 
\divisioMinima
e'4( fis'4 a'4 a'4 cis''4 b'4 a'4 gis'4 fis'4) \quil gis'4( a'4 fis'4) 
\finalis
}

altoMusic = {
	}

tenorMusic = {
	}

bassMusic = {
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
