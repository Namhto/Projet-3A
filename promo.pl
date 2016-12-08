:-module(promo,[promotion/1, groupTD/1, groupTP/1, branch/1, section/2]).


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%% Les promotions %%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

promotion('1A').
promotion('2A').

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%% Les Filières %%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

branch('IR').
branch('AS').

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Les promotions avec filière %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

section(P, B) :- promotion(P), branch(B).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%% Les Groupes de TD %%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

groupTD('1A', 'IR', g1).
groupTD('1A', 'IR', g2).
groupTD('2A', 'IR', g3).
groupTD('2A', 'IR', g4).

groupTD('1A', 'AS', g5).
groupTD('1A', 'AS', g6).
groupTD('2A', 'AS', g7).
groupTD('2A', 'AS', g8).

groupTD(Promo,Branch,GroupeName):- promotion(Promo),branch(Branch).

groupTD(Name):-groupTD(_,_,Name).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%% Les Groupes de TD %%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

groupTP('1A', 'IR', g1).
groupTP('1A', 'IR', g2).
groupTP('2A', 'IR', g3).
groupTP('2A', 'IR', g4).

groupTP('1A', 'AS', g7).
groupTP('1A', 'AS', g8).
groupTP('2A', 'AS', g9).
groupTP('2A', 'AS', g10).

groupTP(Promo,Branch,GroupeName):- promotion(Promo),branch(Branch).

groupTP(Name):-groupTP(_,_,Name).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%% Contraintes %%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
