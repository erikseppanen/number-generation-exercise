(ns generators-exercise.solution2)

(require '[clojure.data.generators :as gen])

;; Step 1: Let's continue to generate a random sequence, but take advantage of
;; Clojure's lazy sequences by making it infinite, so the caller can take as
;; many as they need.
(def ids (repeatedly #(gen/uniform 0 99)))

;; Observation: This doesn't need to be framed as a 'mutable state' problem, so
;; let's avoid the use of atoms, and we don't need the closure either.

;;(def field-closure ...)












;; this function is refactored, but generally works the same way
(defn gen-A-seq [cnt]
  (map #(str "A" %) (take cnt ids)))

;; Step 2: Refactor single-value functions so that they accept their random id
;; from the caller, instead of being responsible for generating it themselves.
(defn gen-B [id]
  (str "B" id))

;; Step 3: Refactor sequence-value functions to pass ids to functions
(defn gen-B-seq [cnt]
  (map #(gen-B %) (take cnt ids)))

(defn gen-all
  "Generate two sequences: one of A numbers, and one of B numbers, where the
  two sequences contain a identical sequence of random numbers." []
  ;; For example:
  ;; [("A45" "A77" "A91")
  ;;  ("B45" "B77" "B91")]
  (doall [(gen-A-seq 3)
          (gen-B-seq 3)]))


