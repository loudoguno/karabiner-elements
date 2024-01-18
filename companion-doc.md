1/18/24
;;* TODO testing out "send" rule
		;; [:a [[:SPKR3] [:wait] [:escp]] ] ;; works
		;; [:r [:sendreturn]] ;; ☑️  works
		;; [:q [:sendq]] ;;? works i guess but sends capital? look into
		;; [:1 [[:SPKR3] [:sendesc]]] ;;❓ seems to send tab?

12/17/23 removed
;• jlik for ⌥ navigation................................. ❗redundant to space+d+j/l TODO delete
		;; [:#Sj :!O#Sleft_arrow]
		;; [:#Sl :!O#Sright_arrow]
		;; [:#Si :!O#Sup_arrow]
		;; [:#Sk :!O#Sdown_arrow]

-------------------------------------------------------

	;; {:des "left cmd -> cmd+tab"
        ;;  :rules [[:left_command :left_command nil {:alone :!Ctab}]]} ;; tap left command to tab last app 🔰 new, from Nikita
------------------------------------------------------
------------------------------------------------------
removed double press  12/10/23
;; * Double Press Left command for Moom ❌ DISABLED > 9/25/23 removing this fixed keysequences in BTT
		;; {:des "Double Press Left commandl" :rules [[:condi :!f& :!d& :!c& :!k& :!w& :!Rctrl-mode]
			;; [:left_gui [[:SPKR2] :!!f14 ["LCMD" 0]] ["LCMD" 1]] ; left commands double press sends moom key f14 (confusing because coded before single press)
			;; [:left_gui :left_gui nil {:alone [[:SPKR3]["LCMD" 1 ]]:delayed {:invoked ["LCMD" 0] :canceled ["LCMD" 0]}}]
			;; ]}
------------------------------------------------------
------------------------------------------------------

--- [ ] moving e mode

;; 230806 (Sun) trying to sync up all devices
;; 230820 (Sun) 🥔 syncing machines before Idaho
;; TODO add Q mode (q+n quick note)
;; TODO Idea for 1-mode (quick notes, now...) good because only lose pinky...
;; 10/10/23 adding g+t for good task
;; 12/01/23 made x+l for extract

;;  {:goku {:default true
;;          :alone   80 ; hold for .. ms to register single tap
;;          :held    50 ; TODO: not sure what it's for
;;          :delay   0 ; time after which the key press is delayed
;;          :sim     30}} ; jkeys need to be pressed within this threshold to be considered simultaneous


;; [: [ [:SPKR3] [:open "INSERT_URL"] ] ] ;;• KEY1+KEY2 for COMMAND_NAME...

	 ;; keep around
		;; [:comma [:km "Switch All Workspaces Left"]] ;;• w+comma for Switch All Workspaces Left
		;; [:period [:km "Switch All Workspaces Right"]];;• w+period for Switch All Workspaces Right
		;; [:caps_lock [ [:SPKR3] [:btt "Move Window Space Left"] ] ] ;;• w+caps_lock/f for Move Window Space Left/Right (via BTT script)
		;; [:f [[:SPKR3] [:btt "Move Window Space Right"] ] ] ;;• w+f for  Move Window Space Right
		;; [:1 [ [:SPKR3] [:btt "Switch to Workspace 1"]]] ;;• w+1 for Switch to Workspace 1 (via BTT script)
		;; [:2 [ [:SPKR3] [:btt "Switch to Workspace 2"]]] ;;• w+2 for Switch to Workspace 2 (via BTT script)
		;; [:3 [ [:SPKR3] [:btt "Switch to Workspace 3"]]] ;;• w+3 for Switch to Workspace 3 (via BTT script)
		;; [:4 [ [:SPKR3] [:btt "Switch to Workspace 4"]]] ;;• w+4 for Switch to Workspace 4 (via BTT script)

--- workspace

file://Users/loudog/Library/Mobile Documents/com~apple~CloudDocs/notes/cheatsheets/_cheatsheets.code-workspace


🔮 recent  s (drafts) collecting as reference sheet: drafts://open?uuid=C2A18889-3DD4-4415-9436-295E9AC86C22 cheatsheets👿

file:///Users/loudog/Library/Mobile%20Documents/com~apple~CloudDocs/notes/cheatsheets%F0%9F%91%BF/ 🕐 r+t Open Recent Drafts

drafts://x-callback-url/runAction?text=TEXT&action=Open%20Recent%20Drafts 📟 py-scripts (vs code workspace

file:///Users/loudog/Dropbox/Sync/py-scripts/py-scripts.code-workspace 😎 Drafts daily scratchpad (drafts action)

drafts://x-callback-url/runAction?text=TEXT&action=goto%20daily%20scratchpad 🆚 Open sync file config in VS Code

vscode:///Users/loudog/Dropbox/Sync/KeyCue/KeyCue-URLs.txt


	;; keep around
			;; [:m [:km "GoTo Gmail Inbox"] [["g&" 1] ["go&" 1]]] ;;+ g+o+m for GoTo Gmail Inbox
			;; [:r [:km "Go To Recent OmniFocus Task"] [["g&" 1] ["go&" 1]]] ;;+ g+o+r for Go To Recent OmniFocus Task
			;; [:a [:km "Finder: Go To Just Press Record Voice Recordings"] [["g&" 1] ["go&" 1]]] ;;+ g+o+r for Finder: Go To Just Press Record Voice Recordings

;;* TODO testing out "send" rule
		;; [:a [[:SPKR3] [:wait] [:escp]] ] ;; works
		;; [:r [:sendreturn]] ;; ☑️  works
		;; [:q [:sendq]] ;;? works i guess but sends capital? look into
		;; [:1 [[:SPKR3] [:sendesc]]] ;;❓ seems to send tab?



		;; other brightness key
		;; [:	p :apple_display_brightness_increment] ;;• z+ for brightness up
			;; [:n :apple_display_brightness_decrement] ;;• z+ for brightness up

;; UNUSED SYSTEM KEYs
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
