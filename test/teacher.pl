use_module('./../teacher').

test(Teachers,Teachess) :-  findall(X,teacher(X),Teachers),
							findall(Y,teaches(_,Y),Teachess).