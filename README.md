# karabiner-elements
this is a public repo for sharing my personal goku/Karabiner-Elements configuration. will add more info to (this page)[https://www.notion.so/loudog/Karabiner-Elements-535f103d8dad482ba07a5554042050e6] in my Notion

## TODO
-  add sections to [[README]]
   - [ ] quick start on how to set up (plugins including comment/bracket colorizer,)
   - [ ] emoji key
   - [ ] config file structure
   - [ ] audio feedback explanation
   - [ ] workflows for rapid adding adding/updating of KE rules, syncing between multiple devices,

## How to set up

## emojis and comment colors
colorized comments and emojis are used to add visual texture and landmarks
;;! displays red for needs attention/broken/TODO
;;⭐
;;+
;;•
- ⭕ TODO, ❗ needs attention
- 🟢 working well, 🟡 working sort-of, - 🔴 not working
- 🔰/✨ new

 ## other things to note...
 - © stands for contextual. common actions shared by most apps can be trigger by KM macros that share the same name but only enabled when their app is active. ex, the macro for quick fuzzy searching an app is named  "© Jump To" and the KE rule looks like
```
[:t [:km "© Jump To"]] ;;• j+t for © Jump To (via KM global contextlua)
```
...
