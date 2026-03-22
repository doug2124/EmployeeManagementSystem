build:
	mvn clean
	mvn package

rebuild:
	docker compose down --remove-orphans
	mvn clean
	mvn package
	docker compose up --build

up:
	docker compose up --build

down:
	docker compose down --remove-orphans