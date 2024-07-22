docker run --name account-db \
    -e POSTGRES_PASSWORD=root \
    -e POSTGRES_USER=root \
    -e POSTGRES_DB=account-db \
    -d -p 5433:5432 postgres
