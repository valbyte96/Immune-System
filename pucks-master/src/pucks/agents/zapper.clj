;; gorilla-repl.fileformat = 1

;; @@
;; Definitions for zapper agents.

(ns pucks.agents.zapper
  (:use quil.core 
        [pucks globals util vec2D]
        [pucks.agents active]
        ))

(defn draw-zapper [p]
  (let [[x y] (:position p)
        radius (:radius p)
        [r g b] (:color p)]
    (push-matrix)
    (translate x y)
    ;; membrane
    (fill r g b 100)
    (ellipse 0 0 (* radius 2) (* radius 2))
    ;; core
    (fill r g b)
    (ellipse 0 0 radius radius)
    (pop-matrix)))



;; Take energy from any overlapping mobile agent, without giving anything in
;; return.
(defn zapper-proposals [p]
  {:transfer (into [] (for [victim (filter :mobile (:overlaps p))]
                        { 
                         :self (:id p)
                         :other (:id victim)
                         :bid {}
                         ;:ask {:energy 0}
                         :ask (if (= 2 (:kill (:genome (:memory victim)))) 
                                {:energy 0.1}
                                {:energy 0})
                         }))})
 
                         ;val edits
                         
                         

(defn zapper []
  (merge (active)
         {:zapper true
          :radius 45
          :color [255 255 255]
          :draw-function draw-zapper
          :proposal-function zapper-proposals
          :memory {:genome {:kill 1}}}))


;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;pucks.agents.zapper/zapper</span>","value":"#'pucks.agents.zapper/zapper"}
;; <=

;; @@

;; @@
;; ->
;;; :kill
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@

;; @@
