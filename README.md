# Hands-On

***********
How to execute:

1) Baixar o executável: Hands-On.jar 

2) Baixar o arquivo: data.txt

3) Colocar o data.txt e o Hands-On.jar na mesma pasta

4) Abrir o terminal 

5) Ir até o local onde esta os arquivos baixados

6) Digitar o comando: java -jar Hands-On.jar


************
How to mount

1) Criar um novo projeto java com nome Hands-On.
2) Dentro do projeto java criar um package com nome app.
3) Dentro do package app Importa as classes Main.java,App.java e Entry.jav.a
4) Dentro do projeto criar uma pasta com nome lib e importas as libs org-apache-commons-logging.jar, org-apache-commons-logging.jar	httpclient-4.3-beta2.jar,	apache-commons-lang.jar.
5) adicionar ao build path as libs do item anterior.
6) Dentro do projeto colocar o arquivo data.txt.
7) executar o projeto apartir da class Main.




Obs.: o arquivo data.txt é usado como input da aplicação. Ele deve ser preenchido conforme o exemplo.
cada linha representa uma entra e cada coluna da linha é respectivamente o SLO desejado para Respostas bem-sucedidas e o SLO Respostas rápidas.

obs2.: o tempo pedido de 100ms para tratar http get response esta muito baixo, ocasionando sempre o não atendimento do SLO.


Não pude dedicar muito tempo para fazer essa aplicação, logo não inclui exceções, verificações e algum tipo de interface decente.
