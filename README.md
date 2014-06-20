gameOfLifeJ
===========

Implementação de melhorias no Game Of Life em Java.


*Para executar, importar a pasta como um projeto no Eclipse.*


Estão implementados até o momento o padrão State, e Strategy com Template Method, 
e a implementação do tabuleiro infinito para o jogo.

Para o teste do padrão Strategy com Template Method foram implementadas novas regras de jogo: RegraGoLEstado e RegraHighLife.

A RegraHighLife é idêntica à regra padrão, com a adição de que uma célula morta renasce se possuir 6 vizinhos.

A RegraGoLEstado serve para testar o padrão State, e é idêntica à padrão, só que células que estão vivas há mais de uma geração se 
tornam um "X" .

Para trocar a regra, modificar a chamada ao construtor da classe Tabuleiro, no construtor da classe GameEngine.

O tabuleiro cresce infinitamente de acordo com a necessidade. 
Na tela pode se usar os comandos W, A, S e D para mover a "visão" do tabuleiro.

