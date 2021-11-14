https://github.com/yqrashawn/GokuRakuJoudo/blob/master/in-the-wild.md
* https://github.com/rgomezcasas/dotfiles/blob/main/os/mac/karabiner-goku/karabiner.edn
* https://gist.github.com/nikolai-cc/02f6b070972840323ae355ef847e91a6 ⭐

* rething hyper key
* game out system that doesn't use 3 key cords




{
;; ----------------------------------
;; this is my goku file for karabiner
;; ----------------------------------
;; more info about goku: https://github.com/yqrashawn/GokuRakuJoudo
;; more info about karabiner: https://karabiner-elements.pqrs.org/docs
;; ----------------------------------
;; article karabiner god mode by nikita: https://medium.com/@nikitavoloboev/karabiner-god-mode-7407a5ddc8f6
;; examples: https://github.com/yqrashawn/GokuRakuJoudo/blob/master/examples.org#profiles-wip
;; tutorial: https://github.com/yqrashawn/GokuRakuJoudo/blob/master/tutorial.md#basic8
;; another article: https://blog.jkl.gg/hacking-your-keyboard/
;; very well documented edn file by Kaushik Gopal: https://gist.github.com/kaushikgopal/ff7a92bbc887e59699c804b59074a126
;; key names: https://github.com/yqrashawn/GokuRakuJoudo/blob/master/src/karabiner_configurator/keys_info.clj

:profiles {
    :Default {
        :default    true
        :sim        50      ;; if keydown event for two different keys are pressed within :sim ms, the keypresses are considered simultaneous
        :delay      500     ;; after :delay ms, the key press is considered to be delayed (TODO WHAT IS THIS??)
        :alone      1000    ;; if keyup event comes within :alone ms from keydown, the key is not just pressed but held
        :held       500     ;; key is fired twice when :held ms is elapsed (otherwise seen as a hold command) (TODO WHAT IS THIS??)
    }
} ;; profiles

;; you can create templates for running shell commands. These follow clojure string template syntax.
:templates {
    :echo "echo \"%s\""
    :open "open \"%s\""
    :open-app "open -a \"%s\""
} ;; templates

;; layers are modifier keys
;; TODO what are simlayers?
:simlayers {
    :launch-mode { :key :o }
} ;; layers

;; with tos you can predefine 'to' keypresses to easily parse them
:tos {
    ;; in order for OSX to register a caps lock press, it has to be held for a little under 100ms
    :toggle_caps {:key :caps_lock :hold_down_ms 100}
}
;; This is where you define the modifications
:main [

    {
        :des "caps lock enhancements"
        :rules [
            ;; Change caps lock to hyper key when held and esc when tapped
            [
                :##caps_lock           ;; FROM caps lock key with no or any modifiers
                :!CTOleft_shift        ;; TO left shift with modifiers Command Control
                nil                    ;; with no conditionals
                {:alone :toggle_caps}  ;; OPTIONS: if pressed alone, press caps_lock event, but hold it for 100ms
            ]
        ]
    }
    {
        :des "launch mode: quick launch applications"
        :rules [
            :launch-mode                                      ;; when open-mode is active (o is held)
                [:t [:open-app "terminal"]]                   ;; and t is pressed, open Terminal
                [:f [:open-app "finder"]]                     ;; and f is pressed, open Finder
                [:d [:open "/users/nikolai/Desktop"]]         ;; and d is pressed, open the Desktop in finder
                [:m [:open "https://theministry.co"]]         ;; and m is pressed, open the Ministry website
        ]
    }
]
}
