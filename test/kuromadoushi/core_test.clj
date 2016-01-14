(ns kuromadoushi.core-test
  (:require [clojure.test.check.clojure-test :refer [defspec]]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test :refer :all]
            [kuromadoushi.core :refer :all]))

(defn- valid-str? [s]
  (let [t (set (map str (range 8)))]
    (some? (t s))))

(def gen-invalid-str-alphanumeric
  (gen/such-that #(not (valid-str? %))
                 (gen/fmap str gen/char-alphanumeric)))

(defspec render*-space-cases
  10000
  (prop/for-all [s gen-invalid-str-alphanumeric]
    (= (render* s) space)))

(deftest render*-test
  (testing "with string"
    (is (= (render* "01234567")
           "[40m　[m[41m　[m[42m　[m[43m　[m[44m　[m[45m　[m[46m　[m[47m　[m"))

    (are [expect actual] (= (render* expect) actual)
      "0"        "[40m　[m"
      "1"        "[41m　[m"
      "2"        "[42m　[m"
      "3"        "[43m　[m"
      "4"        "[44m　[m"
      "5"        "[45m　[m"
      "6"        "[46m　[m"
      "7"        "[47m　[m"))

  (testing "with java.net.URL"
    (is (= (render* (clojure.java.io/resource "test.dat"))
           "[40m　[m[41m　[m[42m　[m[43m　[m[44m　[m[45m　[m[46m　[m[47m　[m")))

  (testing "with java.io.File"
    (is (= (render* (clojure.java.io/file "dev-resources/test.dat"))
           "[40m　[m[41m　[m[42m　[m[43m　[m[44m　[m[45m　[m[46m　[m[47m　[m")))

  (testing "with java.io.BuffeerdReader"
    (with-open [r (java.io.BufferedReader. (java.io.StringReader. "01234567"))]
      (is (= (render* r)
             "[40m　[m[41m　[m[42m　[m[43m　[m[44m　[m[45m　[m[46m　[m[47m　[m")))))
