(ns adventofcode.core)

(require '[clojure.string :as str])

(defn read-lines [path]
  (
    let [
         lines (slurp path)]
         (str/split-lines lines)
  ))
