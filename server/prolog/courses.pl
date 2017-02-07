:- module(course, [course/1, isTP/1, isTD/1, isMagistral/1]).
course('Java').
course('C++').
course('Android').
course('Mathémathiques').
course('Logique Floue').
course('Anglais').

isTP(Course) :- course(Course),
				tp(Course).
				
isTD(Course) :- course(Course),
				td(Course).
				
isMagistral(Course) :- 	course(Course),
						magistral(Course).