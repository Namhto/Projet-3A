:-module(promotion,[promotion/1],[group/2],[branch/1])

%% Ce fichier contient la liste des promotions. &&

%%%%%%%%%%%%%%%%%%%%%%
%%% Les promotions %%%
%%%%%%%%%%%%%%%%%%%%%%

promotion('1A').
promotion('2A').
promotion('3A').

%%%%%%%%%%%%%%%%%%%%%%
%%% Les Filières %%%%%
%%%%%%%%%%%%%%%%%%%%%%

branch('IR').
branch('AS').

%%%%%%%%%%%%%%%%%%%%%%
%%% Les Groupes %%%%%%
%%%%%%%%%%%%%%%%%%%%%%

group('1A', 'IR', g1).
group('1A', 'IR', g2).
group('2A', 'IR', g3).
group('2A', 'IR', g4).
group('3A', 'IR', g5).
group('3A', 'IR', g6).

group('1A', 'AS', g7).
group('1A', 'AS', g8).
group('2A', 'AS', g9).
group('2A', 'AS', g10).
group('3A', 'AS', g11.
group('3A', 'AS', g12).

group(Promo,Branch,GroupeName):- promotion(Promo),branch(Branch).

group(Name):-group(_,_,Name).

%%%%%%%%%%%%%%%%%%%%%%
%%% Contraintes %%%%%%
%%%%%%%%%%%%%%%%%%%%%%
