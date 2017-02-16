:- use_module('./../promo').

test(Promos,Branches,GroupTDs,GroupTPs):-	findall(X, promotion(X), Promos),
											findall(Y, branch(Y), Branches),
											findall(Z, groupTD(_,_,Z), GroupTDs),
											findall(M, groupTP(_,_,M), GroupTPs).