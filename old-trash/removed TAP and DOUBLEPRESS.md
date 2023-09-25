dropping rules i can't figure out what the do but might be missed

	;;* Double Press Left Command for  Moom (via f14) > 6/12/23 🔴 disabling
		;; [:left_gui [[:SPKR2] :!!f14 ["R⌘" 0]] ["R⌘" 1]] ;! had to get rid of to keep numpad mode working..
		;; [:left_gui :left_gui nil {:alone [[:SPKR3]:left_gui["R⌘" 1 ]]:delayed {:invoked ["R⌘" 0] :canceled ["R⌘" 0]}}]
			;; [:left_gui [[:SPKR2] :!!f14 ["R⌘" 0]] ["R⌘" 1]]
			;; [:left_gui :left_gui nil {:alone [[:SPKR3]:!!f14["R⌘" 1 ]]:delayed {:invoked ["R⌘" 0] :canceled ["R⌘" 0]}}]
			]}

---

#
;; [:!Ospacebar :!Ospacebar] [:!COTspacebar :!COTspacebar] [:!COSspacebar :!COSspacebar] [:!COTSspacebar :!COTSspacebar] ;;* modifier+spacebar bug work around...
			;;❓ i don't know what this does, loks like it changes ⌥+spacebar to ⌘⌥⌃spacebar. currently ⌥spacebar triggers Contexts... turning off, 9/25/23
			;; TODO: figure out what the fuck this is...

---

# double press for context search at line 117
		;;* Double Press Command Spacebar for Contexts search... 🔴 disabled
		;; [:!Cspacebar [[:SPKR3] :!Ospacebar  ["LCMDspacebar" 0]] ["LCMDspacebar" 1]] ⌘+spacebar x2 for Contexts search ;;! 🔴 disabled
			;; [:!Cspacebar :!Cspacebar nil {:alone ["LCMDspacebar" 1] :delayed{:invoked ["LCMDspacebar" 0] :canceled ["LCMDspacebar" 0]}} ]
