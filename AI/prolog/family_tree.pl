male(manpreet).
female(gagan).
male(jatinder).
parent_of(gagan,manpreet).
parent_of(jatinder,manpreet).


father_of(X,Y):- male(X),parent_of(X,Y).
mother_of(X,Y):- female(X),parent_of(X,Y).
ancestor_of(X,Y):- parent_of(X,Y).
ancestor_of(X,Y):- parent_of(X,Z),ancestor_of(Z,Y).
