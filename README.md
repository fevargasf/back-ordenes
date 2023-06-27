# Inventory-Orders
Ejemplo de aplicación de Inventario



para construir la imagen de la aplicacion utilizar el comando:
 
docker build -t ORDENES:lates --build-arg "DATABASE_URL=6mgkSTKfUXwZKm2K62Zo@containers-us-west-41.railway.app"  \
--build-arg "USER=postgres" \
--build-arg "HOST=containers-us-west-41.railway.app" \
--build-arg "PGPORT=7966" \
--build-arg "DATABASE=railway" \
--build-arg "PASSWORD=6mgkSTKfUXwZKm2K62Zo" .
 