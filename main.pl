:- module(main, [schedule/1]).

:- use_module('./promo.pl').
:- use_module('./course.pl').
:- use_module('./salle.pl').
:- use_module('./teacher.pl').

%%%%%%%%%%%%%%%%%%%%%% A déplacer dans promo.pl une fois bien modélisée %%%%%%%%%%%%%%%%%%%%%
learn('c', '1A').
learn('maths', '1A').
learn('maths', '2A').
learn('java', '2A').
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

time('8'). time('9'). time('10'). time('11'). time('12'). time('13'). time('14'). time('15'). time('16'). time('17').

day('monday').
day('tuesday').
day('wednesday').
day('thirsday').
day('friday').
day('saturday').
day('sunday').

courseInstance(Teacher, Student, Place, CourseLabel, Time) :- teaches(Teacher,CourseLabel), promotion(Student), learn(CourseLabel, Student), room(Place), time(Time).

instanciate(courseInstance(T,S,P,C,Time)) :- courseInstance(T,S,P,C,Time). 

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%% Test_A : donne une liste de cours avec comme contraintes : SALLE, PROF, PROMO %%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
scheduleAuto(S,X) :- schedule_Acc([], S, X).

schedule_Acc(S,S,0) :- !.
schedule_Acc(L,S,X) :- instanciate(C), append(L,[C],L1),
						Y is X-1,
						schedule_Acc(L1,S,Y).
						
nbrCourses(X) :- findall(P,learn(P,_),L), length(L,X).	

test_A(S) :- nbrCourses(X), scheduleAuto(S,X), uniqueRessource(S).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

scheduleDay(S) :- nbrCourses(X), scheduleAuto(S,X), uniqueRessource(S).

dayInstance(Day, S) :- scheduleDay(S), day(Day).

instanciateDay(dayInstance(Day, S)) :- dayInstance(Day, S).

scheduleWeek_Acc(S,S,0) :- !.
scheduleWeek_Acc(L,S,X) :- instanciateDay(D), append(L,[D], L1),
							Y is X-1,
							scheduleWeek_Acc(L1, S, Y).
						
scheduleWeek(S) :- scheduleWeek_Acc([], S, 7).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%													 CONTRAINTES 													%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%% Unicité %%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
uniqueRessource([]).
uniqueRessource([_]).

uniqueRessource([courseInstance(_,_,P,_,Time)|R]) :- member(courseInstance(_,_,P,_,Time),R), !, fail.
uniqueRessource([courseInstance(T,_,_,_,Time)|R]) :- member(courseInstance(T,_,_,_,Time),R), !, fail.
uniqueRessource([courseInstance(_,S,_,_,Time)|R]) :- member(courseInstance(_,S,_,_,Time),R), !, fail.

uniqueRessource([_|R]) :- uniqueRessource(R).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

pascourt([], Time).
pascourta8h([courseInstance(perrone,_,_,_,height)|_R]) :- !, fail.
pascourta8h([_|R]) :-  pascourta8h(R).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% TEST SERVEUR %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

schedule(S) :- scheduleDay(S).