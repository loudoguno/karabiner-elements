Notes on Moneterey Karabiner setup

bvxzxcvbasdaassdddffgghkjl;qeertuyopqasdfghjkq

-☑️ TODO: 
	- b+o+a for boldate, n+e+q for new notes

⌘_space 2x is still control

11/30/21 removed Z chord mode
		;+ z+b+...............................................................................................................................
			[:b [:km "km macro 1"] [["z&" 1] ["zb&" 1]]] ;+ z+b² for km macro 1
			[:i :apple_display_brightness_increment [["z&" 1] ["zb&" 1]]] ;+ z+b+i
			[:k :apple_display_brightness_decrement [["z&" 1] ["zb&" 1]]] ;+ z+b+i
	:z& ;* –––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
		;* z+b for brightness (held if held)
				[:b [ [:vk_none] ["zb&" 1] ] nil {:delayed {:canceled [ ["zb&" 0]["z&" 0] ]
				:invoked [ [vk_none] ["zb&" 0] ] }:held [ [:km "z held"] ["zb¬" 1]] }]




11/16/21
	- label depricated rules (🔴 disabled) and fixed rules with 🟢
	;; ✅  fixed slash+spacebar for help menu search
	;; ✅  fixed n+i for omnifocus quick entry
	-


(🔴 disabled)
	;* j+e for Jump to Evernote (🛑 disabled)
					;; [:e [ [:SPKR2] :!COspacebar ["je&" 1] ] nil {:delayed {:canceled[["je&" 0]["j&" 0]]
					;; :invoked[:vk_none ["je&" 0]] } :held[:escape [:SPKR3] [:km "Query Evernote"]["je¬" 1]] }]
