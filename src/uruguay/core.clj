(ns uruguay.core
  (:require [clojure.string :as string]))

;; === Syntax sprint ===

; Vector
[1 2 3 4]

; List
'(1 2 3 4)

; Map
{:name "Ben" :age 31}

; Function calling
(+ 3 1)

(str "hey " "there")

(* (+ 1 1) (+ 1 1))






; Function definition
(defn welcome [name]
  (str "Hey there, " name))

(welcome "John")







;; === Immutable data structures ===

(def user {:name "Ben" :age 31})
(identity user)

(assoc user :city "Boston")
(identity user)

(dissoc user :name)
(identity user)



;; === When things "change" ===

(def thoughtbot-attributes
  {:name "thoughtbot"
   :employee-count 50})

(def
  thoughtbot
  (atom thoughtbot-attributes))

#_(swap!
  thoughtbot
  update-in
  [:employee-count]
  inc)

(identity thoughtbot-attributes)



(def savings-account (ref 100))
(def checking-account (ref 100))

(defn move-from-checking-to-savings
  [checking-account
   savings-account
   amount]
  (dosync
    (alter checking-account - amount)
    (alter savings-account + amount)))

#_(move-from-checking-to-savings
    checking-account
    savings-account
    10)

#_(println
    "Savings balance: " @savings-account
    "Checking balance: " @checking-account)


;; === Macros ===

(defmacro using-postfix
  [expression]
  (cons
    (last expression)
    (butlast expression)))

(using-postfix (1 2 +))


(defmacro unless
  [test then else]
  (if (not test) then else))

(unless false "then" "else")
(unless true "then" "else")


(string/reverse
  (first
    (string/split
      (string/lower-case "RubyConf Uruguay")
      #" ")))

(->
  "RubyConf Uruguay"
  string/lower-case
  (string/split #" ")
  first
  string/reverse)
