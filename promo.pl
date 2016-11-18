:- dynamic(ok/1).
:- dynamic(ok/2).

enseignant(perronne).
enseignant(hassenforder).

promotion('3A IR').
promotion('2A AS').

<<<<<<< HEAD
=======
matiere('android').
>>>>>>> origin/master
matiere('c++').
matiere('java').

tp('android').
normal('c++').
normal('java').

salle('ga').
<<<<<<< HEAD
=======
salle('e23').
>>>>>>> origin/master
salle('pc-master').

salleNormale('ga').
salleNormale('e23').
machine('pc-master').

creneau('8h_10h').
creneau('10h_12h').

cours('c++', perronne, '2A AS').
<<<<<<< HEAD
cours('java', hassenforder, '3A IR').
=======
cours('android', hassenforder, '3A IR').
cours('java', perronne, '3A IR').
>>>>>>> origin/master

tpEnMachine(Salle, Matiere) :-	salle(Salle),
								machine(Salle),
								tp(Matiere).
								
pasTP(Salle, Matiere) :-	salle(Salle),
							salleNormale(Salle),
							normal(Matiere).

<<<<<<< HEAD
							
test :- retract(ok(_)),
		retract(ok(_,_)).
		
pasCours(hassenforder, '10h_12h').
		
=======

>>>>>>> origin/master
attribution(Salle, cours(Matiere,Enseignant,Promotion), Creneau) :-	salle(Salle),
																	cours(Matiere,Enseignant,Promotion),
																	creneau(Creneau),
																	tpEnMachine(Salle, Matiere),
																	
																	not(ok(Salle)),
																	not(ok(cours(Matiere,Enseignant,Promotion))),
																	
																	not(ok(Promotion, Creneau)),
																	
<<<<<<< HEAD
																	not(pasCours(Enseignant, Creneau)),
																	
=======
>>>>>>> origin/master
																	assert(ok(Salle)),
																	assert(ok(cours(Matiere,Enseignant,Promotion))),
																	
																	assert(ok(Promotion, Creneau)).
																	
																	
attribution(Salle, cours(Matiere,Enseignant,Promotion), Creneau) :-	salle(Salle),
																	cours(Matiere,Enseignant,Promotion),
																	creneau(Creneau),
<<<<<<< HEAD
								 									pasTP(Salle, Matiere),
=======
																	pasTP(Salle, Matiere),
>>>>>>> origin/master
																	
																	not(ok(Salle)),
																	not(ok(cours(Matiere,Enseignant,Promotion))),
																	
																	not(ok(Promotion, Creneau)),
																	
<<<<<<< HEAD
																	not(pasCours(Enseignant, Creneau)),
																	
=======
>>>>>>> origin/master
																	assert(ok(Salle)),
																	assert(ok(cours(Matiere,Enseignant,Promotion))),
																	
																	assert(ok(Promotion, Creneau)).