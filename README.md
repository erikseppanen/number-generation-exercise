# generators-exercise

https://www.meetup.com/Cap-Clug/events/221717919/

An exercise to illustrate different approaches to solving a simple but non-trivial random number generation problem.

The starting point of this exercise is some code that already exists to generate two random number sequences: one of A numbers, and one of B numbers. That code is solution0.clj.

For example:
```
[("A72" "A67" "A30")
 ("B27" "B65" "B89")]
```

The problem is to modify the code so that the number sequences are the same for both A & B.

For example:
```
[("A45" "A77" "A91")
 ("B45" "B77" "B91")]
```

solution1.clj & solution2.clj are two approaches to solving this problem.

## Usage

Start a lein repl and execute the (gen-all) functions in each solution namespace (there are three) to generate the desired random number sequences.
