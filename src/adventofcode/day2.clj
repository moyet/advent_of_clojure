(ns adventofcode.day2
  (:require
    [adventofcode.core :as core]
    [clojure.string :as str]))

(def test-input ["1-3 a: abcde" "1-3 b: cdefg" "2-9 c: ccccccccc"])

(def real-input (core/read-lines "resources/day2"))

(defn inner [xs]
  (let
    [[count char-colon password] (str/split xs #"\s")
     [mincount maxcount] (str/split count #"-")
     char (first char-colon)
     freq (frequencies password)
     ;antal (count (filter #(= char %) (seq password)))
     ]
    (<= (Integer/parseInt mincount) (or (freq char) 0) (Integer/parseInt maxcount))
    )
  )

(defn day2-question1 [xs]
  (count (filter inner xs)))

;(println (day2-question1 real-input))


(defn inner2 [xs]
    (let [
          [count char-colon password] (str/split xs #"\s")
          [min-pos max-pos] (map dec (map #(Integer/parseInt %) (str/split count #"-")))
          char (first char-colon)
          first_value (nth password min-pos "")
          last_value (nth password max-pos "")
     ]
        (filter #(= char %) [first_value last_value])
))


(defn day2-question2 [x]
  (count (filter #(= 1 %) (map count (map inner2 real-input))))

  )
