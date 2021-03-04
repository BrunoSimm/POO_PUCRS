%curso(nome_curso).
curso(sistemas_de_informaçao).
curso(engenharia_de_software).
%aluno(matricula, nome_aluno, idade, nome_curso).
aluno(1234567, guilherme, 18, sistemas_de_informaçao).
aluno(2837493, bruno, 24, engenharia_de_software).
aluno(2938479, nicolas, 25, engenharia_de_software).
aluno(5819828, joão, 19, engenharia_de_software).
aluno(1098323, diego, 28, sistemas_de_informaçao).
aluno(2837647, rafael, 38, engenharia_de_software).
aluno(8787987, gustavo, 20, sistemas_de_informaçao).
aluno(1982738, ana, 19, engenharia_de_software).
aluno(4387321, gabriela, 21, sistemas_de_informaçao).
%professor(nome_professor).
professor(carlos).
professor(carla).
professor(joana).
%turma(id_turma, nome_professor).
turma(168, carlos).
turma(211, joana).
%disciplina(codigo_disciplina, nome_disciplina, id_turma, nome_curso).
disciplina(10003, poo, 168, sistemas_de_informaçao).
disciplina(10003, poo, 211, sistemas_de_informaçao).
disciplina(10342, pee, 211, engenharia_de_software).
disciplina(10096, engsoftware, 168, sistemas_de_informaçao).

estudante_Pucrs(X,Y):-aluno(_,X,_,Y),curso(Y).
dados_estudantes(W,X,Y,Z):-aluno(W,X,Y,Z).
disciplinas_curso(X,Y):-disciplina(_,X,_,Y),curso(Y).
dados_disciplina(W,X,Y,Z):-disciplina(W,X,Y,Z).
professor_da_turma(X,Y):-turma(X,Y),professor(Y).

letraA(X):-curso(X).
letraB(X,Y,Z):-curso(Z),aluno(X,Y,_,Z).
letraC(X):-professor(X).
letraD(X,Y):-curso(X),aluno(_,Y,_,X).
letraE(X,Y):-disciplina(_,X,Y,_),turma(Y,_).
letraF(X,Y):-disciplina(_,X,Z,_), turma(Z,Y).
letraG(X,Y):-disciplina(_,X,_,Z),aluno(_,Y,_,Z).
letraH(X,Y):-curso(X),aluno(_,_,Y,X).
letraI(X,Y,Z):-aluno(_,X,_,W),curso(W),disciplina(_,Y,Z,W).
letraJ(X,Y):-turma(X,_),disciplina(_,_,X,Y),curso(Y).