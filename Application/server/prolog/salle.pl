:-module(salle,[room/1, roomSize/2, roomEquipment/2, roomType/2]).

%% Ce fichier contient les informations relatives aux salles de cours %%

%%%%%%%%%%%%%%%%%%%%%%
%%%%%%% Salles %%%%%%%
%%%%%%%%%%%%%%%%%%%%%%
room('E25').
room('E24').
room('Grand Amphi').
room('Petit Amphi').
room('PC Master').
%%%%%%%%%%%%%%%%%%%%%%
%%%%%%% Taille %%%%%%%
%%%%%%%%%%%%%%%%%%%%%%
roomSize('E25',40).
roomSize('E24',40).
roomSize('Grand Amphi',40).
roomSize('Petit Amphi',40).
roomSize('PC Master',40).

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
roomType('E25',normal).
roomType('E24',normal).
roomType('Grand Amphi',normal).
roomType('Petit Amphi',normal).
roomType('PC Master',normal).
