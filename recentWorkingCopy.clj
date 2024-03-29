;;= LAST WORKING COPY montereySync.edn .200 ==============================================
;; ❗ start using CHANGELOG
;; -⭐ organize alphabetically using sort lines
;; -⭐ start using co-pilot
;; 230806 (Sun) trying to sync up all devices

{ ;;+ ========================= DEFINITIONS =========================== for templates (aliases for frequently used CLI strings), layers, simlayers
	:templates { ;;= ..................................................................................................................... aliases for shell commands including osascript (execute Applescript file), and afplay (plays sound file)
		:open "open \"%s\"" ; open file
		:wait "sleep 250" ;pause 250 ms

		;; :open "osascript -e open \"%s\" "
		:alf "osascript -e 'tell application \"Alfred 4\" to run trigger \"%s\" in workflow \"%s\" with argument \"\"'" ; run Alfred workflow using workflow bundle ID as argument
		:km "osascript -e 'tell application \"Keyboard Maestro Engine\" to do script \"%s\"'"   ; run KM macro using macro name as argument
		:btt "osascript -e 'tell application \"BetterTouchTool\" to  trigger_named \"%s\"'"         ; run BTT macro using named trigger name as argument

		; AppleScripts that that send keystroke | 🧪 experimenting with
		:type "osascript -e 'tell application \"System Events\" to keystroke \"%s\"'"
		:escp "osascript -e 'tell application \"System Events\" to key code 53' " ; send escape
		:sendq "osascript -e 'tell application \"System Events\" to keystroke \"q\"'" ; send keystroke
		:sendreturn "osascript -e 'tell application \"System Events\" to keystroke return' " ; send escape
		:sendspace "osascript -e 'tell application \"System Events\" to keystroke space' " ; send keystroke
		:sendesc "osascript -e 'tell application \"System Events\" to keystroke tab' " ; send keystroke

		;; Sounds and Audio Feedback invoked by calling `afplay`, used to use emojis to make it more readable but would throw an error after a KE update
		:SPKR3 "afplay /System/Library/PrivateFrameworks/ScreenReader.framework/Versions/A/Resources/Sounds/DrawerOpening.aiff"
		:SPKR2 "afplay /System/Library/PrivateFrameworks/ScreenReader.framework/Versions/A/Resources/Sounds/DrawerClosing.aiff"
		:SPKR1 "afplay /System/Library/PrivateFrameworks/ScreenReader.framework/Versions/A/Resources/Sounds/DrillOut.aiff"
		:SPKR0 "afplay /System/Library/PrivateFrameworks/ScreenReader.framework/Versions/A/Resources/Sounds/DrillIn.aiff"
		:Focus2 "afplay /System/Library/PrivateFrameworks/ScreenReader.framework/Versions/A/Resources/Sounds/Focus2.aiff"
		:beep "afplay /System/Library/PrivateFrameworks/ScreenReader.framework/Versions/A/Resources/Sounds/WindowActivated.aiff"
		:Morse "afplay /System/Library/Sounds/Morse.aiff"
		:Pop "afplay /System/Library/Sounds/Pop.aiff"
		:tink "afplay /System/Library/Sounds/Tink.aiff"
		:soundOn "afplay /System/Library/PrivateFrameworks/ScreenReader.framework/Versions/A/Resources/Sounds/DrillOut.aiff"
		:soundOff "afplay /System/Library/PrivateFrameworks/ScreenReader.framework/Versions/A/Resources/Sounds/DrillIn.aiff"
		}

	:layers { ;;=............................................................................................................................. basic layers like spacemode
		; :tab-mode {:key :tab}
		:space-mode {:key :spacebar :condi [:!f& :!d& :!c& :!k& :!w& :!Rctrl-mode :!LCMD]} ;prevents space mode from overiding F and D modes
		:Rctrl-mode {:key :right_control :alone {:key :spacebar} :condi [:!f& :!d& :!c& :!k& :!w& :!space-mode]} ; :Rctrl-mode {:key :right_control :condi [:!f& :!d& :!c& :!k& :!w&]}
		:numpad-mode {:key :f20} ;;? defined in layers and given symbolic key never used so can be triggered via setting variable in space mode
		:numrow-mode {:key :f20}
		:symrow-mode {:key :f20}
		}

	:simlayers { ;;=........................................................................................................................advanced layers that act as vairables
		;;! :semicolon-mode {:key :semicolon} :! taken out in preference to have semicolon mapped to `fn` for use with Context's quick search
		:slash& {:key :slash}
		:a& {:key :a}
		:b& {:key :b}
		:c& {:key :c}
		:d& {:key :d :condi :!space-mode} ;why is this here?
		:e& {:key :e}
		:f& {:key :f}
		:g& {:key :g}
		:h& {:key :h}
		:i& {:key :i}
		:j& {:key :j}
		:k& {:key :k}
		:l& {:key :l}
		:m& {:key :m}
		:n& {:key :n}
		:o& {:key :o}
		:p& {:key :p}
		:q& {:key :q}
		:r& {:key :r}
		:s& {:key :s}
		:t& {:key :t}
		:u& {:key :u}
		:v& {:key :v}
		:w& {:key :w}
		:x& {:key :x}
		:y& {:key :y}
		:z& {:key :z}
		:period& {:key :period}
		:return& {:key :return_or_enter}
		:quote& {:key :quote}
		; :tab& {:key :tab}
		}
;;+ ============================= MAIN ==============================
:main [  ;;+ ==========================================================
;;============================ HOLDINGKEY ========================= ⭕ TODO: clean up this section (re-title)
		{:des "Holding Keys: ⌘V for Clipboard History, ⇧⌘3 for Screenshot Palette, ⇧⌘4 for Snagit" :rules [
			[:!Cv nil nil {:alone :!Cv :held [:km "Clipboard History"] :repeat false :halt true :params{:alone 150 :held 150}} ] ; default :alone is 500ms and would be too long
			[:!SC3 nil nil {:alone :!SC3 :held [:km "-Screenshot Palette"] :repeat false :halt true :params{:alone 150 :held 150}} ]
			[:!SC4 nil nil {:alone :!SC4 :held [:km "-Snagit Palette"] :repeat false :halt true :params{:alone 150 :held 150}} ]
			]}
;;======================== TAP and DOUBLEPRESS  ===================== ;; C T O S and Q W E R (KE modifier abreviations for reference)
	 ;;* Double Press Command Q to Quit | 🟢 works and in use
		{:des "DOUBLE PRESS: ⌘q² to quit,  " :rules[
			[:!C#Pq [ :!Cq ["⌘q" 0]] ["⌘q" 1]] 		;? when ⌘q is pressed the first time  > variable is set to 1 and nothing is sent
			[:!C#Pq ["⌘q" 1] nil {:delayed {:invoked ["⌘q" 0] :canceled ["⌘q" 0]}}] ;? when pressed the second time send ⌘Q
		]}
	;; * Double Press Left command for Moom (🔴 disabled )
	{:des "Double Press Left commandl" :rules [[:condi :!f& :!d& :!c& :!k& :!w& :!Rctrl-mode]
				; * Double Press Left Command
						; [:left_gui [[:SPKR2] :!!f14 ["LCMD" 0]] ["LCMD" 1]]
						; [:left_gui :left_gui nil {:alone [[:SPKR3]["LCMD" 1 ]]:delayed {:invoked ["LCMD" 0] :canceled ["LCMD" 0]}}]
	;;* Double Press Left Command for  Moom (via f14) > 6/12/23 🔴 disabling
		;; [:left_gui [[:SPKR2] :!!f14 ["R⌘" 0]] ["R⌘" 1]] ;! had to get rid of to keep numpad mode working..
		;; [:left_gui :left_gui nil {:alone [[:SPKR3]:left_gui["R⌘" 1 ]]:delayed {:invoked ["R⌘" 0] :canceled ["R⌘" 0]}}]
			;; [:left_gui [[:SPKR2] :!!f14 ["R⌘" 0]] ["R⌘" 1]]
			;; [:left_gui :left_gui nil {:alone [[:SPKR3]:!!f14["R⌘" 1 ]]:delayed {:invoked ["R⌘" 0] :canceled ["R⌘" 0]}}]

			]}
	{:des "Modifier+Spacebar Stuff" :rules[
		;;* Double Press Command Spacebar for Contexts search... 🔴 disabled
		;; [:!Cspacebar [[:SPKR3] :!Ospacebar  ["LCMDspacebar" 0]] ["LCMDspacebar" 1]] ⌘+spacebar x2 for Contexts search ;;! 🔴 disabled
			;; [:!Cspacebar :!Cspacebar nil {:alone ["LCMDspacebar" 1] :delayed{:invoked ["LCMDspacebar" 0] :canceled ["LCMDspacebar" 0]}} ]
		;;* Double Press Command Spacebar for Spotlight via ⌥⌘+spacebar... 🔰 new
		[:!Cspacebar [[:SPKR3] :!OCspacebar  ["LCMDspacebar" 0]] ["LCMDspacebar" 1]]  ;; pressing ⌘+spacebar a 2nd time (when variable LCMDspacebar is to 1) send keyboard command for spotlight
			[:!Cspacebar :!Cspacebar nil {:alone ["LCMDspacebar" 1] :delayed{:invoked ["LCMDspacebar" 0] :canceled ["LCMDspacebar" 0]}} ] ;; pressing ⌘+spacebar the first time (when variable LCMDspacebar is to 0) set variable LCMDspacebar to 1

		;;* modifier+spacebar bug work around...
			[:!Ospacebar :!Ospacebar] [:!COTspacebar :!COTspacebar] [:!COSspacebar :!COSspacebar] [:!COTSspacebar :!COTSspacebar] ;;❓ i don't know what this does
		]}
;;====================  MODIFIERS and COMMAND MODES =================

		{:des "Shift Space for underscore and dash, Left to Right Modifers...":rules[
			[:!Rright_control :hyphen] [:!Rspacebar :hyphen] ;;* Right Shift +Spacebar (or mod) for underscore
			[:!Sright_control :!Shyphen] [:!Sspacebar :!Shyphen]  ;;*Left Shift+Spacebar (or mod) for dash
			; [:!OSspacebar [[:SPKR3]:!SOspacebar  ]]  ;;*Left Shift+Spacebar (or mod) for dash ...❓not sure what this is doing, ⌥⇧+spacebar to make a sound for ⚡️
			[:!Sright_shift [:SPKR2]] ;;* Left Shift to Right Shift for... ⭕️ available
			[:!Rleft_shift [:SPKR3]] ;;* Right Sfhit to Left Fhist for... ⭕ available
			; [:!Sright_gui [:SPKR3]] [:!Rleft_gui [:SPKR3]] ;;* Left Shift to Right Command and Right Shift to Left Command... ⭕️ available
			]}

			 {:des "left and right command for number and symbol Modes...":rules[
				;;*(R)⌘+(L)⌘ for Number Mode
						[:!Qleft_gui nil nil {:alone [[:SPKR0] ["numpad-mode" 0]]
						:held [[:SPKR1] ["numpad-mode" 1]] :afterup [[:SPKR0] ["numpad-mode" 0]]
						:repeat false :halt false :params{:alone 150 :held 150}} ]
				;;*(L)⌘ +(R) ⌘ for Symbol Home Row Mode
						[:!Cright_gui nil nil {:alone [[:SPKR0] ["symrow-mode" 0]]
						:held [[:SPKR1] ["symrow-mode" 1]] :afterup [[:SPKR0] ["symrow-mode" 0]]
						:repeat false :halt false :params{:alone 150 :held 150}} ]
			]}
;;;======================== SIMULTANEOUS KEY ========================= rules activated when two keys are pressed at the same time
	{:des "Simultaneous Keys":rules [
		[ [:k :m] [ [:km "Activate Keyboard Maestro"]] ] ;;* km to activate Keyboard Maestro
		[ [:v :c]  [:km "Activate Visual Studio Code"] ] ;;* vc to Activate Visual Studio Code
		[ [:s :n]  [:open "sidenotes://open/460F59F5-617F-44CB-B9F0-099E96DF1EE3"] ] ;;* s+n to open SideNates "❗ Now" note via URL (sidenotes://open/460F59F5-617F-44CB-B9F0-099E96DF1EE3)
		[ [:o :b]  [:open "obsidian://advanced-uri?vault=reference-vault&commandid=obsidian-global-hotkeys%253Ashow"] ] ;;* o+b for show/hide Obsidian (via command URI)
		[ [:c :h]  [:open "sidenotes://open/93C96CE1-3C77-49A9-955D-D50340BA04F1"] ] ;;* o+b for show/hide Obsidian (via command URI)

		]}
;;======================= HYPER MODE and MODIFIERS ====================
	{:des "Capslock as hyper" :rules [ [:condi :!space-mode :!Rctrl-mode] ; Capslock as hyper (command+shift+option+control)
		[:##caps_lock :!!left_control nil {:alone :escape} ] ]}
	{:des "Semicolon as fn" :rules [ [:condi :!space-mode :!Rctrl-mode] ;;* Semicolon as FN for use with Contexts quicksearch
		[:##semicolon :##fn nil {:alone :semicolon}] ]}
	{:des "FN from UHK" :rules [[:#SOCTf24 :fn [:uhk-keyboard] ]]} ;;* UHK FN as mac fn via UHK hardcoded f24 > fn in KE but only for uhk
	{:des "FN from UHK 2" :rules [[:#SOCTf24 :fn [:uhk-keyboard-2] ]]} ;;* for V2
	{:des "Tab as fn" :rules [ [:condi :!space-mode :!Rctrl-mode :!f&] ;! got it to stop sending fn
		[:##tab :fn nil {:alone :tab} ] ] }
	{:des "quote as (left) control (for emacs)" :rules [ [:condi :!space-mode :!Rctrl-mode :!f&] ;✨ tryi''ng out for emacs, ❓ don't know what :!f& is for
		[:##quote :##left_control nil {:alone :quote} ] ] }

;;=========================== SPACE MODE ============================ bread and butter space + all sorts of awesome things
	{:des "spacebar mode" :rules [ ;? set up not to conflict with numpad-mode
		;; homerow keyboard
			[:##b :spacebar :space-mode] ;spacebar+b for space
			;spacebar+jlik for left/right/up/down
			[:##j :left_arrow :space-mode]
			[:##l :right_arrow :space-mode]
			[:##i :up_arrow :space-mode]
			[:##k :down_arrow :space-mode]
			;; non-text characters (↩⇥, delete, page up/down)
			[:##semicolon :return_or_enter :space-mode]
			[:##u :!Stab :space-mode]
			[:##o :tab :space-mode]
			[:##p :delete_or_backspace :space-mode]
			[:##y :page_up :space-mode]
			[:##h :page_down :space-mode]
			;; modifiers (⇧⌥⌘⌃)
			[:##s :left_shift :space-mode]
			[:##f :right_command :space-mode]
			[:##a :left_control :space-mode]
			[:##d :left_option :space-mode]
			[:##caps_lock :fn :space-mode]
		;; MISC for other functions (backtick/capslock for escape, b for spacebar and w for moom)
			[:##m [[:SPKR3]:!!f14] :space-mode] [:##m [[:SPKR2]:!!f14] :Rctrl-mode] ;;• spacebar+m for activate moom (like this one better)
			[:##c [[:SPKR3]:!Ospacebar] :space-mode] [:##c [[:SPKR2]:!Ospacebar] :Rctrl-mode] ;;• spacebar+c to activate Contexts
			[:##w [[:SPKR3]:!Ospacebar] :space-mode] [:##c [[:SPKR2]:!Ospacebar] :Rctrl-mode] ;;• spacebar+w to activate Contexts (❗ changing w to do contexts and not moom)
			[:##tab [[:SPKR3]:!Otab] :space-mode] [:##tab [[:SPKR2]:!Otab] :Rctrl-mode] ;;• spacebar+tab for contexts tab switch
			[:##slash [[:SPKR3]:!Oescape] :space-mode]  ;;• spacebar+slash for ⌥⎋ (autocomplete)
			[:##right_shift [[:SPKR3]:!Cf12] :space-mode]  ;;• spacebar+Right Shift for Bartender Keyboard Navigate (via ⌘F12 in Bartender)
			[:##return_or_enter [[:SPKR3]:!Of12] :space-mode]  ;;• spacebar+Enter for Bartender Search menu bar items (via ⌘F12 in Bartender) 🟢🔰new
			[:##v [[:SPKR3][:km "Clipboard History"]] :space-mode]  ;;• spacebar+v for "Clipboard History"(via KM macro) 🔰new

		;;* as Shift for alternative characters (e.g. <,>...)
			[:##q :grave_accent_and_tilde [:space-mode :!numpad-mode]] ;? just added
			[:##e :!Sgrave_accent_and_tilde [:space-mode :!numpad-mode]] ;?
			[:##period :!Speriod [:space-mode :!numpad-mode]]
			[:##comma :!Scomma [:space-mode :!numpad-mode]]
			[:##quote :!Squote [:space-mode :!numpad-mode]]
			[:##open_bracket :!Sopen_bracket [:space-mode :!numpad-mode]]
			[:##close_bracket :!Sclose_bracket [:space-mode :!numpad-mode]]
			[:##equal_sign :!Sequal_sign [:space-mode :!numpad-mode]]
			[:##hyphen :!Shyphen [:space-mode :!numpad-mode]]
			[:##1 :!S1 [:space-mode  :!numpad-mode]] [:##1 :!S1 [:Rctrl-mode  :!numpad-mode]]
			[:##2 :!S2 [:space-mode :!numpad-mode]] [:##2 :!S2 [:Rctrl-mode :!numpad-mode]]
			[:##3 :!S3 [:space-mode :!numpad-mode]] [:##3 :!S3 [:Rctrl-mode :!numpad-mode]]
			[:##4 :!S4 [:space-mode :!numpad-mode]] [:##4 :!S4 [:Rctrl-mode :!numpad-mode]]
			[:##5 :!S5 [:space-mode :!numpad-mode]] [:##5 :!S5 [:Rctrl-mode :!numpad-mode]]
			[:##6 :!S6 [:space-mode :!numpad-mode]] [:##6 :!S6 [:Rctrl-mode :!numpad-mode]]
			[:##7 :!S7 [:space-mode :!numpad-mode]] [:##7 :!S7 [:Rctrl-mode :!numpad-mode]]
			[:##8 :!S8 [:space-mode :!numpad-mode]] [:##8 :!S8 [:Rctrl-mode :!numpad-mode]]
			[:##9 :!S9 [:space-mode :!numpad-mode]] [:##9 :!S9 [:Rctrl-mode :!numpad-mode]]
			[:##0 :!S0 [:space-mode :!numpad-mode]] [:##0 :!S0 [:Rctrl-mode :!numpad-mode]]
			;;* Numpad Mode (activates numpad-mode layer )
				[:right_gui ["numpad-mode" 1] :space-mode {:alone ["numpad-mode" 1] :afterup ["numpad-mode" 0]}]
				[:right_gui [[:SPKR3]["numpad-mode" 1]] :Rctrl-mode {:alone ["numpad-mode" 1] :afterup [[:SPKR2]["numpad-mode" 0] ]}]
				[:right_control [[:SPKR3]["numpad-mode" 1]] :space-mode {:alone ["numpad-mode" 1] :afterup [[:SPKR2]["numpad-mode" 0]]}] ;
				[:spacebar ["numpad-mode" 1] :Rctrl-mode {:alone ["numpad-mode" 1] :afterup ["numpad-mode" 0]}]
				; [:tab ["numpad-mode" 1] :space-mode {:alone ["numpad-mode" 1] :afterup ["numpad-mode" 0]}]
				; [:right_gui [ :SPKR3 :set["numpad-mode" 1]] :space-mode ] ;!
				; [:right_gui ["numpad-mode" 1] nil {:alone ["numpad-mode" 1] :afterup ["numpad-mode" 0]}];!
		]}
;;=========================  NUMBER MODES =========================
	{:des "Numpad Mode" :rules [
			[:!Cspacebar :spacebar :numpad-mode] [:spacebar :spacebar :numpad-mode]
			[:right_gui :0 :numpad-mode]
			[:m :0 :numpad-mode]
			[:j :1 :numpad-mode]
			[:k :2 :numpad-mode]
			[:l :3 :numpad-mode]
			[:u :4 :numpad-mode]
			[:i :5 :numpad-mode]
			[:o :6 :numpad-mode]
			[:7 :7 :numpad-mode]
			[:8 :8 :numpad-mode]
			[:9 :9 :numpad-mode]
			[:p :!Sequal_sign :numpad-mode]
			[:0 :hyphen :numpad-mode] [:s :hyphen :numpad-mode] ;;* s for subtract
			[:slash :slash :numpad-mode] [:d :slash :numpad-mode] ;;* d for divide
			[:t :!S8 :numpad-mode] ;;*t for times
			[:period :period :numpad-mode]
			[:semicolon :return_or_enter :numpad-mode]
			[:right_control :spacebar :numpad-mode]
			[:spacebar :spacebar :numpad-mode]
	]}
	{:des "Homerow Number and symbol Mode" :rules [
			[:!Ca :1 :numrow-mode] [:a :1 :numrow-mode]
			[:a :!S1 :symrow-mode]
			[:!Cs :2 :numrow-mode] [:s :2 :numrow-mode]
			[:s :!S2 :symrow-mode]
			[:!Cd :3 :numrow-mode] [:d :3 :numrow-mode]
			[:d :!S3 :symrow-mode]
			[:!Cf :4 :numrow-mode] [:f :4 :numrow-mode]
			[:f :!S4 :symrow-mode]
			[:!Cg :5 :numrow-mode] [:g :5 :numrow-mode]
			[:g :!S5 :symrow-mode]
			[:!Ch :6 :numrow-mode] [:h :6 :numrow-mode]
			[:h :!S6 :symrow-mode]
			[:!Cj :7 :numrow-mode] [:j :7 :numrow-mode]
			[:j :!S7 :symrow-mode]
			[:!Ck :8 :numrow-mode] [:k :8 :numrow-mode]
			[:k :!S8 :symrow-mode]
			[:!Cl :9 :numrow-mode] [:l :9 :numrow-mode]
			[:l :!S9 :symrow-mode]
			; [:!Csemicolon :0 :numrow-mode] [:semicolon :0 :numrow-mode]
			[:semicolon :!S0 :symrow-mode]
			; [:!Csemicolon :return_or_enter :numrow-mode] [:semicolon :return_or_enter :numrow-mode] ;? don't know why this is here
 			[:!Cp :!S!Sequal_sign :numrow-mode] [:p :!Sequal_sign :numrow-mode]
			[:m :hyphen :numrow-mode] [:o :!S8 :numrow-mode] [:i :slash :numrow-mode]
				[:p :delete_or_backspace :symrow-mode]
			 [:!Cperiod :period :numrow-mode] [:period :period :numrow-mode]
			[:!Cslash :slash :numrow-mode] [:slash :slash :numrow-mode]

			; [:!Cspacebar :spacebar :numrow-mode] [:spacebar :spacebar :numrow-mode]
			; [:!Cright_control :spacebar :numrow-mode] [:right_control :spacebar :numrow-mode]
	]}
;;============================ MOUSEPAD MODE ======================
	{:des "mousepad-mode for a mouse things" :rules [
	; should only work with mouse
			[:!CTkeypad_7 [[:SPKR3] :!STOcomma]] ;;• ⌤⊼7 for  Switch Space Left
			[:!CTkeypad_9 [[:SPKR3] :!STOperiod]] ;;• ⌤⊼9 for  Switch Space Left
			[:!CTOkeypad_7 [[:SPKR3] [:btt "Move Window Space Left"]]] ;;• ⌤⊼⊻7 for Move Window Space Left
			[:!CTOkeypad_9 [[:SPKR3] [:btt "Move Window Space Right"]]] ;;• ⌤⊼⊻9 for Move Window Space Right

	]}
;;============================ A MODE =============================
	{:des "a-mode for a things" :rules [ :a& ;;* –––––––––––––––––––––––––––––––––––––
		[:c [[:SPKR3] :!Oescape] ] ;;• a+c for autocomplete now (via ⌥⎋)
		[:semicolon :!Osemicolon] ;;•🔰  a+semicolon for elipse (to be used as suffix to trigger things)
		; [:comma :!TOleft_arrow] [:period :!TOright_arrow] ;;• a+comma/period  for Active Screen Workspace Left/Right (via ⌃⌥←  in BTT)
	]}
;;=========================== B MODE ==============================
	{:des " b-mode for b things" :rules [ :b& ;;* ––––––––––––––––––––––––––––––––––––
		[:a [:km "Boldate Clean Left"] ] ;;• b+a for Boldate Clean Left 🟢 FIXED
		[:w [:!Oleft_arrow :!OSright_arrow] ] ;;• b+w for highlight word 🤔 interesting daisy chain
		[:l [:!Ta :!TSe :!Sright_arrow] ] ;;• b+L for highlight line
	]}
;;============================ C MODE =============================
	{:des "c-mode for c things" :rules [ :c& ;;* ––––––––––––––––––––––––––––––––––––
		[:a [:km "Jump to Fantastical"] ] ;;• c+a for km "Jump to Fantastical"
		[:o [:km "Query Contacts"] ] ;;• c+o for km "Query Contacts"
		[:d :!Cquote] ;;• c+d for ⌘+quote (evernote default "focus tag field")
		[:m [:km "Move Mouse to Focused Window"] ] ;;• c+m for km "Move Mouse to Focused Window" ✳️NEW

		[:comma [[:SPKR3] :!STOcomma]] ;;• c+comma for Switch Active Workspace Left (via System Hotkeys) 🟤 recently re-activated
		[:period [[:SPKR3] :!STOperiod]] ;;• c+period for Switch Active Workspace Right (via System Hotkeys)

		;; ❌[:w [:km "Center Window on Current Mouse Location"] ] ;;• c+w for km "Center Window on Current Mouse Location" ✳️ NEW
		[:w [:km "Move Mouse to Focused Window"] ] ;;• c+w for km "Move Mouse to Focused Window" ✨new 6/12/23

	]}
;;============================ D MODE ==============================
	{:des "d-mode for d things" :rules [ :d& ;;================================== D MODE

		;; d+spacebar for ⌘ palette (legacy from window manipulation stuff) ⭕ TODO: refactor window mgmt stuff her 📜 old/stale/archive
		[:spacebar [[:SPKR3] :!Cp] ] ;;• d+spacebar for ⌘P (⌘p keyboard maestro conflict palette)
		[:right_control [[:SPKR3] :!Cp] ] 					  ;;= UHK  split spacebar compatability

	;; Tab Manipulation..........................................
		[:s :!TStab] 														;;= d+s for tab left (via ⌃⇥ with action set in app native or KM)
		[:f :!Ttab] 												 	   	  ;;= d+f for ⇧⌃⇥ (tab right)
		[:a :!Copen_bracket] 			   							;;= d+a for ⌘[ (Page Back)
		[:g :!Cclose_bracket] 		   								;;= d+g for ⌘] (Forward Page)
		[:w [:km "Item Up ©"]]		   							  ;;= d+w for Item Up (global KM context "Item Up ©")
		[:v [:km "Item Down ©"]]		         				;;= d+v for Item Down (global KM context "Item Down ©")
		[:c :!Cquote] 					  						  		   ;;= d+x for ⌘+quote (edit tags in omnifocus, evernote ect...)
		;• jlik for ⌥ navigation................................. ❗redundant to space+d+j/l TODO delete
		[:#Sj :!O#Sleft_arrow]
		[:#Sl :!O#Sright_arrow]
		[:#Si :!O#Sup_arrow]
		[:#Sk :!O#Sdown_arrow]

		[:comma [:km "Switch Second Space Left"] ] ;;• c+comma for Switch Second Space Left ✅ working on 💻 Maxbook pro
		[:period [:km "Switch Second Space Right"] ] ;;• c+period for Switch Second Space Right ✅ working on 💻 Maxbook pro

		[:t [:!SCTd] ] ;;• d+t for Dictate Text (via ⇧⌃⌘d hotkey set in System Preferencees > Keyboard > Dictation)
		[:2 [[:SPKR3] :!TO2] ] ;;• d+2 for ⌃⌥2 2Do quick entry ✨ new 7/30/23
		[:q [[:SPKR3] [:open "obsidian://advanced-uri?vault=reference-vault&commandid=quickadd%253ArunQuickAdd"] ]] ;;• d+q for QuickAdd

		;;! * d+m for moving tab/window left/right.....................! ❓⭕ TODO not sure whats up here
				;; [:m [[:vk_none]["dm&" 1]] nil {:delayed {:canceled [["dm&" 0]["d&" 0]]
				;; :invoked [[:vk_none]["dm&" 0]] }  :held [[:km "Move Window Active Space Right (delay)"]["dm¬" 1]] } ]
	]}
;;============================ F MODE =============================
	{:des " f-mode for f things" :rules [ :f& ;;* –––––––––––––––––––––––––––––––––––––
			;;• f+⌘ and space for clicks
				[:spacebar :button1] [:right_control :button1] ;;• f+spacebar for left-click (AND right-control for UHK)
 				[:right_gui :button2];;• f+right_command for right click
 				[:left_gui :button3];;• f+left_command fo (!Cbutton1 doesn't work as a <to> but can be recreated using button3)
			;;• f+1/2/3/4/ focus Column
				[:1 [:km "Focus 1"]]
				[:2 [:km "Focus 2"]]
				[:3 [:km "Focus 3"]]
				[:4 [:km "Focus 4"]]
				[:caps_lock [:km "Focus Sidebar"] ]
				[:return_or_enter [[:SPKR3]:!STOn]] ;;* Notification Center (via System Hotkey ⇧⌥⌃N)
			;;* Focus Window
				[:q [[:SPKR2]:!Cgrave_accent_and_tilde]] [:e [[:SPKR2] :!SCgrave_accent_and_tilde]];;• f+q/e for focus last/next window (via System Preferences)
				[:tab :!Ctab] ;;• f+tab for ⌘⇥
				[:a :!!j]	; [:a [[:SPKR2]:!!j]] ;;•left/right/up/ down via Slate
					[:d :!!l]	; [:d [[:SPKR2]:!!l]]
					[:w :!!i]	; [:w [[:SPKR2]:!!i]]
					[:s :!!k]	; [:s [[:SPKR2]:!!k]]
					[:x :!!x]	; [:x [[:SPKR2]:!!x]]
					[:b :!!b]	; [:b [[:SPKR2]:!!b]]
		[:n :fn] 	;;• f+n for for function (to be used with qweasd moom search)
		[:comma [:km "Switch Third Space Left"] ] ;;• c+, for Switch Third Space Left
		[:period [:km "Switch Third Space Right"] ] ;;• c+. for Switch Third Space Right
	]}
;;============================ G MODE ============================
	{:des "g-mode" :rules [ 	:g& ;;* –––––––––––––––––––––––––––––––––––––––––––
		[:spacebar [:km "Click GUI Button"]] ;;• g+spacebar for Click GUI Button
		[:right_control [:km "Click GUI Button"]] ;;• g+right_control for Click GUI Button (for compatability with UHK split spacebar)
		[:w [[:SPKR3] :!!tab]] ;;• g+w for Click focus Window > ❓ not sure what this is for
	;; keep around
			;; [:m [:km "GoTo Gmail Inbox"] [["g&" 1] ["go&" 1]]] ;;+ g+o+m for GoTo Gmail Inbox
			;; [:r [:km "Go To Recent OmniFocus Task"] [["g&" 1] ["go&" 1]]] ;;+ g+o+r for Go To Recent OmniFocus Task
			;; [:a [:km "Finder: Go To Just Press Record Voice Recordings"] [["g&" 1] ["go&" 1]]] ;;+ g+o+r for Finder: Go To Just Press Record Voice Recordings
	]}
;;=========================== H MODEµ==============================
	{:des " h-mode for h things" :rules [:h& ;;* ––––––––––––––––––––––––––––––––––––
		[:w [:km "Hover Evernote Now"]] ;;• h+w for Hover Evernote Now 🟢
		[:l [:km "Hover ⚡️ LIVE NOTES"]] ;;• h+l for Hover ⚡️ LIVE NOTES 🟢
		[:u [:km "Hover 📅 UPCOMING "]] ;;• h+u for Hover 📅 UPCOMING  🟢
		[:c [:km "Hover Evernote 🕸 Capture (ideas and thoughts)"]] ;;• h+c for Hover Evernote 🕸 Capture (ideas and thoughts) 🟢
		[:t [:km "Hover Notion Lou’s TODO’s"]] ;;• h+t for Hover  Notion Lou’s TODO’s) 🟢🔰
		[:b [:km "Hover Evernote 🧰 WORKBENCH"]] ;;• h+b for Hover Evernote 🧰 WORKBENCH

		[:d [:km "Hover 🍇 DFP Dashboard"]] ;;• h+d forHover 🍇 DFP Dashboard  🟢 > ⭕ to remove
		[:e [:km "Hover Evernote 🍇📞 NEXT MEETING/HUDDLE"]] ;;• h+e 🍇📞 NEXT MEETING/HUDDLE  🟢 > ⭕ to remove


		;; ✨ TEMPLATE to maybe use: [:<INSERT 2nd key> [:km "<INSERT MACRO NAME>"]] ;;• <INSERT 1st key>+<INSERT 2nd key> for <INSERT MACRO NAME>

		;; TODO: need work
			[:o [:km "-Hover Palette"]] ;;• h+w for Hover palette ⭕needs work
			;; [:e [:km "Hover Recent Daily Journal Entry"]] ;;• h+e for Hover Recent Daily Journal Entry 🟢
			[:4 [:km "Hover OmniFocus 🧨C4 TODO"]] ;;• h+4 for Hover OmniFocus 🧨C4 TODO 🔰
		]}
;;============================ I MODE ==============================
	{:des "i-mode for I things" :rules [
	:i& ;;• i+..................................................................................................................................
		[:e [:km "Toggle Emoji and Symbols selector"]] ;;• i+e for Toggle Emoji and Symbols selector via KM macro that also closes the pop-up
		[:d [:km "Hover Evernote  🥔 Idaho Trip (Brosensus)"]] ;;• i+d for 🥔 Idaho Trip (Brosensus) 🟢
		;; [:t [:km "Hover Evernote 🔷 ITINERARY"]] ;;• i+t for Hover Evernote 🔷 ITINERARY 🔴 disabled b/c false positives
		]}
;;============================ J MODE ===============================
	{:des "j-mode" :rules [
	:j&  ;;• j+................................................................................................................................
		[:e [[:SPKR3][:km "Jump to Evernote"]]] ;;• j+e for Jump to Evernote 🟢
		[:d [:km "Jump to Drafts (global)"]] ;;• j+d for Jump to Drafts (global)
		[:s [[:SPKR3][:km "Jump to Stickies"]]] ;;• j+e for Jump to Stickies 🟢
		[:o [:km "Jump to OmniFocus"]] ;;• j+o for Jump to OmniFocus 🟡 needs work > 🟢 better now
		[:w [[:SPKR3] :!Ospacebar]] ;;• j+w for Jump to Window (via Context hotkey ⌥space)

		[:period [:km "© Open Context Menu"]]  ;;• j+period for Open Context Menu (via KM global context)
		[:spacebar [:km "Click GUI Button"]] ;; ⭐j+spacebar for Click GUI Button (one of my favs)

		[:t [:km "© Jump To"]] ;;• j+o for © Jump To (via KM global context)
		[:right_gui [:km "© Jump To"]] ;;• j+right_gui for © Jump To //alternative way with one hand

		[:b [[:SPKR3] [:open  "obsidian://advanced-uri?vault=reference-vault&commandid=darlal-switcher-plus%253Aswitcher-plus%253Aopen"]] ] ;;• j+b_ jump to Obsidian (via QuickSwitcher plus URI
		;; [:KEY_2 [[:SPKR3] [:open "INSERT_URL"] ] ;;• KEY_1+KEY_2 for INSERT_URL from XXX obsidian

	;;* TODO testing out "send" rule
		;; [:a [[:SPKR3] [:wait] [:escp]] ] ;; works
		;; [:r [:sendreturn]] ;; ☑️  works
		;; [:q [:sendq]] ;;? works i guess but sends capital? look into
		;; [:1 [[:SPKR3] [:sendesc]]] ;;❓ seems to send tab?

	]}
;;============================= K MODE =============================
	{:des "k-mode for k things" :rules [ :k& ;;• k+..................................................................
			[:spacebar [:km "Trigger Macro by Name"]] ;;• k+spacebar for "Trigger Macro by Name"
			[:e [:km "Open Karabiner Elements (monterySync.edn) in VS Code"]] ;;• k+e for Open Karabiner Elements (monterySync.edn) in VS Code
			[:v [:km "Activate Karabiner EventViewer"]] ;;• k+v for "Activate Karabiner EventViewer"
			[:y [:open "https://www.notion.so/my-old-ky-home/My-Old-Kentucky-Notion-c9ffb2a6aa6540e1b3e80a34e5db2d72?p=226804d32b084480a53b9c5ec4bde45f&showMoveTo=true)"]] ;;• k+y for ky house dashboard
			[:s [:open "obsidian://advanced-uri?vault=reference-vault&commandid=workspaces-plus%253A%25F0%259F%2593%259F%2520KSSRC%2520config"]] ;;• k+y for ky house dashboard

	]}
;;============================ L MODE =============================
	{:des "L-mode for l things" :rules [ :l& ;;* –––––––––––––––––––––––––––––––––––
		[:s [:km "Clean Line Formatting"]] ;;• l+s for Clean Line Formatting
		[:j [:open "obsidian://log"] ] ;;• l+j for  Log something new to your Daily journal from Lumberjack obsidian plugin
		[:d [:open "https://www.notion.so/loudog/LOU-DASHBOARD-2af984c519f8474a8632893fd5482eba"] ] ;;• l+d for  Lou's Dashboard (Notion) ✨ new
		[:b [:open "obsidian://advanced-uri?vault=reference-vault&daily=true&mode=append"] ] ;;• l+b for log obsidian reference vault daily journal

	]}
;;============================ M MODE ==============================
	{:des "m-mode for m things" :rules [ :m& ;;• m+..............................................................
		[:r [:km "Hover OmniFocus Morning Review"]] ;;• m+r for Hover OmniFocus Morning Review
		[:s [:km "New Message (to self)"]] ;;• m+s for New Message (to self)
	]}
;;============================= N MODE ============================
	{:des "n-mode for n things" :rules [ :n& ;;* ––––––––––––––––––––––––––––––––––––
		[:c [:km "New Event"]] ;;• n+c New Event via Fantastical
		[:m [:km "New Message"]] ;;• n+m for New Message
		[:p [:km "New Password"]] ;;• n+p for New Password
		[:q [:km "New QuickNote"]] ;;• n+q New QuickNote
		[:w [:km "New Window"]] ;;• n+w for New Window
		;; [:s [:km "New Sticky"]] ;;• n+s for New Sticky 💥 conflict with below
		[:d [:km "Drafts Quick Capture (global)"]] ;;• n+d for Drafts Quick Capture (global) ✨ new


		[:i [[:tink] :!CTSo]] ;;• n+i New Omnifocus Quick Entry (via omf hotkey ⌃⇧⌘+o) 🟢 FIXED
		[:o [:km "Send to OmniFocus"]] ;;• n+o for Send to OmniFocus ⭐replaced n+i+i

		[:t [:km "New Typinator Item from Selection"]] ;;• n+t for Quick Add Typinator Item
		[:s [:km "New Typinator Item from Selection"]] ;;• n+s for Quick Add Typinator Item

		[:l [:km "Log Palette"]] ;;• n+l for Log Palette 🟡 need to fix underlying macros
		[:spacebar [:km "Jump to Notes"]] ;;• n+spacebar Jump to Notes

		;; [:a [:km "Boldate Clean Left"] ] ;;• n+a for Boldate Clean Left via KM ✨ new (trying to achieve  b+a awkwardness on UhK)
		[:a [[:SPKR3] :!Ssemicolon :spacebar :left_arrow :left_arrow :!STa :!Cb :left_arrow :!Cb :hyphen :!Te] ] ;;• n+a for Boldate Clean Left NOT via KM, 🧪 new (trying to achieve  b+a awkwardness on UhK)

	]}
;;============================== O MODE =============================
	{:des "o-mode for..." :rules [ :o& ;;* ––––––––––––––––––––––––––––––––––––––––––-
	;;• o+spacebar.......................................................................................................................
	[:spacebar [[:SPKR3][:alf "Search OmniFocus Tasks via Alfred" "net.rhydlewis.alfred.searchomnifocus"]]] ;; o+spacebar for Jump to OmniFocus 🟡 NEEDTOFIX
	[:i [:km "Hover OmniFocus Inbox"]] ;;⭐🔰 o+i for Hover OmniFocus Inbox

	; keep around
			;; [:f [:km "Activate OmniFocus New Window"] [["o&" 1] ["om&" 1]]] ;;+ o+m+f for Activate OmniFocus New Window
			;; [:f [:km "Activate OmniFocus New Window"] [["o&" 1] ["om&" 1]]] ;;+ o+m+f for Activate OmniFocus New Window
			;; [:t [:km "GoTo OmniFocus ™️ TOMORROW"] [["o&" 1] ["om&" 1]]] ;;+ o+m+t for GoTo OmniFocus ™️ TOMORROW
	]}
;;============================ P MODE ============================= ;;  ⭕🌟TODO p mode has a lot of potential because barely used up and allows access to entire keyboard
	{:des "p-mode for..." :rules [ :p& ;;* ––––––––––––––––––––––––––––––––––––––––––
		[:spacebar [[:SPKR3]:!!p]] ;;• p+spacebar for search 1password...
		[:a [:km "Go To Sheet: Pharma"]] ;;• p+a forGo To Sheet: Pharma
	]}
;;============================ R MODE ============================== ⭕ TODO: clean up comments and formatting (consolidate rules to fewer lines and add descriptions)
;; ℹ️ "remote-mode" for  media transport control (play/pause/next song ect..). most send ⌃⌥⌘ (3 modifiers grouped left of space) plus another key -> next layer in KM are contextual groups like QuickTime, media (e.g. spotify), YouTube
	{:des "r-mode for remote things" :rules [ :r& ;;* ––––––––––––––––––––––––––––––––

	[:o [:km "Go to Roam Greenhouse Lou"]] ;;• r+o Go to Roam Greenhouse Lou
	;; [:XXX [:km "Deactivate Remote"]] ;;• r+XXX Deactivate Remote ⭕TODO

	;;* Transport Controls
      [:spacebar :!TOCspacebar] ;;• r+spacebar for pause via ⌃⌥⌘Space ;;*j/l/i/k for remote transport controls
      [:right_control :!TOCspacebar] ;! thought I might need to fix for right control
		[:j :!TOCleft_arrow]
		[:l :!TOCright_arrow]
		[:i :!TOCup_arrow]
		[:k :!TOCdown_arrow]
		[:a :!TOCleft_arrow]
		[:d :!TOCright_arrow]
		[:w :!TOCup_arrow]
		[:s :!TOCdown_arrow]
		[:comma :!TOCcomma]   ;;*comma/dot for speed up and down via ⌃⌥⌘,/.
		[:period :!TOCperiod]
		[:semicolon :!TOCsemicolon] ;;*semicolon/quote for frame forward/backwoord ⌃⌥⌘;/'
		[:p :!TOCp] [:n :!TOCn] [:q :!TOCp] [:e :!TOCn]  ;;* r+p/n and r+q/e for next/previous song 🟢 FIXED

		[:f :!TOCf] ;;*f for fullOCreen via ⌃⌥⌘f
		[:tab [:km "Screenshot Timestamp"]] ;;* r+tab for tab for Screenshot Timeestamp
		[:p [:km "Screenshot Timestamp"]] ;;*tab for Screenshot Timeestamp
			[:right_gui [:km "Screenshot Timestamp"]] ;;*tab for Screenshot Timeestamp
		[:m [:km "Mute"]] ;;* r+m for mute

	;;* Remote Palette
			[:return_or_enter [:km "- Remote Modes Palette"]] ;;* r+return/enter for "- Remote Modes Palette"
			;; [:m [:km "Media Remote"]] 		;;*r for YouTube Remote
			[:y [:km "YouTube Remote"]] 		;;*y for YouTube Remote
			;; [:q [:km "QuickTime Remote"]] 		;;*q for QuickTime Remote ❌ DEACTIVATED so can have trigger back/next with one hand via q/e
			[:x [:km "Deactivate Remote"]] 		;;*q for Deactivate Remote
	]}
;;============================= S Mode =============================
	{:des "s-mode for s things" :rules [ :s& ;;* ––––––––––––––––-----------––––––––––––
		[:t :!STCs] ;;• s+t for Speak Text via system hot key (⇧⌥⌃S)
		[:c [:km "Speak Clipboard"]] ;;• s+c for Speak Clipboard via KM macro 👁 surfacing for visibility

		;; enclose selection with and transform
			[:9 [:km "Enclose Selection with Parenthesis"]] ;;• s+9 for Enclose Selection with Parenthesis 🟢
			[:open_bracket [:km "Enclose Selection with Square Brackets"]] ;;• s+open_bracket for Enclose Selection with Square Brackets
			[:close_bracket [:km "Enclose Selection with Curly Brackets"]] ;;• s+close_bracket for Enclose Selection with Curly Brackets
			;; 🟡 s+right_shift+quote for Enclose Selection with Double Quotes
			[:quote [:km "Enclose Selection with Single Quotes"]] ;;• s+quote for Enclose Selection with Single Quotes
			;;• s+right_shift for transform selection case - [:km "Uppercase Selection"]
			[:right_shift [:km "Capitalize Selection"]] ;;•s+right_shift for Capitalize Selection
		[:j :!SOleft_arrow] [:l :!SOright_arrow] [:i :!SOup_arrow] [:k :!SOdown_arrow] ;;*jlik for select left/right/up/down

		;;*🖱mouse-mode  a/l/fed for scroll mouse now
		[:a {:mkey {:hwheel 5 :speed 5}}]
		[:f {:mkey {:hwheel -5 :speed 5}}]
		[:e {:mkey {:vwheel -5 :speed 5}}]
		[:d {:mkey {:vwheel 5 :speed 5}}]
	]}
;;============================ T MODE ============================
	{	:des "t-mode for t things" :rules [ :t& ;;* ––––––––––––––––––––––––––––––––––––
		[:w [:km "Tab To Window"] ] ;;• t+w for Tab To Window
		[:m [:open "obsidian://timber"] ] ;;• t+w for run timber command from Lumberjack obsidian plugin 🔰 new 7/27/23
		;; [:n [:open "obsidian://timber"] ] ;;• q+n for quick note ToDo
		[:n [:km "Tab New"] ] ;;• t+n for Tab New
	]}

;;============================ U MODE ==============================
;;TODO ⭕ lot of potential here because not used up...
	{:des "u-mode for..." :rules [ :u& ;;* ––––––––––––––––––––––––––––––––––––––––––
		;; [:w [:km "Uppercase Word"]] ;;! u+w for Uppercase Word (🟨 get rid of because unnecessary?) > TODO: delete ❌
		[:c [:km "Uppercase Selection"]] ;;• u+c for Uppercase Selection 🔰
	]}

;;============================ V MODE ==============================
	{	:des "v-mode for..." :rules [ :v& ;;* ––––––––––––––––––––––––––––––––––––––––-
		[:i [[:SPKR3] [:km "Hover Evernote ⭐️ VIPs"] ] ] ;;! v+i  for Hover Evernote ⭐️ VIPs >  TODO: time to delete ❌
		[:2 [[:SPKR3] [:open "obsidian://open?vault=vault2"]]] ;;• v+2 for open Obsidian vault 2 ✨ new 7/30/23
		[:r [[:SPKR3] [:open "obsidian://open?vault=reference-vault"]]] ;;• v+r for open Obsidian vault 2 ✨ new 7/30/23
		[:s [[:SPKR3] [:open "/Users/loudog/Dropbox/Sync/vs-code/vs code sync.code-workspace"]]] ;;• v+s for open VS-Code sync workspace ✨ new 7/30/23 🟢 works, NOTE: do note want to prepend file path with file//
	]}
;;============================ W MODE =============================
	{	:des "w-mode" :rules [ :w& ;;• ––––––––––––––––––––––––––––––––––––––––––––
		[:spacebar [[:SPKR3] :!SOCf3] ] ;;• w+spacebar for Switch Active Workspace Left (via System Hotkey ⌥⇧⌘F3) 🟢works now -> editing because
		[:right_control [[:SPKR3] :!SOCf3 ]] ;; for uhk2
		;; [:spacebar [[:SPKR3] [:btt "Expose"]] ] ;;• w+a for Switch Active Workspace Left (via BTT) 🟢works now -> editing because
		;; [:right_control [[:SPKR3] [:btt "Expose"]] ] ;;• w+right_control (uhk spacebar)

		[:a [[:SPKR3] :!STOcomma]] ;;• w+a for Switch Active Workspace Left (via System Hotkeys)
		[:d [[:SPKR3] :!STOperiod]] ;;• w+d for Switch Active Workspace Right (via System Hotkeys)
		[:f [[:SPKR3] [:btt "Move Window Space Right"] ] ] ;;• w+f  Move Window Space Right (via btt)
		[:caps_lock [[:SPKR3] [:btt "Move Window Space Left"] ] ] ;;• w+capslock Move Window Space Left (via btt)

		[:b [:km "Hover Evernote 🧰 WORKBENCH"]] ;;• w+b for Hover Evernote 🧰 WORKBENCH
		[:c [:km "Center Window on Current Mouse Location"] ] ;;• w+c for km "Move Mouse to Focused Window" ✨new 6/12/23


		[:left_gui [[:SPKR3] :!!f14 ]] ;;* w+left_gui for moom (accessable with left hand)
	;; keep around
		;; [:comma [:km "Switch All Workspaces Left"]] ;;• w+comma for Switch All Workspaces Left
		;; [:period [:km "Switch All Workspaces Right"]];;• w+period for Switch All Workspaces Right
		;; [:caps_lock [ [:SPKR3] [:btt "Move Window Space Left"] ] ] ;;• w+caps_lock/f for Move Window Space Left/Right (via BTT script)
		;; [:f [[:SPKR3] [:btt "Move Window Space Right"] ] ] ;;• w+f for  Move Window Space Right
		;; [:1 [ [:SPKR3] [:btt "Switch to Workspace 1"]]] ;;• w+1 for Switch to Workspace 1 (via BTT script)
		;; [:2 [ [:SPKR3] [:btt "Switch to Workspace 2"]]] ;;• w+2 for Switch to Workspace 2 (via BTT script)
		;; [:3 [ [:SPKR3] [:btt "Switch to Workspace 3"]]] ;;• w+3 for Switch to Workspace 3 (via BTT script)
		;; [:4 [ [:SPKR3] [:btt "Switch to Workspace 4"]]] ;;• w+4 for Switch to Workspace 4 (via BTT script)
	]}
;;============================ X MODE ============================
		{	:des "x-mode for..." :rules [
		:x& ;;* –––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––--
				[:p :!Tdelete_or_backspace ] 		;;• x+p for clear notification
				]}
;;============================ Z MODE ===============================
	{	:des "z-mode for z things..." :rules [
	:z& ;;* –––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
		[:spacebar :play_or_pause] 		;;• z+spacebar for system pause
		[:right_control :play_or_pause] 		;;• z+right_control for system pause (UHK compatability)
		[:j :rewind] ;;• z+j for rewind
		[:l :fastforward] ;;• z+i for fastforward
		[:i :volume_increment] ;;• z+i for volume up
		[:k :volume_decrement] ;;•z+k for volume down
		[:p :vk_consumer_brightness_up] ;;• z+p for brightness up
		[:n :vk_consumer_brightness_down] ;;• z+n for brightness down
		[:m :mute] ;;• z+m for mute

		;; other brightness key
		;; [:	p :apple_display_brightness_increment] ;;• z+ for brightness up
			;; [:n :apple_display_brightness_decrement] ;;• z+ for brightness up

;; UNUSED SYSTEM KEYS
	;; :vk_consumer_brightness_down {:label "vk_consumer_brightness_down (equal todisplay_brightness_decrement)" :not-from true}
	;; :vk_consumer_brightness_up {:label "vk_consumer_brightness_up (equal todisplay_brightness_increment)" :not-from true}
	;; :mission_control {:not-from true :consumer-key true}
	;; :mission_control {:not-from true}
	;; :launchpad {:not-from true :consumer-key true}
	;; :dashboard {:not-from true :consumer-key true}
	;; :illumination_decrement {:not-from true :consumer-key true}
	;; :illumination_increment {:not-from true :consumer-key true}
	;; :eject {:not-from true :consumer-key true}
	;; :apple_display_brightness_decrement {:not-from true :consumer-key true}
	;; :apple_display_brightness_increment {:not-from true :consumer-key true}
	;; :apple_top_case_display_brightness_decrement {:not-from true :consumer-key true}
	;; :apple_top_case_display_brightness_increment {:not-from true :consumer-key true}
	;; :vk_none {:label "vk_none (disable this key)" :not-from true}
	;; :print_screen {:display true}
	;; :scroll_lock {:display true}
	;; :pause {:display true}
	;; :insert {:display true}
	;; :application {}
	;; :help {}
	;; :power {}
	;; :execute {:not-to true}
	;; :menu {:not-to true}
	;; :select {:not-to true}
	;; :stop {:not-to true}
	;; :again {:not-to true}
	;; :undo {:not-to true}
	;; :cut {:not-to true}
	;; :copy {:not-to true}
	;; :paste {:not-to true}
	;; :find {:not-to true}
	;; :international1 {}
	;; :international2 {:not-to true}
	;; :international3 {}
	;; :international4 {:not-to true}
	;; :international5 {:not-to true}
	;; :international6 {:not-to true}
	;; :international7 {:not-to true}
	;; :international8 {:not-to true}
	;; :international9 {:not-to true}
	;; :lang1 {}
	;; :lang2 {}
	;; :lang3 {:not-to true}
	;; :lang4 {:not-to true}
	;; :lang5 {:not-to true}
	;; :lang6 {:not-to true}
	;; :lang7 {:not-to true}
	;; :lang8 {:not-to true}
	;; :lang9 {:not-to true}
	;; :japanese_eisuu {:label "英数キー" :display true}
	;; :japanese_kana {:label "かなキー" :display true}
	;; :japanese_pc_nfer {:label "PCキーボードの無変換キー" :not-to true}
	;; :japanese_pc_xfer {:label "PCキーボードの変換キー" :not-to true}
	;; :japanese_pc_katakana {:label "PCキーボードのかなキー" :not-to true}

	]}
;;========================= PERIOD MODE ===========================
	{:des " period-mode for typinator and autocomplete":rules [
    :period& ;;• –––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
		[:spacebar [[:SPKR3] :!SCTt] ] ;;• period+spacebar for Typinator Quick Search (via ⌃⇧⌘+T hotkey set in app pref.)
		[:left_shift [[:SPKR3] :!STperiod] ] ;;• period+left_shift for Typinator Suggest Abbreviation (via ⌃⇧+. hotkey set in app pref)
	]}
;;========================== RETURN MODE ==========================
	{	:des "return-mode for..." :rules [
	:return& ;;• –––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
		[:delete_or_backspace :!Tdelete_or_backspace] ;;• return+delete for dismiss notification (via ⌃↩) 💡  could also just use
		[:spacebar [[:SPKR3] :!COSTreturn_or_enter]] ;;• return+spacebar for focus menubard (via bartender hotkey)
	]}
;;============================ QUOTE MODE============================
{	:des "quote-mode for..." :rules [

		; [:s [:ToKey]] ;;• quote+s for ToKey hello
]}
;;======================== SEMICOLON MODE  =========================
;! GOING TO SET UP LIKEHYPER KEY for FUNCTIO ❓TODO: clean up semicolon comments (currently fn for Context window snapping)
;;============================ MORE  ================================
	;! more modes temporary till moved to real mode sections
	;; ❗ need to integrate with non catalina sync files and add slash mode
;;============================ SLASH MODE ============================
{	:des "slash-mode for..." :rules [
		;; ;;+ slash+spacebar+........................................................................................................(🔴 disabled)
			;; [:spacebar :!CSslash [["slash&" 1] ["slashspacebar&" 1]]] ;;+ slash+spacebar+spacebar for Focus help menu via ⇧⌘/
		:slash& ;;* ––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
		;;* slash+spacebar for... (🔴 disabled)
			;; [:spacebar [[:SPKR3] :!SCslash ["slashspacebar&" 1]] nil {:delayed{:canceled [["slashspacebar&" 0]["slash&" 0]]
			;; :invoked [ :vk_none ["slashspacebar&" 0]] } :held [[:vk_none]] }]  ;;• slash+spacebar for Focus Menu via ⌥⎋ (System Preferences)

		[:spacebar [[:SPKR3] :!CSslash] ] ;;• slash+spacebar for Help Menu Search (via System hotkey ⌘⇧+/) 🟢

		[:e [:open "evernote:///view/11846588/s107/45e4e957-a18b-8721-8099-0108dfdb2168/6d950bc3-9eca-4610-a1c6-e8dc89702cd2/"] ] ;;•slash+e for open✨ new 8/06/23 📗 EN LOG in Evernote
		[:b [:open "obsidian://advanced-uri?vault=reference-vault&commandid=workspace%253Atoggle-pin&uid=c2352d6a-240a-4730-90da-91bdf10486af"] ] ;;• slash+b for pin 👿 cheatsheet (ref vault) URI
		[:l [[:SPKR3] [:open "obsidian://advanced-uri?vault=reference-vault&commandid=quickadd%253Achoice%253Ab01dce33-74de-4033-83ff-83667640f864"]] ] ;;• /+o to open reference vault Quick Add Master log URI
		;; [:INSERTKEY [[:SPKR3] [:open "INSERT_URL"]] ] ;;• slash+INSERTKEY for ✳️ NEW RULE TO COPY

	]}


;;============================ ... (more stuff)  ================================
	;;* E mode for...
		{:des "e-mode for e things"
		:rules [:e& [:c [:km "Try Current Macro"]]]}

		;;* Chunk Mode
     {:des   "chunkwm mode"
				:rules [
					[:!CS4 ["/usr/local/bin/chunkc border::clear" :!CS4]]
					[:!CS6 ["/usr/local/bin/chunkc border::clear" :!CS3]]
					[:!COSf "/usr/local/bin/chunkc tiling::window --toggle native-fullscreen"]
					:chunkwm-insert-mode
							[:spacebar "/usr/local/bin/chunkc tiling::window --use-insertion-point cancel"]
							[:j "/usr/local/bin/chunkc tiling::window --use-insertion-point west"]
							[:k "/usr/local/bin/chunkc tiling::window --use-insertion-point south"]
							[:i "/usr/local/bin/chunkc tiling::window --use-insertion-point north"]
							[:l "/usr/local/bin/chunkc tiling::window --use-insertion-point east"]
				:chunkwm-move-mode 	;; move windows
							[:j "/usr/local/bin/chunkc tiling::window --warp west"]
							[:k "/usr/local/bin/chunkc tiling::window --warp south"]
							[:i "/usr/local/bin/chunkc tiling::window --warp north"]
							[:l "/usr/local/bin/chunkc tiling::window --warp east"]
				:chunkwm-scale-mode ;; scale windows
							[:j "~/local/bin/chunkwm-resize left"]
							[:k "~/local/bin/chunkwm-resize down"]
							[:i "~/local/bin/chunkwm-resize up"]
							[:l "~/local/bin/chunkwm-resize right"]
							[:spacebar "/usr/local/bin/chunkc tiling::desktop --equalize"]; equalize size of windows
					; :tab-mode
							[:return_or_enter "~/local/bin/chunkwm-change-mode"]
							[:grave_accent_and_tilde "/usr/local/bin/brew services restart chunkwm"]
								[:j "/usr/local/bin/chunkc tiling::window --focus west"]
								[:k "/usr/local/bin/chunkc tiling::window --focus south"]
								[:i "/usr/local/bin/chunkc tiling::window --focus north"]
								[:l "/usr/local/bin/chunkc tiling::window --focus east"]
								[:n "/usr/local/bin/chunkc tiling::window --focus next"]
								[:p "/usr/local/bin/chunkc tiling::window --focus prev"]
							;; change gap setting, reload chunkwmrc
								[:backslash "~/local/bin/chunkwm-gaps 10 10 5 5 7.5"]
								[:delete_or_backspace "~/local/bin/chunkwm-gaps 0 0 0 0 0"]
					;; chunkwm workspace
						;; [:1 "/usr/local/bin/chunkc tiling::desktop --focus $(( $(/usr/local/bin/chunkc tiling::query --desktop id) == 1 ? $(/usr/local/bin/chunkc get _last_active_desktop) : 1 ))"]
						;; [:2 "/usr/local/bin/chunkc tiling::desktop --focus $(( $(/usr/local/bin/chunkc tiling::query --desktop id) == 2 ? $(/usr/local/bin/chunkc get _last_active_desktop) : 2 ))"]
						;; [:3 "/usr/local/bin/chunkc tiling::desktop --focus $(( $(/usr/local/bin/chunkc tiling::query --desktop id) == 3 ? $(/usr/local/bin/chunkc get _last_active_desktop) : 3 ))"]
						;; [:4 "/usr/local/bin/chunkc tiling::desktop --focus $(( $(/usr/local/bin/chunkc tiling::query --desktop id) == 4 ? $(/usr/local/bin/chunkc get _last_active_desktop) : 4 ))"]
					;; rotate windows clockwise and anticlockwise
				[:semicolon "/usr/local/bin/chunkc tiling::window -M next"]
				[:r "/usr/local/bin/chunkc tiling::desktop --rotate 90"]
					[:!Sr "/usr/local/bin/chunkc tiling::desktop --rotate 270"]
					;; rotate on x and y axis
					[:y "/usr/local/bin/chunkc tiling::desktop --mirror vertical"]
					[:!Sy "/usr/local/bin/chunkc tiling::desktop --mirror horizontal"]
					[:spacebar "/usr/local/bin/chunkc tiling::window --toggle fullscreen"]
					[:a "/usr/local/bin/chunkc tiling::window --toggle float"]
					[:b "/usr/local/bin/chunkc tiling::desktop --layout bsp"]
					[:m "/usr/local/bin/chunkc tiling::desktop --layout monocle"]
					[:0 "/usr/local/bin/chunkc tiling::desktop --layout float"]
					[:x "/usr/local/bin/chunkc tiling::window --close"]

					[:delete_or_backspace "/usr/local/bin/chunkc tiling::window --close"]
					[:open_bracket "/usr/local/bin/chunkc tiling::window --send-to-monitor prev"]
					[:close_bracket "/usr/local/bin/chunkc tiling::window --send-to-monitor next"]]}
]
:simlayer-threshold 210 ;def = 50 ;! when set to 1000 there is very noticable delay and 50 isnt enough time, 300 too much
	;! seems to create obsene delay on  on key up
;;*==================== DEVICES and INPUT SOURCES ====================
		:devices {
				:macbook-internal [{:product_id 631 :vendor_id 1452}]
				:uhk-keyboard [{:product_id 24866 :vendor_id 7504}]
				:uhk-keyboard-2 [{:product_id 24868 :vendor_id 7504}]
			}
		:applications {
			:Chromes      ["^com\\.google\\.Chrome$", "^org\\.chromium\\.Chromium$", "^com\\.google\\.Chrome\\.canary$"]
			:Terminals     ["^com\\.apple\\.Terminal$", "^com\\.googlecode\\.iterm2$", "^co\\.zeit\\.hyperterm$", "^co\\.zeit\\.hyper$", "^io\\.alacritty$", "^net\\.kovidgoyal\\.kitty$"]
			:Finder           ["^com\\.apple\\.finder$"]
			:Debuggers   ["^org\\.mozilla\\.firefox$", "^org\\.mozilla\\.firefoxdeveloperedition$", "^com\\.google\\.Chrome$", "^org\\.chromium\\.Chromium$", "^com\\.google\\.Chrome\\.canary$", "^com\\.apple\\.Safari$", "^com\\.microsoft\\.VSCode$"]
			:Browsers      ["^org\\.mozilla\\.firefox$", "^org\\.mozilla\\.firefoxdeveloperedition$", "^com\\.google\\.Chrome$", "^org\\.chromium\\.Chromium$", "^com\\.google\\.Chrome\\.canary$", "^com\\.apple\\.Safari$"]
			}
		:input-sources {
	 		:squirrel {:input_mode_id   "com.googlecode.rimeime.inputmethod.Squirrel"
						:input_source_id "com.googlecode.rimeime.inputmethod.Squirrel.Rime"
						:language        "zh-Hans"}
			:us {:input_mode_id   ""
					:input_source_id "com.apple.keylayout.US"
					:language        "en"}
			}
;;*============================ END ===============================
}

;;* protocol ======================================================
;; ☰ new entry PROTOCOL:
	;; add line with prepend date and description to change log
	;; save, stage, commit with short&good description, push... be sure to pull next time opening up other mbp
