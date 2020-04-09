# INSTALLING WILDFLY 10
1. Download the latest stable version of the Enterprise Application Integration (EAI) server from the official website [wildfly](https://wildfly.org/downloads/). 
(E.g. wildfly-10.0.0.Final.zip) 
2. Extract the zip archive to `C:\EAP`. Your system will create a brand new folder named `wildfly-10.0.0.Final` under `C:\EAP`.
3. Execute the script `C:\EAP\wildfly-10.0.0.Final\bin\standalone.bat` to set up the bootstrap environment, check the installation and start the server.
4. After that the server has been started, you should be able to access the web server at the address `http://localhost:8080` and to access to the console at `http://localhost:8080/console`
# CONFIGURE WILDFLY SERVER
## ADD A USER TO ACCESS TO THE CONSOLE
To be able to access the admin console, you will need to add a new user by executing the script ‘add-user.bat’ located under your WildFly installation folder (e.g. c:\EAP\wildfly-10.0.0.Final).

1. Execute the script `add-user.bat` in a console window.
2. Add a Management User by just typing `enter` since this is the default option.
3. Enter the details of the new user to add as described. (e.g. `admin` and `1234` for a local installation).
4. Revisit the server console at `localhost:9990/console` and enter your credentials.
Now, you should be able to see the WildFly home page
