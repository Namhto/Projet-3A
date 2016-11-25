:- module(teacher,[teacher/1,teaches/2]).
:- use_module('course').

%%%%%%%%%%%%%%%%
%%%  Teacher %%%
%%%%%%%%%%%%%%%%

teacher(perrone).
teacher(hassenforder).
teacher(forestier).
teacher(kutter).

teaches(perrone,c).
teaches(perrone,java).
teaches(hassenforder,androide).
teaches(kutter,marketing).
