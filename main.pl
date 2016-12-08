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

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%% Cours magistral %%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
courseInstance(Teacher, Promotion, Place, CourseLabel, Time) :- isMagistral(CourseLabel), teaches(Teacher,CourseLabel), learn(CourseLabel, section(Promotion, Branch)), room(Place), time(Time).

instanciate(courseInstance(T,Promotion, B,P,C,Time)) :- courseInstance(T,Promotion, B,P,C,Time). 

schedule(S) :- instanciate(C1), append([],[C1],S1), 
				instanciate(C2), append(S1,[C2],S).

uniqueRessource([_]) :- write('alalala').
uniqueRessource([courseInstance(_,_,_,P,_,Time)|R]) :- member(courseInstance(_,_,_,P,_,Time),R), !, fail.
uniqueRessource([courseInstance(T,_,_,_,_,Time)|R]) :- member(courseInstance(T,_,_,_,_,Time),R), !, fail.
uniqueRessource([_|R]) :- uniqueRessource(R).

/**
pascourta8h([]).
pascourta8h([courseInstance(perrone,_,_,_,height)|_R]) :- !, fail.
pascourta8h([_|R]) :-  pascourta8h(R).
*/