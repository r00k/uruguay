(ns uruguay.core)

;; === Syntax sprint ===

; Vector
[1 2 3 4]

; List
'(1 2 3 4)

; Map
{:name "Ben" :age 31}

; Symbol
println

; Function calling
(+ 3 1)
(str "hey" "there")
(* (+ 1 1) (+ 1 1))

; Function definition
(defn welcome [name]
  (str "Hey there, " name))

(welcome "John")

; Also:
;  Namespaces
;  Precedence



;; === Interactive development ===

(defn select-evens [numbers]
  (filter odd? numbers))

(select-evens [1 2 3 4 5])

; cqp



;; === Immutable data structures ===

(def user {:name "Ben" :age 31})

(assoc user :city "Boston")
(dissoc user :name)



;; === Macros ===

(defmacro using-postfix
  [expression]
  (conj (butlast expression)
        (last expression)))

(using-postfix (1 2 +))


(defmacro unless
  [test then else]
  `(if (not ~test) ~then ~else))

(unless false "then" "else")
(unless true "then" "else")

