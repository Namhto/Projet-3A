:-module(promo,[promotion/1, branch/1, pbdp/4]).


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

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%% Les associations promo - filiaire - groupe TD - groupe TP %%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

pbdp('1A', 'IR', d1, p1).
pbdp('1A', 'IR', d1, p2).
pbdp('1A', 'IR', d2, p2).
pbdp('1A', 'IR', d2, p3).

pbdp('2A', 'IR', d1, p1).
pbdp('2A', 'IR', d1, p2).
pbdp('2A', 'IR', d2, p2).
pbdp('2A', 'IR', d2, p3).

pbdp('1A', 'AS', d1, p1).
pbdp('1A', 'AS', d1, p2).
pbdp('1A', 'AS', d2, p2).
pbdp('1A', 'AS', d2, p3).

pbdp('2A', 'AS', d1, p1).
pbdp('2A', 'AS', d1, p2).
pbdp('2A', 'AS', d2, p2).
pbdp('2A', 'AS', d2, p3).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%%%%%%%% Contraintes %%%%%%%%%
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

isAssociated(X,Y) :- pbdp(X,Y,_,_).
isAssociated(X,Y) :- pbdp(X,_,Y,_).
isAssociated(X,Y) :- pbdp(X,_,_,Y).