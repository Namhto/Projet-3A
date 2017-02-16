:- module(course, [course/1, isTP/1, isTD/1, isMagistral/1]).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%% course %%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
course('Java').
course('C++').
course('Android').
course('Mathémathiques').
course('Logique Floue').
course('Anglais').

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%% magistral %%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
magistral('Java').
magistral('C++').
magistral('Android').
magistral('Mathémathiques').
magistral('Logique Floue').
magistral('Anglais').

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%% tp %%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
tp('xxxxxxxxxx').
tp('yyyyyyyyyyy').

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%% règles %%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
isTP(Course) :- course(Course),
				tp(Course).
				
isTD(Course) :- course(Course),
				td(Course).
				
isMagistral(Course) :- 	course(Course),
						magistral(Course).