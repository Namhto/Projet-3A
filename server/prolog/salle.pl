:-module(salle,[room/1, roomSize/2, roomEquipment/2, roomType/2]).

%% Ce fichier contient les informations relatives aux salles de cours %%

%%%%%%%%%%%%%%%%%%%%%%
%%%%%%% Salles %%%%%%%
%%%%%%%%%%%%%%%%%%%%%%
room('GA').
room('e23').
room('PC Master').

%%%%%%%%%%%%%%%%%%%%%% 
%%%%%%% Taille %%%%%%%
%%%%%%%%%%%%%%%%%%%%%%
roomSize('GA', 80).
roomSize('e23', 40).
roomSize('PC Master', 25).

%%%%%%%%%%%%%%%%%%%%%%
%%% Equipements %%%%%%
%%%%%%%%%%%%%%%%%%%%%%
equipment('computer').
equipment('motor').
equipment('projector').
equipment('board').

roomEquipment(R,E):- room(R), equipment(E).

%%%%%%%%%%%%%%%%%%%%%%
%%%% Type salle %%%%%%
%%%%%%%%%%%%%%%%%%%%%%
roomType('GA', normal).
roomType('e23', normal).
roomType('PC Master', TP).
