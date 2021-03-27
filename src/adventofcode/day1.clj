(ns adventofcode.day1
  (:require
    [adventofcode.core :as core]))

(def test-list [1721
979
366
299
675
1456])


(defn day1-question1 [xs value]
  (let [
        [x & resten] xs
        f (fn [y]
            (= value (+ x y)))
        filt (filter f resten)
        ]
        (if (empty? filt)
          (if (empty? resten) 0 (day1-question1 resten value))
          (* x (first resten))
    )))

(day1-question1 test-list, 2020)


(defn inner-func [xs value]
  (let [
        [x & resten] xs
        f (fn [y]
            (= value (+ x y)))
        filt (filter f resten)
        ]
        (if
          (empty? filt)
          (if (empty? resten) nil (inner-func resten value))
          [x (first filt)]
    )))



(defn day1-question2 [xs value]
  (let [
        [x & resten] xs
        inner-result (inner-func resten (- value x))
        ]
      (if (nil? inner-result)
        (day1-question2 resten, value)
        (do
          (println "product" (* x (apply * inner-result)))
          )
        )
  )
)

(day1-question2 test-list 2020)
