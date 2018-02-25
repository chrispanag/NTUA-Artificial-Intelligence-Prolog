:- [taxis].
:- [lines].
:- [nodes].

intersectionsOnStreet(A, D) :-
  belongsTo(B, A),
  isConnected(B, C),
  belongsTo(C, D),
  isRoad(D),
  D \= A.

canMoveFromTo(A, B) :-
  belongsTo(A, C),
  belongsTo(B, C),
  isRoad(C),
  ((\+ oneway(C), (isConnected(A, B) ; isConnected(B, A)));
  (oneway(C), \+ reverse(C), (isConnected(A, B)));
  (oneway(C), reverse(C), isConnected(B,A))).

canMove(A, B) :-
  belongsTo(A, C),
	belongsTo(B, C),
	isRoad(C),
	(oneway(C) ->
    (reverse(C) -> isConnected(B,A)
    ; isConnected(A, B))
  ; (isConnected(A, B) ; isConnected(B,A))).

maxSpeedNode(A, X) :-
  belongsTo(A, B),
  isRoad(B),
  (maxSpeed(B, D) -> X is D ; X is 40).

heuristic(B, X) :-
  maxSpeed(B, D),
  lanes(B, C),
  X is D * ((C - 1) * 0.5 + 1).
