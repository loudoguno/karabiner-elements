README: support documentation for quirky things in my master .edn
<!--  -->

TODO: see [outline](evernote:///view/11846588/s107/eb73deae-f988-4168-a76b-5d8487298d33/eb73deae-f988-4168-a76b-5d8487298d33/)

# code as UI via extensive  syntax, texture, formatting and emojis
- goal to make large unwiedly config files as easy to navigate, update and understand as possible. achieved by adding as much "texture" to text ass possible
- comment colorizer
- emojis usage(e.g.  ✨ means new, 🟢 means working, ❗ means problem)
- Section formatting
  - developed out of necesity to deal with pain points trying to switch from old Karabiner JSON format where modes were in separate files and thus easier to keep organized without getting losed
- comment formatting and consistency. allows you to search if a KE combo has been used
  - consisten about charA+charb for "name of macro"
  - includes contextual note about where TO event happens (system level, app level, KM...)
## use of & as shorthand for mode
- more compact for better readability

# ⌨️ UHK workaround and kludges
- wanted to achieve parity between MBP built-in keyboard setup as configured in Karabiner Elements... and UHK keyboard affected by UHK's programming in UHK Agent at hardware level. things like split space bar
## split spacebar and  Rctrl-mode
see my [EN note](https://www.evernote.com/shard/s107/sh/2ce02da7-2bc5-4ac7-a64b-27bc3483386d/LPknInhkjXOx9qTJ420zsgqsWAbbIowAuQaF1wGzfzrmHmELs8kuunM2vg)
- had to come up with workaround to deal with UHK split spacebar
  - if both keys assigned to space, lost exstensibility, e.g.

## FN fn key
- affects BTT FN+⌘/⇧ to move/resize window
see my EN [Note](https://www.evernote.com/shard/s107/sh/de794a31-e047-4a51-a6fb-abefb38187ff/ZfYX8IKWXy3wpA-NUDR2WavpyZLbg8GMabBIh2FAh1rptJFJkWW9BGQNug)

# Window mgmt
## Window crawl and focus via Slate
- f+adws (left/right/up/down) to focus window relative to current. f+b for window behind...
-
## fast search via Contexts and FN key
- TAB and SEMICOLONG configured in KE to send FN on hold -> Contexts set to activate "quick search" when fn pressed
## BTT window manipulation
- BTT set to manipulate windows
  - FN+COMMAND to resize
  - FN+SHIFT to move

# Jump to Fuzzy Search
- activate global Quick Search Jump to, Go to functionality of apps
  -
- XXX+space
  - inspired by ⌘+space for spotlight. the idea being
  - `P+space` for 1password, moom, contexts
  - `?+space` for system help
  - e.g. `.+space` for Typinator
- also J+E for Evernote, J+C for contexts...
see [EN](https://www.evernote.com/shard/s107/sh/23d79a6e-ef35-4ac6-a2d5-c142de974ec1/2ygVmocTd6fWyFUvlY_r43_7JyE6m44YM5cQAMiDv0lnCQWEhE6KXNZ4pg)


# Special Modes
## 👩‍🚀 SPACE MODE
- moves all non-character producing keys (arrows, return, delete...) under right hand home row.
  - basically shrinks down regular relationship/configuration/layout to fit under right and
- asdf as modifiers

## 🔢 NUMPAD MODE (and symbole mode)
### usage:
- l_control+r_control (must release l_control) to turn uiojklm (key grid naturally under right hand) into symbols
- r_control+l_control (must release r_control) to turn uiojklm,. into numpad
- see [notes](https://www.evernote.com/shard/s107/sh/c329bb2e-889b-4ad7-976f-0102d40ab18c/SrDoX2KMlevKrvlk5x3Yfh_AXLZldRWXyDiHvacdKxtKO9-q0upTtb7fQg)

## 🖱MOUSEPAD MODE
see [EN note](https://www.evernote.com/shard/s107/sh/8e0408df-3768-4f30-9fcf-76cd203d27ad/0ey5Lv0g5KdROc8Gh8Q9EwSkcNa37lKSbRq3oHXxDJu9SEL4QjGbHGheCA)

## 🕹 REMOTE MODE
goal: be able to control applications in background with out losing focus (reduce context switching)... by sending
- for example, sending common transport controls (like play/pause/scrub/speed up) to media players (spotify, YouTube...)

# OTHER
## ⏺️ Micros
## 🕴 Hover system
## long hold, double presses
## g+spacebar for GUI click
- solution for pressing GUI/UX elements that are not accessible via keyboard therefore require mouse click (e.g. Typinator Add button, macOS emoji selector close )
- triggers catch-all KM macro that is continuiosly appended with X then Y as new
- utilizes find image on screen trick
- affected by factors like device, screen resolution...
## f+1/2/3/4 for focus columnar UI elements
- configured as f+1 for "Focus 1", f+2 for "Focus 2"... in KE. this triggers the corresponding macro in KM which is app-specific because consistent naming
- NOTE: similar to © items... © character is used to indicate generic  app-specific macro.
  - macros with same name only enabled for active app
  - allows you to have the same KE rule trigger different macros based on which app is activated
  - e.g. "Item Up ©", Focus 1...



# 🔉 audio feedback
- way to differentiate between events happening at different levels/stages in a chain... or determine if triggered at all
  - sounds at KE layer (bubbles)
  - sounds at KM layer...
  - sounds at BTT layer
- signals when macro is triggered, hits a milestone, or finishes...
- sounds really cool
