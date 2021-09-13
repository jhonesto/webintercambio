#Webintercambio
Projeto Fatec ADS 2013

**IMPLEMENTAÇÃO DE UM SISTEMA PARA INTERCÂMBIOS ESTUDANTIS**

Publicado nos Anais do Conic-Semesp Volume 1,2013
ISSN 2357-8904

[link para a publicação](http://goo.gl/mwJv8Q).

#####Alterações

* Alterado o Banco de dados para H2
* Alterado o Servidor de Aplicação para Tomcat v9.0
* Alterada a versão do primefaces para 8.0
* Utilizando a IDE Eclipse para desenvolvimento

**Dependências adicionadas para persistencia:**

~~~html
	<dependencies>
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.4.32.Final</version>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<version>1.4.200</version>
		</dependency>
	</dependencies>
~~~

**Dependências do JSF:**

~~~html
		<dependency>
			<groupId>javax.faces</groupId>
			<artifactId>javax.faces-api</artifactId>
			<version>2.2</version>
			<scope>provided</scope>
		</dependency>
		
		<dependency>
			<groupId>com.sun.faces</groupId>
			<artifactId>jsf-impl</artifactId>
			<version>2.2.20</version>
		</dependency>
~~~

**Dependências do Primefaces:**

~~~html
		<dependency>
			<groupId>org.primefaces</groupId>
			<artifactId>primefaces</artifactId>
			<version>8.0</version>
		</dependency>
~~~
