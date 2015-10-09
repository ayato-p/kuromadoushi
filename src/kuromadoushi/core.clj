(ns kuromadoushi.core
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [kuromadoushi.ansi :as ka])
  (:import [java.io File]
           [java.io BufferedReader]))

(def space "\u3000")

;; ["black" "red" "green" "yellow" "blue" "magenta" "cyan" "white"]
(def fn-table
  {0 ka/black-bg
   1 ka/red-bg
   2 ka/green-bg
   3 ka/yellow-bg
   4 ka/blue-bg
   5 ka/magenta-bg
   6 ka/cyan-bg
   7 ka/white-bg})

(defn- -render [s]
  (let [f (fn [c]
            (let [i (Character/digit c 10)]
              (cond
                (= c \newline) c
                (>= i 0) ((fn-table i) space)
                :else space)))]
    (->> s
         (map f)
         str/join)))

(defprotocol Renderer
  (render* [this] "render function"))

(extend-protocol Renderer
  String
  (render* [this] (-render this))

  File
  (render* [this]
    (render* (with-open [r (io/reader this)]
               (str/join "\n" (line-seq r)))))

  BufferedReader
  (render* [this]
    (render* (str/join "\n" (line-seq this)))))

(defn render [x]
  (println (render* x)))
