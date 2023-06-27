# Inventory-Orders
Ejemplo de aplicación de Inventario



para construir la imagen de la aplicacion utilizar el comando:

docker build -t ORDENES:lates --build-arg "DATABASE_URL=6mgkSTKfUXwZKm2K62Zo@containers-us-west-41.railway.app"  \
--build-arg "PGUSER=postgres" \
--build-arg "PGHOST=containers-us-west-41.railway.app" \
--build-arg "PGPORT=7966" \
--build-arg "PGDATABASE=railway" \
--build-arg "PGPASSWORD=6mgkSTKfUXwZKm2K62Zo" .