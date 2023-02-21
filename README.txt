1- IDE utilizada: Eclipse
Processo de importação: File > Open Projects from File System > Selecionar diretorio do Projeto > Finish

2- Clicar com botão direito no nome do Projeto: Maven > Update Maven Project > Marcar opção Force Update of Snapshots/Releases > OK

3- Abrir arquivo application.properties:
	A) Alterar valor da linha server.port: (Porta que rodará a aplicação. Padrão = 8080)
	B) Definir nome do banco de dados (alterar de "up_vendas" para o nome desejado) 
	C) Preencher username e password para acesso ao banco de dados conforme configuração de seu banco

4- Primeira execução: Abrir arquivo VendasApplication > Botão direito do mouse > Run As > Java Application

5- Após a primeira execução no arquivo application.properties alterar o valor da linha:
	DE: spring.jpa.hibernate.ddl-auto=CREATE
	PARA: spring.jpa.hibernate.ddl-auto=NONE

6- Paras visualizar a aplicação web, basta acessar o endereço de localhost com a porta selecionada (Padrão http://localhost:8080)
