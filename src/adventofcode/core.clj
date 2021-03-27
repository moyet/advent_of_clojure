(ns adventofcode.core)

(require '[clojure.string :as str])

(defn read-lines [path & condition]
  (
    let [
         lines (slurp path)
         splitted-lines (str/split-lines lines)]

         (cond
           (= (first condition) :as-int) (map #(Integer/parseInt %1) splitted-lines)
           :else splitted-lines
           )))
