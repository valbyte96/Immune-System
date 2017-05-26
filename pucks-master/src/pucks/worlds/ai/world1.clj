;; gorilla-repl.fileformat = 1

;; @@
;; A pucks world.

(ns pucks.worlds.ai.world1  
  (:use [pucks core globals]
        [pucks.agents  vent nursery zapper user]))



(defn agents []
  (concat 
    (for [y (take 5 (iterate #(+ % 20) 100))]
            (merge (zapper) {:position [(rand-int 400) (rand-int 600)]}
              ) )
          (for [x (take 15 (iterate #(+ % 20) 100))]
            (merge (user) {:position [(rand-int 400) (rand-int 600)]}
              ))
          (for [x (take 5 (iterate #(+ % 20) 100))]
            (merge (vent) {:position [(rand-int 400) (rand-int 600)]}
              ))
          
           ;[(nursery user)]
		  ; [(nursery zapper)]
    	   ;[(nursery vent)]
    
          ))

(defn settings []
  {:color [255 0 0]})

;(run-pucks (agents) (settings))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;pucks.worlds.ai.world1/settings</span>","value":"#'pucks.worlds.ai.world1/settings"}
;; <=

;; @@
{:red "blue"}
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:red</span>","value":":red"},{"type":"html","content":"<span class='clj-string'>&quot;blue&quot;</span>","value":"\"blue\""}],"value":"[:red \"blue\"]"}],"value":"{:red \"blue\"}"}
;; <=

;; @@

;; @@
