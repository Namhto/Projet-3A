:-module(salle,[room/1, roomSize/2, roomEquipment/2, roomType/2])

%% Ce fichier contient les informations relatives aux salles de cours &&

%%%%%%%%%%%%%%%%%%%%%% 
%%%%%%% Salles %%%%%%%
%%%%%%%%%%%%%%%%%%%%%%
room('GA').
room('PA').
room('e23').
room('e25').
room('PC Master').

%%%%%%%%%%%%%%%%%%%%%% 
%%%%%%% Taille %%%%%%%
%%%%%%%%%%%%%%%%%%%%%%
roomSize('GA', 80).
roomSize('PA', 60).
roomSize('e23', 40).
roomSize('e25', 50).
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
roomType('PA', normal).
roomType('e23', normal).
roomType('e25', normal).
roomType('PC Master', TP).


