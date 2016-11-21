:- use_module('./../course').

test(Courses, TDs, TPs) :- 	findall(X, course(X), Courses),
							findall(Y, isTD(Y), TDs),
							findall(Z, isTP(Z), TPs).