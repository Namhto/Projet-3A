:- use_module(library(http/thread_httpd)).
:- use_module(library(http/http_dispatch)).
:- use_module(library(http/http_client)).
:- use_module(library(http/json)).
:- use_module(library(http/json_convert)).

:- use_module('./main.pl').

:- http_handler(root(.), process, []).

:- json_object
        courseInstance(prof:string,promo:string,room:string,c:string,time:integer) + [type=courseInstance].

server(Port) :- http_server(http_dispatch, [timeout(30), port(Port)]).

process(_) :- schedule(Data), format('Content-type: text/html~n~n'), write(Data).

:- server(4040).


