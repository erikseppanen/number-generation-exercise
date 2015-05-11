(ns generators-exercise.solution1)

(require '[clojure.data.generators :as gen])

(def common-fields
  "Sequence of random characters that are generated once for all data
  generators."
  {"id" (repeatedly 1000 #(gen/uniform 0 99))})

(def field-closure
  "A closure used to ensure that data generators provide the same sequence of
  common-fields."
  (let [index (atom 0)
        generator (atom "")
        field (atom "")]
    (fn [f g]
      ;; When the field or generator changes
      (when (or (not= @field f) (not= @generator g))
        ;; reset to the new field and/or generator
        (do (reset! generator g) (reset! field f) (reset! index 0)))
      ;; increment the index
      (swap! index inc)
      ;; return the next field from the sequence of common-fields
      (nth (common-fields f) @index))))

;; generate the whole sequence at one time
(defn gen-A-seq [cnt]
  (repeatedly cnt #(str "A" (field-closure "id" "A"))))


;; Here's the problem: some functions generate a single value at a time,
(defn gen-B []
  (str "B" (field-closure "id" "B")))

;; which are called by sequence-value functions
(defn gen-B-seq [cnt]
  (repeatedly cnt #(gen-B)))

(defn gen-all
  "Generate two sequences: one of A numbers, and one of B numbers, where the
  two sequences contain a identical sequence of random numbers." []
  ;; For example:
  ;; [("A45" "A77" "A91")
  ;;  ("B45" "B77" "B91")]
  (doall [(gen-A-seq 3)
          (gen-B-seq 3)]))
