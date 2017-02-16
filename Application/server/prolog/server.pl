:- use_module(library(http/thread_httpd)).
:- use_module(library(http/http_dispatch)).
:- use_module(library(http/http_client)).

:- use_module('./main.pl').

:- http_handler(root(.), process, []).

server(Port) :- http_server(http_dispatch, [timeout(30), port(Port)]).
process(_) :- schedule(S), format('Content-type: text/html~n~n'), write(S).

:- server(4040).


