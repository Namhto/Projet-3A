:- use_module('./promo.pl').
:- use_module('./course.pl').
:- use_module('./salle.pl').

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%  Teacher %%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
teacher('perrone').
teacher('hassenforder').

teaches('perrone','c').
teaches('perrone','java').
teaches('hassenforder','maths').

learn('c', section('1A','IR')).
learn('maths', section('1A','IR')).
learn('maths', section('1A','AS')).
learn('java', section('2A','IR')).

time(height).
time(ten).

courseInstance(Teacher, Student, Place, CourseLabel, Time) :- teaches(Teacher,CourseLabel), groupTD(Student), learn(CourseLabel, Student), room(Place), time(Time).

instanciate(courseInstance(T,S,P,C,Time)) :- courseInstance(T,S,P,C,Time). 


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%% Test_A : donne une liste de cours avec comme contraintes : SALLE, PROF, PROMO %%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
scheduleAuto(S,X) :- schedule_Acc([], S, X).

schedule_Acc(S,S,0) :- !.
schedule_Acc(L,S,X) :- instanciate(C), append(L,[C],L1),
						Y is X-1,
						schedule_Acc(L1,S,Y).
						
nbrCourses(X) :- findall(P,learn(P,_),L), length(L,X).	

test_A(S) :- nbrCourses(X), scheduleAuto(S,X), uniqueRessource(S).

uniqueRessource([]).
uniqueRessource([_]).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%% Contrainte de salle : salle utilisée une seule fois sur un créneau %%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

uniqueRessource([courseInstance(_,_,P,_,Time)|R]) :- member(courseInstance(_,_,P,_,Time),R), !, fail.

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%% Contrainte de prof : prof a une seule fois cours sur un créneau %%%%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

uniqueRessource([courseInstance(T,_,_,_,Time)|R]) :- member(courseInstance(T,_,_,_,Time),R), !, fail.

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%%% Contrainte de promo : promo a une seule fois cours sur un créneau %%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

uniqueRessource([courseInstance(_,S,_,_,Time)|R]) :- member(courseInstance(_,S,_,_,Time),R), !, fail.

uniqueRessource([_|R]) :- uniqueRessource(R).

pascourta8h([]).
pascourta8h([courseInstance(perrone,_,_,_,height)|_R]) :- !, fail.
pascourta8h([_|R]) :-  pascourta8h(R).