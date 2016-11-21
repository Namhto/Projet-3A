
room(e23).
room(amphi).
room(e32).

roomSize(R,S) :- room(R), number(S).
roomSize(e23,35).
roomSize(amphi,200).

roomEquipment(R,E) :- room(R), equipment(E). 

equipment(computer).
equipment(motor).
equipment(projector).
equipment(chalkBoard).

roomType('tp pc').
roomType(normale).
roomType(meca).
roomType(elec).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%% students %%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
promotion('1A').
promotion('2A').
promotion('3A').

branch('IR').
branch('Auto').


group('1A', 'IR', 10, g1).
group('1A', 'IR', 10, g2).
%définition d'un groupe. Un group doit etre définit à l'aide de l'ensemble de ces paramètres
group(Promo, Branch, NbrStudent, _Name) :- promotion(Promo), branch(Branch), number(NbrStudent).

%simplifie la recherche des noms des groupes.
group(Name) :- group(_,_,_,Name).



%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%  Teacher %%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
teacher(perrone).
teacher(hassenforder).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%% course %%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
course(c).
course(java).
course(language).



teaches(perrone,c).
teaches(perrone,java).
teaches(hassenforder,language).


time(height).
time(ten).

courseInstance(Teacher, Student, Place, CourseLabel, Time) :- teaches(Teacher,CourseLabel), group(Student), room(Place), time(Time).

instanciate(courseInstance(T,S,P,C,Time)) :- courseInstance(T,S,P,C,Time). 

schedule(S) :- instanciate(C1), append([],[C1],S1), 
				instanciate(C2), append(S1,[C2],S).


uniqueRessource([_]).
uniqueRessource([courseInstance(_,_,P,_,Time)|R]) :- member(courseInstance(_,_,P,_,Time),R), !, fail.
uniqueRessource([courseInstance(T,_,_,_,Time)|R]) :- member(courseInstance(T,_,_,_,Time),R), !, fail.
uniqueRessource([_|R]) :- uniqueRessource(R).

pascourta8h([]).
pascourta8h([courseInstance(perrone,_,_,_,height)|_R]) :- !, fail.
pascourta8h([_|R]) :-  pascourta8h(R).




