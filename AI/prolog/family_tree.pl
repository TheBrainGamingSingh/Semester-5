:- discontiguous male/1.
:- discontiguous female/1.
male(manpreet).
female(ekjot).
female(gagan).
male(jatinder).
male(dalip).
female(surinder).
parent(dalip,jatinder).
parent(surinder,jatinder).
parent(gagan,manpreet).
parent(jatinder,manpreet).
parent(gagan,ekjot).
parent(jatinder,ekjot).


father(X,Y):- male(X),parent(X,Y).
mother(X,Y):- female(X),parent(X,Y).
sibling(X,Y):- parent(Z,X),parent(Z,Y), X \= Y.
son(X,Y):- male(X),parent(Y,X).
daughter(X,Y):- female(X),parent(Y,X).
grandparent(X,Y):- parent(X,Z),parent(Z,Y).
grandfather(X,Y):- male(X),grandparent(X,Y).
