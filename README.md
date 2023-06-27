# Inventory-Orders
Ejemplo de aplicación de Inventario



para construir la imagen de la aplicacion utilizar el comando:

<<<<<<< HEAD
docker build -t ORDENES:lates --build-arg "DATABASE_URL=6mgkSTKfUXwZKm2K62Zo@containers-us-west-41.railway.app"  \
--build-arg "PGUSER=postgres" \
--build-arg "PGHOST=containers-us-west-41.railway.app" \
--build-arg "PGPORT=7966" \
--build-arg "PGDATABASE=railway" \
--build-arg "PGPASSWORD=6mgkSTKfUXwZKm2K62Zo" .
=======
docker build -t inventory-orders:lates --build-arg "POSTGRES_DB_SERVER=172.17.0.5"  \
--build-arg "POSTGRES_DATASOURCE_USERNAME=postgres" \
--build-arg "POSTGRES_DATASOURCE_PASSWORD=gis123" .
>>>>>>> 4427aff0154e323f44eb7b76bfb7fe4740aaa0da
