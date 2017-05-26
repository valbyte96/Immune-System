;; gorilla-repl.fileformat = 1

;; @@

;; Definition for user agents. This is a good template to build on to produce
;; smarter agents.

(ns pucks.agents.user  
  (:use [pucks globals util]
        [pucks.agents active]
        pucks.agents.generic))

(defn rand-probability
  "Returns a random probability between 0 and 1.0."
  []
  (rand 1.0))


(defn mutate-probability
  "Returns a mutated version of probability value p."
  [p]
  (max 0.0 (min 1.0 (+ p (- (rand 0.05) 0.025)))))
;;;
(defn mutate-kill
  "Returns a mutated version of color vector c."
  [k]
  (rand-int 4))

(defn mutate
  "Mutates a given virus's 'kill' value to make it look like a body cell"
  [genome]
  (-> genome
    (assoc :kill (mutate-kill (:kill genome)))))



(defn user-proposals [p]
 
  (merge {:acceleration 0
          :rotation (relative-position->rotation (:velocity p))
          :transfer (into [] (for [victim (filter :mobile (:overlaps p))]
                               {:self (:id p)
                                :other (:id victim)
                                :bid {}
                                :ask (if (= 3 (:kill (:genome (:memory victim)))) 
                                       {:energy 0.1}
                                       {:energy 0})}))}
         (if (< (rand-probability) 0.001)
           {:spawn [(assoc ((:spawn-function p))
                      ;; position will be relative to position of parent
                      :memory {:genome (if (<= (mutate-probability (float 0.001)) (float 0.00001)) 
                                         (mutate (:genome (:memory p)))
                                         (:genome (:memory p)))}
                      :position [(- (rand-int 3) 1) (- (rand-int 3) 1)])]}
           {})))



;;
;(defn user [spawn-function]
 (defn user []
  (merge (active)
         {:zapper true
          :user true
          :proposal-function user-proposals
          :memory {:genome {:kill 2}}
          :spawn-function user 

          })
          )

;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;pucks.agents.user/user</span>","value":"#'pucks.agents.user/user"}
;; <=

;; @@

;; @@

;; @@

;; @@
