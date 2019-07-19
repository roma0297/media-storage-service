# media-storage-service
The service for storing and managing media files

MySQL Installer 5.7.26
https://dev.mysql.com/get/Downloads/MySQLInstaller/mysql-installer-community-5.7.26.0.msi

Setting environment variables for the database:

1. Run system properties (Win + Pause/Break).
2. Click the tab "Advanced system settings" -> "Environment Variables".
3. Create three variables "New".

Variable name                 ->    Variable value

3.1 JDBC_DATABASE_URL         ->    example  :  (jdbc:mysql://localhost:3306/NAME_DB?useSSL=false&serverTimezone=UTC)   
3.2 JDBC_DATABASE_USERNAME    ->    USERNAME                            
3.3 JDBC_DATABASE_PASSWORD    ->    PASSWORD

4. Restart your computer.
5. You are great.
