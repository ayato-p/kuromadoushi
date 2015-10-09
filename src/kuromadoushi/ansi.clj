(ns kuromadoushi.ansi
  (:require [clojure.string :as str]))

(def csi "\u001b[")

(def sgr "m")

(def reset-font (str csi sgr))

(defmacro defsgrfn [name & args]
  `(defn ~name [s#]
     (str csi ~(str/join ";" args) sgr s# reset-font)))

(defn helper [i c]
  `(list
    (defsgrfn ~(symbol c) ~(+ i 30))
    (defsgrfn ~(symbol (str c "-bg")) ~(+ i 40))
    ))

(defmacro ^:private defsgrfns [colors]
  (let [fns (->> colors
                 (map-indexed helper)
                 (apply concat))]
    `(do
       ~@fns)))

(defsgrfns
  ["black" "red" "green" "yellow" "blue" "magenta" "cyan" "white"])
