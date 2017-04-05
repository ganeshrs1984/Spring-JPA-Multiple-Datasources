# Spring-JPA-Multiple-Datasources
Springboot  JPA dealing Multiple Datasources
  This Repo was a practical overview of how to configure your Spring Boot JPA project to use multiple databases.
# Database 
   Postgres sql
   
# Interesting points to look
  
  To connect to two databases we need to manually configure a DataSource -> EntityManagerFactory -> and JpaTransactionManager. This is done in ProfileDatasourceJPAConfig and TechDatasourceJPAConfig.  
