:- module(promo,[promotion/1, branch/1, groupTP/3, groupTP/1, groupTD/3, groupTD/1]).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%% Les promotions %%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

promotion('1A').
promotion('2A').
promotion('3A').

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%% Les Filières %%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

branch('IR').
branch('AS').

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%% Les Groupes de TD %%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

groupTD('1A', 'IR', g1).
groupTD('1A', 'IR', g2).
groupTD('2A', 'IR', g3).
groupTD('2A', 'IR', g4).
groupTD('3A', 'IR', g5).
groupTD('3A', 'IR', g6).

groupTD('1A', 'AS', g7).
groupTD('1A', 'AS', g8).
groupTD('2A', 'AS', g9).
groupTD('2A', 'AS', g10).
groupTD('3A', 'AS', g11.
groupTD('3A', 'AS', g12).

groupTD(Promo,Branch,GroupeName):- promotion(Promo),branch(Branch).

groupTD(Name):-groupTD(_,_,Name).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%% Les Groupes de TD %%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

groupTP('1A', 'IR', g1).
groupTP('1A', 'IR', g2).
groupTP('2A', 'IR', g3).
groupTP('2A', 'IR', g4).
groupTP('3A', 'IR', g5).
groupTP('3A', 'IR', g6).

groupTP('1A', 'AS', g7).
groupTP('1A', 'AS', g8).
groupTP('2A', 'AS', g9).
groupTP('2A', 'AS', g10).
groupTP('3A', 'AS', g11.
groupTP('3A', 'AS', g12).

groupTP(Promo,Branch,GroupeName):- promotion(Promo),branch(Branch).

groupTP(Name):-groupTP(_,_,Name).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%% Contraintes %%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
