# Coba docker compose

spring-boot jpa dengan env dev dan prod. dan docker
pada uji coba ini kita meggabungkan atau menjebatani antara aplikasi spring-boot dengan jpa(Env dev,prod) dengan docker.
sebelumnya sudah kita bahas mengenai cara melakukan configurasi pada spring-boot dengan jpa(Env dev,prod) dengan docker di github repository dengan docker dan enviroment

## Implemntasi

buat configrasi docker dengan mengikuti ini https://github.com/ardileon/cbDocker (add juga docker compose) dan melakukan config env dengan https://github.com/ardileon/enviroment

setelah itu pada bagian application-dev/prod.properties  

sebelumnya

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/dummydbdckr00
```
sesudahnya
```bash
spring.datasource.url=jdbc:postgresql://db:5432/dummydbdckr00
```
dari localhost -> db dikarenakan 

terus lakukan configuration untuk postgresql didocker compose 

```python
version: '3.4'
services:
  web:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - db

  db:
    container_name: dckpst_db
    image: postgres:16.2
    volumes:
      - dckpst_db:/var/lib/postgresql/data
    environment:
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=12345
      - POSTGRES_DB=dummydbdckr00
      - PGDATA=/var/lib/postgresql/data/pgdata
      - SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/dummydbdckr00
    ports:
      - "5432:5432"

volumes:
  dckpst_db: {}
```
### Penjelasan kode diatas
1. Pada kode diatas version: '3.4' itu menandakan version docker compose.
2. services: itu kasih tau pada docker compose untuk menjalankan beberapa container secara sekaligus
3. web: kasih tau pada docker compose untuk membuat container dengan configuration apps spring-bootnya (karena apps sudah di konfigurasi di Docker file)
4. db: kasih tau pada docker compose untuk membuat container db dengan image dan config 

## Apa aja yang harus diperhatikan

1. Pada koneksi yang menghubungkan antara psql dengan apps spring-boot, yaitu 
```bash
spring.datasource.url=jdbc:postgresql://db:5432/dummydbdckr00
```
dimana kita perlu memastikan bahwa port dan configruasi db harus tepat 

2. Nah kita itu cuma tinggal configurasi pada koneksi ke database dan juga lakukan configurasi pada db dan apllikasi spring boot seperti biasa 

3. Jika kita pilih menggunakandocker compose karena untuk menjalankan container tanpa harus build version container tinggal docker compose up 

4. Jika error bisa lihat logs pada setiap container yang sedang atau tidak berjalan sama sekali 

## Tata cara menggunakan 

1. untuk run pada file docker-compose.yml -> docker compose up 
2. dan untuk stop docker-compose.yml -> docker compose down / compose stop
3. Untuk build jar bisa menggunakan  mvn install -DskipTests=true  (tidak rekomend)