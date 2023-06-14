CREATE USER microservice_hotel IDENTIFIED BY microservice_hotel;

GRANT CREATE SESSION TO microservice_hotel;

GRANT ALL PRIVILEGES TO microservice_hotel;

-- Liquibase needs to access the DBA_RECYCLEBIN
GRANT SELECT ON SYS.DBA_RECYCLEBIN TO microservice_hotel;
