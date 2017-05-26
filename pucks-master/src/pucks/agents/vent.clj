;; gorilla-repl.fileformat = 1

;; @@
;; Definitions for vent agents.

(ns pucks.agents.vent
  (:use quil.core 
        [pucks globals util vec2D]
        [pucks.agents active]
        pucks.agents.generic))

(defn rand-prob
  "Returns a random probability between 0 and 1.0."
  []
  (rand 1.0))

(defn draw-vent [p]
  (let [[x y] (:position p)
        radius (:radius p)
        [r g b] (:color p)
        [core-r core-g core-b] [238 118 0]
        core-diameter (int (* (float radius) (:energy p)))]
    (push-matrix)
    (translate x y)
    (rotate (:rotation p))
    ;; membrane
    (fill r g b 100)
    (ellipse 0 0 (* radius 2) (* radius 2))
    ;; core
    (fill 255 255 255)
    (ellipse 0 0 radius radius)
    (fill core-r core-g core-b 196) 
    (ellipse 0 0 core-diameter core-diameter)
    (pop-matrix)))

;; Give energy to any overlapping mobile agent, asking nothing in return.

(defn vent-proposals [p]
  (merge {:transfer (into [] (for [recipient (filter :mobile (:overlaps p))]
                               {:self (:id p)
                                :other (:id recipient)
                                }))}
         (if (< (rand-prob) 0.1)
           {:spawn [(assoc ((:spawn-function p))
                      ;; position will be relative to position of parent

                      :position [(- (rand-int 3) 1) (- (rand-int 3) 1)])]}
           {})))

(defn vent []
  (merge (active)
         {:vent false
          :radius 50
          :color [255 0 0]
          :core-color [174 42 42]
          :draw-function draw-vent
          :proposal-function vent-proposals
          :memory {:genome {:kill 3}}
          :spawn-function vent
          
          
          }))

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;pucks.agents.vent/vent</span>","value":"#'pucks.agents.vent/vent"}
;; <=

;; @@

;; @@
