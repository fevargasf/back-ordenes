# Inventory-Orders
Ejemplo de aplicación de Inventario



para construir la imagen de la aplicacion utilizar el comando:

docker build -t inventory-orders:lates --build-arg "POSGRESQL_DB_SERVER=172.17.0.2"  \
--build-arg "POSGRESQL_DATASOURCE_USERNAME=postgres" \
--build-arg "POSGRESQL_DATASOURCE_PASSWORD=gis123" .