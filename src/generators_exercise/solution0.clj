(ns generators-exercise.solution0)

(require '[clojure.data.generators :as gen])

(defn gen-A-seq [cnt]
  (repeatedly cnt #(str "A" (gen/uniform 0 99))))

(defn gen-B []
  (str "B" (gen/uniform 0 99)))

(defn gen-B-seq [cnt]
  (repeatedly cnt #(gen-B)))

(defn gen-all
  "Generate two random number sequences: one of A numbers, and one of B
  numbers." []
  ;; For example:
  ;; [("A72" "A67" "A30")
  ;;  ("B27" "B65" "B89")]
  (doall [(gen-A-seq 3)
          (gen-B-seq 3)]))
