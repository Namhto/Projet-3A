%% Ce fichier contient les informations relatives aux salles de cours &&

%%%%%%%%%%%%%%%%%%%%%%
%%% Les salles %%%%%%%
%%%%%%%%%%%%%%%%%%%%%%
room(GA).
room(PA).
room(e23).
room(e25).
room(PC Master).

%% Taille des salles %%
roomSize(R,S):- room(R),number(S).

%%%%%%%%%%%%%%%%%%%%%%
%%% Equipements %%%%%%
%%%%%%%%%%%%%%%%%%%%%%
equipment(computer).
equipment(motor).
equipment(projector).
equipment(board).

roomEquipment(R,E):- room(R), equipment(E).

%%Types de salles%%
roomType(TP).
roomType(normal).


