:-module(teacher, [teacher/1, teaches/2]).

%% Ce fichier contient les informations relatives aux enseignants &&

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%%%%% Enseignants %%%%%%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
teacher('perrone').
teacher('hassenforder').

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%% Relations prof - cours %%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
teaches('perrone','c').
teaches('perrone','java').
teaches('hassenforder','maths').