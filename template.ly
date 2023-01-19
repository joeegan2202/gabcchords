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
  $$LYRICS$$
}

chantMusic = {
  \tieDown
  $$SOPRANO$$
}

altoMusic = {
  $$ALTO$$
}

tenorMusic = {
  $$TENOR$$
}

bassMusic = {
  $$BASS$$
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
